package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserJdbcDao implements UserDao{
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) ->
            new User(rs.getLong("id"), rs.getString("username"));

    @Autowired //Autowired le dice a spring cuál es el constructor que yo quiero que use cuando genera sus instancias
    public UserJdbcDao(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }
    //se usa el Optional ya que es una mala práctica devolver null
    @Override
    public Optional<User> findById(long id){
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?",new Object[] {id},// se usa este approach para evitar sql injection
                USER_ROW_MAPPER
        ).stream().findFirst(); //stream nos permite recorrer colecciones de forma lazy y nos viene bien porque devuelve optional =)
    }

    @Override
    public User findByUsername(String username){
        return jdbcTemplate.query("SELECT * FROM users WHERE username = ?",new Object[] {username},// se usa este approach para evitar sql injection
                USER_ROW_MAPPER
        ).stream().findFirst();
    }

    @Override
    public User create(String email, String password, int id) {
        final Map<String,Object> values = Map.of("username",email);
        final Number key = jdbcInsert.executeAndReturnKey(values);
        return new User(email,password,key.longValue());
    }
}

package ar.edu.itba.paw.models;

public class User {
    private final String email;
    private String password;

    private int id;

    public User(final String email, final String password, final int id){
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
}

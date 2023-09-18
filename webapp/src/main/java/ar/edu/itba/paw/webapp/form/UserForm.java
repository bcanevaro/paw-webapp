package ar.edu.itba.paw.webapp.form;

import ar.edu.itba.paw.webapp.validation.FieldsMustMatch;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@FieldsMustMatch(fields={"password","repeatPassword"})
public class UserForm {
    @Size(min=6,max=40)
    private String name;
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min=8)
    @NotEmpty
    private String password;
    @Size(min=8)
    @NotEmpty
    private String repeatPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}

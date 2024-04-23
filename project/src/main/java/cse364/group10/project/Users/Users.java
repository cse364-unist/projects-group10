package cse364.group10.project.Users;

public class Users {
    private String name;
    private String password;
    private String email;

    Users() {}

    Users(String name, String password, String email) {
        this.name = name; this.password = password; this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

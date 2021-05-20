import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private boolean isAdmin;

    public User(String id, String username, String password, boolean isAdmin){
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;

    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}

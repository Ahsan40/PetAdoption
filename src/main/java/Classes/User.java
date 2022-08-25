package Classes;

public class User {
   private String name;
   private String username;
   private String password;
   private String email;
   private String location;
   private String contact;
   private String profilePic;

    public User(String name, String username, String password, String email, String location, String contact) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
        this.contact = contact;
        this.profilePic = "uploads/img/avatar.jpg";
    }

    public User(String name, String username, String password, String email, String location, String contact, String profilePic) {
        this(name, username, password, email, location, contact);
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
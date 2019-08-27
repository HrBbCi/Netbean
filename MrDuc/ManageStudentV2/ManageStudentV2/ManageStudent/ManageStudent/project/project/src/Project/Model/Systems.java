package Project.Model;

public class Systems {

  private String username;
  private String password;

  public Systems() {

  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Systems(String username, String password) {
    this.username = username;
    this.password = password;
  }

}

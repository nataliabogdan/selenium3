package training;

public class User {

  private String name;
  private String familyName;
  private String street;
  private String code;
  private String town;
  private String email;
  private String tel;
  private String password;
  private String country;
  private String state;

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public String getFamilyName() {
    return familyName;
  }

  public User setFamilyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  public String getStreet() {
    return street;
  }

  public User setStreet(String street) {
    this.street = street;
    return this;
  }

  public String getCode() {
    return code;
  }

  public User setCode(String code) {
    this.code = code;
    return this;
  }

  public String getTown() {
    return town;
  }

  public User setTown(String town) {
    this.town = town;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getTel() {
    return tel;
  }

  public User setTel(String tel) {
    this.tel = tel;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public User setCountry(String country) {
    this.country = country;
    return this;
  }

  public String getState() {
    return state;
  }

  public User setState(String state) {
    this.state = state;
    return this;
  }
}

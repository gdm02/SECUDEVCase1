package model;

public class Account {

	public static String ID_col = "id";
	public static String FIRSTNAME_col = "fname";
	public static String LASTNAME_col = "lname";
	public static String GENDER_col = "gender";
	public static String SALUTATION_col = "salutation";
	public static String BIRTHDATE_col = "birthdate";
	public static String USERNAME_col = "username";	
	public static String PASSWORD_col = "password";
	public static String ABOUT_col = "about";
	public static String LEVEL_col = "level";
	
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	private String firstname;
	private String lastname;
	private String gender;
	private String salutation;
	private String birthdate;
	private String username;
	private String password;
	private String about;
	private String level;
	
	
	
}

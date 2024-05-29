package stepDefinition;

public class Giftcard {

	private String rname;
	private String sname;
	private String message;
	private String email;
	private String configemail;
	
	
	public Giftcard(String rname, String sname, String message, String email, String configemail) {
		super();
		this.rname = rname;
		this.sname = sname;
		this.message = message;
		this.email = email;
		this.configemail = configemail;
	}
	
	
	@Override
	public String toString() {
		return "Giftcard [rname=" + rname + ", sname=" + sname + ", message=" + message + ", email=" + email
				+ ", configemail=" + configemail + "]";
	}


	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfigemail() {
		return configemail;
	}
	public void setConfigemail(String configemail) {
		this.configemail = configemail;
	}
	
	
}

package di21.bloc4.dao;

public class Learner {

	private long id;
	private String group;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private int abscenceQuantity;
	private boolean isDelegate;

	public Learner(long id, String group, String firstName, String lastName, String emailAddress, String phoneNumber,
			int abscenceQuantity, boolean isDelegate) {
		this.id = id;
		this.group = group;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.abscenceQuantity = abscenceQuantity;
		this.isDelegate = isDelegate;
	}

	@Override
	public String toString() {
		return "Apprenant : [\n"
				+ "\tId : " + id + ",\n"
				+ "\tPromotion : " + group + ",\n"
				+ "\tPrénom : " + firstName + ",\n"
				+ "\tNom : " + lastName + ",\n"
				+ "\tAdresse email : " + emailAddress + ",\n"
				+ "\tNuméro de téléphone : " + phoneNumber + ",\n"
				+ "\tAbscences : " + abscenceQuantity + ",\n"
				+ "\tDélégué : " + (isDelegate ? "oui" : "non") + "\n"
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAbscenceQuantity() {
		return abscenceQuantity;
	}

	public void setAbscenceQuantity(int abscenceQuantity) {
		this.abscenceQuantity = abscenceQuantity;
	}

	public boolean isDelegate() {
		return isDelegate;
	}

	public void setDelegate(boolean isDelegate) {
		this.isDelegate = isDelegate;
	}

}

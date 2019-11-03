package lab5;

abstract class PersonL5 {
	protected String name;
	protected int age;
	/**
	 * No argument constructor. Default values private contractor for
	 * name and age 18.
	 */
	public PersonL5() {	
		this("private contractor", 18);
	}
	/**
	 * Two parameter constructor.
	 * @param name Name of the person.
	 * @param age Age of the person.
	 */
	public PersonL5(String name, int age) {
		this.age = (age < 151 && age > 1) ? age: 18;
		this.name = name.isEmpty() ? "private contractor" : name;
	}
	/**
	 * The two string method for the class.	
	 */
	public String toString() {
		return name + "," + age;
	}
	/**
	 * Getter for the name.
	 * @return The name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter for the name.
	 * @param newName The name that is to be set.
	 */
	public void setName(String newName) {
		name = newName;
	}
	/**
	 * The getter for the age.
	 * @return The age.
	 */
	public int getAge() {
		return age;
	}
	/**
	 * The setter for the age. Must be less that 151.
	 * @param newAge The age that is to be set.
	 */
	public void setAge(int newAge) {
		if(newAge < 151) {
			age = newAge;
		}
	}	
}

package ba.bitcamp.homework16.task04;

public class Employee {

	private String name;
	private String gender;
	private double salary;

	/**
	 * Creating constructor
	 * 
	 * @param name
	 *            name of employee
	 * @param maleOrFemale
	 *            is employee male or female
	 * @param salary
	 *            employee salary
	 */
	public Employee(String name, String gender, double salary) {
		this.name = name;
		this.gender = gender;
		this.salary = salary;
	}

	/**
	 * Returns employee name
	 * 
	 * @return name of employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns if employee is male or female
	 * 
	 * @return male or female
	 */
	public String getmaleOrFemale() {
		return gender;
	}

	/**
	 * Returns month salary
	 * 
	 * @return salary
	 */

	public double getSalary() {
		return salary;
	}

	/**
	 * Allows user to set month salary
	 * 
	 * @param salary
	 *            sets salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return String
				.format("Name of employee: %s\nEmployee gender: %s\nEmployee salary: %.2f\n",
						name, gender, salary);
	}
}
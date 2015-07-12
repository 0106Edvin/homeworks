package ba.bitcamp.homework16.task04;

public class Company {

	private String name;
	private Employee manager;
	private Employee[] employees;

	/**
	 * Creates constructor
	 * 
	 * @param name
	 *            name of company
	 * @param manager
	 *            manager of company
	 * @param employees
	 *            employees in company
	 */
	public Company(String name, Employee manager, Employee[] employees) {
		this.name = name;
		this.manager = manager;
		this.employees = employees;
	}

	/**
	 * Calculates how many employees works in company. Manager is not in
	 * employee array, even he works in company
	 * 
	 * @param e
	 *            array of employees
	 * @return number of employees in company
	 */
	public int employeesInCompany(Employee[] e) {
		return e.length;
	}

	/**
	 * Calculates sum of all salaries in company
	 * 
	 * @param e
	 *            array of employees, which salaries are calculated
	 * @return total earnings in company
	 */
	public double sumSalary(Employee[] e) {
		double sum = 0;
		for (int i = 0; i < e.length; i++) {
			sum += e[i].getSalary();
		}
		return sum;
	}

	/**
	 * Calculates how many women works in company
	 * 
	 * @param e
	 *            array of employees
	 * @return number of women in company
	 */
	public int womensInCompany(Employee[] e) {
		int women = 0;
		for (int i = 0; i < e.length; i++) {
			if (e[i].getmaleOrFemale().equals("female")) {
				women++;
			}
		}
		return women;
	}

	/**
	 * Raise salary of every employee for some amount
	 * 
	 * @param e
	 *            array of employees
	 * @param raise
	 *            amount of money salary is raised
	 */

	public void raiseSallary(Employee[] e, double raise) {
		for (int i = 0; i < e.length; i++) {
			e[i].setSalary(e[i].getSalary() + raise);
		}
	}

	public String toString() {
		String s = "";

		s += "Company name: " + name + "\n";
		s += "Manager name: " + manager.getName() + "\n";
		s += "Number of employees: " + employees.length;
		return s;
	}
}

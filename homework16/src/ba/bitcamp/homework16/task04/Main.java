package ba.bitcamp.homework16.task04;

public class Main {

	public static void main(String[] args) {
		/**
		 * Creating employees
		 */

		Employee e1 = new Employee("Edvin Mulabdic", "male", 1300);
		Employee e2 = new Employee("Ajla El Tabari", "female", 1670);
		Employee e3 = new Employee("Dinko Hodyic", "male", 980);
		Employee e4 = new Employee("Medina Banjic", "female", 1500);

		/**
		 * Creating an array of employees
		 */
		Employee [] e = new Employee[4];
		e[0] = e1;
		e[1] = e2;
		e[2] = e3;
		e[3] = e4;
		
		/**
		 * Creating company, company name, manager, and employees
		 */
		Company c1 = new Company("Bit Camp", e1, new Employee[]{e2, e3, e4});
		
		/**
		 * Testing
		 */
		System.out.println("There are " + c1.employeesInCompany(e) + " employees in company");
		System.out.println("Total earnings of all employees is " + c1.sumSalary(e));
		System.out.println("There are " +c1.womensInCompany(e) + " women in company");
		
		System.out.println();
		
		c1.raiseSallary(e, 50);
		System.out.println("Salary after raise: " + c1.sumSalary(e));
		
		System.out.println();
		
		System.out.println(c1);
		
		System.out.println();
		System.out.println(e1);
	}

}

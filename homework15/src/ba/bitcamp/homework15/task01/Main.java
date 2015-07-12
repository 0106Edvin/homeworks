package ba.bitcamp.homework15.task01;

public class Main {

	public static void main(String[] args) {
	
		/**
		 * Creates a new cash box 
		 */
		CashBox cb1 = new CashBox("Crni fond");
		
		cb1.addMoney(-5);
		
		System.out.println(cb1.printInformation());
//		cb1.takeAllMoney();
//		System.out.println(cb1.printInformation());
	}

}

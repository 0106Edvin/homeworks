package ba.bitcamp.homework16.task03;

import org.w3c.dom.css.Counter;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * Creates new printers
		 */

		Printer p1 = new Printer("Printer 1");
		Printer p2 = new Printer();

		/**
		 * Adds 10 papers, 10 ink and print status
		 * 
		 */
		p1.addPaper(9);
		p1.addInk(27);
		System.out.println(p1);
		p1.printPages(50);
		System.out.println(p1);
		
		System.out.println();
		p2.addPaper(7);
		p2.addInk(59);
		System.out.println(p2);
		p2.printPages(58);
		System.out.println(p2);
		

		System.out.println();

		/**
		 * Prints sum of all pages printer ever printed
		 */
		System.out.println("Sum of all pages printer ever printed: " + Printer.getCounter());
	}

}

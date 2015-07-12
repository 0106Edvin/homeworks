package ba.bitcamp.homework16.task03;

public class Printer {

	private static final int INK_UNIT = 3;
	private static final int PAPER_UNIT = 1;
	private static final int NO_RESOURCE = 0;
	private static final int MAX_RESOURCE = 100;

	private static int totalPrinted = 0;

	private String name;
	private int amountOfpaper;
	private int amountOfInk;
	private int sumPrintedPages;
	private String status;

	/**
	 * Creating constructors
	 * 
	 * @param name
	 *            name of the printer
	 */
	public Printer(String name) {
		this();
		this.name = name;
	}

	/**
	 * Creating constructors
	 */
	public Printer() {
		this.name = "Default Printer";
		this.amountOfInk = 0;
		this.sumPrintedPages = 0;
		this.amountOfpaper = 0;

	}

	/**
	 * Returns amount of ink
	 * 
	 * @return true if there is any ink false if there is no ink
	 */

	public boolean hasInk() {
		return (amountOfInk >= INK_UNIT) ? true : false;
	}

	/**
	 * Returns amount of paper
	 * 
	 * @return true if there is any paper false if there is no paper
	 */
	public boolean hasPaper() {
		return (amountOfpaper > NO_RESOURCE) ? true : false;
	}

	/**
	 * Returns sum of printed pages
	 * 
	 * @return number of printed pages
	 */

	public int printedPages() {
		return sumPrintedPages;
	}

	/**
	 * Adds paper to printer If there is more than 100 papers, that means that
	 * capacity is full, and can't add more papers
	 * 
	 * @param num
	 *            number of papers added
	 */
	public void addPaper(int num) {
		if (amountOfpaper + num <= MAX_RESOURCE) {
			amountOfpaper += num;
		} else {
			amountOfpaper = MAX_RESOURCE;
		}
	}

	/**
	 * Adds ink to printer, If there is more than 100 ink, thath means that
	 * capacity is full, and can't add more ink
	 * 
	 * @param num
	 *            number of ink added
	 */
	public void addInk(int num) {
		if (amountOfInk + num <= MAX_RESOURCE) {
			amountOfInk += num;
		} else {
			amountOfInk = MAX_RESOURCE;
		}
	}

	/**
	 * Prints pages while there is paper or ink For every page that is printed
	 * sum of printed pages is increased for 1, amount of paper is decreased for
	 * 1, amount of ink is decreased for 3 and counter that counts all printed
	 * pages ever, is raised for sum of printed pages
	 * 
	 * @param num
	 */
	public void printPages(int numberOfPages) {
		for (int i = numberOfPages; i > 0; i--) {
			if (hasPaper() && hasInk()) {
				amountOfpaper -= PAPER_UNIT;
				amountOfInk -= INK_UNIT;
				sumPrintedPages++;
				totalPrinted++;
			}

		}
	}

	/**
	 * Returns total printed pages
	 * 
	 * @return
	 */
	public static int getCounter() {
		return totalPrinted;
	}

	/**
	 * Prints the status of printer
	 * 
	 * @return
	 */
	public String status() {
		if (amountOfInk > 3 && amountOfpaper >= 1) {
			return "Ready";
		}
		if (amountOfInk < 3 && amountOfpaper > 0) {
			return "No ink";

		}
		if (amountOfInk > 3 && amountOfpaper == 0) {
			return "No paper";

		}
		return "No ink or paper";

	}

	/**
	 * Prints information of printer
	 */

	public String toString() {
		return String
				.format("Printer name: %s,amountOfpaper %d, amountOfInk %d, status: %s",
						name, amountOfpaper, amountOfInk, status());
	}

}

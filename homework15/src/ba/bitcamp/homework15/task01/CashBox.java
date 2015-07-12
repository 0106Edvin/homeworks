package ba.bitcamp.homework15.task01;

public class CashBox {

	/**
	 * Creating a cash box
	 * 
	 */
	@SuppressWarnings("unused")
	private String name;
	private Integer currentSum;

	public CashBox(String name) {
		super();
		this.name = name;
		this.currentSum = 0;

	}

	/**
	 * Gives user an opportunity to add money to his cash box
	 * 
	 * @param money
	 *            the amount of money user want to add to his cash box which is
	 *            added to current sum of money
	 */
	public void addMoney(Integer money) {
		if (money < 0 ){
			System.out.println("Please enter a positive number");
		}else 
		currentSum += money;
	}

	/**
	 * Takes all money from users cash box
	 */
	public void takeAllMoney() {
		currentSum -= currentSum;
	}

	/**
	 * Calculates how much money does user have
	 * 
	 * @return the amount of money expressed in words "not much", "some",
	 *         "a lot of"
	 */
	public String printInformation() {

		if (currentSum == 0) {
			return "It is empty!";
		} else if (currentSum <= 20) {
			return "There is some, but not much money!";

		} else if (currentSum <= 100) {
			return "There is some money!";

		}  
		return "There is a lot of money!";

	}
}

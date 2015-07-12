package ba.bitcamp.homework15.task02;

public class Animal {
	/**
	 * Name of the animal
	 */
	@SuppressWarnings("unused")
	private String name;
	/**
	 * How much is animal active
	 */
	private Integer active;
	/**
	 * How much is animal thirsty
	 */
	private Integer thirsty;
	/**
	 * Time of day, by default it is day
	 */
	public static Integer timeOfDay = 1;
	/**
	 * The amount of water in habitat, by default is 1
	 */
	public static Integer amountOfWater = 1;

	/**
	 * Creating constructors
	 * 
	 * @param name
	 *            Name of the animal
	 * @param active
	 *            How much is animal active
	 * @param thirsty
	 *            How much is animal thirsty
	 */
	public Animal(String name, Integer active, Integer thirsty) {
		this.name = name;
		if (active >= 1 && active <= 2 && thirsty >= 1 && thirsty <= 3) {
			this.active = active;
			this.thirsty = thirsty;
		}
		else this.active = 1;
			 this.thirsty = 1;
	}

	/**
	 * Prints animal status depending of the time of day, and amount of water
	 */
	public void animalStatus() {
		if (timeOfDay == active && thirsty <= amountOfWater) {
			System.out
					.println("It's fine. The animal is active and has water.");
		} else if (timeOfDay == active && thirsty >= amountOfWater) {
			System.out
					.println("The animal is active, but does not have enough water.");
		} else if (timeOfDay != active && thirsty <= amountOfWater) {
			System.out
					.println("The animal is not active, but has enough water.");
		} else  {
			System.out
					.println("The animal is not active and it does not have enough water");
		}
	}

	/**
	 * Turns day into night, and night into day
	 */
	public static void cycleDayNight() {
		if (timeOfDay == 1) {
			timeOfDay = 2;
		} else 
			timeOfDay = 1;
		}
	

	/**
	 * Changes the amount of water in habitat which have impact on animal status
	 * 
	 * @param num
	 *            Number which represents amount of water: 0: no water 1: small
	 *            amount of water 2: normal amount of water 3: a lot of water
	 */
	public static void setAmountOfWater(Integer num) {
		if (amountOfWater >= 0 && amountOfWater <= 3) {
			amountOfWater = num;
		}
	}
}

package ba.bitcamp.weekend05.task01;

import javax.naming.OperationNotSupportedException;

public class Protagonist extends Character {

	public static final int MAX_CHARACTERS = 3;

	private Goal goal;
	private Character[] characters = { null, null, null };
	private Character enemy = null;

	/**
	 * Constructor
	 * 
	 * @param elementName
	 *            Name of Character
	 * @param gender
	 *            character gender
	 * @param isCharacterAlive
	 *            is alive
	 * @param isCapable
	 *            is capable
	 * @param goal
	 *            main goal of character
	 * @param enemy
	 *            characters main enemy
	 */
	public Protagonist(String elementName, String gender,
			boolean isCharacterAlive, boolean isCapable, Goal goal,
			Character enemy) {
		super(elementName, gender, isCharacterAlive, isCapable);
		this.goal = goal;
		this.enemy = enemy;
	}

	public Character getEnemy() {
		return enemy;
	}

	public void setEnemy(Character enemy) {
		this.enemy = enemy;

	}

	public Goal getGoal() {
		return goal;
	}

	public Character[] getCharacters() {
		return characters;
	}

	/**
	 * Setting character
	 * 
	 * @throws OperationNotSupportedException
	 *             if user try to add more characters than allowed throw
	 *             exception
	 */
	public void setCharacters() throws OperationNotSupportedException {
		if (characters.length > MAX_CHARACTERS) {
			throw new OperationNotSupportedException(
					"Maximal number of characters is three");
		} else {
			this.characters = characters;
		}
	}

	/**
	 * Adding characters
	 * 
	 * @param ally
	 *            character that is added
	 */
	public void addCharacters(Character ally) {
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] == null) {
				characters[i] = ally;
				break;
			} else if (characters[characters.length - 1] != null) {
				System.out.println("Can't add more allies.");

			}
		}
	}

	/**
	 * Creating a battle, depending on what the main goal of character is First
	 * we must set his chance, and enemy chance (enemy chance is a random number
	 * from 0-100 )
	 * Setting when character will succeed and when will be defeated
	 */
	public void attainGoal() {
		int enemyChance = (int) (Math.random() * 100);
		int chance = 0;
		if (isCapable() == true) {
			chance = 40;

		}
		if (enemy.isCapable() == true) {
			chance -= 30;
		}
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] == null) {
				break;

			} else if (characters[i].isCapable() == true) {
				chance += 20;

			}
		}
		if (goal.getHeaviness() == Goal.NORMAL) {
			chance -= 20;
		} else if (goal.getHeaviness() == Goal.IMPOSSIBLE) {
			chance = 0;
		}
		if (chance < 0) {
			chance = 0;
		} else if (chance > 100) {
			chance = 100;
			System.out.println(chance);
		}

		if (chance > enemyChance) {
			if (goal.getHeaviness() == Event.DEFEAT) {
				System.out.println("Our Hero succeeded. Enemy is defeated: "
						+ enemy.getElementName());
			} else if (goal.getEvent() == Event.FRIENDSHIP) {
				System.out
						.println("Our Hero succeeded.He became friend with enemy "
								+ enemy.getElementName());
			} else if (goal.getEvent() == Event.LOVE) {
				System.out.println("Our Hero succeeded. He fall in love with "
						+ enemy.getElementName());
			} else if (goal.getEvent() == Event.MANIPULATION) {
				System.out
						.println("Our Hero succeeded. He manipulate his enemy "
								+ enemy.getElementName());

			} else if (goal.getEvent() == Event.VENGEANCE) {
				System.out.println("Our Hero succeeded. He avange "
						+ enemy.getElementName());

			}
		}
		if (chance <= enemyChance) {
			if (goal.getEvent() == Event.DEFEAT) {
				System.out.println("Our Hero failed. Hero failed to  defeate: "
						+ enemy.getElementName());
			} else if (goal.getEvent() == Event.FRIENDSHIP) {
				System.out
						.println("Our Hero failed.He failed to became friend with enemy "
								+ enemy.getElementName());
			} else if (goal.getEvent() == Event.LOVE) {
				System.out
						.println("Our Hero failed. He failed to  fall in love with "
								+ enemy.getElementName());
			} else if (goal.getEvent() == Event.MANIPULATION) {
				System.out
						.println("Our Hero failed. He failed to manipulate his enemy "
								+ enemy.getElementName());

			} else if (goal.getEvent() == Event.VENGEANCE) {
				System.out.println("Our Hero failed. He failed to avange "
						+ enemy.getElementName());

			}
		}
	}
}
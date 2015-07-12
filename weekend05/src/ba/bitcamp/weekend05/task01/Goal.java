package ba.bitcamp.weekend05.task01;

public class Goal extends StoryElement {
	/**
	 * Constant variables
	 */
	public static final int EASY = 0;
	public static final int NORMAL = 1;
	public static final int IMPOSSIBLE = 2;

	private int heaviness;
	private int event;
	private Character character;

	/**
	 * Creating constructor
	 * @param elementName Name of character
	 * @param heaviness Game mode
	 * @param event Goal of a main character
	 * @param character
	 */
	public Goal(String elementName, int heaviness, int event,
			Character character) {
		super(elementName);
		this.heaviness = heaviness;
		this.event = event;
		this.character = character;

	}

	public int getHeaviness() {
		return heaviness;
	}

	public void setHeaviness(int heaviness) {
		this.heaviness = heaviness;
	}

	public int getEvent() {
		return event;
	}

	public void setEvent(int event) {
		this.event = event;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public static int getEasy() {
		return EASY;
	}

	public static int getNormal() {
		return NORMAL;
	}

	public static int getImpossible() {
		return IMPOSSIBLE;
	}

}

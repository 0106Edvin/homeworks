package ba.bitcamp.weekend05.task01;

public class Character extends StoryElement {
	/**
	 * Character properties
	 */
	private String gender;
	private boolean isCharacterAlive;
	private boolean isCapable = false;

	/**
	 * Creating constructor
	 * @param elementName Name of character
	 * @param gender character gender
	 * @param isCharacterAlive is character alive
	 * @param isCapable is character capable
	 */
	public Character(String elementName, String gender,
			boolean isCharacterAlive, boolean isCapable) {
		super(elementName);
		this.gender = gender;
		this.isCapable = isCapable;
		this.isCharacterAlive = true;
	}
	/**
	 * Kill character if he is alive
	 * @param c
	 */
	public void killCharacter(Character c) {

		isCharacterAlive = false;

	}
	/**
	 * if the character is not capable make him capable
	 */
	public void makeCharacterCapable() {

		isCapable = true;

	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isCharacterAlive() {
		return isCharacterAlive;
	}

	public void setCharacterAlive(boolean isCharacterAlive) {
		this.isCharacterAlive = isCharacterAlive;
	}

	public boolean isCapable() {
		return isCapable;
	}

	public void setCapable(boolean isCapable) {
		this.isCapable = isCapable;
	}

}

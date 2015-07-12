package ba.bitcamp.weekend05.task01;

public class Main {

	public static void main(String[] args) {

		/**
		 * One little girl started a mission of defeating cancer She had a help
		 * from mom, dad, and her younger brother
		 */

		Character c1 = new Character("Sue", "female", true, true);
		Character a1 = new Character("Susana", "female", true, true);
		Character a2 = new Character("John", "male", true, true);
		Character a3 = new Character("Ben", "male", true, false);

		/**
		 * They decided to fight back cancer, and don't let the cancer take
		 * their lovely Sue First tried her younger brother Ben, with giving her
		 * all the love he has, but unfortunately that wasn't enough
		 */
		Character enemy = new Character("CANCER", null, true, true);
		Goal g1 = new Goal("Try to kill cancer with love", Goal.IMPOSSIBLE,
				Event.DEFEAT, a3);
		Protagonist p1 = new Protagonist(c1.getElementName(), c1.getGender(),
				true, false, g1, enemy);
		p1.attainGoal();
		/**
		 * After that failure her parents decide to take control, take her to
		 * doctors, and started with therapy After a couple of months on a
		 * strong pills , and a lots of therapies a little girl Succeded in her
		 * battle
		 */

		Goal g2 = new Goal("Kill the cancer", Goal.EASY, Event.DEFEAT, enemy);
		p1 = new Protagonist(c1.getElementName(), c1.getGender(), true, true,
				g2, enemy);
		p1.addCharacters(a1);
		p1.addCharacters(a2);
		p1.addCharacters(a3);
		p1.setEnemy(enemy);
		p1.attainGoal();
		p1.killCharacter(a2);
		p1.killCharacter(a1);
		/**
		 * After a long and heavy battle our little girl defeated cancer Now she
		 * is a beautiful women with her own family Her parents are died, but
		 * she will be always grateful for love and support they gave her
		 */

	}

}

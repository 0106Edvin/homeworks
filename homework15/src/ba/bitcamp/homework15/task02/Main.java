package ba.bitcamp.homework15.task02;

public class Main {

	public static void main(String[] args) {
		/**
		 * Creates animals
		 */
		Animal a1 = new Animal("Animal 1", 2, 1);
		Animal a2 = new Animal("Animal 2" , 1, 3);
		
		a1.animalStatus();
		a2.animalStatus();
		
		Animal.cycleDayNight();
		Animal.setAmountOfWater(0);
		
		a1.animalStatus();
		a2.animalStatus();
	}

}

package ba.bitcamp.homework16.task02;

public class Main {

	public static void main(String[] args) {

		Glass g1 = new Glass(null, 0, 1);

		g1.addLiquid("Sprite", 1.5);
		System.out.println(g1.getCurrentCapacity());
		System.out.println(g1.getTypeOfLiquid());
	//	g1.addLiquid("Sprite", 0.3); // liquid is added because it is the same
										// type like in glass
		System.out.println(g1.getCurrentCapacity());
		System.out.println(g1.getTypeOfLiquid());
		g1.addLiquid("Water", 0.2); // liquid is not added because it is not
									// "Sprite"
		g1.emptyGlass();
		System.out.println(g1.getCurrentCapacity());
	}

}

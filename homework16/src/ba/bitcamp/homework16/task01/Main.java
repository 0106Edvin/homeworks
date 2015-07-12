package ba.bitcamp.homework16.task01;

public class Main {

	public static void main(String[] args) {
	
		Temperature t1 = new Temperature(0);
		t1.setTemperature(25);
		
		System.out.println(t1.getTemperatureInC());
		System.out.println(t1.getTemperatureInF());
		System.out.println(t1.getTemperatureInK());
		
	}
	
}

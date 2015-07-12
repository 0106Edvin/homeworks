package ba.bitcamp.homework16.task01;

public class Temperature {

	private double celsius;

	public Temperature(int celsius) {
		this.celsius = celsius;

	}

	/**
	 * Prints temperature in celsius
	 */
	public double getTemperatureInC() {
		return celsius;
	}

	/**
	 * Prints temperature in kelvin, by adding 273,15 on celsius
	 */
	public double getTemperatureInK() {
		return celsius + 273.15;
	}

	/**
	 * Prints temperature in farenheit by adding 32 on celsius
	 */
	public double getTemperatureInF() {
		return celsius + 32;
	}

	/**
	 * Gives opportunity to set the temperature
	 * 
	 * @param num
	 *            temperature
	 * @return temperature in celsius
	 */
	public double setTemperature(int num) {
		celsius = num;
		return celsius;
	}

	public String toString() {
		return String.format("Celsius: %d", celsius);
	}
}

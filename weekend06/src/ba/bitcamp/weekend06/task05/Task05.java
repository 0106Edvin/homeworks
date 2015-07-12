package ba.bitcamp.weekend06.task05;


public class Task05 {

	public static void main(String[] args) {
		System.out.println(getPower(2, 5));
		System.out.println(getPower(-2, 4));
		System.out.println(getPower(-2, -2));

	}
	/**
	 * Returning Power when exponent is zero, 
	 * when exponent is positive
	 * and when exponent is negative
	 * @param a number 
	 * @param b exponent
	 * @return 
	 */
	public static double getPower(double a, double b) {
		if (b == 0) {
			return 1;
					
		}else if (b > 0){
			return a*(getPower(a,b-1));
		}else if (b < 0){
			return (1/a) * getPower(a,b+1);
		}else{
			return -1;
		}

		

	}

}
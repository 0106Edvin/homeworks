package ba.bitcamp.homework28.task01;
/**
 * creating a Complaint
 * @author User
 *
 */
public class Complaint {
	private Integer id;
	private String time;
	private String date;
	private String name;
	private String complaint;
	
	/**
	 * Constructor for complaint
	 * @param id
	 * @param time
	 * @param date
	 * @param name
	 * @param complaint
	 */
	
	public Complaint(Integer id, String time, String date, String name,
			String complaint) {
		super();
		this.id = id;
		this.time = time;
		this.date = date;
		this.name = name;
		this.complaint = complaint;
	}
	/**
	 * to string method
	 */

	public String toString(){
		String s = id +" | " + time + " | " + date +" | " + name + " | " + complaint;
		return s;
	}
	

}

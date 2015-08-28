package ba.bitcamp.homework28.task03;


/**
 * creating product
 * @author User
 *
 */
public class Product {
	
	private Integer id;
	private String name;
	private long code;
	private Double price;
	public Product(Integer id, String name, long code, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String toString(){
		String s = id + " | " + name + " | " + code + " | " + price;
		return s;
	} 

}

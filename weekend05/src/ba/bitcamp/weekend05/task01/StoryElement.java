package ba.bitcamp.weekend05.task01;

public abstract class StoryElement {

	private String elementName;

	public StoryElement(String elementName) {
		super();
		this.elementName = elementName;
	}
	
	public StoryElement(){
		this ("StElement");
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	
}

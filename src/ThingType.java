
public class ThingType {
	
	/*
	 * name of thing
	 */
	private String name;
	
	/*
	 * description of thing
	 */
	
	private String description;

	public ThingType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ThingType [name=" + name + ", description=" + description + "]";
	}
	
		
	
}

import java.util.HashMap;
import java.util.List;

public class User {
	
	/*
	 * unique identifier for user
	 */
	private int id;
	/*
	 * User name
	 */
	private String  name;
	
	/*
	 * Array of things that user have
	 */
//	HashMap<ThingType, Integer> things;
	
	List<ThingType> things;
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<ThingType> getThings() {
		return things;
	}

	public void setThings(List<ThingType> things) {
		this.things = things;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", things=" + things + "]";
	}
	
	

}

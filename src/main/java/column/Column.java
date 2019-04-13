package column;

import interfaces.Type_t_itf;

public class Column {
	
	private String name;
	private Type_t_itf type;
	
	/**
	 * @param name
	 * @param type
	 */
	public Column(String name, Type_t_itf type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// maybe return type.type == {'int', 'float', ... }
	public String getType() {
		return type.getType();
	}

	public void setType(Type_t_itf type) {
		this.type = type;
	}
	
	
	
}

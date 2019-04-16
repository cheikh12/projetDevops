package column;

import interfaces.Type_t_itf;

public class Column implements Comparable<Column> {
	
	private String name;
	private Type_t_itf type;
	
	/**
	 * @param name: a String for the column name
	 * @param type: a type element created with the default type constructor
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

	public String getType() {
		return type.getType();
	}

	public void setType(Type_t_itf type) {
		this.type = type;
	}

	
	@Override
    public boolean equals(Object o) {
		if (o instanceof Column) {
			return this.getName().equals( ((Column) o).getName() ) && this.getType().equals( ((Column) o).getType());
		} 
		return false;
		
	}

	public int compareTo(Column o) {
		// TODO Auto-generated method stub
				if (o instanceof Column) {
					return this.name.compareTo(((Column) o).name);
				}
				return 0;
	}
	
}

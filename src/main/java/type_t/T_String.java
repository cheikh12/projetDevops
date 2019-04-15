package type_t;

import interfaces.Type_t_itf;

public class T_String implements Type_t_itf {
	private String s;
	
	/**
	 * @param s
	 */
	public T_String(String s) {
		super();
		this.s = s;
	}
	
	/**
	 * a default constructor used to instanciate a Column of type string
	 */
	public T_String() {
		super();
		this.s = "DEFAULT_STRING";
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return "string";
	}

	public void print() {
		// TODO Auto-generated method stub
		if (!isNull())
			System.out.print(this.s);
	}

	public boolean isNull() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return s;
	}

}

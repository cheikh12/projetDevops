package type_t;

import interfaces.Type_t_itf;

public class T_Int implements Type_t_itf {
	private Integer i; 
	
	/**
	 * a default constructor used to instanciate a Column of type int
	 */
	public T_Int() {
		super();
		this.i = 1;
	}

	public T_Int(Integer i) {
		this.i = i;
	}

	public String getType() {
		return "int";
	}

	public void print() {
		if (!isNull())
			System.out.print(this.i);
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public boolean isNull() {
		return i == null;
	}
	
}

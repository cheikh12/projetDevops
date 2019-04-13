package type_t;

import interfaces.Type_t_itf;

public class T_Bool implements Type_t_itf  {
	
	private Boolean b;
	
	/**
	 * @param b
	 */
	public T_Bool(boolean b) {
		super();
		this.b = b;
	}
	
	/**
	 * a default constructor used to instanciate a Column of type bool
	 */
	public T_Bool() {
		super();
		this.b = true;
	}

	public String getType() {
		return "bool";
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.print(b);
	}

	public boolean isNull() {
		// TODO Auto-generated method stub
		return false;
	}

}

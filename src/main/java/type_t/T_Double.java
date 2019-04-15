package type_t;

import interfaces.Type_t_itf;

public class T_Double implements Type_t_itf {
	private Double d;

	/**
	 * @param d
	 */
	public T_Double(Double d) {
		super();
		this.d = d;
	}
	
	/**
	 * a default constructor used to instanciate a Column of type double
	 */
	public T_Double() {
		super();
		this.d = 1.0;
	}

	public String getType() {
		return "double";
	}

	public void print() {
		if (!isNull())
			System.out.print(this.d);
	}

	public boolean isNull() {
		return d == null;
	}
	
	public String toString() {
		return String.valueOf(d);
	}
}

package row;

import interfaces.Type_t_itf;

public class Row {
	
	private Type_t_itf element;
	
	public Row(Type_t_itf element) {
		this.element = element;
	}

	public Type_t_itf getElement() {
		return element;
	}

	public void setElement(Type_t_itf element) {
		this.element = element;
	}
	
	
}

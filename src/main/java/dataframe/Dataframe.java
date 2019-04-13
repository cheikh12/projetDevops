package dataframe;

import java.util.ArrayList;
import java.util.SortedMap;

import column.Column;
import interfaces.Dataframe_itf;
import interfaces.Type_t_itf;
import row.Row;

public class Dataframe implements Dataframe_itf {
	
	private SortedMap<Column, ArrayList<Row>> dataSet;
	private int size;
		
	public Dataframe(String csvFileName) {
		
	}
	
	public Dataframe(String[][] data) {
		String[] columnNames = data[0];
		String[] columnTypes = data[1];
	}
	
	public void showAll() {
		
	}
	
	public void showHead(int n) {
		
	}
	
	public void showTail(int n) {
		
	}
	
	public Dataframe selectRow(int idx) {
		return null;
	}
	
	public Dataframe selectRows(int[] idx) {
		return null;
	}
	
	public Dataframe selectRowsBetween(int i, int j) {
		return null;
	}
	
	public Dataframe selectColumn(String column) {
		return null;
	}
	
	public Dataframe selectColumns(String[] columns) {
		return null;
	}
	
	public Type_t_itf min(String column) {
		return null;
	}
	
	public Type_t_itf max(String column) {
		return null;
	}
	
	
	public Type_t_itf avg(String column) {
		return null;
	}
}

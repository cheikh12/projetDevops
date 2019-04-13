package dataframe;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import column.Column;
import interfaces.Dataframe_itf;
import interfaces.Type_t_itf;
import row.Row;
import type_t.*;

public class Dataframe implements Dataframe_itf {
	
	private TreeMap<Column, ArrayList<Row>> dataSet;
	private int size;
		
	public Dataframe(String csvFileName) {
		
	}
	
	public Dataframe(String[][] data) throws Exception {
		String[] columnNames = data[0];
		
		for (int i = 0; i < data[1].length; i++) {
			if (!isValidType(data[1][i])) 
				throw new Exception("Invalid data type for column '" + data[0][i] + "'");
		}
		String[] columnTypes = data[1];
		
		int nbRows = data.length;
		this.dataSet = new TreeMap<Column, ArrayList<Row>>();
		this.size = 0;
		
		// outer loop iterating over the columns of the 2D array
		for (int c = 0; c < data[0].length; c++) {
			Type_t_itf columnType = null;
			String columnName = data[0][c];
			
			if (data[1][c].equals("int")) {
				columnType = new T_Int();
			}
			else if (data[1][c].equals("double")) {
				columnType = new T_Double();
			}
			else if (data[1][c].equals("string")) {
				columnType = new T_String();
			}
			else if (data[1][c].equals("bool")) {
				columnType = new T_Bool();
			}
			else {
				throw new Exception("Unknown data type for column '" + columnName + "'");
			}
			
			Column col = new Column(columnName, columnType);
			ArrayList<Row> colRows = new ArrayList<Row>();
			
			if (nbRows > 2) { // test to see if dataframe contains data or just defined the columns
				
				// inner loop iterating over rows of current column to add its elements
				for (int r = 2; r < nbRows; r++) {
					Row currentRow = null;
					String currentRowElement = data[c][r];
					
					if (columnType instanceof T_Int) {
						int element = Integer.valueOf(currentRowElement);
						currentRow = new Row(new T_Int(element));
					}
					else if (columnType instanceof T_Double) {
						double element = Double.valueOf(currentRowElement);
						currentRow = new Row(new T_Double(element));
					}
					else if (columnType instanceof T_String) {
						currentRow = new Row(new T_String(currentRowElement));
					}
					else if (columnType instanceof T_Bool) {
						boolean element = Boolean.valueOf(currentRowElement);
						currentRow = new Row(new T_Bool(element));
					}
					else {
						throw new Exception("Unknown data type for column '" + columnName + "'");
					}
					
					colRows.add(currentRow);
					
				}
				dataSet.put(col, colRows);
			}			
		}
		this.size = this.dataSet.values().size();
	}
	
	private boolean isValidType(String type) {
		return type.equals("int") || type.equals("double") || type.equals("bool") || type.equals("string");
	}
	
	public void showAll() {
				
		Set<Column> keys = dataSet.keySet();
		for (Column col : keys) {
			System.out.print(col.getName() + "\t");
		}
		System.out.print("\n\n");
		
		//ArrayList<ArrayList<Row>> values = this.dataSet.values();
		System.out.println(this.dataSet.values());
		
		
		
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
	
	public static void main(String[] args) throws Exception {
		String[][] data = {
				{"id", "fname", "lname"}, {"int", "string", "string"},
				{"1", "Charles", "Dickens"}, {"2", "Tony", "Stark"}, {"3", "Bruce", "Banner"}
		};
		
		Dataframe d = new Dataframe(data); 
		d.showAll();
	}
}

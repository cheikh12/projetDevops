package dataframe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

import column.Column;
import interfaces.Dataframe_itf;
import interfaces.Type_t_itf;
import row.Row;
import type_t.*;

public class Dataframe implements Dataframe_itf {
	
	private LinkedHashMap<Column, ArrayList<Row>> dataSet;
	private TreeMap<Column, ArrayList<Row>> sortedDataSet;
	private TreeMap<String, String> sortedColumnTypes;
	private String[][] dataSet2DArray;
	private String[] columnTypes;
	
	private int nbDataRows;
		
	public Dataframe(String csvFileName) {
		
	}
	
	public Dataframe(String[][] data) throws Exception {
		//String[] columnNames = data[0];
		
		for (int i = 0; i < data[1].length; i++) {
			if (!isValidType(data[1][i])) 
				throw new Exception("Invalid data type for column '" + data[0][i] + "'");
		}
		columnTypes = data[1];
		this.sortedColumnTypes = new TreeMap<String, String>(); // new String[data[1].length];
		
		int nbRows = data.length;
		this.dataSet = new LinkedHashMap<Column, ArrayList<Row>>();
		this.sortedDataSet = new TreeMap<Column, ArrayList<Row>>();
		this.nbDataRows = 0;
		
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
					String currentRowElement = data[r][c].trim();
					//System.out.println(currentRowElement);
					
					if (columnType instanceof T_Int) {
						Integer element = null;
						if (!currentRowElement.equals(""))
							element = Integer.parseInt(currentRowElement);
						currentRow = new Row(new T_Int(element));
					}
					else if (columnType instanceof T_Double) {
						Double element = null;
						if (!currentRowElement.equals(""))
							element = Double.parseDouble(currentRowElement);
						currentRow = new Row(new T_Double(element));
					}
					else if (columnType instanceof T_String) {
						String element = null;
						if (!currentRowElement.equals(""))
							element = currentRowElement;
						currentRow = new Row(new T_String(element));
					}
					else if (columnType instanceof T_Bool) {
						Boolean element = null;
						if (!currentRowElement.equals(""))
							element = Boolean.valueOf(currentRowElement);
						currentRow = new Row(new T_Bool(element));
					}
					else {
						throw new Exception("Unknown data type for column '" + columnName + "'");
					}
					
					if (c == 0)
						nbDataRows++;
					colRows.add(currentRow);
					
				}
				//dataSet.put(col, colRows);
			}
			if (!this.sortedDataSet.containsKey(col)) {
				dataSet.put(col, colRows);
				sortedDataSet.put(col, colRows);
			}
			else 
				throw new Exception("Trying to create a column that already exists!");
			
		}
		
		init2DArrayOfDataSet();
		
		// this last block initializes the column types of the sorted columns
		Set<Column> cols = sortedDataSet.keySet();
		//int sortedColumnTypesIdx = 0;
		for (Column c : cols) {
			this.sortedColumnTypes.put(c.getName(), c.getType());
			//this.sortedColumnTypes[sortedColumnTypesIdx] = c.getType();
			//sortedColumnTypesIdx++;
		}
		/*
		for (int i = 0; i < sortedColumnTypes.length; i++)
			System.out.println(sortedColumnTypes[i]);
			*/
	}
	
	private boolean isValidType(String type) {
		return type.equals("int") || type.equals("double") || type.equals("bool") || type.equals("string");
	}
	
	private void init2DArrayOfDataSet() {
		Set<Column> columns = dataSet.keySet();
		int nbColumns = columns.size();
		int nbRows = this.nbDataRows;
		
		this.dataSet2DArray = new String[nbRows + 1][nbColumns];
		
		int r = 0;
		for (Column col : columns) {
			dataSet2DArray[0][r] = col.getName();
			r++;
		}
		
		Collection<ArrayList<Row>> dataValues = dataSet.values();
		Object[] dataValuesArray =  dataValues.toArray();
		
		for (int c = 0; c < dataValuesArray.length; c++) {
			@SuppressWarnings("unchecked")
			ArrayList<Row> currentColData = (ArrayList<Row>) dataValuesArray[c];
			
			for (int l = 0; l < currentColData.size(); l++) {
				if (currentColData.get(l).getElement().isNull())
					dataSet2DArray[l + 1][c] = "";
				else
					dataSet2DArray[l + 1][c] = (String) currentColData.get(l).toString();
			}
		}
	}
	
	public void showAll() {
		for (int i = 0; i < this.dataSet2DArray.length; i++) {
			for (int j = 0; j < this.dataSet2DArray[0].length; j++) {
				System.out.print(this.dataSet2DArray[i][j] + "\t\t\t" );
			}
			System.out.println();
		}
		return;
	}
	
	public void showHead(int n) {
		int nbRowsToShow = -1;
		
		if (n <= 0) {
			nbRowsToShow = 5 + 1; // + 1 for the row that contains the column names
		}
		else {
			if (n <= this.dataSet2DArray.length - 1) // - 1 for the row that contains the column names
				nbRowsToShow = n + 1; // + 1 for the row that contains the column names
			else
				nbRowsToShow = this.dataSet2DArray.length;
		}
		
		for (int i = 0; i < nbRowsToShow; i++) {
			for (int j = 0; j < this.dataSet2DArray[0].length; j++) {
				System.out.print(this.dataSet2DArray[i][j] + "\t\t\t" );
			}
			System.out.println();
		}
		return;
	}
	
	public void showTail(int n) {
		int nbRowsToShow = -1;
		
		if (n <= 0) {
			nbRowsToShow = 5 + 1; // + 1 for the row that contains the column names
		}
		else {
			if (n <= this.dataSet2DArray.length - 1) // - 1 for the row that contains the column names
				nbRowsToShow = n + 1; // + 1 for the row that contains the column names
			else
				nbRowsToShow = this.dataSet2DArray.length;
		}
		
		for (int c = 0; c < this.dataSet2DArray[0].length; c++)
			System.out.print(this.dataSet2DArray[0][c] + "\t\t\t" );
		
		System.out.println();
		
		for (int i = this.dataSet2DArray.length - nbRowsToShow + 1; i < this.dataSet2DArray.length; i++) {
			for (int j = 0; j < this.dataSet2DArray[0].length; j++) {
				System.out.print(this.dataSet2DArray[i][j] + "\t\t\t" );
			}
			System.out.println();
		}
		return;
	}
	
	public Dataframe selectRow(int idx) throws Exception {
		if (idx + 1 >= this.dataSet2DArray.length) 
			throw new Exception("Index out of bounds");
		
		if (idx < 0)
			throw new Exception("Invalid index value");
		
		Set<Column> columns = this.dataSet.keySet();
		int nbColumns = columns.size();
		
		String[][] newData = new String[3][nbColumns];
		
		for (int i = 0; i < this.dataSet2DArray[0].length; i++) {
			newData[0][i] = this.dataSet2DArray[0][i];
			newData[1][i] = this.columnTypes[i];
			newData[2][i] = this.dataSet2DArray[idx+1][i];
		}
		Dataframe res = null;
		try {
			res = new Dataframe(newData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public Dataframe selectRows(int[] idx) throws Exception {
		int nbRowsToSelect = idx.length;
		
		for (int i = 0; i < nbRowsToSelect; i++) {
			if (idx[i] + 1 >= this.dataSet2DArray.length) 
				throw new Exception("Index out of bounds");
			
			if (idx[i] < 0)
				throw new Exception("Invalid index value");
		}
		
		Set<Column> columns = this.dataSet.keySet();
		int nbColumns = columns.size();
		
		String[][] newData = new String[nbRowsToSelect + 2][nbColumns]; // +2 for column name & column type
		
		// loop to set the column name and column type in the newData array
		for (int i = 0; i < this.dataSet2DArray[0].length; i++) {
			newData[0][i] = this.dataSet2DArray[0][i];
			newData[1][i] = this.columnTypes[i];
		}
		
		// loop to insert the data into the newData array
		int r = 2; // data starts from the 2nd row of newData array
		for (int i = 0; i < nbRowsToSelect; i++) {
			int rowBeingSelected = idx[i];
			for (int c = 0; c < this.dataSet2DArray[0].length; c++) {
				newData[r][c] = this.dataSet2DArray[rowBeingSelected + 1][c];
			}
			r++;
		}
		/* 
		for (int i = 0; i < newData.length; i++) {
			for (int j = 0; j < newData[0].length; j++) {
				System.out.print(newData[i][j] + "\t");
			}
			System.out.print("\n");
		}
		*/
		Dataframe res = null;
		try {
			res = new Dataframe(newData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public Dataframe selectRowsBetween(int i, int j) {
		return null;
	}
	
	public Dataframe selectColumn(String column) throws Exception {
		Dataframe res = null;
		
		if (!this.sortedColumnTypes.containsKey(column)) {
			System.err.println("Column to select does not exist");
			return res;
		}
		
		String colType = this.sortedColumnTypes.get(column);
		Type_t_itf columnType = null;
		
		if (colType.equals("int")) {
			columnType = new T_Int();
		}
		else if (colType.equals("double")) {
			columnType = new T_Double();
		}
		else if (colType.equals("string")) {
			columnType = new T_String();
		}
		else if (colType.equals("bool")) {
			columnType = new T_Bool();
		}
		else {
			throw new Exception("Unknown data type for column '" + column + "'");
		}
		
		ArrayList<Row> colRows = this.sortedDataSet.get(new Column(column, columnType));
		int nbRowsInSelectedColumn = colRows.size();
		
		String[][] newData = new String[nbRowsInSelectedColumn + 2][1]; // +2 for the row with the col name & row with col type
		newData[0][0] = column;
		newData[1][0] = colType;
		
		int dataRow = 2;
		
		for (int i = 0; i < nbRowsInSelectedColumn; i++) {
			if (!colRows.get(i).getElement().isNull())
				newData[dataRow][0] = colRows.get(i).toString();
			else
				newData[dataRow][0] = "";
			dataRow++;
		}
		
		res = new Dataframe(newData);
		return res;
	}
	
	public Dataframe selectColumns(String[] columns) throws Exception {
		Dataframe res = null;
		
		int columnsArgLength = columns.length;
		String[] columnsArgTypes = new String[columnsArgLength];
		
		for (int i = 0; i < columnsArgLength; i++) {
			if (this.sortedColumnTypes.containsKey(columns[i])) {
				columnsArgTypes[i] = this.sortedColumnTypes.get(columns[i]);
			}
			else {
				System.err.println("A column to select does not exist");
				return res;
			}
		}
		
		String[][] newData = new String[this.nbDataRows + 2][columnsArgLength];
		
		for (int c = 0; c < columnsArgLength; c++) {
			String colType = columnsArgTypes[c];
			Type_t_itf columnType = null;
			
			if (colType.equals("int")) {
				columnType = new T_Int();
			}
			else if (colType.equals("double")) {
				columnType = new T_Double();
			}
			else if (colType.equals("string")) {
				columnType = new T_String();
			}
			else if (colType.equals("bool")) {
				columnType = new T_Bool();
			}
			else {
				throw new Exception("Unknown data type for column '" + columns[c] + "'");
			}
			
			ArrayList<Row> colRows = this.sortedDataSet.get(new Column(columns[c], columnType));
			
			newData[0][c] = columns[c];
			newData[1][c] = colType;
			int dataRow = 2;
			
			for (int r = 0; r < colRows.size(); r++) {
				if (!colRows.get(r).getElement().isNull())
					newData[dataRow][c] = colRows.get(r).toString();
				else
					newData[dataRow][c] = "";
				dataRow++;
			}
		}
		
		res = new Dataframe(newData);
		return res;
	}
	
	public Double[] min(String[] columns) throws Exception {
		int columnsArgLength = columns.length;
		
		if (!this.checkIfAllColumnsExist(columns))
			throw new Exception("Unknown column in arguments!");
		
		String[] columnsArgTypes = this.getTypesOfColumnArgs(columns);
		
		Double[] res = new Double[columnsArgLength];
		for (int i = 0; i < columnsArgLength; i++)
			res[i] = null;
		
		for (int c = 0; c < columnsArgLength; c++) {
			double minElement = Double.MAX_VALUE;
			String colType = columnsArgTypes[c];
			
			if (colType.equals("int") || colType.equals("double")) {
				Type_t_itf columnType = null;
				
				if (colType.equals("int"))
					columnType = new T_Int();
				else
					columnType = new T_Double();
				
				ArrayList<Row> colRows = this.sortedDataSet.get(new Column(columns[c], columnType));
				
				for (int r = 0; r < colRows.size(); r++) {
					if (!colRows.get(r).getElement().isNull()) {
						double d = Double.valueOf(colRows.get(r).getElement().toString());
						if (d < minElement)
							minElement = d;
					}
				}
				res[c] = minElement;
			}
		}
		return res;
	}
	
	public Double[] max(String[] columns) throws Exception {
		int columnsArgLength = columns.length;
		
		if (!this.checkIfAllColumnsExist(columns))
			throw new Exception("Unknown column in arguments!");
		
		String[] columnsArgTypes = this.getTypesOfColumnArgs(columns);
		
		Double[] res = new Double[columnsArgLength];
		for (int i = 0; i < columnsArgLength; i++)
			res[i] = null;
		
		for (int c = 0; c < columnsArgLength; c++) {
			double maxElement = Double.MIN_VALUE;
			String colType = columnsArgTypes[c];
			
			if (colType.equals("int") || colType.equals("double")) {
				Type_t_itf columnType = null;
				
				if (colType.equals("int"))
					columnType = new T_Int();
				else
					columnType = new T_Double();
				
				ArrayList<Row> colRows = this.sortedDataSet.get(new Column(columns[c], columnType));
				
				for (int r = 0; r < colRows.size(); r++) {
					if (!colRows.get(r).getElement().isNull()) {
						double d = Double.valueOf(colRows.get(r).getElement().toString());
						if (d > maxElement)
							maxElement = d;
					}
				}
				res[c] = maxElement;
			}
		}
		return res;
	}
	
	private boolean checkIfAllColumnsExist(String[] columns) {
		int columnsArgLength = columns.length;
		String[] columnsArgTypes = new String[columnsArgLength];
		
		for (int i = 0; i < columnsArgLength; i++) {
			if (this.sortedColumnTypes.containsKey(columns[i])) {
				columnsArgTypes[i] = this.sortedColumnTypes.get(columns[i]);
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	private String[] getTypesOfColumnArgs(String[] columns) {
		int columnsArgLength = columns.length;
		String[] columnsArgTypes = new String[columnsArgLength];
		
		for (int i = 0; i < columnsArgLength; i++) 
			columnsArgTypes[i] = this.sortedColumnTypes.get(columns[i]);
		
		return columnsArgTypes;
	}
	
	public Double[] mean(String[] columns) throws Exception {
		int columnsArgLength = columns.length;
		
		if (!this.checkIfAllColumnsExist(columns))
			throw new Exception("Unknown column in arguments!");
		
		String[] columnsArgTypes = this.getTypesOfColumnArgs(columns);
		
		Double[] res = new Double[columnsArgLength];
		for (int i = 0; i < columnsArgLength; i++)
			res[i] = null;
		
		for (int c = 0; c < columnsArgLength; c++) {
			double nbNonNullElements = 0, accumulator = 0;
			String colType = columnsArgTypes[c];
			
			if (colType.equals("int") || colType.equals("double")) {
				Type_t_itf columnType = null;
				
				if (colType.equals("int"))
					columnType = new T_Int();
				else
					columnType = new T_Double();
				
				ArrayList<Row> colRows = this.sortedDataSet.get(new Column(columns[c], columnType));
				
				for (int r = 0; r < colRows.size(); r++) {
					if (!colRows.get(r).getElement().isNull()) {
						accumulator += Double.valueOf(colRows.get(r).getElement().toString());// (colRows.get(r).getElement().getValue()));
						nbNonNullElements++;
					}
				}
				double nonNullMean = accumulator / nbNonNullElements ;
				res[c] = nonNullMean;
				//System.out.print(columns[c] + ": " + nonNullMean + "\n");
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		String[][] data = {
				{"id", "fname", "lname", "balance", "age"}, 
				{"int", "string", "string", "double", "int"},
				{"1", "Charles", "Dickens", "41983.23", "22"}, 
				{"2", "Tony", "Stark", "292849.11", "44"}, 
				{"3", "Bruce", "Banner", "983777.98", "43"},
				{"4", "Peter", "Parker", "9800.98", "19"},
				{"5", "Lizzy", "Mcguire", "9880.98", "19"},
				{"6", "Aunt", "May", "", "68"}
		};
			
		Dataframe d = new Dataframe(data); 
		d.showAll();
		
		System.out.println("\n\n\n");
		
		Double[] meanRes = d.min(new String[] {"id", "fname", "balance"});
		
		System.out.println(meanRes[0]);
		
		
		
		
		
		//d2.showTail(4);
		
		/*
		Dataframe d2 = d.selectRows(new int[] {5, 2, 4});
		
		d2.showAll();
		Dataframe d2 = d.selectColumns(new String[] {"balance", "id"});
		d2.showAll();
		*/
		
	}
}

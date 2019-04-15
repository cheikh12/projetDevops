package interfaces;

import dataframe.Dataframe;

public interface Dataframe_itf {
	
	public void showAll();
	
	public void showHead(int n);
	
	public void showTail(int n);
	
	public Dataframe selectRow(int idx) throws Exception;
	
	public Dataframe selectRows(int[] idx) throws Exception;
	
	public Dataframe selectRowsBetween(int i, int j);
	
	public Dataframe selectColumn(String column) throws Exception;
	
	public Dataframe selectColumns(String[] columns) throws Exception;
	
	public Double[] min(String[] columns) throws Exception;
	
	public Double[] max(String[] columns) throws Exception;
	
	public Double[] mean(String[] column) throws Exception;
	
}

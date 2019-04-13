package interfaces;

import dataframe.Dataframe;

public interface Dataframe_itf {
	
	public void showAll();
	
	public void showHead(int n);
	
	public void showTail(int n);
	
	public Dataframe selectRow(int idx);
	
	public Dataframe selectRows(int[] idx);
	
	public Dataframe selectRowsBetween(int i, int j);
	
	public Dataframe selectColumn(String column);
	
	public Dataframe selectColumns(String[] columns);
	
	public Type_t_itf min(String column);
	
	public Type_t_itf max(String column);
	
	public Type_t_itf avg(String column);
	
}
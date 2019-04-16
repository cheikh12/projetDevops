package interfaces;

import dataframe.Dataframe;
import interfaces.*;

public interface Dataframe_itf {
	
	public void showAll();
	
	public void showHead(int n);
	
	public void showTail(int n);
	
	public Dataframe selectRow(int idx) throws Exception;
	
	public Dataframe selectRows(int[] idx) throws Exception;
	
	public Dataframe selectRowsBetween(int i, int j);
	
	public Dataframe selectColumn(String column);
	
	public Dataframe selectColumns(String[] columns);
	
	public Type_t_itf min(String column);
	
	public Type_t_itf max(String column);
	
	public Type_t_itf avg(String column);
	
}

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {

	private Double[] coefficients;
	private Double from,to,step;
	public GornerTableModel(Double from,Double to,Double step,Double[] coefficients)
	{
		this.from=from;
		this.to=to;
		this.step=step;
		this.coefficients=coefficients;
	}
	public Double getFrom()
	{
		return from;
	}
	public Double getTo()
	{
		return to;
	}
	public Double getStep()
	{
		return step;
	}
	
	public int getColumnCount() {
		return 3;
	}
	
	public int getRowCount()
	{
		return new Double(Math.ceil((to-from)/step)).intValue()+1;
	}


	public Object getValueAt(int row, int col) 
	
	{
		Boolean b=false;
		Double x=from+step*row;
		Double result = x;
		 for (int i=coefficients.length-1; i>=0; i--)
			 result=(result*x+coefficients[i]);
			if (col==0) { 
				return x; 
			} else 
				if (col==1){ 
					return result; 
			} else {
				if (result>0) 
					b = true;
				return b;
			}
	}
	public String getColumName(int col)
	{
		switch(col) {
		case 0: return "Значения X";
		case 2: return "больше 0 ?";
		default :return "Значение многочлена";
		}
	}
	public Class<?>getColumnClass(int col)
	{
		switch(col) {
		case 2:return Boolean.class;
		default :return Double.class;
		}
	}
}

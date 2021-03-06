package bobby;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ViewTable extends JPanel {

	private JTable table;
	private DefaultTableModel model;
	private final Vector<String> columnNames;

	public ViewTable(){
		setLayout(new FlowLayout(FlowLayout.CENTER));
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		columnNames = new Vector<String>();
		columnNames.add("Element");
		columnNames.add("Value");
		
		model = new DefaultTableModel(data, columnNames){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(new Dimension(850, 730));
		
		add(pane);		
	}
	
	public void updateTable(double[][] data) {
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		Vector<String> v;
		double sum = 0;
		for (int i = 0; i < data[0].length; i++){
			double val = data[0][i];
			sum += val;
			if (sum > 1)
				sum = 1;
			
			DecimalFormat format = new DecimalFormat("#.0000"); 
			
						
			v = new Vector<String>();
			v.add(String.valueOf(i+1));
			v.add(String.valueOf(format.format(val)));
			v.add(String.valueOf(format.format(sum)));
			dataVector.add(v);
		}
		
		
		// process from dataset into dataVector
		
		model.setDataVector(dataVector, columnNames);
	}
	
}

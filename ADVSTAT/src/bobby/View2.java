package bobby;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


import controller.Controller;

public class View2 extends JFrame implements ActionListener, KeyListener{
	
	private JTextField txtPopulationSize,
						txtSampleSize,
						txtLowerBound,
						txtUpperBound;
	
	private JLabel lblPopulationSize,
					lblSampleSize,
					lblErrorMsg,
					lblLowerBound,
					lblUpperBound,
					lblType;
	private JButton btnGenerate, btnReset;
	private JPanel pnlMenuView;
	private GraphPanel pnlGraphPView, pnlGraphSView; 
//	private Range range; 
	private JComboBox<String> cmbxType;
	private JScrollPane sp;
	private DefaultTableModel tbModel;
	private JTable table;
	private JSlider sliderP, sliderS;
	private int defaultSliderMax,defaultSliderMin;
	public View2() {
		super("ADVSTAT");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
	//	range = new Range(-1, -1);
		
		initComponents();
		setComponents();
		addComponents();
	}
	private void initComponents(){
		defaultSliderMax = 5;
		defaultSliderMin = 0;
		
		txtPopulationSize = new JTextField();
		txtSampleSize = new JTextField();
		txtLowerBound = new JTextField();
		txtUpperBound = new JTextField();
		
		lblPopulationSize = new JLabel("Population (N):");
		lblSampleSize = new JLabel("Sample Size (n):");
		lblLowerBound = new JLabel("Lower Bound:");
		lblUpperBound = new JLabel("Upper Bound:");
		lblErrorMsg = new JLabel();
		
		lblType = new JLabel("Distribution Type:");
		cmbxType = new JComboBox<String>();
		cmbxType.addItem("Random");
		cmbxType.addItem("Uniform");
		cmbxType.addItem("Skewed");
		cmbxType.addItem("Normal");
		cmbxType.addItem("Bimodal");
		
		tbModel = new DefaultTableModel();
		tbModel.addColumn("x");
		tbModel.addColumn("P");
		table = new JTable(tbModel);
		
		sp = new JScrollPane(table);
		
		sliderP = new JSlider();
		sliderS = new JSlider();
		
		pnlGraphPView = new GraphPanel();
		pnlGraphSView = new GraphPanel();
		pnlMenuView = new JPanel();
		
		btnGenerate = new JButton("Generate");
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txtPopulationSize.setText("");
				txtSampleSize.setText("");
				txtLowerBound.setText("");
				txtUpperBound.setText("");
				
				resetColor();
				lblErrorMsg.setText("");
			}
		});
	}
	
	private void setComponents(){
		int verticalLocation = 50;
	
		pnlMenuView.setBounds(0, 0, 280, 500);
		pnlMenuView.setLayout(null);

	/*	lblPopulationSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSampleSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLowerBound.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpperBound.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
	*/	
		
		lblPopulationSize.setBounds(50, verticalLocation + 20, 150, 30);
		
		sliderP.setBounds(40,verticalLocation + 50, 210, 50);
		sliderP.setPaintLabels(true);
		sliderP.setMajorTickSpacing(1);
		sliderP.setPaintTicks(true);
		setMaximumP(defaultSliderMax);
		setMinimumP(defaultSliderMin);
		
		
		lblSampleSize.setBounds(50, verticalLocation + 110, 150, 30);
		
		sliderS.setBounds(40,verticalLocation + 140, 210, 50);
		sliderS.setPaintLabels(true);
		sliderS.setMajorTickSpacing(1);
		sliderS.setPaintTicks(true);
		setMaximumS(defaultSliderMax);
		setMinimumS(defaultSliderMin);
		
		lblLowerBound.setBounds(50, verticalLocation + 190, 150, 30);
		lblUpperBound.setBounds(50, verticalLocation + 230, 150, 30);
	
		txtPopulationSize.setBounds(160, verticalLocation + 23, 85, 25);
		txtSampleSize.setBounds(160, verticalLocation + 113, 85, 25);
		txtLowerBound.setBounds(160, verticalLocation + 193, 85, 30);
		txtUpperBound.setBounds(160, verticalLocation + 233, 85, 30);
		
		lblType.setBounds(50, verticalLocation + 270, 150, 30);
		cmbxType.setBounds(160, verticalLocation + 273, 85, 25);
	
		
		btnGenerate.setBounds(36, verticalLocation + 310, 100, 30);
		btnReset.setBounds(147, verticalLocation + 310, 100, 30);
		lblErrorMsg.setBounds(50, verticalLocation + 340, 300, 30);
		
		JLabel label = new JLabel("Probability Distribution Table");
		label.setBounds(36, verticalLocation + 320, 210, 30);
		sp.setBounds(36, verticalLocation + 350, 210, 30);
	
		lblErrorMsg.setForeground(Color.red);
	
		btnGenerate.setFocusable(false);
		btnReset.setFocusable(false);
		
		pnlGraphPView.setBounds(280, verticalLocation + 0, 500, 500);
	//	pnlGraphPView.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlGraphPView.setBorder(BorderFactory.createEtchedBorder(Color.black, getBackground()));
			
			
		pnlGraphSView.setBounds(750, verticalLocation + 0, 500, 500);
		pnlGraphSView.setBorder(BorderFactory.createLineBorder(Color.black));
		
	//	pnlMenuView.add(label);
	}
	private void addComponents(){
		pnlMenuView.add(txtPopulationSize);
		pnlMenuView.add(lblPopulationSize);
		
		pnlMenuView.add(sliderP);
		
		pnlMenuView.add(txtSampleSize);
		pnlMenuView.add(lblSampleSize);

		pnlMenuView.add(sliderS);
		
		pnlMenuView.add(lblLowerBound);
		pnlMenuView.add(lblUpperBound);
		pnlMenuView.add(txtLowerBound);
		pnlMenuView.add(txtUpperBound);
		pnlMenuView.add(lblType);
		pnlMenuView.add(cmbxType);
		
		pnlMenuView.add(btnGenerate);
		pnlMenuView.add(btnReset);
		
		pnlMenuView.add(lblErrorMsg);
		
	//	pnlMenuView.add(sp);
		this.add(pnlGraphPView);
		this.add(pnlGraphSView);
		this.add(pnlMenuView);
		
	}
	public void setMinimumP(int minimum) {
		if (sliderP.getMinimum() != minimum) 
			sliderP.setMinimum(minimum);
	}
	
	public void setMaximumP(int maximum) {
		if (sliderP.getMaximum() != maximum) 
			sliderP.setMaximum(maximum);
	}
	
	public void setMinimumS(int minimum) {
		if (sliderS.getMinimum() != minimum) 
			sliderS.setMinimum(minimum);
	}
	
	public void setMaximumS(int maximum) {
		if (sliderS.getMaximum() != maximum) 
			sliderS.setMaximum(maximum);
	}
	public void displayDistList(ArrayList<Double> distList){
		
		
//		table.setModel(tbModel);
		
		for(int i = 0; i < distList.size(); i++) {
			Object[] obj = {i, String.format("%.5g%n", distList.get(i))};
			tbModel.addRow(obj);
		}
		
		pnlMenuView.add(sp);
	}
	
	public void setDistributionListP(ArrayList<Double> distList) {
		pnlGraphPView.setDistribution(distList);
	}
	public void setDistributionListS(ArrayList<Double> distList) {
		pnlGraphSView.setDistribution(distList);
	}
	
	public void resetColor(){
		txtPopulationSize.setBackground(Color.white);
		txtSampleSize.setBackground(Color.white);
		txtLowerBound.setBackground(Color.white);
		txtUpperBound.setBackground(Color.white);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object Target = e.getSource();
		
		if(Target.equals(cmbxType)){
	//		if(cmbxType.getSelectedItem().equals("Random"))
	//			btnGenerate.addActionListener(Controller.randomListener);
		}
	}
	
	public void graphPopulationDistribution() {
		
	}
	public void displayErrorMessage(String errorMsg) {
	//	lblErrorMsg.setText(errorMsg);
		
	}
	public class Range {
		public int start, finish;
		public Range(int s, int f){
			start = s;
			finish = f;
		}
	}
//	public void setRange(int s, int f){
	//	range = new Range(s, f);
//	}
	public int getPopulation(){
		try {
			if(!txtPopulationSize.getText().equals(""))
				return Integer.parseInt(txtPopulationSize.getText());
			else return 0;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public void setGenerateListener(ActionListener l){
		btnGenerate.addActionListener(l);
	} 
	
	public int getSampleSize(){
		try {
			if(!txtSampleSize.getText().equals(""))
				return Integer.parseInt(txtSampleSize.getText());
			else return 0;
		} catch (Exception e) {
			return 0;
		}
	}
	public void setPopulation(int n){
		txtPopulationSize.setText(n + "");
	}

	public void setSampleSize(int n){
		txtSampleSize.setText(n + "");
	}
	public Range getRange(){
		if(txtLowerBound.getText().equals(""))
			return new Range(-1, -1);
		else return new Range(Integer.parseInt(txtLowerBound.getText()), Integer.parseInt(txtUpperBound.getText()));
	}
	public void redrawGraph(){
		pnlGraphPView.repaint();
		pnlGraphSView.repaint();
	}
	public JComboBox<String> getCmbxType() {
		return cmbxType;
	}
	public void setCmbxType(JComboBox<String> cmbxType) {
		this.cmbxType = cmbxType;
	}
	
	public void keyPressed(KeyEvent arg0) {}
	
	public void keyReleased(KeyEvent arg0) {
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				sliderP.setExtent(getPopulation());
				
			}
		});
	}
	public void keyTyped(KeyEvent arg0) {}
	
	
}

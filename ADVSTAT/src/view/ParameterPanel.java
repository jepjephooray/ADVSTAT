package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeListener;

import model.Model.GenerationType;

import org.jdesktop.swingx.JXFormattedTextField;
import org.jdesktop.swingx.JXTextField;
import org.jfree.data.category.CategoryDataset;

public class ParameterPanel extends JPanel{
	public static final int DEFAULT_N = 1;
	public static final int MAX_N = 5;
	public static final int MIN_N = 0;

	private boolean hasError;
	
	private JTextField txtN;
	private JTextField txtUpperB;
	private JTextField txtLowerB;
	private JSlider sliderPopulationSize, sliderSampleSize;
	private JLabel lblError;
	private JComboBox<String> cmbxType;
	public JPanel sliderPanel;
	private JPanel sliderContainerPopulationSize;
	private JPanel sliderContainerSampleSize;
	
	public ParameterPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
		
		Dimension lblSize = new Dimension(20, 50);
		Dimension txtSize = new Dimension(35, 30);
		Dimension lblLongSize = new Dimension(120, 30);
		
		txtN = new JXFormattedTextField("Population size");
		txtN.setPreferredSize(lblLongSize);
		
		txtLowerB = new JXFormattedTextField("Lower bound");
		txtLowerB.setPreferredSize(lblLongSize);
		
		txtUpperB = new JXFormattedTextField("Upper bound");
		txtUpperB.setPreferredSize(lblLongSize);
		
		cmbxType = new JComboBox<String>();
		cmbxType.setPreferredSize(lblLongSize);
		cmbxType.addItem("Normal");
		cmbxType.addItem("Bimodal");
		cmbxType.addItem("Skewed");
		cmbxType.addItem("Uniform");
		cmbxType.addItem("Random");
		
		JLabel lblN = new JLabel("Population size:");
		lblN.setPreferredSize(lblLongSize);
		
		JLabel lblUp = new JLabel("Upper bound:");
		lblUp.setPreferredSize(lblLongSize);
		
		JLabel lblLow = new JLabel("Lower bound:");
		lblLow.setPreferredSize(lblLongSize);
		
		
		JLabel lblType = new JLabel("Data generation");
		lblType.setPreferredSize(lblLongSize);
		
//		formPanel.add(lblN);
		formPanel.add(txtN);
		
//		formPanel.add(lblLow);
		formPanel.add(txtLowerB);
		
//		formPanel.add(lblUp);
		formPanel.add(txtUpperB);
		
	
		formPanel.add(lblType);
		formPanel.add(cmbxType);
		
		lblError = new JLabel("Test error here");
		lblError.setForeground(Color.red);
		lblError.setPreferredSize(lblLongSize);
		formPanel.add(lblError);

		
		/**
		 * Sliders
		 */
		
		
		
		sliderContainerPopulationSize = new JPanel();
		sliderContainerPopulationSize.setBorder(BorderFactory.createTitledBorder("Simulate population size"));

		
		
		sliderPopulationSize = new JSlider(JSlider.HORIZONTAL, MIN_N, MAX_N, DEFAULT_N);
		sliderPopulationSize.setPreferredSize(new Dimension(750, 30));
		sliderPopulationSize.setMajorTickSpacing(1);
		sliderPopulationSize.setPaintTicks(true);
		sliderContainerPopulationSize.add(sliderPopulationSize);
	
		
		sliderContainerSampleSize = new JPanel();
		sliderContainerSampleSize.setBorder(BorderFactory.createTitledBorder("Simulate sample size"));
		
		sliderSampleSize = new JSlider(JSlider.HORIZONTAL, MIN_N, MAX_N, DEFAULT_N);
		sliderSampleSize.setMajorTickSpacing(10);
		sliderSampleSize.setMinorTickSpacing(5);
		sliderSampleSize.setPaintTicks(true);
		sliderSampleSize.setPreferredSize(new Dimension(750, 30));
		sliderContainerSampleSize.add(sliderSampleSize);
		
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
		sliderPanel.add(sliderContainerPopulationSize);
		sliderPanel.add(sliderContainerSampleSize);
		sliderPanel.setVisible(false);
		
		add(formPanel);
		add(sliderPanel);
		
	}
	
	public void updatePopulation(int population){
		sliderContainerPopulationSize.setBorder(null);
		sliderContainerPopulationSize.setBorder(BorderFactory.createTitledBorder("Population size: " + population));
		
		
	}
	
	public void updateSample(int sample){
		sliderContainerSampleSize.setBorder(null);
		sliderContainerSampleSize.setBorder(BorderFactory.createTitledBorder("Sample size: " + sample));
	}
	
	
	public int getN() throws Exception{
		int value = Integer.parseInt(txtN.getText());
		if (value > 100)
			value = 100;
		
		int division = 0;
		int minor = 0;
		
		if (value > 50){
			division = 10;
			minor = 5;
		}else if (value > 10 && value < 50){
			division = 5;
			minor = 1;
		}else {
			division = 2;
			minor = 1;
		}
		
		sliderPopulationSize.setMajorTickSpacing(division);
		sliderPopulationSize.setMinorTickSpacing(minor);
		
		sliderSampleSize.setMajorTickSpacing(division);
		sliderSampleSize.setMinorTickSpacing(minor);
		
		return value;
	}
	
	public int getUpperB() throws Exception{
		int value = Integer.parseInt(txtUpperB.getText());
		return value;
	}
	
	public int getLowerB() throws Exception{
		int value = Integer.parseInt(txtLowerB.getText());
		return value;
	}
	
	public boolean isInputValid(int type) throws Exception {
		boolean valid = true;
/*		Object singleX[];
		Object rangeX[];
		try {
		Object _singleX[] = {lbln, txtN};
		
		singleX = _singleX;
		}catch(Exception e){
			return false;
		}
		
		
		
		
		clearErrors();
		
		for(int i = 0; i < singleX.length; i++) {
			JTextField f = (JTextField)singleX[i];
			try {
				if( f.getText().equals("") || f.getText().matches("\\D") || Integer.parseInt(f.getText()) < 0) {
					f.setBackground(Color.pink);
					valid = false;
				}
			} catch(Exception e) {
				e.printStackTrace();
				f.setBackground(Color.pink);
				valid = false;
			}
		}
*/		if(this.getLowerB() > this.getUpperB()){
			txtLowerB.setBackground(Color.pink);
			txtUpperB.setBackground(Color.pink);
		}
		return valid;
	}
	
	public void clearErrors() {
		txtN.setBackground(Color.white);
		txtLowerB.setBackground(Color.white);
		txtUpperB.setBackground(Color.white);
		hasError = false;
		
		
	/*	try {
			if (getn(null) > getN()){
				lbln.setBackground(Color.pink);
				hasError = true;
			}
		}catch (Exception e){
			hasError = true;
		}
*/	}
	
	
	/**
	 * Should only display the graph if there are no errors.
	 */
	public boolean shouldDisplayGraph(){
		return hasError == false;
	}
	
	public void addChangeListener(ChangeListener listener){
		sliderPopulationSize.addChangeListener(listener);
		sliderSampleSize.addChangeListener(listener);
	}
	
	public int getPopulationSize() {
		return sliderPopulationSize.getValue();
	}
	
	public int getSampleSize() {
		return sliderSampleSize.getValue();
	}
	
	public int getPopulationSizeMinimum() {
		return sliderPopulationSize.getMinimum();
	}
	
	public int getPopulationSizeMaximum() {
		return sliderPopulationSize.getMaximum();
	}
	
	public void setPopulationSizeMinimum(int minimum) {
		if (sliderPopulationSize.getMinimum() != minimum) 
			sliderPopulationSize.setMinimum(minimum);
	}
	
	public void setPopulationSizeMaximum(int maximum) {
		if (sliderPopulationSize.getMaximum() != maximum) 
			sliderPopulationSize.setMaximum(maximum);
	}
	public void setSampleSizeMinimum(int minimum) {
		if (sliderSampleSize.getMinimum() != minimum) 
			sliderSampleSize.setMinimum(minimum);
	}
	
	public void setSampleSizeMaximum(int maximum) {
		if (sliderSampleSize.getMaximum() != maximum) 
			sliderSampleSize.setMaximum(maximum);
	}
	public void addGraphListener(View listener) {
		txtN.addKeyListener(listener);
		txtLowerB.addKeyListener(listener);
		txtUpperB.addKeyListener(listener);
		
		// sliderX.addChangeListener(listener);
		sliderPopulationSize.addChangeListener(listener);
		sliderSampleSize.addChangeListener(listener);
		
		cmbxType.addActionListener(listener);
	}

	public GenerationType getGenerationType() {
		String data = (String)cmbxType.getSelectedItem();
		switch(data){
			default:
			case "Normal": return GenerationType.Normal;
			case "Bimodal": return GenerationType.Bimodal;
			case "Skewed": return GenerationType.Skewed;
			case "Uniform": return GenerationType.Uniform;
			case "Random": return GenerationType.Random;
		}
	}

}

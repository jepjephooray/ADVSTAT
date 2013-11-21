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
import javax.swing.event.ChangeListener;

import org.jfree.data.category.CategoryDataset;

public class ParameterPanel extends JPanel{
	public static final int DEFAULT_X = 1;
	public static final int MAX_N = 5;
	public static final int MIN_N = 1;

	private boolean hasError;
	
	private JTextField txtn;
	private JTextField txtN;
	private JTextField txtUpperB;
	private JTextField txtLowerB;
	private JLabel lblgivenX;
	private JSlider sliderK, slidern;
	private JLabel lblError;
	private JComboBox<String> cmbxType;
	
	public ParameterPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		Dimension lblSize = new Dimension(10, 30);
		Dimension txtSize = new Dimension(35, 30);
		Dimension lblLongSize = new Dimension(85, 30);
		
		txtN = new JTextField("");
		txtN.setPreferredSize(txtSize);
		
		txtn = new JTextField("");
		txtn.setPreferredSize(txtSize);
		
		txtLowerB = new JTextField("");
		txtLowerB.setPreferredSize(txtSize);
		
		txtUpperB = new JTextField("");
		txtUpperB.setPreferredSize(txtSize);
		
		cmbxType = new JComboBox<String>();
		cmbxType.addItem("Normal");
		cmbxType.addItem("Bimodial");
		cmbxType.addItem("Skewed");
		cmbxType.addItem("Uniform");
		cmbxType.addItem("Random");
		
		JLabel lbln = new JLabel("n");
		lbln.setPreferredSize(lblSize);
		
		JLabel lblN = new JLabel("N");
		lblN.setPreferredSize(lblSize);
		
		JLabel lblUp = new JLabel("Upper Bound");
		lblUp.setPreferredSize(lblLongSize);
		
		JLabel lblLow = new JLabel("Lower Bound");
		lblLow.setPreferredSize(lblLongSize);
		
		lblgivenX = new JLabel("Probability given x = 0 : ");
		lblgivenX.setPreferredSize(new Dimension(300, 30));
		//lblgivenX.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel lblType = new JLabel("Type");
		
		add(lblN);
		add(txtN);
		
		add(Box.createRigidArea(new Dimension(45, 30)));
		
		add(lbln);
		add(txtn);
				
		add(Box.createRigidArea(new Dimension(45, 30)));
		
		add(lblLow);
		add(txtLowerB);
		
		add(lblUp);
		add(txtUpperB);
	
		add(lblType);
		add(cmbxType);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.red);
		
		add(lblError);

		JPanel sliderContainer = new JPanel();
		sliderContainer.setBorder(BorderFactory.createTitledBorder("Input"));
		sliderContainer.setLayout(new BoxLayout(sliderContainer, BoxLayout.Y_AXIS));
		// sliderContainer.setPreferredSize(new Dimension(400, 125));
		
		lblUp = new JLabel("N");
		lblUp.setPreferredSize(lblSize);
		
		sliderContainer.add(lblUp);
		
		sliderK = new JSlider(JSlider.HORIZONTAL, MIN_N, MAX_N, DEFAULT_X);
		sliderK.setPreferredSize(new Dimension(300, 30));
		sliderK.setMajorTickSpacing(1);
		sliderK.setPaintTicks(true);
		sliderK.setPaintLabels(true);
		sliderContainer.add(sliderK);
		
		/*
		JLabel lblX = new JLabel("x - number of draws from the population");
		lblX.setPreferredSize(lblSize);
		
		sliderContainer.add(lblX);
		
		sliderX = new JSlider(JSlider.HORIZONTAL, MIN_N, MAX_N, DEFAULT_X); 
		sliderX.setPreferredSize(new Dimension(300, 30));
		sliderX.setPaintLabels(true);
		sliderX.setMajorTickSpacing(1);
		sliderX.setPaintTicks(true);
		sliderX.setPaintLabels(true);
		sliderContainer.add(sliderX);
		//sliderContainer.setBorder(BorderFactory.createTitledBorder(""));
		sliderContainer.add(lblgivenX);
		
		*/
		
		lbln = new JLabel("n");
		lbln.setPreferredSize(lblSize);
		sliderContainer.add(lbln);
		slidern = new JSlider(JSlider.HORIZONTAL, MIN_N, MAX_N, DEFAULT_X);
		slidern.setPaintLabels(true);
		slidern.setMajorTickSpacing(1);
		slidern.setPaintTicks(true);
		slidern.setPaintLabels(true);
		slidern.setPreferredSize(new Dimension(300, 30));
		slidern.setPaintLabels(true);
		sliderContainer.add(slidern);
	}
	public int getn(Object src) throws Exception{
		if (src != null && src.equals(slidern)){
			txtn.setText("" + slidern.getValue());
			return slidern.getValue();
		}else
			return Integer.parseInt(txtn.getText());
	}
	
	public int getN() throws Exception{
		int value = Integer.parseInt(txtN.getText());
		if (value > 100)
			value = 100;
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
	
	public void setn(int n) {
		txtn.setText(n+"");
	}
	
	
	public boolean isInputValid(int type) {
		Object singleX[];
		Object rangeX[];
		try {
		Object _singleX[] = {txtn, txtN, getUpperB()};
		
		singleX = _singleX;
		}catch(Exception e){
			return false;
		}
		
		
		
		boolean valid = true;
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
		return valid;
	}
	
	public void clearErrors() {
		txtn.setBackground(Color.white);
		txtN.setBackground(Color.white);
		hasError = false;
		
		
		try {
			if (getn(null) > getN()){
				txtn.setBackground(Color.pink);
				hasError = true;
			}
		}catch (Exception e){
			hasError = true;
		}
	}
	
	/**
	 * Should only display the graph if there are no errors.
	 */
	public boolean shouldDisplayGraph(){
		return hasError == false;
	}
	
	public void addChangeListener(ChangeListener listener){
		sliderK.addChangeListener(listener);
		slidern.addChangeListener(listener);
	}
	
	public int getValueOfK() {
		return sliderK.getValue();
	}
	
	public int getMinimumK() {
		return sliderK.getMinimum();
	}
	
	public int getMaximumK() {
		return sliderK.getMaximum();
	}
	public void setGivenXProbability(int x, double prob) {
		lblgivenX.setText("Probability given x = " + x + " : " + prob);
	}
	
	public void setMinimumK(int minimum) {
		if (sliderK.getMinimum() != minimum) 
			sliderK.setMinimum(minimum);
	}
	
	public void setMaximumK(int maximum) {
		if (sliderK.getMaximum() != maximum) 
			sliderK.setMaximum(maximum);
	}
	public void addGraphListener(View listener) {
		txtn.addKeyListener(listener);
		txtN.addKeyListener(listener);
		// sliderX.addChangeListener(listener);
		sliderK.addChangeListener(listener);
		slidern.addChangeListener(listener);
	}

}

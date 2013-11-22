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
	
	private JLabel lbln;
	private JTextField txtN;
	private JTextField txtUpperB;
	private JTextField txtLowerB;
	private JLabel lblgivenX;
	private JSlider sliderK, slidern;
	private JLabel lblError;
	private JComboBox<String> cmbxType;
	
	public ParameterPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel formPanel = new JPanel(); 
		
		Dimension lblSize = new Dimension(20, 30);
		Dimension txtSize = new Dimension(35, 30);
		Dimension lblLongSize = new Dimension(85, 30);
		
		txtN = new JTextField("");
		txtN.setPreferredSize(txtSize);
		
		lbln = new JLabel("");
		lbln.setPreferredSize(txtSize);
		
		
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
		
		JLabel lbln = new JLabel("n: ");
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
		
		formPanel.add(lblN);
		formPanel.add(txtN);
		
	//	formPanel.add(Box.createRigidArea(new Dimension(45, 30)));
		formPanel.add(lbln);
		formPanel.add(lbln);
				
		formPanel.add(Box.createRigidArea(new Dimension(45, 30)));
		
		formPanel.add(lblLow);
		formPanel.add(txtLowerB);
		
		formPanel.add(lblUp);
		formPanel.add(txtUpperB);
	
		formPanel.add(lblType);
		formPanel.add(cmbxType);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.red);
		
		formPanel.add(lblError);

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
		slidern.setMajorTickSpacing(1);
		slidern.setPaintTicks(true);
		slidern.setPreferredSize(new Dimension(300, 30));
		slidern.setPaintLabels(true);
		sliderContainer.add(slidern);
		
		add(formPanel);
		add(sliderContainer);
	}
	public int getn(Object src) throws Exception{
		if (src != null && src.equals(slidern)){
			lbln.setText("" + slidern.getValue());
			return slidern.getValue();
		}else
			return Integer.parseInt(lbln.getText());
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
		lbln.setText(n+"");
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
	public void setMinimumn(int minimum) {
		if (slidern.getMinimum() != minimum) 
			slidern.setMinimum(minimum);
	}
	
	public void setMaximumn(int maximum) {
		if (slidern.getMaximum() != maximum) 
			slidern.setMaximum(maximum);
	}
	public void addGraphListener(View listener) {
		txtN.addKeyListener(listener);
		txtLowerB.addKeyListener(listener);
		txtUpperB.addKeyListener(listener);
		
		// sliderX.addChangeListener(listener);
		sliderK.addChangeListener(listener);
		slidern.addChangeListener(listener);
	}

}

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

import model.Model.GenerationType;

import org.jdesktop.swingx.JXFormattedTextField;

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
	private JButton btnGenerate;
	private JButton btnGraph;
	
	public ParameterPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5)); 
		
		Dimension lblSize = new Dimension(20, 50);
		Dimension txtSize = new Dimension(70, 30);
		Dimension lblLongSize = new Dimension(100, 30);
		Dimension lblLongerSize = new Dimension(190, 30);
		
		txtN = new JXFormattedTextField("Population size");
		txtN.setPreferredSize(txtSize);
		
		txtLowerB = new JXFormattedTextField("Lower bound");
		txtLowerB.setPreferredSize(txtSize);
		
		txtUpperB = new JXFormattedTextField("Upper bound");
		txtUpperB.setPreferredSize(txtSize);
		
		cmbxType = new JComboBox<String>();
		cmbxType.setToolTipText("Data generation");
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
		
	
		// formPanel.add(lblType);
		formPanel.add(cmbxType);
		

		btnGenerate = new JButton("Generate population");
		btnGenerate.setPreferredSize(lblLongerSize);
		formPanel.add(btnGenerate);
		
		btnGraph = new JButton("Graph");
		btnGraph.setPreferredSize(lblLongSize);
		formPanel.add(btnGraph);
		

		lblError = new JLabel("");
		lblError.setForeground(Color.red);
		lblError.setPreferredSize(lblLongerSize);
		lblError.setVisible(false);
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
		sliderSampleSize.setValue(2);
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
		txtN.setText("" + population);
		
	}
	
	public void updateSample(int sample){
		sliderContainerSampleSize.setBorder(null);
		sliderContainerSampleSize.setBorder(BorderFactory.createTitledBorder("Sample size: " + sample));
	}
	
	
	public int getN() throws Exception{
		if (txtN.getText().equalsIgnoreCase(""))
			throw new Exception("No population");
		
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
	
	public boolean isInputValid() throws Exception {
		boolean valid = true;
		if(this.getLowerB() > this.getUpperB()){
			txtLowerB.setBackground(Color.pink);
			txtUpperB.setBackground(Color.pink);
			throw new Exception("Invalid bounds");
		}
		return valid;
	}
	
	public void clearErrors() {
		txtN.setBackground(Color.white);
		txtLowerB.setBackground(Color.white);
		txtUpperB.setBackground(Color.white);
		lblError.setVisible(false);
		lblError.setText("");
		hasError = false;
	}
	
	
	/**
	 * Should only display the graph if there are no errors.
	 */
	public boolean shouldDisplayGraph(){
		return hasError == false;
	}
	
	public int getPopulationSize() {
		return sliderPopulationSize.getValue();
	}
	
	public int getSampleSize() {
		return sliderSampleSize.getValue();
	}

	public void setSample(int n) {
		if (n > sliderPopulationSize.getValue())
			n = sliderPopulationSize.getValue();
		else if (n < 0)
			n = 2;
		
		sliderSampleSize.setValue(n);
		
	}

	public void setPopulation(int n) {
		sliderSampleSize.setMaximum(n);
		sliderPopulationSize.setMaximum(n);
		
		sliderPopulationSize.setValue(n);
		
	}	
	public void addGraphListener(View listener) {
		txtN.addKeyListener(listener);
		txtLowerB.addKeyListener(listener);
		txtUpperB.addKeyListener(listener);
		
		sliderPopulationSize.addChangeListener(listener);
		sliderSampleSize.addChangeListener(listener);
		btnGenerate.addActionListener(listener);
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

	public void setError(String message) {
		lblError.setVisible(true);
		lblError.setText(message);
	}


}

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;


public class Graph extends JPanel{
	
	private JTextField txtn;
	private JTextField txtN;
	private JTextField txtK;
	private JLabel lblgivenX;
	
	private JButton btnCalculate;
	private Component lblError;
	public static int DEFAULT_X = 1;
	public static int MAX_N = 5;
	public static int MIN_N = 1;
	
	private CategoryPlot plot;
	private JSlider sliderK, sliderX, slidern;
	private boolean hasError;
	
	public Graph() {
		//setPreferredSize(new Dimension(475, 525));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents();
	}
	
	
	private JFreeChart createChart(final CategoryDataset dataset){
		   final JFreeChart chart = ChartFactory.createAreaChart(
		            "Hypergeometric Probability Distribution",    // chart title
		            "Random variable X",               // domain axis label
		            "Probability",                  // range axis label
		            dataset,                  // data
		            PlotOrientation.VERTICAL, // orientation
		            false,                     // include legend
		            false,                     // tooltips
		            false                     // urls
		        );
		 
		        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

		        // set the background color for the chart...
		   		// final StandardLegend legend = (StandardLegend) chart.getLegend();
		   		// legend.setAnchor(StandardLegend.SOUTH);

		        chart.setBackgroundPaint(getBackground());
		        final TextTitle subtitle = new TextTitle("");
		        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
		        subtitle.setPosition(RectangleEdge.TOP);
//		        subtitle.setSpacer(new Spacer(Spacer.RELATIVE, 0.05, 0.05, 0.05, 0.05));
		        subtitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
		        chart.addSubtitle(subtitle);
		        
		        plot = chart.getCategoryPlot();
		        plot.setForegroundAlpha(0.5f);
		        
		  //      plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
		        plot.setBackgroundPaint(Color.lightGray);
		        plot.setDomainGridlinesVisible(true);
		        plot.setDomainGridlinePaint(Color.white);
		        plot.setRangeGridlinesVisible(true);
		        plot.setRangeGridlinePaint(Color.white);
		        
		        
		        final CategoryAxis domainAxis = plot.getDomainAxis();
		        // domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		        domainAxis.setLowerMargin(0.0);
		        domainAxis.setUpperMargin(0.0);
		        domainAxis.addCategoryLabelToolTip("Type 1", "The first type.");
		        domainAxis.addCategoryLabelToolTip("Type 2", "The second type.");
		        domainAxis.addCategoryLabelToolTip("Type 3", "The third type.");
		        
		       
		        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		        rangeAxis.setTickUnit(new NumberTickUnit(0.1F));
		        rangeAxis.setLabelAngle(0 * Math.PI / 2.0);
		        // OPTIONAL CUSTOMISATION COMPLETED.
		        
		        return chart;
	}
		
	// no desipat ^_^
	private void initComponents() {
		
		JPanel graphContainer = new JPanel();
		// graphContainer.setPreferredSize(new Dimension(475, 300));
		
		
		// create a dataset...
        final double[][] data = new double[][] {
        		{0.0}
        };

        final CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
            "Series ", "", data
        );
        
        
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
        // chartPanel.setPreferredSize(new Dimension(460, 300));
		
		graphContainer.add(chartPanel);
		add(graphContainer);
		
		JPanel fieldContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		// fieldContainer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		// fieldContainer.setPreferredSize(new Dimension(150, 100));
		
		Dimension lblSize = new Dimension(10, 30);
		Dimension txtSize = new Dimension(35, 30);
		Dimension btnSize = new Dimension(90, 30);
		
		txtN = new JTextField("");
		txtN.setPreferredSize(txtSize);
		
		txtn = new JTextField("");
		txtn.setPreferredSize(txtSize);
		
		txtK = new JTextField("");
		txtK.setPreferredSize(txtSize);
		txtK.setEditable(false);
		
		JLabel lbln = new JLabel("n");
		lbln.setPreferredSize(lblSize);
		
		JLabel lblN = new JLabel("N");
		lblN.setPreferredSize(lblSize);
		
		JLabel lblK = new JLabel("K");
		lblK.setPreferredSize(lblSize);
		
		lblgivenX = new JLabel("Probability given x = 0 : ");
		lblgivenX.setPreferredSize(new Dimension(300, 30));
		//lblgivenX.setBorder(BorderFactory.createEtchedBorder());
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBorder(BorderFactory.createEtchedBorder());
		btnCalculate.setPreferredSize(btnSize);
				
		
		fieldContainer.add(lblN);
		fieldContainer.add(txtN);
		
		fieldContainer.add(Box.createRigidArea(new Dimension(45, 30)));
		
		fieldContainer.add(lbln);
		fieldContainer.add(txtn);
				
		fieldContainer.add(Box.createRigidArea(new Dimension(45, 30)));
		
		fieldContainer.add(lblK);
		fieldContainer.add(txtK);
		
		
		lblError = new JLabel("");
		lblError.setForeground(Color.red);
		
		fieldContainer.add(lblError);

		

		JPanel sliderContainer = new JPanel();
		sliderContainer.setBorder(BorderFactory.createTitledBorder("Input"));
		sliderContainer.setLayout(new BoxLayout(sliderContainer, BoxLayout.Y_AXIS));
		// sliderContainer.setPreferredSize(new Dimension(400, 125));
		
		lblK = new JLabel("k - number of total success elements in the population size");
		lblK.setPreferredSize(lblSize);
		
		sliderContainer.add(lblK);
		
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
		
		
		
		add(fieldContainer);
		add(sliderContainer);
		
		
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
	
	public int getk() throws Exception{
		txtK.setText(sliderK.getValue() + "");
		return sliderK.getValue();
	}
	
	public void setn(int n) {
		txtn.setText(n+"");
	}
	
	
	public boolean isInputValid(int type) {
		Object singleX[];
		Object rangeX[];
		try {
		Object _singleX[] = {txtn, txtN, getk()};
		
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
		sliderX.addChangeListener(listener);
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
	
	public int getValueOfX() {
		return sliderX.getValue();
	}
	
	public void setGivenXProbability(int x, double prob) {
		lblgivenX.setText("Probability given x = " + x + " : " + prob);
	}
	
	public void updateDomain(final CategoryDataset dataset) {
		plot.setDataset(dataset);
	}
	
	public void setMinimumK(int minimum) {
		if (sliderK.getMinimum() != minimum) 
			sliderK.setMinimum(minimum);
	}
	
	public void setMaximumK(int maximum) {
		if (sliderK.getMaximum() != maximum) 
			sliderK.setMaximum(maximum);
	}
	
	public void setMinimumX(int minimum) {
		if (sliderX.getMinimum() != minimum) 
			sliderX.setMinimum(minimum);
	}
	
	public void setMaximumX(int maximum) {
		if (sliderX.getMaximum() != maximum) 
			sliderX.setMaximum(maximum);
	}


	public void addGraphListener(View listener) {
		txtn.addKeyListener(listener);
		txtN.addKeyListener(listener);
		// sliderX.addChangeListener(listener);
		sliderK.addChangeListener(listener);
		slidern.addChangeListener(listener);
	}

}

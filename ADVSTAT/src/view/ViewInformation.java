package view;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Population;


public class ViewInformation extends JPanel {

	private static final Dimension Space = new Dimension(450, 30);
	private JLabel mean;
	private JLabel variance;
	private JLabel populationSize;
	private JLabel sampleSize;
	private JLabel sampleMean;
	private JLabel sampleVariance;

	public ViewInformation(){
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		add(makeLabel("Population size: "));
		populationSize = makeLabel("");
		add(populationSize);
		add(Box.createRigidArea(Space));
		
		add(makeLabel("Population mean: "));
		mean = makeLabel("");
		add(mean);
		add(Box.createRigidArea(Space));
		
		add(makeLabel("Population variance: "));
		variance = makeLabel("");
		add(variance);
		add(Box.createRigidArea(Space));
		
		add(makeLabel("Sample size: "));
		sampleSize = makeLabel("");
		add(sampleSize);
		add(Box.createRigidArea(Space));
		
		add(makeLabel("Sample mean: "));
		sampleMean = makeLabel("");
		add(sampleMean);
		add(Box.createRigidArea(Space));
		
		add(makeLabel("Sample variance: "));
		sampleVariance = makeLabel("");
		add(sampleVariance);
		add(Box.createRigidArea(Space));
		
	}
	
	public void InitializePopulationInformation(int populationSize, double mean, double variance){
		
	}
	
	public void InitializeSampleInformation(int sampleSize, double sampleMean, double sampleVariance){
		this.sampleSize.setText("" + sampleSize);
	}
	
	private JLabel makeLabel(String text){
		Dimension labelDimension = new Dimension(150, 30);
		JLabel label = new JLabel(text);		
		label.setPreferredSize(labelDimension);
		return label;
	}

	public void InitializePopulationInformation(Population population) {
		this.populationSize.setText("" + population.getPopulationSize());
		this.mean.setText("" + population.getMean());
		this.variance.setText("" + population.getVariance());
	}

	public void InitializeSampleInformation(Population population) {
		this.sampleSize.setText("" + population.getSampleSize());
		this.sampleMean.setText("" + population.getSampleMean());
		this.sampleVariance.setText("" + population.getSampleVariance());
	}
}

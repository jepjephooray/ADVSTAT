package view;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.jfree.data.category.CategoryDataset;

public class MainPanel extends JPanel{
	private GraphPanel populationGraphPanel;
	private GraphPanel samplingGraphPanel;
	public ParameterPanel parameterPanel;

	public MainPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel graphPanels = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		GraphPanel.PopulationGraph = populationGraphPanel = new GraphPanel("Population Distribution");
		graphPanels.add(populationGraphPanel);
		
		GraphPanel.SamplingGraph = samplingGraphPanel = new GraphPanel("Sampling Distribution");
		graphPanels.add(populationGraphPanel);
	
		parameterPanel = new ParameterPanel();
		
		add(graphPanels);
		add(parameterPanel);
		
	}

	public void addGraphListener(View view) {
		parameterPanel.addKeyListener(view);
		parameterPanel.addChangeListener(view);
	}

	public void updatePopulationDomain(CategoryDataset dataset) {
		GraphPanel.PopulationGraph.updateDomain(dataset);
	}
	
	public void updateSamplingDomain(CategoryDataset dataset) {
		GraphPanel.SamplingGraph.updateDomain(dataset);
	}
}

package view;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.jfree.data.category.CategoryDataset;

import view.GraphPanel.Type;

public class MainPanel extends JPanel{
	private GraphPanel populationGraphPanel;
	private GraphPanel samplingGraphPanel;
	public ParameterPanel parameterPanel;

	public MainPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel graphPanels = new JPanel();
		graphPanels.setLayout(new BoxLayout(graphPanels, BoxLayout.Y_AXIS));
		
		GraphPanel.PopulationGraph = populationGraphPanel = new GraphPanel("Population Distribution", Type.Population);
		graphPanels.add(populationGraphPanel);
		
		GraphPanel.SamplingGraph = samplingGraphPanel = new GraphPanel("Sampling Distribution", Type.Sample);
		graphPanels.add(samplingGraphPanel);
	
		parameterPanel = new ParameterPanel();
		
		add(graphPanels);
		add(parameterPanel);
		
	}

	public void addGraphListener(View view) {
		parameterPanel.addGraphListener(view);
	}

	public void updatePopulationDomain(CategoryDataset dataset) {
		GraphPanel.PopulationGraph.updateDomain(dataset);
	}
	
	public void updateSamplingDomain(CategoryDataset dataset) {
		GraphPanel.SamplingGraph.updateDomain(dataset);
	}
}

package controller;

import java.util.Enumeration;
import java.util.Hashtable;

import model.Model;
import view.Parameters;
import view.GraphUpdateEvent;
import view.GraphUpdateListener;
import view.View;



public class Controller2 implements GraphUpdateListener {
	private Model model;
	private View view;
	
	public Controller2(Model Model, View View) {
		this.model = Model;
		this.view = View;
		
		this.view.addGraphListener(this);
	}

	@Override
	public void updatePerformed(GraphUpdateEvent e) {
		Parameters p = e.getParameters();
		
		// prepare variables
		double[][] data = new double[1][];
		data[0] = new double[p.getMaximum()];
		
		// compute for all x
	//	for(int x = 0; x < p.getMaximum(); x++) {
	//		model.calculateHypergeometricDist(x+1, p.getBigN(), p.getSmallN(), p.getK());
	//		data[0][x] = model.getProbability();
	//	}
		Hashtable<String, Double> frequencyTable = this.model.getPopulationFrequencyTable();
		Enumeration<String> keys = frequencyTable.keys();
		
		String currentKey;
		while ((currentKey = keys.nextElement()) != null){
			Double frequency = frequencyTable.get(currentKey);
			
		}
		
		// update
		view.UpdateGraph(data);
	}

	
}

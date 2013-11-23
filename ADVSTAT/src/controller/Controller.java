package controller;

import model.Model;
import view.GraphUpdateEvent;
import view.GraphUpdateEvent.UpdateType;
import view.GraphUpdateListener;
import view.Parameters;
import view.View;



public class Controller implements GraphUpdateListener {
	private Model model;
	private View view;
	
	public Controller(Model Model, View View) {
		this.model = Model;
		this.view = View;
		this.view.addGraphListener(this);
	}

	@Override
	public void updatePerformed(GraphUpdateEvent e) {
		Parameters param = e.getParameters();
		
		if (e.getType() == UpdateType.Population){
			model.Initialize(param);
			view.UpdatePopulationGraph(model.getPopulationFrequencyTable());
		}else {
			model.changeSampleSize(param);
			view.UpdateSampleGraph(model.getSampleFrequencyTable());
		}
	}

	
}

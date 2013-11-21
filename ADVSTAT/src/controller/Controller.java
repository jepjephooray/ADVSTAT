package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import model.Model;
import view.View2;

public class Controller {
	
	View2 view;
	Model model;
	ArrayList<Double> distList = new ArrayList<>();
	generateListener generateListener = new generateListener();
	
	public Controller(View2 view, Model model) {
		
		this.view = view;
		this.model = model;
		
		this.view.setGenerateListener(generateListener);
	}

	public void display() {
		
		
		view.setDistributionListP(distList);
		view.redrawGraph();
		view.setVisible(true);
	}
	
	 class generateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch(view.getCmbxType().getSelectedIndex()) {
			
			case 0:
				randomGenerate();
				break;
				
			case 1:
				
				break; 
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				break;
			}
			
		}
		
	}
	
	public void randomGenerate(){
		Random random = new Random();
        int maxDataPoints = 5;
        int maxScore = 10;
        distList.clear();
        for (int i = 0; i < maxDataPoints; i++) {
        	distList.add((double) random.nextDouble() * maxScore);
      //  	distList.add((double) i);
        }
        display();
		
	}
	
}

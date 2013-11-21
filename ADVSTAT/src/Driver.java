import java.util.Enumeration;
import java.util.Hashtable;

import view.View;
import controller.Controller;
import controller.Controller;
import model.Model;
import model.Population;


public class Driver {
	
	public static void main(String args[]) {
		View view = new View();
		Model model = new Model();
		//Hashtable<String, Integer> freqTable = model.getPopulationFrequencyTable();
		//System.out.println();
		
		
		//Enumeration<String> keys = freqTable.keys();
		/*
		for(; keys.hasMoreElements();) {
			String key = keys.nextElement();
			System.out.println(key + " - " + freqTable.get(key));
		}
		*/
		
		// Controller controller = new Controller(view, model);
		//controller.display();
		Controller controller = new Controller(model, view);
		
	}
	
	
}

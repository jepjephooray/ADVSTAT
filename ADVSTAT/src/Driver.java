import model.Model;
import model.generate.BimodalStrategy;
import model.generate.NormalStrategy;
import model.generate.UniformStrategy;
import view.Parameters;
import view.View;
import controller.Controller;


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
		
		//new Parameters(n, N, u, l, type)
		Parameters param = new Parameters(5, 10, 5, 0, Model.GenerationType.Normal);
		//NormalStrategy normStrat = new NormalStrategy(param);
		//normStrat.Generate();
		//BimodalStrategy bimodal = new BimodalStrategy(param);
		//bimodal.Generate();
		UniformStrategy uniform = new UniformStrategy(param);
		uniform.Generate();
		
	}
	
	
}

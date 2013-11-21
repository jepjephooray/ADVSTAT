import view.View;
import controller.Controller;
import model.Model;
import model.Population;


public class Driver {
	
	public static void main(String args[]) {
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(view, model);
		controller.display();
		model.generateIntData(1, 10, 3);
		for (int i = 0; i < model.getPopulation().getData().length; i++) {
			System.out.println(model.getPopulation().getData()[i]);
		}
		System.out.println();
		model.population_mean_variance();
		model.generatePopulationDistributionTable();
		model.generatePossibleSamples(2);
		model.sampleMean_mean_variance();
		model.generateSamplingDistributionTable();
	}
	
	
}

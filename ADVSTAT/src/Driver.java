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
		
	}
	
	
}

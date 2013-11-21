import view.View2;
import controller.Controller;
import model.Model;
import model.Population;


public class Driver {
	
	public static void main(String args[]) {
		View2 view = new View2();
		Model model = new Model();
		Controller controller = new Controller(view, model);
		controller.display();
		
	}
	
	
}

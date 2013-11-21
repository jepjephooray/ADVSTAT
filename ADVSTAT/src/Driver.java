import view.View;
import view.View2;
import controller.Controller;
import controller.Controller2;
import model.Model;
import model.Population;


public class Driver {
	
	public static void main(String args[]) {
		View view = new View();
		Model model = new Model();
		Controller2 controller = new Controller2(model, view);
		
	}
	
	
}

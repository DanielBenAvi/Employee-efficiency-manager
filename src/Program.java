
import Controller.Controller;
import Model.Model;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage stg) throws Exception {
		Model Model = new Model();
		View View = new View(stg);
		

		Controller theController = new Controller(Model, View);



	}


}

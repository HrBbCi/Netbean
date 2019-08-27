import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClickerController extends Application {

	private AutoClicker autoClicker = new AutoClicker(1, 1);
	@FXML
	public TextField numClickText;
	@FXML
	public TextField delayText;

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("ClickerView.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void onSubmitClick() {
		System.out.println(delayText.getText());
		System.out.println(numClickText.getText());

		Integer delay = Integer.parseInt(delayText.getText()) * 1000;
		Integer count = Integer.parseInt(numClickText.getText());

		autoClicker.setCount(count);
		autoClicker.setDelay(delay);
		autoClicker.start();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class findByTimeWindow extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public findByTimeWindow() {
		// TODO Auto-generated constructor stub
		Stage stage = new Stage();
		try {
			start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLs/findByTimeWindow.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("选择医生工作时间窗口");
		primaryStage.show();
	}

}

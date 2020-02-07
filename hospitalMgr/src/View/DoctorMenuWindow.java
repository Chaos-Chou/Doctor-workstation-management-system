package View;

import Manager.StageManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DoctorMenuWindow extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public DoctorMenuWindow() {
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLs/DoctorMenuWindow.fxml"));
		Parent root = loader.load();
		StageManager.CONTROLLER.put("DoctorMenuWindowController", loader.getController());
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("医生选择目录窗口");
		primaryStage.show();
	}

}

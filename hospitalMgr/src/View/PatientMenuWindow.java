package View;

import Manager.StageManager;

/**
 * 患者选择目录窗口
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PatientMenuWindow extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public PatientMenuWindow() {
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLs/PatientMenuWindow.fxml"));
		Parent root = loader.load();
		StageManager.CONTROLLER.put("PatientMenuWindowController", loader.getController());
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("患者目录窗口");
		primaryStage.show();
	}

}

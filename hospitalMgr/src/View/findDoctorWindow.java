package View;

import Manager.StageManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class findDoctorWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLs/findDoctorWindow.fxml"));
		Parent root = loader.load();
		StageManager.CONTROLLER.put("findDoctorWindowController", loader.getController());
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("查询医生窗口");
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public findDoctorWindow() {
		// TODO Auto-generated constructor stub
		Stage stage = new Stage();
		try {
			start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

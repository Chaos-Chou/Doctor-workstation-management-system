package View;

import Controller.updateDoctorWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class updateDoctorWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLs/updateDoctorWindow.fxml"));
		Parent root = loader.load();
		updateDoctorWindowController controller = loader.getController();
		controller.init();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("修改医生窗口");
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public updateDoctorWindow() {
		// TODO Auto-generated constructor stub
		Stage stage = new Stage();
		try {
			start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

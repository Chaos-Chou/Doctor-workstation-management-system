package Controller;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.DoctorDaoImp;
import Manager.StageManager;
import View.DoctorMenuWindow;
import entity.Doctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class DoctorWindowController {

	@FXML
	private JFXButton button;

	@FXML
	private TextField textField;

	@FXML
	void click(ActionEvent event) {
		int docId = Integer.valueOf(textField.getText());
		Doctor doctor = new DoctorDaoImp().findDoctor(docId);
		if (doctor == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("您的输入有误！请重新输入");

			alert.showAndWait();
		} else {
			new DoctorMenuWindow();
			DoctorMenuWindowController controller = (DoctorMenuWindowController) StageManager.CONTROLLER
					.get("DoctorMenuWindowController");
			controller.setDoctor(doctor);
		}
	}

}
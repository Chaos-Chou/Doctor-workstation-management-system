package Controller;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.PatientDaoImp;
import Manager.StageManager;
import View.PatientMenuWindow;
import entity.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PatientWindowController {

	@FXML
	private JFXButton button;

	@FXML
	private TextField textField;

	@FXML
	void click(ActionEvent event) {
		int patId = Integer.valueOf(textField.getText());
		Patient user = new PatientDaoImp().findPatient(patId);
		if (user == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("您的输入有误！请重新输入");

			alert.showAndWait();
		} else {
			new PatientMenuWindow();
			PatientMenuWindowController controller = (PatientMenuWindowController) StageManager.CONTROLLER
					.get("PatientMenuWindowController");
			controller.setUser(user);
		}
	}

}

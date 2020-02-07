package Controller;

import com.jfoenix.controls.JFXButton;

import View.AdminWindow;
import View.DoctorWindow;
import View.PatientWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainWindowController {

	@FXML
	private JFXButton button2;

	@FXML
	private JFXButton button3;

	@FXML
	private JFXButton button1;

	@FXML
	void clickButton1(ActionEvent event) throws Exception {
		new PatientWindow();
	}

	@FXML
	void clickButton2(ActionEvent event) {
		new DoctorWindow();
	}

	@FXML
	void clickButton3(ActionEvent event) {
		new AdminWindow();
	}

}

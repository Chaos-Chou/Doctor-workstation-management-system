package Controller;

import com.jfoenix.controls.JFXButton;

import View.addDoctorWindow;
import View.delDoctorWindow;
import View.findDoctorWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DoctorManageWindowController {

	@FXML
	private JFXButton add;

	@FXML
	private JFXButton find;

	@FXML
	private JFXButton update;

	@FXML
	private JFXButton delete;

	@FXML
	void click1(ActionEvent event) {
		// 增
		new addDoctorWindow();
	}

	@FXML
	void click2(ActionEvent event) {
		// 删
		new delDoctorWindow();
	}

	@FXML
	void click3(ActionEvent event) {
		// 改
		new findDoctorWindow();
	}

	@FXML
	void click4(ActionEvent event) {
		// 查
		new findDoctorWindow();
	}

}

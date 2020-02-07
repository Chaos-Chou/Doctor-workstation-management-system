package Controller;

import com.jfoenix.controls.JFXButton;

import View.findByGradeWindow;
import View.findByTimeWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PFindDoctorController {

	@FXML
	private JFXButton button2;

	@FXML
	private JFXButton button1;

	@FXML
	void click1(ActionEvent event) {
		// 按等级查询医生
		new findByGradeWindow();
	}

	@FXML
	void click2(ActionEvent event) {
		// 按时间查询医生
		new findByTimeWindow();
	}

}

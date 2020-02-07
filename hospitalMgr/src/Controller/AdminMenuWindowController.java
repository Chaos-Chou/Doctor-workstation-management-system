package Controller;

import com.jfoenix.controls.JFXButton;

import View.DoctorManageWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminMenuWindowController {

	@FXML
	private JFXButton doctor;

	@FXML
	private JFXButton subscribe;

	@FXML
	private JFXButton patient;

	@FXML
	private JFXButton medicine;

	@FXML
	private JFXButton room;

	@FXML
	private JFXButton order;

	@FXML
	void click1(ActionEvent event) {
		// 医生管理 (剩下的管理与此管理相似，暂不实现)
		new DoctorManageWindow();
	}

	@FXML
	void click2(ActionEvent event) {
		// 患者管理
	}

	@FXML
	void click3(ActionEvent event) {
		// 订单管理
	}

	@FXML
	void click4(ActionEvent event) {
		// 药品管理
	}

	@FXML
	void click5(ActionEvent event) {
		// 诊室管理
	}

	@FXML
	void click6(ActionEvent event) {
		// 预约管理
	}

}

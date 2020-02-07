package Controller;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.DoctorDaoImp;
import Manager.StageManager;
import entity.Doctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ChangeWorktimeWindowController {

	@FXML
	private JFXButton afternoon;

	@FXML
	private JFXButton noon;

	@FXML
	private JFXButton morning;

	@FXML
	void click1(ActionEvent event) {
		// 上午 1
		DoctorMenuWindowController controller = (DoctorMenuWindowController) StageManager.CONTROLLER
				.get("DoctorMenuWindowController");
		Doctor doctor = controller.getDoctor();
		if (new DoctorDaoImp().updateWorktime(doctor.getD_id(), 1)) {
			doctor.setWorktime(1);
			showInfo(doctor);
		} else {
			showAlert();
		}
	}

	@FXML
	void click2(ActionEvent event) {
		// 中午 2
		DoctorMenuWindowController controller = (DoctorMenuWindowController) StageManager.CONTROLLER
				.get("DoctorMenuWindowController");
		Doctor doctor = controller.getDoctor();
		if (new DoctorDaoImp().updateWorktime(doctor.getD_id(), 2)) {
			doctor.setWorktime(2);
			showInfo(doctor);
		} else {
			showAlert();
		}
	}

	@FXML
	void click3(ActionEvent event) {
		// 下午 3
		DoctorMenuWindowController controller = (DoctorMenuWindowController) StageManager.CONTROLLER
				.get("DoctorMenuWindowController");
		Doctor doctor = controller.getDoctor();
		if (new DoctorDaoImp().updateWorktime(doctor.getD_id(), 3)) {
			doctor.setWorktime(3);
			showInfo(doctor);
		} else {
			showAlert();
		}
	}

	void showAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("错误警告");
		alert.setHeaderText(null);
		alert.setContentText("对不起，更新失败！");
		alert.showAndWait();
	}

	void showInfo(Doctor doctor) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("通知");
		alert.setHeaderText(null);
		String temp;
		if (doctor.getWorktime() == 1) {
			temp = "上午";
		} else if (doctor.getWorktime() == 2) {
			temp = "中午";
		} else {
			temp = "下午";
		}
		alert.setContentText("更新成功！您的工作时间已经改为：" + temp);
		alert.showAndWait();
	}

}

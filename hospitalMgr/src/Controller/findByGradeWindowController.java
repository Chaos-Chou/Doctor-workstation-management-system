package Controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.DoctorDaoImp;
import entity.Doctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class findByGradeWindowController {

	@FXML
	private JFXButton button2;

	@FXML
	private JFXButton button1;

	@FXML
	void click1(ActionEvent event) {
		// 普通医生
		ArrayList<Doctor> doctors = null;
		doctors = new DoctorDaoImp().findDoctorsGrade(0);
		if (doctors == null) {
			showAlert();
		} else {
			showInfo(doctors);
		}
	}

	@FXML
	void click2(ActionEvent event) {
		// 专家医生
		ArrayList<Doctor> doctors = null;
		doctors = new DoctorDaoImp().findDoctorsGrade(1);
		if (doctors == null) {
			showAlert();
		} else {
			showInfo(doctors);
		}
	}

	// 报错信息
	void showAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("错误警告");
		alert.setHeaderText(null);
		alert.setContentText("对不起，查询内容为空！");
	}

	// 查询信息
	void showInfo(ArrayList<Doctor> doctors) {
		Stage stage = new Stage();
		stage.setTitle("查询结果窗口");
		VBox box = new VBox();
		Label list = new Label("ID\t" + String.format("%-10s", "姓名\t") + "性别\t\t" + String.format("%-15s", "电话\t\t\t")
				+ "等级\t\t工作时间\t\t诊室号\t" + String.format("%-15s", "诊室名") + "诊室位置");
		box.getChildren().add(list);
		Label tempLabel = null;
		for (int i = 0; i < doctors.size(); i++) {
			tempLabel = doctors.get(i).showInfo();
			box.getChildren().add(tempLabel);
		}

		Scene scene = new Scene(box);
		stage.setScene(scene);
		stage.show();
	}
}

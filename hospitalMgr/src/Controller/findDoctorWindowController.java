package Controller;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.DoctorDaoImp;
import View.updateDoctorWindow;
import entity.Doctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class findDoctorWindowController {

	private Doctor doctor = null;

	@FXML
	private JFXButton button;

	@FXML
	private TextField id;

	@FXML
	private JFXButton button1;

	@FXML
	void click1(ActionEvent event) {
		// 查询
		int docId = Integer.valueOf(id.getText());
		doctor = new DoctorDaoImp().findDoctor(docId);
		if (doctor == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("查询失败！不存在所查询的一医生！");
			alert.showAndWait();
		} else {
			this.setDoctor(doctor);
			showInfo(doctor);
		}
	}

	@FXML
	void click(ActionEvent event) {
		// 修改
		int docId = Integer.valueOf(id.getText());
		doctor = new DoctorDaoImp().findDoctor(docId);
		if (doctor == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("查询失败！不存在所查询的一医生！");
			alert.showAndWait();
		} else {
			this.setDoctor(doctor);
			new updateDoctorWindow();
		}
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	void showInfo(Doctor doctor) {
		Stage stage = new Stage();
		stage.setTitle("查询结果窗口");
		VBox box = new VBox();
		Label list = new Label("ID\t" + String.format("%-10s", "姓名\t") + "性别\t\t" + String.format("%-15s", "电话\t\t\t")
				+ "等级\t\t工作时间\t\t诊室号\t" + String.format("%-15s", "诊室名") + "诊室位置");
		box.getChildren().add(list);
		Label tempLabel = null;
		tempLabel = doctor.showInfo();
		box.getChildren().add(tempLabel);

		Scene scene = new Scene(box);
		stage.setScene(scene);
		stage.show();
	}

}

package Controller;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.SubscribeDaoImp;
import View.ChangeWorktimeWindow;
import entity.Doctor;
import entity.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class DoctorMenuWindowController {

	private Doctor doctor = null; // 登录的医生

	@FXML
	private JFXButton button2;

	@FXML
	private Label title;

	@FXML
	private JFXButton button1;

	@FXML
	void click1(ActionEvent event) {
		// 更改工作时间
		new ChangeWorktimeWindow();
	}

	@FXML
	void click2(ActionEvent event) {
		// 就诊患者
		Subscribe nextSubscribe = new SubscribeDaoImp().findNextSubscribe(doctor.getD_id());
		if (nextSubscribe == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("您现在无下一位患者！");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("通知");
			alert.setHeaderText(null);
			alert.setContentText("您的下一位患者编号为：" + nextSubscribe.getP_id() + "\n已经通知患者，请准备就诊");
			alert.showAndWait();
			new SubscribeDaoImp().updateSubscribe(nextSubscribe.getS_date(), nextSubscribe.getS_id(), 2);
		}
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
		setLabel(doctor);
	}

	public void setLabel(Doctor doctor) {
		String info = doctor.getD_name() + "医生";
		title.setText(info);
	}

}

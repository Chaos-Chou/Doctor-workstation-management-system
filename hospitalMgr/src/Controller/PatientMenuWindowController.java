package Controller;

/**
 * 患者选择目录窗口控制
 */

import com.jfoenix.controls.JFXButton;

import View.PFindDoctorWindow;
import View.SubscribeDoctorWindow;
import View.cancelSubscribeWindow;
import entity.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PatientMenuWindowController {

	private Patient user;// 登录的用户信息

	@FXML
	private JFXButton button2;

	@FXML
	private JFXButton button3;

	@FXML
	private JFXButton button1;

	@FXML
	private Label label;

	@FXML
	void clickButton1(ActionEvent event) {
		// 预约医生
		new SubscribeDoctorWindow();
	}

	@FXML
	void clickButton2(ActionEvent event) {
		// 查询医生
		new PFindDoctorWindow();
	}

	@FXML
	void clickButton3(ActionEvent event) {
		// 取消预约
		new cancelSubscribeWindow();
	}

	public void setLabel(Patient user) {
		String info = user.getP_name();
		if (user.getP_gender().equals("m")) {
			info += "先生";
		} else if (user.getP_gender().equals("w")) {
			info += "女士";
		}

		label.setText(info);
	}

	public Patient getUser() {
		return user;
	}

	public void setUser(Patient user) {
		setLabel(user);
		this.user = user;
	}

}

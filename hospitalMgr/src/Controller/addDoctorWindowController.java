package Controller;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.DoctorDaoImp;
import entity.Doctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class addDoctorWindowController {

	@FXML
	private JFXButton button;

	@FXML
	private TextField gender;

	@FXML
	private TextField phone;

	@FXML
	private TextField grade;

	@FXML
	private TextField name;

	@FXML
	private TextField id;

	@FXML
	private TextField worktime;

	@FXML
	private TextField roomid;

	@FXML
	void click(ActionEvent event) {
		Doctor doctor = new Doctor();
		doctor.setD_id(Integer.valueOf(id.getText()));
		doctor.setD_name(name.getText());
		doctor.setD_gender(gender.getText());
		doctor.setD_phone(phone.getText());
		doctor.setGrade(Integer.valueOf(grade.getText()));
		doctor.setRoom_id(Integer.valueOf(roomid.getText()));
		doctor.setWorktime(Integer.valueOf(worktime.getText()));

		if (new DoctorDaoImp().addDoctor(doctor)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("通知");
			alert.setHeaderText(null);
			alert.setContentText("添加成功！");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("添加失败！");
			alert.showAndWait();
		}
	}

}

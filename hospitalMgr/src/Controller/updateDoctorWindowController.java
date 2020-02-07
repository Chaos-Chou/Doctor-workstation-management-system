package Controller;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.DoctorDaoImp;
import Manager.StageManager;
import entity.Doctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class updateDoctorWindowController {

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
		DoctorDaoImp ddImp = new DoctorDaoImp();
		Doctor doctor = new Doctor();
		doctor.setD_gender(gender.getText());
		doctor.setD_id(Integer.valueOf(id.getText()));
		doctor.setD_name(name.getText());
		doctor.setD_phone(phone.getText());
		doctor.setGrade(Integer.valueOf(grade.getText()));
		doctor.setRoom_id(Integer.valueOf(roomid.getText()));
		doctor.setWorktime(Integer.valueOf(worktime.getText()));

		findDoctorWindowController controller = (findDoctorWindowController) StageManager.CONTROLLER
				.get("findDoctorWindowController");
		int docId = controller.getDoctor().getD_id();

		if (ddImp.updateDoctor(docId, doctor)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("通知");
			alert.setHeaderText(null);
			alert.setContentText("修改成功！");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("修改失败！");
			alert.showAndWait();
		}
	}

	public void init() {
		findDoctorWindowController controller = (findDoctorWindowController) StageManager.CONTROLLER
				.get("findDoctorWindowController");
		Doctor doctor = controller.getDoctor();
		id.appendText(String.valueOf(doctor.getD_id()));
		name.appendText(doctor.getD_name());
		gender.appendText(doctor.getD_gender());
		phone.appendText(doctor.getD_phone());
		grade.appendText(String.valueOf(doctor.getGrade()));
		roomid.appendText(String.valueOf(doctor.getRoom_id()));
		worktime.appendText(String.valueOf(doctor.getWorktime()));
	}

}

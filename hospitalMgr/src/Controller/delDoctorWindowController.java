package Controller;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.DoctorDaoImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class delDoctorWindowController {

	@FXML
	private JFXButton button;

	@FXML
	private TextField id;

	@FXML
	void click(ActionEvent event) {
		int del = Integer.valueOf(id.getText());

		if (new DoctorDaoImp().delDoctor(del)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("通知");
			alert.setHeaderText(null);
			alert.setContentText("删除成功！");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("删除失败！");
			alert.showAndWait();
		}
	}

}

package Controller;

import com.jfoenix.controls.JFXButton;

import View.AdminMenuWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class AdminWindowController {

	@FXML
	private JFXButton button;

	@FXML
	private TextField textField;

	@FXML
	void click(ActionEvent event) {
		if (textField.getText().equals("301018")) {
			new AdminMenuWindow();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("管理员密码输入有误！");
			alert.showAndWait();
		}
	}

}

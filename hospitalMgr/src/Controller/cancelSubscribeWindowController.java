package Controller;

import java.sql.Date;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.SubscribeDaoImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class cancelSubscribeWindowController {

	@FXML
	private JFXButton button;

	@FXML
	private TextField month;

	@FXML
	private TextField year;

	@FXML
	private TextField num;

	@FXML
	private TextField day;

	@FXML
	void click(ActionEvent event) {
		Date date = new Date(Integer.valueOf(year.getText()) - 1900, Integer.valueOf(month.getText()) - 1,
				Integer.valueOf(day.getText()));
		int number = Integer.valueOf(num.getText());
		if (new SubscribeDaoImp().delSubscribe(date, number)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("通知");
			alert.setHeaderText(null);
			alert.setContentText("删除预约成功！");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("对不起，输入的预约单不存在，删除失败！");
			alert.showAndWait();
		}
	}

}

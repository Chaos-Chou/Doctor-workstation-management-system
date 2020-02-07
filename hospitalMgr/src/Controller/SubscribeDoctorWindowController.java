package Controller;

import java.sql.Date;

import com.jfoenix.controls.JFXButton;

import Dao.Daoimp.SubscribeDaoImp;
import Manager.StageManager;
import entity.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class SubscribeDoctorWindowController {

	@FXML
	private JFXButton button;

	@FXML
	private TextField textArea;

	@FXML
	void click(ActionEvent event) {
		// 确认输入
		int DocId = Integer.valueOf(textArea.getText());
		PatientMenuWindowController controller = (PatientMenuWindowController) StageManager.CONTROLLER
				.get("PatientMenuWindowController");
		Subscribe tempSubscribe = new Subscribe();
		tempSubscribe.setD_id(DocId);
		tempSubscribe.setP_id(controller.getUser().getP_id());
		tempSubscribe.setS_date(new Date(System.currentTimeMillis()));
		tempSubscribe.setS_id(Math.abs(tempSubscribe.getS_date().hashCode()) % 10000);// 生成预约单号
		tempSubscribe.setState(1);

		if (new SubscribeDaoImp().addSubscribe(tempSubscribe)) {
			Alert success = new Alert(AlertType.INFORMATION);
			success.setTitle("通知");
			success.setHeaderText(null);
			success.setContentText("预约成功！请您等待医生就诊，您的预约单号为：" + tempSubscribe.getS_id());
			success.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误警告");
			alert.setHeaderText(null);
			alert.setContentText("对不起，您预约的时间或医生已满");

			alert.showAndWait();
		}
	}

}

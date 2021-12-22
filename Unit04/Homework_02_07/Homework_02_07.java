package Unit04.Homework_02_07;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Homework_02_07 extends Application {
//    ImageView cnf = new ImageView(new Image("/Unit04/cnf/cnf.jpg"));// var不能用在成员变量上，疑似只能用在局部变量上

    @Override
    public void start(Stage primaryStage) throws Exception {
	GridPane root = new GridPane();
	root.setAlignment(Pos.CENTER);
	
	ImageView cnf = new ImageView(new Image("/Unit04/cnf/cnf.jpg"));

	root.add(cnf, 1, 0);

	var btnEnlarge = new Button("Enlarge");
	btnEnlarge.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		// TODO 自动生成的方法存根
		cnf.setScaleX(1.1 * cnf.getScaleX());
		cnf.setScaleY(1.1 * cnf.getScaleY());
	    }
	});
	var btnShrink = new Button("Shrink");
	btnShrink.setOnAction(new EventHandler<ActionEvent>() {

	    @Override
	    public void handle(ActionEvent event) {
		// TODO 自动生成的方法存根
		cnf.setScaleX(0.9 * cnf.getScaleX());
		cnf.setScaleY(0.9 * cnf.getScaleY());
	    }
	});

	root.add(btnEnlarge, 0, 1);
	root.add(btnShrink, 2, 1);

	primaryStage.setScene(new Scene(root, 600, 300));
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }

}
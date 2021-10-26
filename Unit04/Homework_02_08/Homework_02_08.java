package Unit04.Homework_02_08;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Homework_02_08 extends Application {
    ImageView cnf = new ImageView(new Image("/Unit04/cnf/cnf.jpg"));// var�������ڳ�Ա�����ϣ�����ֻ�����ھֲ�������

    @Override
    public void start(Stage primaryStage) throws Exception {
	GridPane root = new GridPane();
	root.setAlignment(Pos.CENTER);

	// var cnf = new ImageView(new Image("/Unit04/cnf/cnf.jpg"));
	root.add(cnf, 1, 0);
	cnf.setOnMouseDragged(e -> {
	    cnf.setX(e.getX());
	    cnf.setY(e.getY());
	});

	var btnEnlarge = new Button("Enlarge");
	btnEnlarge.setOnAction(e -> {
	    cnf.setScaleX(1.1 * cnf.getScaleX());
	    cnf.setScaleY(1.1 * cnf.getScaleY());
	});
	var btnShrink = new Button("Shrink");
	btnShrink.setOnAction(e -> {// lamda���ʽҪ��ӿ��ڵĳ��󷽷�ֻ����һ��������Ϊ�����Ĳ���--����ͬ
	    cnf.setScaleX(0.9 * cnf.getScaleX());
	    cnf.setScaleY(0.9 * cnf.getScaleY());
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
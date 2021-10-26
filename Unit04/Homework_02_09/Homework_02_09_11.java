package Unit04.Homework_02_09;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Homework_02_09_11 extends Application {
    ImageView cnf = new ImageView(new Image("/Unit04/cnf/cnf.jpg"));// var不能用在成员变量上，疑似只能用在局部变量上
    double cnfX = 0.0;
    double cnfY = 0.0;

    @Override
    public void start(Stage primaryStage) throws Exception {
	AnchorPane root = new AnchorPane();
	root.setPrefWidth(500);
	root.setPrefHeight(200);
	root.setStyle("-fx-background-color:#EEEE09");

	HBox hb = new HBox();
	hb.setAlignment(Pos.CENTER);
	hb.spacingProperty().bind(hb.widthProperty().divide(5));
	hb.prefWidthProperty().bind(root.widthProperty());
	hb.setPrefHeight(100);
	AnchorPane.setBottomAnchor(hb, 0.0);
	hb.setStyle("-fx-background-color:#EE1209");

	var btnEnlarge = new Button("Enlarge");
	btnEnlarge.setOnAction(e -> {
	    cnf.setScaleX(1.1 * cnf.getScaleX());
	    cnf.setScaleY(1.1 * cnf.getScaleY());
	});
	var btnShrink = new Button("Shrink");
	btnShrink.setOnAction(e -> {// lamda表达式要求接口内的抽象方法只能右一个，参数为方法的参数--名相同
	    cnf.setScaleX(0.9 * cnf.getScaleX());
	    cnf.setScaleY(0.9 * cnf.getScaleY());
	});

	root.getChildren().add(cnf);
	cnf.setOnMousePressed(e -> {
	    cnfX = e.getX();
	    cnfY = e.getY();
	});
	cnf.setOnMouseDragged(e -> {
	    AnchorPane.setLeftAnchor(cnf, e.getSceneX() - cnfX - cnf.getTranslateX());
	    AnchorPane.setTopAnchor(cnf, e.getSceneY() - cnfY - cnf.getTranslateY());
	});
	root.widthProperty().addListener(e->{
	    cnf.fitWidthProperty().bind(root.widthProperty().divide(4));
	});
	root.heightProperty().addListener(e->{
	    cnf.fitHeightProperty().bind(root.heightProperty().divide(4));
	});
	KeyValue kv1 = new KeyValue(cnf.translateXProperty(), 0);
	KeyFrame kf1 = new KeyFrame(Duration.seconds(0), "kf1", e -> {

	}, kv1);
	KeyValue kv2 = new KeyValue(cnf.translateXProperty(), root.getPrefWidth() / 4 * 3);
	KeyFrame kf2 = new KeyFrame(Duration.seconds(5), "kf2", e -> {

	}, kv2);
	FadeTransition ft = new FadeTransition(Duration.seconds(0.1), cnf);
	ft.setFromValue(0);
	ft.setToValue(1);
	ft.setCycleCount(Animation.INDEFINITE);
	ft.play();

	Timeline timeline = new Timeline();
	timeline.getKeyFrames().addAll(kf1, kf2);
	timeline.play();
	hb.getChildren().add(btnEnlarge);
	hb.getChildren().add(btnShrink);

	root.getChildren().add(hb);
	primaryStage.setScene(new Scene(root));
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }

}
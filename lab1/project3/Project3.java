package lab1.project3;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * 开发一个GUI应用程序，模拟四辆赛车，如下图所示。可以设置每辆车的速度(1代表最高速度，100代表最低速度)
 * 
 * 绘制显示组件、容器和布局管理器的用户界面草图。
 * 设计一个名为Car的类，用适当的数据字段、构造函数和方法来演示一辆赛车。
 * 绘制一个包含主框架类、它的超类和Car类的UML图。
 */

/*
 * 我觉得需要说明一下,其实我本人非常讨厌这类重复性的代码,没有任何营养,且缺乏美感,但是我更讨厌GUI,自从大一上软导课写完小组项目验收的静态页面之后,我就对前端死心了,况且Javafx的中文资料确实太少了
 */
public class Project3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
	AnchorPane root = new AnchorPane();
	root.setPrefSize(1000, 300);

	// 表头
	HBox title = new HBox();
	title.setAlignment(Pos.CENTER);
	title.setSpacing(20);

	HBox h1 = new HBox();
	Label l1 = new Label("car 1");
	TextField t1 = new TextField();
	t1.setPromptText("1~100,1最快, 100最慢");
	h1.getChildren().addAll(l1, t1);

	HBox h2 = new HBox();
	Label l2 = new Label("car 2");
	TextField t2 = new TextField();
	t2.setPromptText("1~100,1最快, 100最慢");
	h2.getChildren().addAll(l2, t2);

	HBox h3 = new HBox();
	Label l3 = new Label("car 3");
	TextField t3 = new TextField();
	t3.setPromptText("1~100,1最快, 100最慢");
	h3.getChildren().addAll(l3, t3);

	HBox h4 = new HBox();
	Label l4 = new Label("car 4");
	TextField t4 = new TextField();
	t4.setPromptText("1~100,1最快, 100最慢");
	h4.getChildren().addAll(l4, t4);

	Button reStart = new Button("重来");
	reStart.setPrefWidth(50);
	reStart.setPrefHeight(25);
	Button start = new Button("开始");
	start.setPrefWidth(50);
	start.setPrefHeight(25);

	title.getChildren().addAll(h1, h2, h3, h4, reStart, start);

	// 表体
	CarPane c1 = new CarPane(100, 50);
	CarPane c2 = new CarPane(100, 50);
	CarPane c3 = new CarPane(100, 50);
	CarPane c4 = new CarPane(100, 50);

	root.getChildren().addAll(title, c1, c2, c3, c4);
	AnchorPane.setTopAnchor(c1, 30.0);
	AnchorPane.setTopAnchor(c2, 100.0);
	AnchorPane.setTopAnchor(c3, 170.0);
	AnchorPane.setTopAnchor(c4, 240.0);

	KeyValue kv1s = new KeyValue(c1.translateXProperty(), 0);
	KeyValue kv1l = new KeyValue(c1.translateXProperty(), root.getPrefWidth() - 100);
	KeyFrame kf1s = new KeyFrame(Duration.seconds(0), kv1s);

	KeyValue kv2s = new KeyValue(c2.translateXProperty(), 0);
	KeyValue kv2l = new KeyValue(c2.translateXProperty(), root.getPrefWidth() - 100);
	KeyFrame kf2s = new KeyFrame(Duration.seconds(0), kv2s);

	KeyValue kv3s = new KeyValue(c3.translateXProperty(), 0);
	KeyValue kv3l = new KeyValue(c3.translateXProperty(), root.getPrefWidth() - 100);
	KeyFrame kf3s = new KeyFrame(Duration.seconds(0), kv3s);

	KeyValue kv4s = new KeyValue(c4.translateXProperty(), 0);
	KeyValue kv4l = new KeyValue(c4.translateXProperty(), root.getPrefWidth() - 100);
	KeyFrame kf4s = new KeyFrame(Duration.seconds(0), kv4s);

	start.setOnMouseClicked(e -> {
	    Timeline timeline = new Timeline();

	    //虽然是自欺欺人但是我觉着吧,这速度的配置就不太合理,所以这个相对映射我觉着这也没啥问题,它确实是个映射,但是唯一的缺点就是没啥用
	    int v1 = 0;
	    int v2 = 0;
	    int v3 = 0;
	    int v4 = 0;
	    
	    int ti1 = 0;
	    int ti2 = 0;
	    int ti3 = 0;
	    int ti4 = 0;

	    try {
		v1 = Integer.parseInt(t1.getText());
		v2 = Integer.parseInt(t2.getText());
		v3 = Integer.parseInt(t3.getText());
		v4 = Integer.parseInt(t4.getText());
		
		ti1=v1;
		ti2=v2;
		ti3=v3;
		ti4=v4;

		if ((ti1 < 1 || ti1 > 100) || (ti2 < 1 || ti2 > 100) || (ti3 < 1 || ti3 > 100)
			|| (ti4 < 1 || ti4 > 100)) {
		    throw new RuntimeException("Illegal speed");
		}

		KeyFrame kf1l = new KeyFrame(Duration.seconds(ti1), kv1l);
		KeyFrame kf2l = new KeyFrame(Duration.seconds(ti2), kv2l);
		KeyFrame kf3l = new KeyFrame(Duration.seconds(ti3), kv3l);
		KeyFrame kf4l = new KeyFrame(Duration.seconds(ti4), kv4l);

		timeline.getKeyFrames().addAll(kf1s, kf1l, kf2s, kf2l, kf3s, kf3l, kf4s, kf4l);
		timeline.play();
	    } catch (Exception e2) {
		e2.printStackTrace();
		throw e2;
	    }
	});

	reStart.setOnMouseClicked(e -> {
	    t1.clear();
	    t2.clear();
	    t3.clear();
	    t4.clear();

	    c1.translateXProperty().set(0);
	    c2.translateXProperty().set(0);
	    c3.translateXProperty().set(0);
	    c4.translateXProperty().set(0);
	});

	primaryStage.setScene(new Scene(root));
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }

}

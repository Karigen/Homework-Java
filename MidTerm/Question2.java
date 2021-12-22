package MidTerm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 *编写一个JavaFX程序在窗格的中心绘制一个矩形。
 *确保当用户更改窗格的大小时，矩形的中心始终在窗格的中心，而且，矩形的宽度和高度正好等于窗格的宽度和高度的一半。
 *当用户点击带有主按钮(通常是左边的按钮)的面板上的鼠标时，程序应该计算鼠标的位置，如果鼠标不在矩形框内，则打印“输出”，
 *否则在控制台中打印“输入”。
 */

public class Question2 extends Application {
    @Override
    public void start(Stage primaryStage) {
	Pane p = new Pane();
	p.setStyle("-fx-background-color:#FF0000");// 又红又专

	Rectangle r = new Rectangle();
	r.setFill(Color.YELLOW);
	p.widthProperty().addListener(o -> {
	    r.setWidth(p.getWidth() / 2);
	    r.setX((p.getWidth() - r.getWidth()) / 2);
	});
	p.heightProperty().addListener(o -> {
	    r.setHeight(p.getHeight() / 2);
	    r.setY((p.getHeight() - r.getHeight()) / 2);
	});

	p.setOnMouseClicked(e -> {

	    if (e.getButton().equals(MouseButton.PRIMARY)) {
		double mX = e.getX();
		double mY = e.getY();

		if (mX > r.getX() && mY > r.getY() && mX < r.getX() + r.getWidth() && mY < r.getY() + r.getHeight()) {
		    System.out.println("in");
		} else {
		    System.out.println("out");
		}
	    }

	});

	p.getChildren().add(r);
	primaryStage.setScene(new Scene(p));
	primaryStage.show();
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	launch(args);
    }
}
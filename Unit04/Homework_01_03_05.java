package Unit04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Homework_01_03_05 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
	// TODO 自动生成的方法存根
	Pane pane=new Pane();
	//myPane.setAlignment(Pos.BASELINE_LEFT);
	
	//按钮和矩形
	final double BTN_WIDTH=50;
	final double BTN_HEIGHT=25;
	Button btn=new Button();
	btn.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
	btn.setText("Hello");
	btn.setFont(Font.font("Segoe Script"));
	btn.setTextFill(Color.RED);
	btn.layoutXProperty().bind(pane.widthProperty().divide(2).subtract(btn.getPrefWidth()/2));
	btn.layoutYProperty().bind(pane.heightProperty().divide(2).subtract(btn.getPrefHeight()/2));
	
	Rectangle rectangle=new Rectangle(200, 100);
	rectangle.xProperty().bind(pane.widthProperty().divide(2).subtract(rectangle.getWidth()/2));
	rectangle.yProperty().bind(pane.heightProperty().divide(2).subtract(rectangle.getHeight()/2));
	
	//放入
	pane.getChildren().add(rectangle);
	pane.getChildren().add(btn);
	
	Scene scene=new Scene(pane);
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	launch(args);
    }

}

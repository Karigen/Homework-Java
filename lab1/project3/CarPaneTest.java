package lab1.project3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CarPaneTest extends Application {

    @Override
    // 测试代码,不用管
    public void start(Stage primaryStage) throws Exception {
	AnchorPane root = new AnchorPane();
	CarPane car = new CarPane();
	root.getChildren().add(car);
	AnchorPane.setTopAnchor(car, 0.0);
	AnchorPane.setLeftAnchor(car, 0.0);

	primaryStage.setScene(new Scene(root));
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }

}

class CarPane extends VBox {
    public CarPane() {
	this.setPrefWidth(100);
	this.setPrefHeight(50);
	paintCar();
    }

    public CarPane(double width, double height) {
	this.setPrefWidth(width);
	this.setPrefHeight(height);
	paintCar(true);
    }

    private void paintCar(boolean is) {
	// 顶 梯形或者两个三角形
	Pane top = new Pane();
	top.setPrefSize(this.getPrefWidth(), this.getPrefHeight() / 3);
	Polygon roof = new Polygon();
	roof.setFill(Color.RED);
	top.getChildren().add(roof);
	roof.getPoints().addAll(top.getPrefWidth() / 3, 0.0, top.getPrefWidth() / 3 * 2, 0.0,
		top.getPrefWidth() / 7 * 6, top.getPrefHeight(), top.getPrefWidth() / 7, top.getPrefHeight());
	// 中
	Rectangle center = new Rectangle();
	center.setWidth(this.getPrefWidth());
	center.setHeight(this.getPrefHeight() / 3);
	center.setFill(Color.GREEN);

	// 底
	HBox bottom = new HBox();
	bottom.setPrefSize(this.getPrefWidth(), this.getPrefHeight() / 3);
	bottom.setAlignment(Pos.CENTER);
	bottom.spacingProperty().bind(bottom.widthProperty().divide(5));

	Circle tire1 = new Circle();
	tire1.setRadius(bottom.getPrefHeight() / 2);
	Circle tire2 = new Circle();
	tire2.setRadius(bottom.getPrefHeight() / 2);
	bottom.getChildren().addAll(tire1, tire2);

	this.getChildren().addAll(top, center, bottom);
    }

    // 本来是想做一个动态拉伸效果的,但奈何Javafx国内资料实在太少,本人英语又太差,无论是翻出去还是看它自己带的注释都看不太明白,翻译插件或者其他软件翻译出来效果又不咋地,无奈放弃
    private void paintCar() {
	// 顶 梯形或者两个三角形
	Pane top = new Pane();
	Polygon roof = new Polygon();
	roof.setFill(Color.RED);
	top.getChildren().add(roof);
	top.prefWidthProperty().addListener(o -> {
	    roof.getPoints().clear();
	    roof.getPoints().addAll(top.getPrefWidth() / 3, 0.0, top.getPrefWidth() / 3 * 2, 0.0,
		    top.getPrefWidth() / 7 * 6, top.getPrefHeight(), top.getPrefWidth() / 7, top.getPrefHeight());
//	    roof.getPoints().set(0, top.getPrefWidth()/5);
//	    roof.getPoints().set(1, top.getPrefWidth()/5*4);
	});
	top.prefHeightProperty().addListener(o -> {
	    roof.getPoints().clear();
	    roof.getPoints().addAll(top.getPrefWidth() / 3, 0.0, top.getPrefWidth() / 3 * 2, 0.0,
		    top.getPrefWidth() / 7 * 6, top.getPrefHeight(), top.getPrefWidth() / 7, top.getPrefHeight());
//	    roof.getPoints().set(5, top.getPrefHeight());
//	    roof.getPoints().set(7, top.getPrefHeight());
	});

	// 中
	Rectangle center = new Rectangle();
	center.setFill(Color.GREEN);
//	center.widthProperty().bind(this.widthProperty());

	// 底
	HBox bottom = new HBox();
	bottom.setAlignment(Pos.CENTER);
	bottom.spacingProperty().bind(bottom.widthProperty().divide(5));

	Circle tire1 = new Circle();
	Circle tire2 = new Circle();
	bottom.getChildren().addAll(tire1, tire2);

	bottom.prefHeightProperty().addListener(o -> {
	    tire1.setRadius(bottom.getPrefHeight() / 2);
	    tire2.setRadius(bottom.getPrefHeight() / 2);
	});

	this.heightProperty().addListener(o -> {
	    top.setPrefHeight(this.getHeight() / 3);
	    center.setHeight(this.getHeight() / 3);
	    bottom.setPrefHeight(this.getHeight() / 3);
	});
	this.widthProperty().addListener(o -> {
	    top.setPrefWidth(this.getWidth());
	    center.setWidth(this.getWidth());
	    bottom.setPrefWidth(this.getWidth());
	});

	this.getChildren().addAll(top, center, bottom);
    }
}
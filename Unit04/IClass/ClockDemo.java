package Unit04.IClass;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClockDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
	// TODO 自动生成的方法存根
	ClockPane clock = new ClockPane();
	BorderPane pane = new BorderPane();

	Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
	    clock.setCurrentTime();
	    String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
	    Label lblCurrentTime = new Label(timeString);
	    pane.setTop(lblCurrentTime);
	    BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
	}));
	pane.setCenter(clock);
	animation.setCycleCount(Timeline.INDEFINITE);
	animation.play();
	
	Scene scene = new Scene(pane, 250, 250);
	primaryStage.setTitle("DisplayClock");
	primaryStage.setScene(scene);
	primaryStage.show();

	pane.widthProperty().addListener(ov -> clock.setW(pane.getWidth()));
	pane.heightProperty().addListener(ov -> clock.setH(pane.getHeight()));
    }

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	launch(args);
    }

}

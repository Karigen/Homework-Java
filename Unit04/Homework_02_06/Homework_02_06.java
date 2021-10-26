package Unit04.Homework_02_06;

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

public class Homework_02_06 extends Application {
    
    ImageView cnf = new ImageView(new Image("/Unit04/cnf/cnf.jpg"));

    @Override
    public void start(Stage primaryStage) throws Exception {
	GridPane root = new GridPane();
	root.setAlignment(Pos.CENTER);

	//var cnf = new ImageView(new Image("/Unit04/cnf/cnf.jpg"));
	root.add(cnf, 1, 0);

	var btnEnlarge = new Button("Enlarge");
	btnEnlarge.setOnAction(new EnlargeHanlder());
	var btnShrink = new Button("Shrink");
	btnShrink.setOnAction(new ShrinkHanlder());
	root.add(btnEnlarge, 0, 1);
	root.add(btnShrink, 2, 1);

	primaryStage.setScene(new Scene(root, 600, 300));
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }

    class EnlargeHanlder implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
	    cnf.setScaleX(1.1 * cnf.getScaleX());
	    cnf.setScaleY(1.1 * cnf.getScaleY());
	}
    }

    class ShrinkHanlder implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
	    cnf.setScaleX(0.9 * cnf.getScaleX());
	    cnf.setScaleY(0.9 * cnf.getScaleY());
	}
    }

}

//class EnlargeHanlder implements EventHandler<ActionEvent>{
//    private ImageView im;
//    
//    @Override
//    public void handle(ActionEvent event) {
//	im.setScaleX(1.1*im.getScaleX());
//	im.setScaleY(1.1*im.getScaleY());
//    }
//    
//    public EnlargeHanlder(ImageView im) {
//	this.im=im;
//    }
//}
//
//class ShrinkHanlder implements EventHandler<ActionEvent>{
//    private ImageView im;
//    
//    @Override
//    public void handle(ActionEvent event) {
//	im.setScaleX(0.9*im.getScaleX());
//	im.setScaleY(0.9*im.getScaleY());
//    }
//    
//    public ShrinkHanlder(ImageView im) {
//	this.im=im;
//    }
//}
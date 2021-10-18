package Unit04;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Homework06 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
	//����
	BorderPane root=new BorderPane();
	
	//��
	FlowPane top=new FlowPane();
	top.setPrefHeight(100);
	for (int i = 1; i <= 56; i++) {
	    top.getChildren().add(new ImageView((new Image("/Unit04/ethnic/"+i+".png", 35, 35, true, true))));
	}
	
	//��
	HBox bottom=new HBox();
	bottom.setPrefHeight(100);
	bottom.setAlignment(Pos.CENTER);
	bottom.spacingProperty().bind(bottom.widthProperty().divide(5));
	Button btn1=new Button();
	btn1.setText("��ť1");
	Button btn2=new Button();
	btn2.setText("��ť2");
	bottom.getChildren().add(btn1);
	bottom.getChildren().add(btn2);
	
	//��
	VBox left=new VBox();
	left.setPrefWidth(200);
	left.setAlignment(Pos.CENTER);
	Text poem=new Text("��ӽ�졷\n�죬�죬�죬\n��������衣\n��ë����ˮ��\n���Ʋ��岨��\n");
	left.getChildren().add(poem);
	
	//��
	StackPane right=new StackPane();
	right.setPrefWidth(200);
	right.setAlignment(Pos.CENTER);
	right.getChildren().add(new ImageView(new Image("/Unit04/misc/yinyang.png", 100, 100, true, true)));
	
	//��
	GridPane center=new GridPane();
	center.setAlignment(Pos.CENTER);
	for (int i = 0; i < 8; i++) {
	    center.add(new ImageView(new Image("/Unit04/bg/"+i+".png", 100, 100, true, true)), i%4, i/4);
	}
	
	//���η���
	root.setTop(top);
	root.setBottom(bottom);
	root.setLeft(left);
	root.setRight(right);
	root.setCenter(center);
	Scene scene=new Scene(root);
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������
	launch(args);
    }

}

package MidTerm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 *��дһ��JavaFX�����ڴ�������Ļ���һ�����Ρ�
 *ȷ�����û����Ĵ���Ĵ�Сʱ�����ε�����ʼ���ڴ�������ģ����ң����εĿ�Ⱥ͸߶����õ��ڴ���Ŀ�Ⱥ͸߶ȵ�һ�롣
 *���û������������ť(ͨ������ߵİ�ť)������ϵ����ʱ������Ӧ�ü�������λ�ã������겻�ھ��ο��ڣ����ӡ���������
 *�����ڿ���̨�д�ӡ�����롱��
 */

public class Question2 extends Application {
    @Override
    public void start(Stage primaryStage) {
	Pane p = new Pane();
	p.setStyle("-fx-background-color:#FF0000");// �ֺ���ר

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
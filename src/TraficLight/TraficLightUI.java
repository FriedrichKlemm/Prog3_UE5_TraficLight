package TraficLight;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * Created by Friedrich on 16.06.2017.
 */
public class TraficLightUI extends Application{
    private Group group = new Group();
    private Button greenButton, yellowButton, redButton, redYellow;
    private BorderPane borderpane = new BorderPane();
    private Scene scene = new Scene(borderpane, 700, 700);
    private Rectangle body = new Rectangle(scene.getWidth() / 2, scene.getHeight() / 2, 70, 200);
    private Circle greenCircle = new Circle();
    private Circle yellowCircle = new Circle();
    private Circle redCircle = new Circle();
    private Pane traficLightPane;


    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Traficlight");


        group.getChildren().add(body);

        traficLightPane = new Pane(group);
        greenButton = new Button("Green");
        greenButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            synchronized public void handle(ActionEvent event) {
                yellow();
                try {
                    this.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //green();
            }
        });

        yellowButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                yellow();
            }
        });

        redButton = new Button("Red");
        redButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                red();
            }
        });

        redYellow = new Button("RedYellow");
        redYellow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                redyellow();
            }
        });



        FlowPane buttonList = new FlowPane(Orientation.HORIZONTAL);
        buttonList.getChildren().addAll(greenButton, yellowButton, redButton, redYellow);
        buttonList.setAlignment(Pos.CENTER);





        borderpane.setCenter(traficLightPane);
        borderpane.setBottom(buttonList);

        //body = new Rectangle(scene.getWidth()/2, scene.getHeight()/2, 70, 200);

        red();

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private boolean green(){
            body = new Rectangle(scene.getWidth() / 2, scene.getHeight() / 2, 70, 200);
            body.setFill(Color.GRAY);
            body.setStroke(Color.BLACK);
            greenCircle = new Circle(scene.getWidth() / 2 + 35, scene.getWidth() / 2 + 160, 20);
            greenCircle.setFill(Color.GREEN);
            group.getChildren().clear();
            group.getChildren().addAll(body, greenCircle);
        return true;
    }

    private boolean yellow(){
        body = new Rectangle(scene.getWidth()/2, scene.getHeight()/2, 70, 200);
        body.setFill(Color.GRAY);
        body.setStroke(Color.BLACK);
        yellowCircle = new Circle(scene.getWidth()/2+35, scene.getHeight()/2+100, 20);
        yellowCircle.setFill(Color.YELLOW);
        group.getChildren().clear();
        group.getChildren().addAll(yellowCircle);
        //for (int i = 0; i<1000000; i++);
        return true;
    }

    private boolean red() {
        body = new Rectangle(scene.getWidth()/2, scene.getHeight()/2, 70, 200);
        body.setFill(Color.GRAY);
        body.setStroke(Color.BLACK);
        redCircle = new Circle(scene.getWidth()/2 + 35, scene.getWidth()/2 + 35, 20);
        redCircle.setFill(Color.RED);
        group.getChildren().clear();
        group.getChildren().addAll(body, redCircle);
        return true;
    }

    private boolean redyellow(){
        body = new Rectangle(scene.getWidth()/2, scene.getHeight()/2, 70, 200);
        body.setFill(Color.GRAY);
        body.setStroke(Color.BLACK);
        redCircle = new Circle(scene.getWidth()/2 + 35, scene.getWidth()/2 + 35, 20);
        redCircle.setFill(Color.RED);
        yellowCircle = new Circle(scene.getWidth()/2+35, scene.getHeight()/2+100, 20);
        yellowCircle.setFill(Color.YELLOW);
        group.getChildren().clear();
        group.getChildren().addAll(body, redCircle, yellowCircle);
        return true;
    }

}

package TraficLight;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * Created by Friedrich on 20.06.2017.
 */
public class UserInterface{
    private Group group = new Group();
    private Button greenButton, yellowButton, redButton, redYellowButtom;
    private BorderPane borderpane = new BorderPane();
    private Scene scene = new Scene(borderpane, 700, 700);
    private Rectangle body = new Rectangle(scene.getWidth() / 2, scene.getHeight() / 2, 70, 200);

    private Circle greenCircle = new Circle();
    private Circle yellowCircle = new Circle();
    private Circle redCircle = new Circle();
    private Pane traficLightPane;
    private ButtonControl buttonControl;
    private TraficControl runningThread;

    public UserInterface(Stage primaryStage){

        primaryStage.setTitle("Traficlight");

        body.setStroke(Color.BLACK);
        body.setFill(Color.GRAY);



        redCircle = new Circle(scene.getWidth()/2 + 35, scene.getWidth()/2 + 35, 20);
        redCircle.setVisible(true);
        redCircle.setFill(Color.RED);

        yellowCircle = new Circle(scene.getWidth()/2+35, scene.getHeight()/2+100, 20);
        yellowCircle.setVisible(false);
        yellowCircle.setFill(Color.YELLOW);

        greenCircle = new Circle(scene.getWidth() / 2 + 35, scene.getWidth() / 2 + 160, 20);
        greenCircle.setVisible(false);
        greenCircle.setFill(Color.GREEN);

        TraficControl control =new TraficControl(this, Status.standart);
        control.start();

        greenButton = new Button("Green");
        greenButton.setOnAction(new ButtonControl(this, control));
        redButton = new Button("Red");
        redButton.setOnAction(new ButtonControl(this, control));
        yellowButton = new Button("Yellow");
        yellowButton.setOnAction(new ButtonControl(this, control));
        redYellowButtom = new Button("Blink");
        redYellowButtom.setOnAction(new ButtonControl(this, control));


        group.getChildren().addAll(body, redCircle, yellowCircle, greenCircle);
        traficLightPane = new Pane(group);

        FlowPane buttonList = new FlowPane(Orientation.HORIZONTAL);
        buttonList.getChildren().addAll(greenButton, yellowButton, redButton, redYellowButtom);
        buttonList.setAlignment(Pos.CENTER);

        borderpane.setCenter(traficLightPane);
        borderpane.setBottom(buttonList);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public Circle getGreenCircle() {
        return greenCircle;
    }

    public Circle getYellowCircle() {
        return yellowCircle;
    }

    public Circle getRedCircle() {
        return redCircle;
    }
}

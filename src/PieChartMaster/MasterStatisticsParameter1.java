package PieChartMaster;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Friedrich on 23.06.2017.
 */
public class MasterStatisticsParameter1 implements SubjectInterface {
    List<GraficControler> observerList = new ArrayList<GraficControler>();
    private double valueOfSlider;

    private Label label;
    private FlowPane slider;
    private Scene scene;


    public MasterStatisticsParameter1(Stage stage, String name, double startValue){
        label = new Label(name + ": ");
        stage.setTitle("MasterStudiesStatistics");

        slider = new FlowPane();
        Slider slider1 = new Slider(0,100, startValue);
        slider.getChildren().addAll(label, slider1);
        scene = new Scene(slider, 300, 100);

        valueOfSlider = slider1.getValue();

        stage.setScene(scene);
        stage.show();

    }


    @Override
    public void addObserver(GraficControler observer) {
        this.observerList.add(observer);

    }

    @Override
    public void removeObserver(GraficControler observer) {
        this.observerList.remove(observer);

    }

    @Override
    public void notifyAllObserver() {
        for (GraficControler observer : observerList) {
            observer.update();
        }

    }

    public void refreshState(double newValue){
        this.valueOfSlider = newValue;
        this.notifyAllObserver();
    }

    public String getName(){
        return this.label.getText();
    }
}

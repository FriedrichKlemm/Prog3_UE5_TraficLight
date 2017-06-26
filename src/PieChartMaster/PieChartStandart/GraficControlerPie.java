package PieChartMaster.PieChartStandart;

import PieChartMaster.GraficControler;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.stream.Collectors;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

/**
 * Created by Friedrich on 26.06.2017.
 */
public class GraficControlerPie extends Application {
    private PieChart.Data Parameter1 = null;
    private PieChart.Data Parameter2 = null;
    private PieChart.Data Parameter3 = null;
    private Stage mainStage;
    private Group pieChart;
    private BorderPane borderPane;
    private Scene scene;
    private String label;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;
        mainStage.setMinHeight(700);
        mainStage.setMinWidth(700);
        mainStage.setTitle("Studenten im Master: ");

        pieChart = new Group();
        borderPane = new BorderPane();
        scene = new Scene(pieChart,700, 700);

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                Parameter1 = new PieChart.Data("zugehöriger Bachelorstudiengang : 69%", 69),
                Parameter2 =new PieChart.Data("fremder uniinterner Bachelorstudiengang : 12%",    12),
                Parameter3 = new PieChart.Data("andere Universitären  ", 100-Parameter1.getPieValue()-Parameter2.getPieValue())
        );
        final PieChart chart = new PieChart(pieChartData);

        chart.setPrefSize(scene.getWidth(), scene.getHeight());
        chart.setLabelsVisible(true);
        ((Group) scene.getRoot()).getChildren().add(chart);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String [] args){
        launch(args);
    }
}

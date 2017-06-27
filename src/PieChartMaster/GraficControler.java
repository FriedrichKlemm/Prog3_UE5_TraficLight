package PieChartMaster;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Friedrich on 21.06.2017.
 */
public class GraficControler implements OnSlideListener{
    private Group pieChart;
    private BorderPane borderPane;
    private Scene scene;


    public GraficControler(Stage primaryStage) {



        primaryStage.setTitle("PieChartStuff");
        pieChart = new Group();
        borderPane = new BorderPane();
        scene = new Scene(pieChart, 700, 700);

        PieChart chart = new PieChart();



        chart.setTitle("Studients for master degree");

        pieChart.getChildren().addAll(chart);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    @Override
    public void onSlide(double value) {

    }

    @Override
    public void addOnSlideListener(OnSlideListener listener) {
    }

    @Override
    public void update(double value) {

    }
}

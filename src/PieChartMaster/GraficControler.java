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
public class GraficControler extends Application implements ObserverInterface{
    //List<MasterStatisticsParameter1> dataList;
    ObservableList<MasterStatisticsParameter1> pieChartData;
    private Group pieChart;
    private BorderPane borderPane;
    private Scene scene;

    public GraficControler(Stage primaryStage, ObservableList<MasterStatisticsParameter1> dataList) {
        this.pieChartData = dataList;
        //this.dataList = dataList;
        for (MasterStatisticsParameter1 m: pieChartData
                ) {
            m.addObserver(this);

        }

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

    public void run(){

    }

    @Override
    public void update() {
        for (MasterStatisticsParameter1 m:
             pieChartData) {

        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}

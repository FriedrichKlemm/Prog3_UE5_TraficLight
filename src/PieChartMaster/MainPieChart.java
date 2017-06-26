package PieChartMaster;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;


/**
 * Created by Friedrich on 23.06.2017.
 */
public class MainPieChart extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MasterStatisticsParameter1 bachelor = new MasterStatisticsParameter1(new Stage(), "Bachelor", 69);
        MasterStatisticsParameter1 other =new MasterStatisticsParameter1(new Stage(), "andere Studiengänge", 12);
        GraficControler graficControler = new GraficControler(primaryStage, )
    }
}

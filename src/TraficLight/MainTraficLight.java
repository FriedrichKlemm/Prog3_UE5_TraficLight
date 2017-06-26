package TraficLight;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Friedrich on 20.06.2017.
 */
public class MainTraficLight extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        new UserInterface(primaryStage);
    }
}

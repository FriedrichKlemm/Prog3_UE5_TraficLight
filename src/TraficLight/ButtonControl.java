package TraficLight;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by Friedrich on 20.06.2017.
 */
public class ButtonControl implements EventHandler<ActionEvent>{
    Button currentButton;
    TraficControl controller;
    UserInterface userInterface;

    public ButtonControl(UserInterface userInterface, TraficControl controller){
        this.userInterface = userInterface;
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent event) {
        currentButton = (Button) event.getSource();
        //controller.setChangeFlag(false);

        switch (currentButton.getText()){
            case "Red": {
                controller.setChangeFlag(false);
                if (controller.getStatus().equals(Status.technicalIssue)){
                    controller.setChangeFlag(true);
                }
                controller.setStatus(Status.greenToRed);
                controller.setChangeFlag(true);
                break;
            }
            case "Green": {
                controller.setChangeFlag(false);
                if (controller.getStatus().equals(Status.technicalIssue)){
                    controller.setChangeFlag(true);
                }
                controller.setStatus(Status.redToGreen);
                controller.setChangeFlag(true);
                break;
            }
            case "Blink":
                controller.setStatus(Status.technicalIssue);
                //controller.setChangeFlag(true);
                break;
        }
    }

}

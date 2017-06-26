package TraficLight;

/**
 * Created by Friedrich on 20.06.2017.
 */
public class TraficControl extends Thread {
    private Status status;
    private UserInterface userInterface;
    private boolean changeFlag;

    //TODO: boolean flag for changes, so that loop gets interrupted

    public Status getStatus() {
        return status;
    }

    TraficControl(UserInterface userInterface, Status status){
        this.userInterface = userInterface;
        this.status = status;
        changeFlag = false;
    }

    public void run(){
            //System.out.println("new status entered: " + status);
            if (changeFlag == false) {
                if (status.equals(Status.redToGreen)) {
                    synchronized (userInterface.getYellowCircle()) {
                        userInterface.getYellowCircle().setVisible(true);
                    }
                    synchronized (this) {
                        try {
                            wait(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    synchronized (userInterface.getRedCircle()) {
                        userInterface.getRedCircle().setVisible(false);
                    }
                    synchronized (userInterface.getYellowCircle()) {
                        System.out.println("Why not?");
                        userInterface.getYellowCircle().setVisible(false);
                    }
                    synchronized (userInterface.getGreenCircle()) {
                        userInterface.getGreenCircle().setVisible(true);
                        //System.out.println("setting Green");
                    }
                }
                if (status.equals(Status.greenToRed)) {
                    synchronized (userInterface.getGreenCircle()) {
                        userInterface.getGreenCircle().setVisible(false);
                    }
                    synchronized (userInterface.getYellowCircle()) {
                        userInterface.getYellowCircle().setVisible(true);
                    }

                    synchronized (this) {
                        try {
                            wait(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    synchronized (userInterface.getYellowCircle()) {
                        userInterface.getYellowCircle().setVisible(false);
                    }
                    synchronized (userInterface.getRedCircle()) {
                        userInterface.getRedCircle().setVisible(true);
                    }
                }
                if (status.equals(Status.technicalIssue)) {
                    while (changeFlag != true) {
                        synchronized (userInterface.getGreenCircle()) {
                            userInterface.getGreenCircle().setVisible(false);
                        }
                        synchronized (userInterface.getRedCircle()) {
                            userInterface.getRedCircle().setVisible(false);
                        }

                        synchronized (userInterface.getYellowCircle()) {
                            if (userInterface.getYellowCircle().isVisible() == false) {
                                userInterface.getYellowCircle().setVisible(true);
                            } else userInterface.getYellowCircle().setVisible(false);
                        }
                        synchronized (this) {
                            try {
                                wait(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
                if (status.equals(Status.standart)) {
                    synchronized (userInterface.getRedCircle()) {
                        //System.out.println("Standart");
                        userInterface.getRedCircle().setVisible(true);
                    }
                }
            }
            else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public void setChangeFlag(boolean changeFlag){
        this.changeFlag = changeFlag;
    }

    public void setStatus(Status status){
        this.status = status;
    }
}

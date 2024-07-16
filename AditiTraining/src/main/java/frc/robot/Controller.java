package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class Controller {
    
    private static final String MANIP_NAME = "Logitech Dual Action";
    private static final String DRIVER_NAME = "Controller (Xbox One For Windows)";
    private static final int UNKNOWN_PORT = -1;

    private XboxController manipulatorController;
    private XboxController driverController;
    private int manipulatorPort;
    private int driverPort;


    public Controller() {
       manipulatorPort = getManipulatorPort();
       driverPort      = getDriverPort();

    

    }
    
    public int getManipulatorPort() { 
        int portNum;
        GenericHID genericController;

        for (portNum = 0; portNum < 6; portNum++){
            genericController = new GenericHID(portNum);

            if(genericController.isConnected() == true) {
                System.out.println("Name is " + genericController.getName());
            }
            
            if (genericController.getName().equals(MANIP_NAME) == true){
                return portNum;
            }
        }
        return UNKNOWN_PORT;

    }

    public int getDriverPort() { 
        int portNum;
        GenericHID genericController;

        for (portNum = 0; portNum < 6; portNum++){
            genericController = new GenericHID(portNum);

            if(genericController.isConnected() == true) {
                System.out.println("Name is " + genericController.getName());
            }
            
            if (genericController.getName().equals(DRIVER_NAME) == true){
                return portNum;
            }
        }
        return UNKNOWN_PORT;

    }
    public void updateController() { 
        int currentManipulatorPort;
        int currentDriverPort;
        currentManipulatorPort = getManipulatorPort();
        currentDriverPort      = getDriverPort();

        if (driverPort != currentDriverPort){
            driverController = new XboxController(currentDriverPort);
            driverPort = currentDriverPort;
            System.out.println("Driver controller is now on port: " + driverPort);
        }

        if (manipulatorPort != currentManipulatorPort){
            manipulatorController = new XboxController(currentManipulatorPort);
            manipulatorPort = currentManipulatorPort;
            System.out.println("Manipulator controller is now on port: " + manipulatorPort);
        }
        

    }
}

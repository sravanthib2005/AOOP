
package robotics.control;

public class Main {
    public static void main(String[] args) {
        Robot industrialRobot = new Industrialrobot();
        Robot serviceRobot = new ServiceRobot();
        Robot drone = new Drone();

        Control remoteControl = new Remotecontrol(industrialRobot);
        remoteControl.executeCommand();

        Control automatedControl = new Automatedcontrol(serviceRobot);
        automatedControl.executeCommand();

        remoteControl = new Remotecontrol(drone);
        remoteControl.executeCommand();
    }
}


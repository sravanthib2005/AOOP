
package robotics.control;

public class Remotecontrol implements Control {
    private Robot robot;

    public Remotecontrol(Robot robot) {
        this.robot = robot;
    }

    
    public void executeCommand() {
        System.out.println("Remote control executing command...");
        ((Robot) robot).operate();
    }
}

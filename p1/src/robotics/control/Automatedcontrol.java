
package robotics.control;

public class Automatedcontrol implements Control {
    private Robot robot;

    public Automatedcontrol(Robot robot) {
        this.robot = robot;
    }

    
    public void executeCommand() {
        System.out.println("Automated control executing command...");
        robot.operate();
    }
}


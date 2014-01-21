/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package Robot2014;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Relay;
import Subsystems.ClawMotor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot implements RobotPorts
{
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    private static RobotDrive driveTrain;
    private static Joystick gamePad;
    
    private static ClawMotor claw;
    
    public void robotInit()
    {
      
        gamePad = new Joystick(GAMEPAD);
        driveTrain = new RobotDrive(MOTOR_LEFT_ONE, MOTOR_LEFT_TWO, MOTOR_RIGHT_ONE, MOTOR_RIGHT_TWO);
        
        driveTrain.setSafetyEnabled(true);
        
        claw = new ClawMotor();
        
    }
    
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void teleopPeriodic()
    {

        driveTrain.tankDrive(gamePad, 4, gamePad, 2);
        checkClaw();
        
    }
    
    
    public void checkClaw()
    {
        if(gamePad.getRawButton(2)){
            getClaw().motorForward();
        }
        else if(gamePad.getRawButton(4)){
            getClaw().motorBackward();
        }
        else{
            getClaw().stopMotor();
        }
    }
    
    public static ClawMotor getClaw()
    {
        return claw;
    }
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Subsystems;

import Robot2014.RobotPorts;
import edu.wpi.first.wpilibj.Relay;
/**
 *
 * @author MRT253
 */
public class ClawMotor implements RobotPorts{
    
    private Relay claw;
    
    public ClawMotor(){
        claw = new Relay(CLAW_MOTOR);
    }
    public void motorForward(){
        claw.set(Relay.Value.kForward);
    }
    public void motorBackward(){
        claw.set(Relay.Value.kReverse);
    }
    public void stopMotor(){
        claw.set(Relay.Value.kOff);
    }
}

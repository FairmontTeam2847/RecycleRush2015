package org.usfirst.frc.team2847.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TiltPan extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	// Servo tilt = new Servo(RobotMap.tiltServo);
	// Servo pan = new Servo(RobotMap.panServo);

	public void setBoth(double t, double p) {
		// tilt.setAngle(t);
		// pan.setAngle(p);
	}
}

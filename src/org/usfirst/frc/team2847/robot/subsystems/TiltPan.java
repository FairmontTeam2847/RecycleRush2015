package org.usfirst.frc.team2847.robot.subsystems;

import org.usfirst.frc.team2847.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
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

	Servo tilt = new Servo(RobotMap.tiltServo);
	Servo pan = new Servo(RobotMap.panServo);

	public void setPan(double val) {
		pan.setAngle(val);
	}

	public void setTilt(double val) {
		tilt.setAngle(val);
	}

	public void setBoth(double t, double p) {
		tilt.setAngle(t);
		pan.setAngle(p);
	}
}

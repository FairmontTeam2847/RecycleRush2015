package org.usfirst.frc.team2847.robot.subsystems;

import org.usfirst.frc.team2847.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}

	Talon elevator = new Talon(RobotMap.elevatorMotor);
	Talon elevatorB = new Talon(RobotMap.elevatorBMotor);

	public void torro(double vel) {
		elevator.set(vel);
		elevatorB.set(vel);
	}

	public void nothing() {
		elevator.set(0);
		elevatorB.set(0);
	}

}

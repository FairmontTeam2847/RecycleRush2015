package org.usfirst.frc.team2847.robot.subsystems;

import org.usfirst.frc.team2847.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	Talon elevatorA = new Talon(RobotMap.elevatorMotor);
	Talon elevatorB = new Talon(RobotMap.elevatorBMotor);
	DigitalInput hallEffect = new DigitalInput(RobotMap.hallA);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void torro(double vel) {
		elevatorA.set(vel);
		elevatorB.set(vel);
	}

	public void nothing() {
		elevatorA.set(0);
		elevatorB.set(0);
	}

	public boolean isHallSet() {
		return !hallEffect.get();
	}

}
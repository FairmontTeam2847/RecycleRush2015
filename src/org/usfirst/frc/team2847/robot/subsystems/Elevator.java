package org.usfirst.frc.team2847.robot.subsystems;

import org.usfirst.frc.team2847.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	Talon elevatorA = new Talon(RobotMap.elevatorMotor);
	Talon elevatorB = new Talon(RobotMap.elevatorBMotor);
	private DigitalInput hallEffect = new DigitalInput(RobotMap.hallA);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	private int currentLevel = 0;
	private boolean withinRange = false;

	public void resetMove() {
		currentLevel = 0;
		withinRange = false;
	}

	public boolean gotoLevel(int targetLevel) {
		boolean returnState = false;

		int direction = 0;

		if (currentLevel < targetLevel) {
			torro(direction = -1);
			returnState = false;
		} else if (currentLevel > targetLevel) {
			torro(direction = 1);
			returnState = false;
		} else {
			nothing();
			returnState = true;
		}
		if (withinRange != isHallSet() && !withinRange) {
			withinRange = true; // record this exec for next exec
			if (direction == -1) {
				currentLevel++;
			} else if (direction == 1) {
				currentLevel--;
			}
		} else if (withinRange != isHallSet() && withinRange) {
			withinRange = false;
		}
		return returnState;
	}

	public void torro(double vel) {
		elevatorA.set(vel);
		elevatorB.set(vel);
	}

	public void nothing() {
		elevatorA.set(0);
		elevatorB.set(0);
	}

	private boolean isHallSet() {
		return !hallEffect.get();
	}

	public void updateData() {
		SmartDashboard.putBoolean("within", withinRange);
		SmartDashboard.putNumber("level", currentLevel);
	}

}
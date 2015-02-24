package org.usfirst.frc.team2847.robot.subsystems;

import org.usfirst.frc.team2847.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Fork extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}

	Solenoid forkerOpen = new Solenoid(RobotMap.forkPistons[0]);
	Solenoid forkerClose = new Solenoid(RobotMap.forkPistons[1]);

	public void openFork() {
		forkerOpen.set(true);
		forkerClose.set(false);

	}

	public void closeFork() {
		forkerOpen.set(false);
		forkerClose.set(true);
	}

	public boolean isForkOpen() {
		return forkerOpen.get();
	}
}

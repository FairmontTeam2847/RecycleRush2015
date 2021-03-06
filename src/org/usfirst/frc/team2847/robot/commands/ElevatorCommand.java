package org.usfirst.frc.team2847.robot.commands;

import org.usfirst.frc.team2847.robot.Robot;
import org.usfirst.frc.team2847.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorCommand extends Command {

	boolean run;
	int dir;

	public ElevatorCommand(boolean run, int dir) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevator);
		this.run = run;
		this.dir = dir;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (RobotMap.DEBUGMODE) {
			System.out.println(this);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (run) {
			Robot.elevator.torro(RobotMap.liftSpeed * dir
					* Robot.oi.getJoyThrottle());
		} else {
			Robot.elevator.nothing();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

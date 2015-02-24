package org.usfirst.frc.team2847.robot.commands;

import org.usfirst.frc.team2847.robot.Robot;
import org.usfirst.frc.team2847.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForkCommand extends Command {

	boolean run;
	boolean done;

	public ForkCommand(boolean forkit) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.fork);
		this.run = forkit;
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
			Robot.fork.openFork();
		} else {
			Robot.fork.closeFork();

		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		done = (run == Robot.fork.isForkOpen()) ? true : false;

		return done;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

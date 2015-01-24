package org.usfirst.frc.team2847.robot.commands;

import org.usfirst.frc.team2847.robot.Robot;
import org.usfirst.frc.team2847.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TiltPanCommand extends Command {

	boolean run;
	double x;
	double y;
	double tiltAngle = 90;
	double panAngle = 90;

	public TiltPanCommand(boolean run, double x, double y) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.tiltpan);
		this.run = run;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (RobotMap.DEBUGMODE) {
			System.out.println(this);
		}

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		int pov = Robot.oi.fPOV();
		switch (pov) {
		case 0:
			Robot.tiltpan.setBoth(tiltAngle, panAngle);
			break;
		case 1:
			tiltAngle = tiltAngle - 0.1;
			Robot.tiltpan.setBoth(tiltAngle, panAngle);
			break;
		case 2:
			tiltAngle = tiltAngle - 0.1;
			panAngle = panAngle - 0.1;
			Robot.tiltpan.setBoth(tiltAngle, panAngle);
			break;
		case 3:
			panAngle = panAngle - 0.1;
			Robot.tiltpan.setBoth(tiltAngle, panAngle);
			break;
		case 4:
			panAngle = panAngle - 0.1;
			tiltAngle = tiltAngle + 0.1;
			Robot.tiltpan.setBoth(tiltAngle, panAngle);
			break;
		case 5:
			tiltAngle = tiltAngle + 0.1;
			Robot.tiltpan.setBoth(tiltAngle, panAngle);
			break;
		case 6:
			tiltAngle = tiltAngle + 0.1;
			panAngle = panAngle + 0.1;
			Robot.tiltpan.setBoth(tiltAngle, panAngle);
			break;
		case 7:
			panAngle = panAngle + 0.1;
			Robot.tiltpan.setBoth(tiltAngle, panAngle);
			break;
		case 8:
			panAngle = panAngle + 0.1;
			tiltAngle = tiltAngle - 0.1;
			Robot.tiltpan.setBoth(tiltAngle, panAngle);
			break;

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

package org.usfirst.frc.team2847.robot.commands;

import org.usfirst.frc.team2847.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MagicElevator extends Command {

	int count;
	int mySetpoint;
	int tcount;
	double go;
	boolean done;
	int ion;
	int ioff;
	boolean ibool;

	public MagicElevator(int setpoint) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevator);
		mySetpoint = setpoint;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println(this);
		tcount = mySetpoint;
		go = 0;
		ion = 0;
		ioff = 0;
		done = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		count = count + tcount;

		if (Robot.elevator.isHallSet()) {
			ion = ion++;
			ioff = 0;
		} else if (!Robot.elevator.isHallSet()) {
			ioff = ioff++;
			ion = 0;
		}
		if (ion > 100) {
			ibool = true;
		}
		if (ioff > 100) {
			ibool = false;
		}

		if (count > 0 && Robot.elevator.isHallSet()) {
			count = (count - 1);
			ibool = false;
		} else if (count < 0 && Robot.elevator.isHallSet()) {
			count = (count + 1);
			ibool = false;
		}

		if (count >= 1) {
			go = 1;
		} else if (count <= -1) {
			go = -1;
		}
		Robot.elevator.torro(go);

		if (count != 0) {
			done = false;
		} else if (count == 0) {
			done = true;
		}
		tcount = 0;
		update();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevator.nothing();
	}

	protected void update() {
		SmartDashboard.putNumber("ion", ion);
		SmartDashboard.putNumber("ioff", ioff);
		SmartDashboard.putNumber("count", count);
		SmartDashboard.putBoolean("hall", Robot.elevator.isHallSet());
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
package org.usfirst.frc.team2847.robot;

import org.usfirst.frc.team2847.robot.commands.autoCommand;
import org.usfirst.frc.team2847.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2847.robot.subsystems.Elevator;
import org.usfirst.frc.team2847.robot.subsystems.Fork;
import org.usfirst.frc.team2847.robot.subsystems.TiltPan;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final TiltPan tiltpan = new TiltPan();
	public static final Fork fork = new Fork();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Elevator elevator = new Elevator();

	public static OI oi;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();

		SmartDashboard.putData("Subsystems", drivetrain);
		SmartDashboard.putData("ele", elevator);

		// instantiate the command used for the autonomous period
		autonomousCommand = new autoCommand();

		System.out.println("Recycle Rush!!!");
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		System.out.println("150% hyperbole!");
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		Robot.elevator.updateData();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}

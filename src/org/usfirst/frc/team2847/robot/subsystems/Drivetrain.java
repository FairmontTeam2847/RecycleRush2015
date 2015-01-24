package org.usfirst.frc.team2847.robot.subsystems;

import org.usfirst.frc.team2847.robot.RobotMap;
import org.usfirst.frc.team2847.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Drivetrain extends PIDSubsystem {

	// Initialize your subsystem here

	Encoder encR = new Encoder(RobotMap.rightEncA, RobotMap.rightEncB);
	Encoder encL = new Encoder(RobotMap.leftEncA, RobotMap.leftEncB);
	RobotDrive drive = new RobotDrive(RobotMap.frontLeftMotor,
			RobotMap.rearLeftMotor, RobotMap.frontRightMotor,
			RobotMap.rearRightMotor);

	public Drivetrain() {
		super("Drivetrain", RobotMap.Kp, RobotMap.Ki, RobotMap.Kd);
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		System.out.println("Drivetrain Subsystem");
		setAbsoluteTolerance(500);
		encL.reset();
		encR.reset();

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new JoystickDrive());

	}

	public void mecDrive(double x, double y, double rot) {
		drive.mecanumDrive_Cartesian(x, y, rot, 0);
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return encL.getRaw();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		drive.mecanumDrive_Cartesian(output, 0, 0, 0);
	}
}

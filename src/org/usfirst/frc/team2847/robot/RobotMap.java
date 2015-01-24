package org.usfirst.frc.team2847.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// OPERATOR CONTROLS
	public static final int driveJoy = 0;
	public static final int gamepadJoy = 1;

	public static final int forkOpenButton = 1;
	public static final int forkCloseButton = 2;
	public static final int liftUpButton = 3;
	public static final int liftDownButton = 4;

	// moving parts
	public static final int frontRightMotor = 3;
	public static final int frontLeftMotor = 2;
	public static final int rearRightMotor = 1;
	public static final int rearLeftMotor = 0;

	public static final int elevatorMotor = 4;
	public static final int elevatorBMotor = 5;

	public static final int panServo = 0;
	public static final int tiltServo = 1;

	public static final int forkPistons[] = { 0, 1 };

	// custom speeds
	public static final double liftSpeed = 1;

	// PID LOOP
	public static final double Kp = 4;
	public static final double Ki = 0;
	public static final double Kd = 0;
	public static final double tolerance = 500;
	public static final boolean DEBUGMODE = true;

	// sensors
	public static final int leftEncA = 1;
	public static final int leftEncB = 2;
	public static final int rightEncA = 3;
	public static final int rightEncB = 4;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

}

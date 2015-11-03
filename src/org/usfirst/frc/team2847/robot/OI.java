package org.usfirst.frc.team2847.robot;

import org.usfirst.frc.team2847.robot.commands.ElevatorCommand;
import org.usfirst.frc.team2847.robot.commands.ForkCommand;
import org.usfirst.frc.team2847.robot.commands.MagicTimeDrive;
import org.usfirst.frc.team2847.robot.commands.gotoLevel;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick driveJoy = new Joystick(RobotMap.driveJoy),
			gameJoy = new Joystick(RobotMap.gamepadJoy);

	Button bForkO = new JoystickButton(driveJoy, RobotMap.forkOpenButton),
			bForkC = new JoystickButton(driveJoy, RobotMap.forkCloseButton),
			bElevatorU = new JoystickButton(driveJoy, RobotMap.liftUpButton),
			// bMajixU = new JoystickButton(driveJoy, RobotMap.majixLiftUp),
			// bMajixD = new JoystickButton(driveJoy, RobotMap.majixLiftDown),
			bLift0 = new JoystickButton(driveJoy, RobotMap.gotoLift0),
			bLift1 = new JoystickButton(driveJoy, RobotMap.gotoLift1),
			bLift2 = new JoystickButton(driveJoy, RobotMap.gotoLift2),
			bLiftR = new JoystickButton(driveJoy, RobotMap.gotoLiftR),
			btest = new JoystickButton(driveJoy, 8),
			btest2 = new JoystickButton(driveJoy, 10),
			bElevatorD = new JoystickButton(driveJoy, RobotMap.liftDownButton);

	public OI() {
		bForkO.whenPressed(new ForkCommand(true));
		bForkC.whenPressed(new ForkCommand(false));

		bElevatorU.whenPressed(new ElevatorCommand(true, 1));
		bElevatorU.whenReleased(new ElevatorCommand(false, 0));
		bElevatorD.whenPressed(new ElevatorCommand(true, -1));
		bElevatorD.whenReleased(new ElevatorCommand(false, 0));
		btest.whenPressed(new MagicTimeDrive(3, .25));
		btest2.whenPressed(new MagicTimeDrive(3, -.25));

		// bMajixU.whenPressed(new MagicElevator(1));
		// bMajixD.whenPressed(new MagicElevator(-1));
		bLift0.whenPressed(new gotoLevel(0));
		bLift1.whenPressed(new gotoLevel(1));
		bLift2.whenPressed(new gotoLevel(2));
		bLiftR.whenPressed(new gotoLevel(88));
	}

	public double getJoyX() {
		return driveJoy.getX();
	}

	public double getJoyY() {
		return driveJoy.getY();
	}

	public int fPOV() {
		return driveJoy.getPOV();
	}

	public double getJoyR() {
		return driveJoy.getTwist();
	}

	public double getJoyThrottle() {
		return driveJoy.getThrottle();
	}
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}

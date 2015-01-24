package org.usfirst.frc.team2847.robot;

import org.usfirst.frc.team2847.robot.commands.ElevatorCommand;
import org.usfirst.frc.team2847.robot.commands.ForkCommand;

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
			bElevatorU = new JoystickButton(driveJoy, RobotMap.liftDownButton),
			bElevatorD = new JoystickButton(driveJoy, RobotMap.liftDownButton);

	public OI() {
		bForkO.whenPressed(new ForkCommand(true));
		bForkC.whenPressed(new ForkCommand(false));

		bElevatorU.whenPressed(new ElevatorCommand(true, 1));
		bElevatorU.whenReleased(new ElevatorCommand(false, 0));
		bElevatorD.whenPressed(new ElevatorCommand(true, -1));
		bElevatorD.whenReleased(new ElevatorCommand(false, 0));
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

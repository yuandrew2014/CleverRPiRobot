package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 * Vic's ultrasonic sensor running with Erik's Clever Robot for Pi
 * version 0.9, 170227
 **********************************************************************************************/
import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class CleverRobot extends IRobotAdapter {
	Sonar sonar = new Sonar();
	private boolean tailLight;

	public CleverRobot(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		CleverRobot rob = new CleverRobot(base);
		rob.setup();
		while (rob.loop()) {
		}
		rob.shutDown();

	}

	private void setup() throws Exception {
		driveDirect(100, 100);
	}

	private boolean loop() throws Exception {
		readSensors(100);
	if (isLightBump()) {
		driveDirect(0,0);
		Thread.sleep(500);
		driveDirect(-500,-500);
		Thread.sleep(1000);
		driveDirect(500,0);
		Thread.sleep(600);
		driveDirect(500,500);
	}
	//if (isBumpRight()) {
		//driveDirect(-500,-500);
		//Thread.sleep(1000);
		//driveDirect(0,500);
		//Thread.sleep(600);
		//driveDirect(500,500);
	//}
	

		return true;
	}

	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}

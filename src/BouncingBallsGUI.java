


import mickel.anim.Stage;
import mickel.image.ImageFile;
import java.awt.*;

import java.awt.Color;


/** The primary GUI window of the BouncingBalls application.
 */
public class BouncingBallsGUI
{
	// FIELDS
	// ------------------------------------------------------------
	private Stage myStage;// The base window for the app.
	private Dimension myScreenSize;	// The size of the screen.


	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** Constructs and initializes each of the components for this
	 *  GUI window.
	 *
	 *  postcondition: The primary GUI window is initialized and
	 *                   its animation cycle is started.
	 *      algorithm: Initialize a new Stage to have a title of
	 *                   "Bouncing Balls", a width of 400, and a
	 *                   height of 400.
	 *                 Set the background of myStage to be a new
	 *                   Color of your choice, preferably with a
	 *                   low alpha value. For example, translucent
	 *                   orange would be new Color(200,100,0,66)
	 *                 Optionally, set the background of myStage
	 *                   to be an image (GIF, JPEG, or PNG)
	 *                   of your choice. For example, the Duke.png
	 *                   file has been provided for you. Construct
	 *                   it using new ImageFile("Duke.png")
	 *                 Set the location of myStage such that it
	 *                   will be centered on a 1280 x 1024 screen.
	 *                   HINT: Use a mathematical expression to
	 *                   automatically calculate the appropriate
	 *                   x and y coordinate the upper left corner
	 *                   of myStage.
	 *                 Invoke this object's addSprites() method.
	 *                 Tell myStage to open its window.
	 *                 Tell myStage to start its animation cycle.
	 */
	public BouncingBallsGUI()
	{
		this.myStage = new Stage("Bouncing Balls", 400, 400);
		myStage.setBackground(new Color(200,100,0,66));
		myStage.setBackground(new ImageFile("Duke.png"));
		myStage.setLocation(640 - myStage.getWidth() / 2, 512 - myStage.getHeight() / 2);
		addSprites();
		myStage.openWindow();
		myStage.start();
	}


	// METHODS
	// ------------------------------------------------------------
	/** Constructs and adds multiple Ball objects to the Stage.
	 *  postcondition: Constructs and adds one Ball object for each
	 *                   of the 3 Ball constructors to the Stage.
	 *      algorithm: Declare a Ball variable called b1 and assign
	 *                   to it a new Ball object with no parameters.
	 *                 Declare a Ball variable called b2 and assign
	 *                   to it a new Ball object with 2 specific
	 *                   parameters (width and height of myStage).
	 *                 Declare a Ball variable called b3 and assign
	 *                   to it a new Ball object with 4 specific
	 *                   parameters (x-location, y-location, size,
	 *                   color) of your choice and add it to myStage.
	 *                 Add b1 to myStage.
	 *                 Add b2 to myStage.
	 *                 Add b3 to myStage.
	 */
	private void addSprites()
	{
		int ballSpeed = 0;
		int paddleSpeed = 0;
		String OS = System.getProperty("os.name").toLowerCase();

		if (OS.equals("mac os x")){
			System.out.println("Mac OS X detected");
			ballSpeed = 1;
			paddleSpeed = ballSpeed + 1;
		}
		else if ((OS.equals("windows 10")) || (OS.equals("windows 8")) || (OS.equals("windows 7"))||(OS.equals("windows 11"))){
			System.out.println("Windows detected");
			ballSpeed = 3;
			paddleSpeed = ballSpeed + 2;
		}
		else{
			System.exit(101);
		}
		Player1 Player1 = new Player1(10,0, paddleSpeed, 10, 75, Color.RED);
		Player2 Player2 = new Player2(380,0, paddleSpeed, 10,75, Color.RED);
		Ball b1 = new Ball(20,20,50,	Color.ORANGE, Player1, Player2, ballSpeed);
		myStage.add(b1);
		myStage.add(Player1);
		myStage.add(Player2);
	}
}

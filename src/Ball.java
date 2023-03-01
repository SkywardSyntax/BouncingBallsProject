


import mickel.anim.Sprite;
import mickel.io.Key;

import java.awt.*;

import java.awt.geom.Ellipse2D;


/** Represents a Ball that dynamically bounces around the interior
 *  of a rectangular Stage.
 */
public class Ball extends Sprite
{
	// FIELDS
	// ------------------------------------------------------------
	private int myPosXBall;		// X-coordinate of this Ball
	private int myPosYBall;		// Y-coordinate of this Ball

	private int myDirX;		// Horizontal speed of this Ball
	private int myDirY;		// Vertical speed of this Ball

	private int mySize;		// Diameter of this Ball
	private Color myColor;	// Color of this Ball

	private Color prevColor = myColor;

	private Player1 Player1Rect;
	private Player2 Player2Rect;

	private Ball ball;

	private int P1Score;
	private int P2Score;



	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** Constructs a large, red Ball that is initially located in
	 *  the upper left corner of the screen.
	 *
	 *     algorithm: Assign mySize a value of 100.
	 *                Assign myPosX and myPosY a value of
	 *                  one half mySize plus one.
	 *                Assign myDirX a value of 2.
	 *                Assign myDirY a value of 1.
	 *                Assign myColor a Color value of RED.
	 */
	public Ball() {
		mySize = 100;
		myPosXBall = mySize / 2 + 1;
		myPosYBall = mySize / 2 + 1;
		myDirX = 2;
		myDirY = 1;
		myColor = Color.RED;
		prevColor = myColor;
	}

	/** Constructs a small, green Ball that is initially centered
	 *  on a specified region of the screen.
	 *
	 *  precondition: width >= 0, height >= 0
	 *     algorithm: Assign mySize a value of 25.
	 *                Assign myPosX a value of half of width
	 *                Assign myPosY a value of half of height
	 *                Assign myDirX a value of -2.
	 *                Assign myDirY a value of 5.
	 *                Assign myColor a Color value of GREEN.
	 *
	 * @param width		Width of the stage
	 * @param height	Height of the stage
	 */
	public Ball(int width, int height) {
		mySize = 25;
		myPosXBall = width / 2;
		myPosYBall = height / 2;
		myDirX = -2;
		myDirY = 5;
		myColor = Color.GREEN;
		prevColor = myColor;
	}

	/** Constructs a Ball that initially has the specified
	 *  location, size, and color.
	 *
	 *     algorithm: Assign mySize a value of size.
	 *                Assign myPosX the value of x.
	 *                Assign myPosY the value of y.
	 *                Assign myDirX the value of 3.
	 *                Assign myDirY the value of 3.
	 *                Assign myColor the value of c.
	 *
	 * @param x		The x-coordinate of this Ball's location
	 * @param y		The y-coordinate of this Ball's location
	 * @param size	The diameter of this Ball
	 * @param c		The Color of this Ball
	 */
	public Ball(int x, int y, int size, Color c, Player1 player1Rect, Player2 player2Rect, int speed) {
		mySize = size;
		myPosXBall = x;
		myPosYBall = y;
		myDirX = speed;
		myDirY = speed;
		myColor = c;
		prevColor = myColor;
		Player1Rect = player1Rect;
		Player2Rect = player2Rect;
	}


	// METHODS
	// ------------------------------------------------------------
	/** Performs one frame of movement for this Ball object.
	 *
	 *  precondition:
	 * postcondition: The location of this Ball will be incremented
	 *                by one frame in its current direction of
	 *                movement. If the resulting location lies
	 *                beyond the boundaries of the Stage, this Ball's
	 *                direction will be adjusted accordingly to
	 *                reflect a "bounce".
	 *     algorithm: Increment myPosX by myDirX.
	 *                Increment myPosY by myDirY.
	 *                Declare an int variable w and initialize it
	 *                  with the value of the width of this Ball's
	 *                  Stage.
	 *                Declare an int variable h and initialize it
	 *                  with the value of the height of this Ball's
	 *                  Stage.
	 *                If the left edge of this Ball is less than 0
	 *                  and this Ball is moving left, negate the
	 *                  value of myDirX.
	 *                If the right edge of this Ball is greater than
	 *                  w and this Ball is moving right, negate the
	 *                  value of myDirX.
	 *                If the top edge of this Ball is less than 0
	 *                  and this Ball is moving up, negate the
	 *                  value of myDirY.
	 *                If the bottom edge of this Ball is greater than
	 *                  h and this Ball is moving down, negate the
	 *                  value of myDirY.
	 */
	public void act()
	{
		myPosXBall += myDirX;
		myPosYBall += myDirY;
		int w = getStage().getWidth();
		int h = getStage().getHeight();
		if (myPosXBall-12 < 0 && myDirX < 0) {
			myDirX = -myDirX;
			System.out.println("\u001b[31mPlayer 2 Scored!");
			P2Score++;
			prevColor = myColor;
		}
		if (myPosXBall + mySize > w-12 && myDirX > 0) {
			myDirX = -myDirX;
			System.out.println("\u001b[32mPlayer 1 Scored!");
			P1Score++;
		}
		if (myPosYBall-12 < 0 && myDirY < 0) {
			myDirY = -myDirY;
		}
		if (myPosYBall + mySize > h-12 && myDirY > 0) {
			myDirY = -myDirY;

		}
		if (myPosXBall + mySize > Player1Rect.getMyPosXRect() && myPosXBall < Player1Rect.getMyPosXRect() + Player1Rect.getMyWidth() && myPosYBall + mySize > Player1Rect.getMyPosYRect() && myPosYBall < Player1Rect.getMyPosYRect() + Player1Rect.getMyHeight()) {
			myDirX = -myDirX;
			myDirY = myDirY;


		}
		if (myPosXBall + mySize > Player2Rect.getMyPosXRect() && myPosXBall < Player2Rect.getMyPosXRect() + Player2Rect.getMyWidth() && myPosYBall + mySize > Player2Rect.getMyPosYRect() && myPosYBall < Player2Rect.getMyPosYRect() + Player2Rect.getMyHeight()) {
			myDirX = -myDirX;
			myDirY = myDirY;

		}
	}




	/** Draws a representation of the current state of this Ball
	 *  onto the graphics canvas, g.
	 *
	 *  precondition: g is the "canvas" of the Stage
	 * postcondition: Draws a representation of the current state
	 *                of this Ball onto the graphics canvas, g.
	 *     algorithm: Set the Color of g to be myColor.
	 *                Paint a filled oval onto g that is located at
	 *                  (myPosX, myPosY) with a width and height of
	 *                  mySize.
	 *
	 * @param g	The "canvas" on which this Ball is to be drawn.
	 */
	public void draw(Graphics2D g)
	{
		g.setColor(myColor);
		g.fillOval(myPosXBall, myPosYBall, mySize, mySize);
	}


	/** Gets the boundaries of this Sprite.
	 *
	 * postcondition: Returns a Shape object that corresponds to the
	 *                characteristics used in the draw() method.
	 *     algorithm: Return a new Ellipse2D.Double object that uses
	 *                  myPosX and myPosY for the x and y parameters
	 *                  and mySize for the width and height parameters.
	 *
	 * @return   The Shape specifying the boundaries of this Sprite
	 */
	public Shape getShape()
	{
		return new Ellipse2D.Double(myPosXBall, myPosYBall, mySize, mySize);
	}


	/* The following methods are event-handling methods that respond
	 * to keyboard events and mouse events. You may wish to experiment
	 * with these to add additional "user controls" for Ball objects.
	 */
	public void keyPressed (Key k) {
		if (k == Key.ESC) {
			System.out.println("\n\u001b[32mPlayer 1 Score:\u001b[0m " + P1Score);
			System.out.println("\n\u001b[31mPlayer 2 Score:\u001b[0m " + P2Score);
			System.exit(0);
		}
		if (k == Key.SPACE){
			myColor = prevColor;
		}
		if ( k == Key.BACKSPACE){
			myColor = Color.BLACK;
		}
		if (Player1Rect.ballIsTouchingRectangle(myPosXBall, myPosYBall, mySize, mySize) == true){
			myDirX = -myDirX;
		}
		if (Player1Rect.ballIsTouchingRectangle(myPosXBall, myPosYBall, mySize, mySize) == true){
			myDirX = -myDirX;
		}

	}
	public void keyReleased(Key k) {



	}
	public void keyTyped   (Key k) {

	}

	public void mousePressed (int x, int y) {
		myPosXBall = x;
		myPosYBall = y;
	}
	public void mouseReleased(int x, int y) { /* TODO: Insert code */ }
	public void mouseClicked (int x, int y) {

	}
	public void mouseMoved   (int x, int y) {

	}
	public void mouseDragged (int x, int y) {
		myPosXBall = x;
		myPosYBall = y;
	}
	public void mouseEntered (int x, int y) {

	}
	public void mouseExited  (int x, int y) { /* TODO: Insert code */ }

}

import mickel.anim.Sprite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import java.awt.geom.Ellipse2D;
import mickel.io.Key;

public class Player1 extends Sprite {
    private int myPosXRect;        // X-coordinate of this Rectangle
    private int myPosYRect;        // Y-coordinate of this Rectangle

    private int myDirX;        // Horizontal speed of this Rectangle

    private int myDirY;        // Vertical speed of this Rectangle

    private int  prevMyDirY;

    private int mySize;

    private int myWidth;        // Diameter of this Rectangle

    private int myHeight;       // Diameter of this Rectangle

    private Color myColor;    // Color of this Rectangle

    private Color prevColor = myColor;

    public Player1(int xPos, int yPos, int speedY, int myWidth, int myHeight, Color myColor) {
        myPosXRect = xPos;
        myPosYRect = yPos;
        myDirX = 0;
        myDirY = speedY;
        this.myColor = myColor;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        prevMyDirY = myDirY;

    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect(myPosXRect, myPosYRect, myWidth, myHeight);
    }

    public Shape getShape() {
        return new Ellipse2D.Double(myPosXRect, myPosYRect, 100, 100);
    }

    public void act() {
        myPosXRect += myDirX;
        myPosYRect += myDirY;
        int w = getStage().getWidth();
        int h = getStage().getHeight();
        if (myPosXRect < 0 && myDirX < 0) {
            myDirX = -myDirX;
        }
        if (myPosXRect + myWidth > w && myDirX > 0) {
            myDirX = 0;
        }
        if (myPosYRect-12 < 0 && myDirY < 0) {
            myDirY = 0;
        }
        if (myPosYRect + myHeight > h-12 && myDirY > 0) {
            myDirY = 0;
        }
    }

    public int getMyPosXRect(){
        return myPosXRect;
    }
    public int getMyPosYRect(){
        return myPosYRect;
    }
    public int getMyWidth(){
        return myWidth;
    }
    public int getMyHeight(){
        return myHeight;
    }
    public int getMyDirY(){
        return myDirY;
    }
    public void setMyDirY(int newDirY){
        myDirY = newDirY;
    }
    public void setMyDirX(int newDirX){
        myDirX = newDirX;
    }
    public void setMyPosXRect(int newPosXRect){
        myPosXRect = newPosXRect;
    }
    public void setMyPosYRect(int newPosYRect){
        myPosYRect = newPosYRect;
    }
    public void setMyWidth(int newWidth){
        myWidth = newWidth;
    }
    public void setMyHeight(int newHeight){
        myHeight = newHeight;
    }



    public boolean ballIsTouchingRectangle(int BallX, int BallY, int BallWidth, int BallHeight){
        if (BallX + BallWidth >= myPosXRect && BallX <= myPosXRect + myWidth && BallY + BallHeight >= myPosYRect && BallY <= myPosYRect + myHeight){
            return true;
        }
        return false;
    }
    public void keyPressed (Key k) {
        if (k == Key.W) {
            if (myDirY > 0){
                myDirY *= -1;
            }
            if (myDirY == 0) {
                myDirY = -1*prevMyDirY;
            }

        }
        if (k == Key.S) {
            if (myDirY < 0){
                myDirY *= -1;
            }
            if (myDirY == 0) {
                myDirY = prevMyDirY;
            }
        }

    }


}

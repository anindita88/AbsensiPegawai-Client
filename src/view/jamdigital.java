package view;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
*
* @author Anindita
*/

public class jamdigital extends javax.swing.JInternalFrame {


//Deklarasi Variable
JInternalFrame frame;

int currentHour;
int currentMinute;
int currentSecond;

//Set Font
Font myFont = new Font("Segoe UI Light", Font.BOLD, 30);

//Set Color
Color myColor = new Color(0, 0, 0);

//Save Font Information.
FontMetrics fm;

public jamdigital() {
//Create a window using JFrame with title ( Java Digital Clock )
frame = new JInternalFrame("Digital Clock");


//add(this) mean add created panel into JFrame
//Which panel ?
//See line 98 and 20 (I hope you understand it)
frame.add(this);

//Set default close operation for JFrame
frame.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);

//Set Frame size
frame.setSize(500, 75);

//Make JFrame locate at center

//Make JFrame visible
frame.setVisible(true);
frame.setResizable(false);
frame.setBounds(450, 300, 500, 75);
// frame.setUndecorated(false);

/*
*Loop that will make sure panel show current time
*like current second, current minute and current hour.
*/
while (true) {
//It will do all code in method paint(See line 71)
repaint();

try {
Thread.sleep(900);
} catch (Exception exception) {
exception.printStackTrace();
}
}
}
@Override
public void paint(Graphics g) {
super.paint(g);

/*
*Create current Date object. It means it store information
*about current hour, minute and second.
*/
Date myDate = new Date();

currentHour = myDate.getHours();
currentMinute = myDate.getMinutes();
currentSecond = myDate.getSeconds();

//Set font that will use to draw digital number
g.setFont(myFont);

//Information about distance between number in digital clock
fm = g.getFontMetrics();
int hourXCoordinate = 20;
int minuteXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 2);
int secondXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 4);

//Set color that will use to draw digital number
g.setColor(myColor);

//Draw hour, draw (:) between number, draw minute and draw second.
g.drawString(Integer.toString(currentHour), hourXCoordinate, 30);
g.drawString(":", (hourXCoordinate + minuteXCoordinate) / 2, 30);
g.drawString(Integer.toString(currentMinute), minuteXCoordinate, 30);
g.drawString(":", (secondXCoordinate + minuteXCoordinate) / 2, 30);
g.drawString(Integer.toString(currentSecond), secondXCoordinate, 30);
}

public static void main(String[] args) {
jamdigital sdc = new jamdigital();
}
}
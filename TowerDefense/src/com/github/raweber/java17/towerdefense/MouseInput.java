package com.github.raweber.java17.towerdefense;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {

	public void mouseClicked(MouseEvent e) {
		MouseHandler.mouseClicked(e);
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
//		MouseHandler.mouseDown(e);
	}

	public void mouseReleased(MouseEvent e) {
		MouseHandler.mouseUp(e);
	}

	public void mouseDragged(MouseEvent e) {
		MouseHandler.mouseMoved(e);
		MouseHandler.mouseDown(e);
	}

	public void mouseMoved(MouseEvent e){
		MouseHandler.mouseMoved(e);
	}

}

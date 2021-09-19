import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PaintCanvas extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	ArrayList<Point> currentDrawStack = new ArrayList<>();
	ArrayList<ArrayList<Point>> drawStack = new ArrayList<>();
	
	ArrayList<ArrayList<Point>> undoStack = new ArrayList<>();
	
	PaintFrame parent;
	
	Color cColor = new Color(0x0);
	
	public PaintCanvas(PaintFrame parent) {
		this.parent = parent;
		setPreferredSize(new Dimension(500, 500));
	}
	
	public void paint(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setPaint(new Color(0xffffff));
		g.fillRect(0, 0, 500, 500);
		
		g.setPaint(cColor);
		
		for (ArrayList<Point> pointList : drawStack) {
			for (Point point : pointList) {
				g.fillOval((int) point.getX(), (int) point.getY(), 10, 10);
			}
		}
		
		for (Point point : currentDrawStack) {
			g.fillOval((int) point.getX(), (int) point.getY(), 10, 10);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		addToDrawStack(e.getPoint());
	}
	
	private void addToDrawStack(Point p) {
		currentDrawStack.add(p);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
	
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		addToDrawStack(e.getPoint());
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		drawStack.add(currentDrawStack);
		currentDrawStack = new ArrayList<>();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		System.out.println(keyCode);
		switch (keyCode) {
			case KeyEvent.VK_C -> cColor = JColorChooser.showDialog(null, "Farbauswahl", null);
			case KeyEvent.VK_Z -> undoLastPaint();
			case KeyEvent.VK_Y -> redoLastPaint();
		}
	}
	
	private void redoLastPaint() {
		try {
			drawStack.add(undoStack.remove(undoStack.size() - 1));
		} catch (IndexOutOfBoundsException ignored) {
		}
	}
	
	private void undoLastPaint() {
		try {
			undoStack.add(drawStack.remove(drawStack.size() - 1));
		} catch (IndexOutOfBoundsException ignored) {
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
}

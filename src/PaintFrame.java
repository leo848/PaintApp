import javax.swing.*;


public class PaintFrame extends JFrame {
	final ColorChooser colorDialog = new ColorChooser();
	GameLoop loop;
	PaintCanvas canvas;
	InputMap inputMap;
	
	PaintFrame(GameLoop gameLoop) {
		loop = gameLoop;
		
		canvas = new PaintCanvas(this);
		
		inputMap = canvas.getInputMap();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(canvas);
		pack();
		
		//colorDialog.setVisible(true);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		addKeyListener(canvas);
		getContentPane().addMouseListener(canvas);
		getContentPane().addMouseMotionListener(canvas);
	}
	
	public void repaintCanvas() {
		canvas.repaint();
	}
}
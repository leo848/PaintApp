import java.awt.*;
import java.awt.image.*;

public class GameLoop implements Runnable {
	public Thread thread;
	public BufferStrategy bs;
	public Graphics g;
	PaintFrame paintFrame;
	int sleepMillis = 50;
	private Boolean running = false;
	
	public GameLoop() {
	
	}
	
	public synchronized void start() {
		System.out.println("start");
		if (running) return;
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public void run() {
		System.out.println("run");
		init();
		
		while (running) {
			update();
			render();
			try {
				Thread.sleep(sleepMillis);
			} catch (InterruptedException ignored) {
			
			}
			
		}
		
		stop();
	}
	
	private void init() {
		System.out.println("init");
		paintFrame = new PaintFrame(this);
		
	}
	
	private void update() {
		//System.out.println("update");
		
	}
	
	private void render() {
		paintFrame.repaintCanvas();
	}
	
	public synchronized void stop() {
		if (!running) return;
		running = false;
		paintFrame.dispose();
		try {
			thread.join();
		} catch (Exception ignored) {
		
		}
	}
}
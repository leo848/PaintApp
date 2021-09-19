import javax.swing.*;
import java.awt.*;

public class ColorChooser extends JDialog {
	JTextField hexCodeField = new JTextField("default value");
	
	public ColorChooser() {
		setSize(200, 200);
		
		getContentPane().add(new JLabel("Choose a color"));
		getContentPane().add(hexCodeField, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
	}
}

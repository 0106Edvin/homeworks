package ba.bitcamp.homework18.task05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * 
 * Ovaj zadatak je odradjen na predavanjima zajedno sa predavacem
 *
 */
public class Color1 extends JPanel {
	private static final long serialVersionUID = -5911055841726470526L;

	private int red;
	private int green;
	private int blue;
	private JButton click;

	public Color1(int width, int height) {
		
		initButton(width, height);

		/**
		 * sliders
		 */
		int sliderHeight = (height / 7);
		Dimension sliderDimension = new Dimension(width - 75, sliderHeight);

		JSlider redSlider = new JSlider(0, 255);
		initSlider(redSlider, "red", sliderDimension);
		redSlider.setValue(0);

		JSlider greenSlider = new JSlider(0, 255);
		initSlider(greenSlider, "green", sliderDimension);
		greenSlider.setValue(0);

		JSlider blueSlider = new JSlider(0, 255);
		initSlider(blueSlider, "blue", sliderDimension);
		blueSlider.setValue(0);

		// labels
		JLabel redLabel = new JLabel("RED");
		JLabel greenLabel = new JLabel("GREEN");
		JLabel blueLabel = new JLabel("BLUE");

		add(click);
		add(redLabel);
		add(redSlider);
		add(greenLabel);
		add(greenSlider);
		add(blueLabel);
		add(blueSlider);

	}

	private void initSlider(JSlider slider, String name, Dimension d) {
		slider.setName(name);
		slider.setPreferredSize(d);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider)e.getSource();
				
				String name = changed.getName();
				switch(name){
				case "red":
					red = changed.getValue();
					break;
				case "green":
					green = changed.getValue();
					break;
				case "blue":
					blue = changed.getValue();
					break;
				}
				updateButton();
				
			}
		});

	}

	private void updateButton() {
		click.setBackground(new Color(red, green, blue));
		click.setForeground(new Color(255 - red, 255 - green, 255 - blue));
	}

	private void initButton(int width, int height) {

		click = new JButton("Click me");
		click.setPreferredSize(new Dimension(width, height / 2));
		click.setOpaque(true);
		click.setBorderPainted(false);
		click.setFont(new Font("Monospace", Font.BOLD, 26));

		updateButton();
	}
}

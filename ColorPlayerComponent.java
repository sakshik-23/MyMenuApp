package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorPlayerComponent extends JPanel{
	
private JButton b1;
	
	public ColorPlayerComponent() {
		b1=new JButton("Get Color");
		b1.addActionListener((e)->{
			Color selected=JColorChooser.showDialog(this, "Select Color", Color.PINK);
			this.setBackground(selected);
		});
		super.add(b1);
		super.setSize(200,200);
		super.setLayout(new FlowLayout());
		super.setVisible(false);
	}

}

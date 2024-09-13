package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class MyColorPanel extends JPanel{
	
	private JButton b;
	private Color col=Color.BLACK;
	private int x=200, y=200;
	ArrayList<BallThread> al=new ArrayList<BallThread>();
	
	public MyColorPanel()
	{
		b=new JButton("Get Color");
		b.addActionListener((e)->{
			Color selected=JColorChooser.showDialog(this, "Select Color", Color.PINK);
			//this.setBackground(selected);
			col=selected;
			this.repaint();//this internally calls the paint function
		});
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				x=e.getX();
				y=e.getY();
				//MyColorPanel.this.repaint();//use this of my color panel and then repaint
				BallThread ball=new BallThread(col, x, y, MyColorPanel.this);
				ball.start();
				al.add(ball);
			}
		});
		
		this.setLayout(new FlowLayout());
		this.add(b);
		this.setSize(400,400);
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(BallThread b1:al)
		{
		g.setColor(b1.ballColor);
		g.fillOval(b1.currentX, b1.starty, 40, 40);
		}
	}

}

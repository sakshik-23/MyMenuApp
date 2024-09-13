package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TicTacToe extends JPanel{
	
	private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, n1, n2;
	private JLabel winner, score, score2, scoreboard, name1, name2;
	private ButtonGroup bgrp;
	private JButton save, empty;
	private JRadioButton rb1, rb2;
	private int s=0, s2=0;
	private PrintWriter pw;
	
	public TicTacToe() {
		
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("c:/java_texts/gamescore.txt",true);
			pw=new PrintWriter(fout);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		name1=new JLabel("Enter name for Player 1 - 'O':");
		name1.setBounds(20, 10, 200, 80);
		n1=new JTextField();
		n1.setBounds(190, 30, 100, 40);
		name2=new JLabel("Enter name for Player 2 - 'X':");
		name2.setBounds(20, 80, 200, 80);
		n2=new JTextField();
		n2.setBounds(190, 100, 100, 40);
		
		rb1=new JRadioButton();
		rb1.setBounds(10, 150, 100, 50);
		rb1.setEnabled(false);
		
		
		rb2=new JRadioButton();
		rb2.setBounds(10, 190, 100, 50);
		rb2.setEnabled(false);
		
		save=new JButton("SAVE NAMES");
		save.setBounds(300, 100, 160, 30);
		save.addActionListener((s)->{
			String a=n1.getText();
			rb1.setText(a);
			rb1.setSelected(true);
			
			String b=n2.getText();
			rb2.setText(b);
		});
		
		bgrp=new ButtonGroup();
		bgrp.add(rb1);
		bgrp.add(rb2);
		
		tf1=new JTextField();
		tf1.setBounds(300, 200, 100, 100);
		tf1.setFont(new Font("Arial", Font.PLAIN, 50));
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf1.setEnabled(false);
		tf2=new JTextField();
		tf2.setBounds(400, 200, 100, 100);
		tf2.setFont(new Font("Arial", Font.PLAIN, 50));
		tf2.setHorizontalAlignment(JTextField.CENTER);
		tf2.setEnabled(false);
		tf3=new JTextField();
		tf3.setBounds(500, 200, 100, 100);
		tf3.setFont(new Font("Arial", Font.PLAIN, 50));
		tf3.setHorizontalAlignment(JTextField.CENTER);
		tf3.setEnabled(false);
		tf4=new JTextField();
		tf4.setBounds(300, 300, 100, 100);
		tf4.setFont(new Font("Arial", Font.PLAIN, 50));
		tf4.setHorizontalAlignment(JTextField.CENTER);
		tf4.setEnabled(false);
		tf5=new JTextField();
		tf5.setBounds(400, 300, 100, 100);
		tf5.setFont(new Font("Arial", Font.PLAIN, 50));
		tf5.setHorizontalAlignment(JTextField.CENTER);
		tf5.setEnabled(false);
		tf6=new JTextField();
		tf6.setBounds(500, 300, 100, 100);
		tf6.setFont(new Font("Arial", Font.PLAIN, 50));
		tf6.setHorizontalAlignment(JTextField.CENTER);
		tf6.setEnabled(false);
		tf7=new JTextField();
		tf7.setBounds(300, 400, 100, 100);
		tf7.setFont(new Font("Arial", Font.PLAIN, 50));
		tf7.setHorizontalAlignment(JTextField.CENTER);
		tf7.setEnabled(false);
		tf8=new JTextField();
		tf8.setBounds(400, 400, 100, 100);
		tf8.setFont(new Font("Arial", Font.PLAIN, 50));
		tf8.setHorizontalAlignment(JTextField.CENTER);
		tf8.setEnabled(false);
		tf9=new JTextField();
		tf9.setBounds(500, 400, 100, 100);
		tf9.setFont(new Font("Arial", Font.PLAIN, 50));
		tf9.setHorizontalAlignment(JTextField.CENTER);
		tf9.setEnabled(false);
		
		empty=new JButton("RESTART GAME");
		empty.setBounds(500, 10, 180, 30);
		
		winner=new JLabel();
		winner.setBounds(300, 500, 300, 50);
		
		scoreboard=new JLabel("SCORE BOARD");
		scoreboard.setBounds(750, 200, 300, 50);
		
		score=new JLabel();
		score.setBounds(700, 300, 300, 50);
		
		score2=new JLabel();
		score2.setBounds(700, 400, 300, 50);
		
		empty.addActionListener((e)->{
			if(tf1.getText()!= null && tf2.getText()!=null && tf3.getText()!=null && tf4.getText()!=null && tf5.getText()!=null && tf6.getText()!=null && tf7.getText()!=null && tf8.getText()!=null && tf9.getText()!=null)
			{
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
				tf8.setText("");
				tf9.setText("");
				n1.setText("");
				n2.setText("");
				rb1.setText("");
				rb2.setText("");
				bgrp.clearSelection();
				winner.setText("");
				//score.setText("");
			}
		});
		
		tf1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rb1.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf1.setText("O");
					tf1.setForeground(Color.BLACK);
					tf1.setEnabled(false);
				}
				if(rb2.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf1.setText("X");
					tf1.setForeground(Color.BLACK);
					tf1.setEnabled(false);
				}
				if(tf1.getText().equals("O"))
				{
					bgrp.clearSelection();
					rb2.setSelected(true);
				}
				else
				{
					bgrp.clearSelection();
					rb1.setSelected(true);
				}
				if(checkLine()==true)
				{
					bgrp.clearSelection();
				}
				matchTie();
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) { }
		});
		
		tf2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rb1.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf2.setText("O");
					tf2.setForeground(Color.BLACK);
					tf2.setEnabled(false);
				}
				if(rb2.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf2.setText("X");
					tf2.setForeground(Color.BLACK);
					tf2.setEnabled(false);
				}
				if(tf2.getText().equals("O"))
				{
					bgrp.clearSelection();
					rb2.setSelected(true);
				}
				else
				{
					bgrp.clearSelection();
					rb1.setSelected(true);
				}
				if(checkLine()==true)
				{
					bgrp.clearSelection();
				}
				matchTie();
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) { }
		});
		
		tf3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rb1.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf3.setText("O");
					tf3.setForeground(Color.BLACK);
					tf3.setEnabled(false);
				}
				if(rb2.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf3.setText("X");
					tf3.setForeground(Color.BLACK);
					tf3.setEnabled(false);
				}
				if(tf3.getText().equals("O"))
				{
					bgrp.clearSelection();
					rb2.setSelected(true);
					
				}
				else
				{
					bgrp.clearSelection();
					rb1.setSelected(true);
				}
				if(checkLine()==true)
				{
					bgrp.clearSelection();
				}
				matchTie();
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) { }
		});
		
		tf4.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rb1.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf4.setText("O");
					tf4.setForeground(Color.BLACK);
					tf4.setEnabled(false);
				}
				if(rb2.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf4.setText("X");
					tf4.setForeground(Color.BLACK);
					tf4.setEnabled(false);
				}
				if(tf4.getText().equals("O"))
				{
					bgrp.clearSelection();
					rb2.setSelected(true);
				}
				else
				{
					bgrp.clearSelection();
					rb1.setSelected(true);
				}
				if(checkLine()==true)
				{
					bgrp.clearSelection();
				}
				matchTie();
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) { }
		});
		
		tf5.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rb1.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf5.setText("O");
					tf5.setForeground(Color.BLACK);
					tf5.setEnabled(false);
				}
				if(rb2.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf5.setText("X");
					tf5.setForeground(Color.BLACK);
					tf5.setEnabled(false);
				}
				if(tf5.getText().equals("O"))
				{
					bgrp.clearSelection();
					rb2.setSelected(true);
				}
				else
				{
					bgrp.clearSelection();
					rb1.setSelected(true);
				}
				if(checkLine()==true)
				{
					bgrp.clearSelection();
				}
				matchTie();
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) { }
		});
		
		tf6.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rb1.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf6.setText("O");
					tf6.setForeground(Color.BLACK);
					tf6.setEnabled(false);
				}
				if(rb2.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf6.setText("X");
					tf6.setForeground(Color.BLACK);
					tf6.setEnabled(false);
				}
				if(tf6.getText().equals("O"))
				{
					bgrp.clearSelection();
					rb2.setSelected(true);
				}
				else
				{
					bgrp.clearSelection();
					rb1.setSelected(true);
				}
				if(checkLine()==true)
				{
					bgrp.clearSelection();
				}
				matchTie();
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) { }
		});
		
		tf7.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rb1.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf7.setText("O");
					tf7.setForeground(Color.BLACK);
					tf7.setEnabled(false);
				}
				if(rb2.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf7.setText("X");
					tf7.setForeground(Color.BLACK);
					tf7.setEnabled(false);
				}
				if(tf7.getText().equals("O"))
				{
					bgrp.clearSelection();
					rb2.setSelected(true);
				}
				else
				{
					bgrp.clearSelection();
					rb1.setSelected(true);
				}
				if(checkLine()==true)
				{
					bgrp.clearSelection();
				}
				matchTie();
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) { }
		});
		
		tf8.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rb1.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf8.setText("O");
					tf8.setForeground(Color.BLACK);
					tf8.setEnabled(false);
				}
				if(rb2.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf8.setText("X");
					tf8.setForeground(Color.BLACK);
					tf8.setEnabled(false);
				}
				if(tf8.getText().equals("O"))
				{
					bgrp.clearSelection();
					rb2.setSelected(true);
				}
				else
				{
					bgrp.clearSelection();
					rb1.setSelected(true);
				}
				if(checkLine()==true)
				{
					bgrp.clearSelection();
				}			
			    matchTie();	
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) { }
		});
		
		tf9.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(rb1.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf9.setText("O");
					tf9.setForeground(Color.BLACK);
					tf9.setEnabled(false);
				}
				if(rb2.isSelected() && e.getX()>0 && e.getY()>0)
				{
					tf9.setText("X");
					tf9.setForeground(Color.BLACK);
					tf9.setEnabled(false);
				}
				if(tf9.getText().equals("O"))
				{
					bgrp.clearSelection();
					rb2.setSelected(true);
				}
				else
				{
					bgrp.clearSelection();
					rb1.setSelected(true);
				}
				if(checkLine()==true)
				{
					bgrp.clearSelection();
				}
				matchTie();
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) { }
		});
		
		//Container c1=t.getRootPane();
		super.add(name1);
		super.add(n1);
		super.add(name2);
		super.add(n2);
		super.add(rb1);
		super.add(rb2);
		super.add(tf1);
		super.add(tf2);
		super.add(tf3);
		super.add(tf4);
		super.add(tf5);
		super.add(tf6);
		super.add(tf7);
		super.add(tf8);
		super.add(tf9);
		super.add(scoreboard);
		super.add(score);
		super.add(score2);
		super.add(winner);
		super.add(empty);
		super.add(save);
		super.setSize(400,500);
		super.setLayout(null);
		super.setVisible(false);
		//f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	public boolean checkLine()
	{
		if(tf1.getText().equals(tf2.getText())  && tf2.getText().equals(tf3.getText()) && !tf1.getText().equals(""))
		{	
			if(rb1.isSelected())
			{
				winner.setText("WOHOOOO !!! "+n2.getText()+" is the WINNER!!!");
				s2++;
				score.setText("Player 1 - "+s);
				score2.setText("Player 2 - "+s2);
				pw.println(n2.getText()+" is winner");
				pw.flush();
				//pw.close();
			}
			else
			{
				winner.setText("WOHOOOO !!! "+n1.getText()+" is the WINNER!!!");
				s++;
				score.setText("Player 1 - "+s);
				score2.setText("Player 2 - "+s2);
				pw.println(n1.getText()+" is winner");
				pw.flush();
			}
			return true;
		}
		else if(tf4.getText().equals(tf5.getText())  && tf5.getText().equals(tf6.getText()) && !tf4.getText().equals(""))
		{
			if(rb1.isSelected())
			{
				winner.setText("WOHOOOO !!! "+n2.getText()+" is the WINNER!!!");
				s2++;
				score.setText("Player 1 - "+s++);
				score2.setText("Player 2 - "+s2);
				pw.println(n2.getText()+" is winner");
				pw.flush();
			}
			else
			{
				winner.setText("WOHOOOO !!! "+n1.getText()+" is the WINNER!!!");
				s++;
				score.setText("Player 1 - "+s);
				score2.setText("Player 2 - "+s2++);
				pw.println(n1.getText()+" is winner");
				pw.flush();
			}
			return true;
		}
		else if(tf7.getText().equals(tf8.getText())  && tf8.getText().equals(tf9.getText()) && !tf7.getText().equals(""))
		{
			if(rb1.isSelected())
			{
				winner.setText("WOHOOOO !!! "+n2.getText()+" is the WINNER!!!");
				s2++;
				score.setText("Player 1 - "+s++);
				score2.setText("Player 2 - "+s2);
				pw.println(n2.getText()+" is winner");
				pw.flush();
			}
			else
			{
				winner.setText("WOHOOOO !!! "+n1.getText()+" is the WINNER!!!");
				s++;
				score.setText("Player 1 - "+s);
				score2.setText("Player 2 - "+s2++);
				pw.println(n1.getText()+" is winner");
				pw.flush();
			}
			return true;
		}
		else if(tf1.getText().equals(tf4.getText())  && tf4.getText().equals(tf7.getText()) && !tf1.getText().equals(""))
		{
			if(rb1.isSelected())
			{
				winner.setText("WOHOOOO !!! "+n2.getText()+" is the WINNER!!!");
				s2++;
				score.setText("Player 1 - "+s++);
				score2.setText("Player 2 - "+s2);
				pw.println(n2.getText()+" is winner");
				pw.flush();
			}
			else
			{
				winner.setText("WOHOOOO !!! "+n1.getText()+" is the WINNER!!!");
				s++;
				score.setText("Player 1 - "+s);
				score2.setText("Player 2 - "+s2++);
				pw.println(n1.getText()+" is winner");
				pw.flush();
			}
			return true;
		}
		else if(tf2.getText().equals(tf5.getText())  && tf5.getText().equals(tf8.getText()) && !tf2.getText().equals(""))
		{
			if(rb1.isSelected())
			{
				winner.setText("WOHOOOO !!! "+n2.getText()+" is the WINNER!!!");
				s2++;
				score.setText("Player 1 - "+s++);
				score2.setText("Player 2 - "+s2);
				pw.println(n2.getText()+" is winner");
				pw.flush();
			}
			else
			{
				winner.setText("WOHOOOO !!! "+n1.getText()+" is the WINNER!!!");
				s++;
				score.setText("Player 1 - "+s);
				score2.setText("Player 2 - "+s2++);
				pw.println(n1.getText()+" is winner");
				pw.flush();
			}
			return true;
		}
		else if(tf3.getText().equals(tf6.getText())  && tf6.getText().equals(tf9.getText()) && !tf3.getText().equals(""))
		{
			if(rb1.isSelected())
			{
				winner.setText("WOHOOOO !!! "+n2.getText()+" is the WINNER!!!");
				s2++;
				score.setText("Player 1 - "+s++);
				score2.setText("Player 2 - "+s2);
				pw.println(n2.getText()+" is winner");
				pw.flush();
			}
			else
			{
				winner.setText("WOHOOOO !!! "+n1.getText()+" is the WINNER!!!");
				s++;
				score.setText("Player 1 - "+s);
				score2.setText("Player 2 - "+s2++);
				pw.println(n1.getText()+" is winner");
				pw.flush();
			}
			return true;
		}
		else if(tf1.getText().equals(tf5.getText())  && tf5.getText().equals(tf9.getText()) && !tf1.getText().equals(""))
		{
			if(rb1.isSelected())
			{
				winner.setText("WOHOOOO !!! "+n2.getText()+" is the WINNER!!!");
				s2++;
				score.setText("Player 1 - "+s++);
				score2.setText("Player 2 - "+s2);
				pw.println(n2.getText()+" is winner");
				pw.flush();
			}
			else
			{
				winner.setText("WOHOOOO !!! "+n1.getText()+" is the WINNER!!!");
				s++;
				score.setText("Player 1 - "+s);
				score2.setText("Player 2 - "+s2++);
				pw.println(n1.getText()+" is winner");
				pw.flush();
			}
			return true;
		}
		else if(tf3.getText().equals(tf5.getText())  && tf5.getText().equals(tf7.getText()) && !tf3.getText().equals(""))
		{
			if(rb1.isSelected())
			{
				winner.setText("WOHOOOO !!! "+n2.getText()+" is the WINNER!!!");
				s2++;
				score.setText("Player 1 - "+s++);
				score2.setText("Player 2 - "+s2);
				pw.println(n2.getText()+" is winner");
				pw.flush();
			}
			else
			{
				winner.setText("WOHOOOO !!! "+n1.getText()+" is the WINNER!!!");
				s++;
				score.setText("Player 1 - "+s);
				score2.setText("Player 2 - "+s2++);
				pw.println(n1.getText()+" is winner");
				pw.flush();
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean matchTie()
	{
		if(!tf1.getText().equals("") && !tf2.getText().equals("") && !tf3.getText().equals("") && !tf4.getText().equals("") && !tf5.getText().equals("") && !tf6.getText().equals("") && !tf7.getText().equals("") && !tf8.getText().equals("") && !tf9.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "IT'S A TIE :(");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		TicTacToe t=new TicTacToe();
		
	}


}

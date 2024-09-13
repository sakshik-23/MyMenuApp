package gui;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataEntryComponent extends JPanel{
	
	//private JLabel heading;
	private JTextField tf1, tf2, tf3;
	private JLabel l1, l2, l3;
	private JButton b1, b2;
	
	public DataEntryComponent() {
		l1=new JLabel("Enter name-");
		tf1=new JTextField(10);
		l2=new JLabel("Enter phone no-");
		tf2=new JTextField(10);
		l3=new JLabel("Enter age-");
		tf3=new JTextField(10);
		/*File f=new File("e:/sakshi/temp/userdata.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		b1=new JButton("SAVE");
		b1.addActionListener((e)->{
			FileOutputStream fout;
			try {
				fout = new FileOutputStream("e:/sakshi/temp/userdata.txt", true);
				PrintWriter pw=new PrintWriter(fout);
				pw.println(tf1.getText()+","+tf2.getText()+","+tf3.getText());
				pw.flush();
				pw.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		b2=new JButton("RESET");
		b2.addActionListener((e)->{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
		});
		super.add(l1);
		super.add(tf1);
		super.add(l2);
		super.add(tf2);
		super.add(l3);
		super.add(tf3);
		super.add(b1);
		super.add(b2);
		super.setSize(100,200);
		super.setLayout(new FlowLayout());
		super.setVisible(false);
	}

}

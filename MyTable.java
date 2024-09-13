package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JScrollPane;//scroll able panel
import javax.swing.JTable;

public class MyTable extends JPanel{

	private JTable t;
	
	public MyTable() {
		
		/*String[][] data= {
				{"Abhishek","2156465323","24"},
				{"Priya","9876456","21"}
		};*/
		String[] columnNames= {"Name","PhoneNum","Age"};
		String[][] s=null;
		try {
			s=getDataFromFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t=new JTable(s,columnNames);
		this.add(new JScrollPane(t));
		this.setSize(600,600);
		this.setVisible(false);
	}
	
	public String[][] getDataFromFile() throws FileNotFoundException
	{
		FileInputStream fin=new FileInputStream("e:\\sakshi\\temp\\userdata.txt");
		Scanner sc=new Scanner(fin);
		
		String[][] x=new String[3][3];
		int row=0;
		while(sc.hasNextLine())
		{
			String data=sc.nextLine();
			//System.out.println(data);
			String[] separate=data.split(",");
			x[row][0]=separate[0];
			x[row][1]=separate[1];
			x[row][2]=separate[2];
			row++;
		}
		
		return x;
		
	}
}



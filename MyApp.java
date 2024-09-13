package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MyApp extends JFrame{
	
	private DataEntryComponent dec;
	private ColorPlayerComponent cpc;
	private TicTacToe tc;
	private MyTable mt;
	private JMenuBar mb;
	private JMenu m1, m2, m3, m4;
	
	public MyApp() {
		dec=new DataEntryComponent();
		cpc=new ColorPlayerComponent();
		tc=new TicTacToe();
		mt=new MyTable();
		mb=new JMenuBar();
		m1=new JMenu("Data Entry");
		m1.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				dec.setVisible(true);
				cpc.setVisible(false);
				mt.setVisible(false);
				tc.setVisible(false);
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		m2=new JMenu("Color Player");
		m2.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				cpc.setVisible(true);
				dec.setVisible(false);
				mt.setVisible(false);
				tc.setVisible(false);
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		m3=new JMenu("Tic Tac Toe");
		m3.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				tc.setVisible(true);
				dec.setVisible(false);
				cpc.setVisible(false);
				mt.setVisible(false);
				
				
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		m4=new JMenu("Table Data");
		m4.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				mt.setVisible(true);
				dec.setVisible(false);
				cpc.setVisible(false);
				tc.setVisible(false);
				
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		
		this.setJMenuBar(mb);
		this.add(mt);
		this.add(dec);
		this.add(cpc);
		//this.add(new ColorPlayerComponent());
		this.add(tc);
		
		super.setSize(800,800);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
	}

	public static void main(String[] args) {
		
		 MyApp obj=new MyApp();

	}

}

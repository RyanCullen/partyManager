package dnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ManagerFrame extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem loadMenuItem;
	private JMenuItem exitMenuItem;
	public static String dataFileName;
	private CharacterList charList;
	private JMenuItem newMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ManagerFrame frame = new ManagerFrame();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerFrame()
	{
		setTitle("D&D Party Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		newMenuItem = new JMenuItem("New");
		fileMenu.add(newMenuItem);
		
		loadMenuItem = new JMenuItem("Load");
		
		fileMenu.add(loadMenuItem);
		
		exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		loadMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if (arg0.getSource() == loadMenuItem) {
			FileDialog fd = new FileDialog(this, "Choose data file to load", FileDialog.LOAD);
			fd.setVisible(true);
			String dir = fd.getDirectory();
			String path = fd.getFile();
			if (dir != null && fd != null) {
				dataFileName = dir + path;
				charList = new CharacterList(dataFileName);
			}
		}
		else
			if (arg0.getSource() == exitMenuItem) {
				this.dispose();
			}
			else
				if (arg0.getSource() == newMenuItem) {
					
				}
		
	}

}

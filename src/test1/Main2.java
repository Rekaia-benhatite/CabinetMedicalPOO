package test1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;

public class Main2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel jlabelx;
    private JLabel jlabely;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 frame = new Main2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 677);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		 JPanel panel = new JPanel();
		 panel.setForeground(new Color(30, 144, 255));
		 panel.setBounds(30, 36, 333, 535);
		 contentPane.add(panel);
		 panel.setLayout(null);
		
		 jlabelx = new JLabel("New label");
		jlabelx.setBounds(726, 96, 132, 41);
		contentPane.add(jlabelx);
		
		 jlabely = new JLabel("New label");
		jlabely.setBounds(746, 225, 112, 41);
		contentPane.add(jlabely);
	}
	int newid;
	String uname;
	String usertype;
	public Main2(int id, String username, String utype)
	{
		this();
		this.uname = username;
		jlabelx.setText(uname);
		this.usertype = utype;
		jlabely.setText(usertype);
		this.newid= id;
	}
}
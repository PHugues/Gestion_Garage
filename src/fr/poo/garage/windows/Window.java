/**
 * Dec 14, 2017
 * @author = Pierre Hugues - Group G11
 * @version 1.0
 */
package fr.poo.garage.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class representing a 
 * <p>
 * Dec 14, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */


public final class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -911495180918942498L;
	
	
	private JButton loginButton = new JButton("Log In");
	private JButton registerButton = new JButton("Register");
	
	public Window()
	{
		this.setTitle("Menu");
		this.setSize(840, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("\n+--------------+");
				System.out.println("|    Log in    |");
				System.out.println("+--------------+\n");
				Login lg = new Login(null, "Login", true);
				LoginInfo lgInfo = lg.showLogin();
				JOptionPane.showMessageDialog(null, lgInfo.toString(), "Connection", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		registerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n+----------------+");
				System.out.println("|    Register    |");
				System.out.println("+----------------+\n");
				Register rg = new Register(null, "Register", true);
				RegisterInfo rgInfo = rg.showRegister();
				JOptionPane.showMessageDialog(null, rgInfo.toString(), "Client info", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("\n+---------------------------+");
				System.out.println("|    End of registration    |");
				System.out.println("+---------------------------+\n");
			}
		});
		
		Box b1 = Box.createHorizontalBox();
		b1.add(loginButton);
		b1.add(registerButton);
		
		Box b2 = Box.createVerticalBox();
		b2.add(b1);
		
		this.getContentPane().add(b2);
		this.setVisible(true);
	}

}

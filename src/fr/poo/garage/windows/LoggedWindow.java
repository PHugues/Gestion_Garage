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

public final class LoggedWindow extends JFrame {

	private static final long serialVersionUID = -5836497008018189600L;
	
	private JButton rentButton = new JButton("Rent");
	private JButton returnButton = new JButton("Return");
	private JButton disconnectButton = new JButton("Disconnect");
	
	public LoggedWindow()
	{
		this.setTitle("Menu");
		this.setSize(840, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		rentButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("\n+--------------------+");
				System.out.println("|        Rent        |");
				System.out.println("+--------------------+\n");
				new Rent();
			}
			
		});
		
		returnButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
		        System.out.println("\n+----------------------+");
				System.out.println("|        Return        |");
		        System.out.println("+----------------------+\n");
		        new ReturnV();
			}
		});
		
		disconnectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Successfully  disconnected.", "Disconnect", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("\n+---------------------+");
				System.out.println("|    End of log in    |");
				System.out.println("+---------------------+\n");
				setVisible(false);
			}
		});
		
		Box b1 = Box.createHorizontalBox();
		b1.add(returnButton);
		b1.add(rentButton);
		b1.add(disconnectButton);
		
		Box b2 = Box.createVerticalBox();
		b2.add(b1);
		
		this.getContentPane().add(b2);
		this.setVisible(true);
	}
}

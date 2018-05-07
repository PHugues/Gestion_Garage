package fr.poo.garage.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.poo.garage.Client;
import fr.poo.garage.Garage;

/**
 * Class representing a 
 * <p>
 * Dec 14, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */


public final class Register extends JDialog {
	
	private static final long serialVersionUID = 237814241972253759L;
	
	private RegisterInfo rInfo = new RegisterInfo();
	
	private JLabel nameLabel, idLabel, passLabel;
	private JTextField name, ID, pass;

	public Register(JFrame mother, String title, boolean modal)
	{
		super(mother, title, modal);
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    this.initComponent();
	}
	
	public RegisterInfo showRegister()
	{
		this.setVisible(true);
		return this.rInfo;
	}
	
	private void initComponent()
	{
		//Name
		JPanel panName = new JPanel();
		panName.setBackground(Color.white);
		panName.setPreferredSize(new Dimension(250, 60));
		name = new JTextField();
		name.setPreferredSize(new Dimension(100, 25));
		panName.setBorder(BorderFactory.createTitledBorder("Name"));
		nameLabel = new JLabel("Enter a name :");
		panName.add(nameLabel);
		panName.add(name);
		
		//ID
		JPanel panID = new JPanel();
		panID.setBackground(Color.white);
		panID.setPreferredSize(new Dimension(250, 60));
		ID = new JTextField();
		ID.setPreferredSize(new Dimension(100, 25));
		panID.setBorder(BorderFactory.createTitledBorder("Identification number :"));
		idLabel = new JLabel("Enter an ID :");
		panID.add(idLabel);
		panID.add(ID);
		
		//Password
		JPanel panPass = new JPanel();
		panPass.setBackground(Color.white);
		panPass.setPreferredSize(new Dimension(500, 60));
		pass = new JTextField();
		pass.setPreferredSize(new Dimension(300, 25));
		panPass.setBorder(BorderFactory.createTitledBorder("Password :"));
		passLabel = new JLabel("Enter a password :");
		panPass.add(passLabel);
		panPass.add(pass);
		
		//Content
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panName);
		content.add(panID);
		content.add(panPass);
		
		JPanel control = new JPanel();
		
		JButton okButton = new JButton("Confirm");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					new Client(ID.getText(), name.getText(), pass.getText());
					System.out.println("New client : " + Garage.getClientList().get(ID.getText()).getName() + "\n");
					rInfo = new RegisterInfo(name.getText(), ID.getText(), pass.getText());
					setVisible(false);
				}
				catch(NullPointerException e)
				{
					System.out.println("Can't create new client.\n");
					rInfo = new RegisterInfo();
					setVisible(false);
				}
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
			}
		});
		
		control.add(okButton);
		control.add(cancelButton);
		
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}
}

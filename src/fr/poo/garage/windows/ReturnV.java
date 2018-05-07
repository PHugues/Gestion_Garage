package fr.poo.garage.windows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.poo.garage.Car;
import fr.poo.garage.Garage;
import fr.poo.garage.Motorbike;
import fr.poo.garage.Truck;
import fr.poo.garage.Vehicle;

/**
 * Class representing a 
 * <p>
 * Dec 14, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */

public class ReturnV extends JFrame {

	private static final long serialVersionUID = -5278213457862198524L;
	
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	
	int indice = 0;
	
	static JLabel typeLabel, carLicenceLabel, rentedLabel, deadLineLabel, rentDateLabel, lengthLabel, brandLabel, nameLabel, yearLabel, powerLabel;
	
	public static JPanel createPannel(int i)
	{
		JPanel card = new JPanel();
		card.setBackground(Color.WHITE);
		if(Garage.getUser().getRentedVehicle().get(i) instanceof Truck)
		{
			typeLabel = new JLabel("Type : Truck ||");
			card.add(typeLabel);
			carLicenceLabel = new JLabel("Car Licence : " + Garage.getUser().getRentedVehicle().get(i).getCarLicense());
			card.add(carLicenceLabel);
			lengthLabel = new JLabel("Length : " + ((Truck) Garage.getUser().getRentedVehicle().get(i)).getLength() + " ||");
			card.add(lengthLabel);
		}
		
		else if(Garage.getUser().getRentedVehicle().get(i) instanceof Car)
		{
			typeLabel = new JLabel("Type : Car ||");
			card.add(typeLabel);
			carLicenceLabel = new JLabel("Car Licence : " + Garage.getUser().getRentedVehicle().get(i).getCarLicense());
			card.add(carLicenceLabel);
			brandLabel = new JLabel("Brand : " + ((Car) Garage.getUser().getRentedVehicle().get(i)).getBrand() + " ||");
			card.add(brandLabel);
			nameLabel = new JLabel("Name : " + ((Car) Garage.getUser().getRentedVehicle().get(i)).getName() + " ||");
			card.add(nameLabel);
			yearLabel = new JLabel("Year : " + ((Car) Garage.getUser().getRentedVehicle().get(i)).getYear());
			card.add(yearLabel);
		}
		
		else if(Garage.getUser().getRentedVehicle().get(i) instanceof Motorbike)
		{
			typeLabel = new JLabel("Type : Motorbike ||");
			card.add(typeLabel);
			carLicenceLabel = new JLabel("Car Licence : " + Garage.getUser().getRentedVehicle().get(i).getCarLicense());
			card.add(carLicenceLabel);
			brandLabel = new JLabel("Brand : " + ((Motorbike) Garage.getUser().getRentedVehicle().get(i)).getBrand() + " ||");
			card.add(brandLabel);
			powerLabel = new JLabel("Power : " + ((Motorbike) Garage.getUser().getRentedVehicle().get(i)).getPower() + " ||");
			card.add(powerLabel);
		}
		
		rentedLabel = new JLabel("Rented : " + Garage.getUser().getRentedVehicle().get(i).isRented());
		card.add(rentedLabel);
		rentDateLabel = new JLabel("Rent date : " + Garage.getUser().getRentedVehicle().get(i).getRentDate() + "\n");
		card.add(rentDateLabel);
		deadLineLabel = new JLabel("Return deadline : " + Garage.getUser().getRentedVehicle().get(i).getDeadLineRent() + "\n");
		card.add(deadLineLabel);
		return card;
	}
	
	public ReturnV()
	{
		if(Garage.getUser().getRentedVehicle().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "No rented vehicle", "Error", JOptionPane.ERROR_MESSAGE);
			this.setVisible(false);
		}
		else
		{
			this.setTitle("Rented Vehicles");
			this.setSize(330, 200);
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.setLocationRelativeTo(null);
			content.setLayout(cl);
			for(int i = 0 ; i < Garage.getUser().getRentedVehicle().size() ; i++)
			{
				content.add(createPannel(i));
			}
			
			
			JPanel boutonPane = new JPanel();
			JButton next = new JButton("Next");
			next.addActionListener(new ActionListener()
			{
	
				public void actionPerformed(ActionEvent arg0) 
				{
					if(++indice >= Garage.getUser().getRentedVehicle().size()-1)
					{
						indice = 0;
					}
					System.out.println("Vehicle number " + (indice+1));
					cl.next(content);
				}
			});
			
			JButton cancel = new JButton("Cancel");
			cancel.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					System.out.println("\n+-----------------------------+");
					System.out.println("|        End of return        |");
					System.out.println("+-----------------------------+\n");
					setVisible(false);
				}
			});
			
			JButton returnV = new JButton("Return");
			returnV.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int option = JOptionPane.showConfirmDialog(null, "Do you wish to return this vehicle ?", "Returning vehicle", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.OK_OPTION)
					{
						System.out.println("Returning...");
						Vehicle.returnVehicle(Garage.getUser(), Garage.getUser().getRentedVehicle().get(indice));
						setVisible(false);
					}
				}
			});
			
			boutonPane.add(next);
			boutonPane.add(returnV);
			boutonPane.add(cancel);
			
			this.getContentPane().add(boutonPane, BorderLayout.NORTH);
			this.getContentPane().add(content, BorderLayout.CENTER);
			this.setVisible(true);
		}
	}
}

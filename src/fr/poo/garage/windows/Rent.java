package fr.poo.garage.windows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import fr.poo.garage.exceptions.RentException;

/**
 * Class representing a 
 * <p>
 * Dec 14, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */

public final class Rent extends JFrame {

	private static final long serialVersionUID = -9015376339707638519L;

	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	
	protected List<String> listContent = new ArrayList<String>();
	
	int indice = 0;
	
	static JLabel typeLabel, carLicenceLabel, rentedLabel, deadLineLabel, rentDateLabel, lengthLabel, brandLabel, nameLabel, yearLabel, powerLabel;
	
	public static JPanel createPannel(int i)
	{
		JPanel card = new JPanel();
		card.setBackground(Color.WHITE);
		
		if(Vehicle.getListVehicle().get(i) instanceof Truck)
		{
			typeLabel = new JLabel("Type : Truck ||");
			card.add(typeLabel);
			carLicenceLabel = new JLabel("Car Licence : " + Vehicle.getListVehicle().get(i).getCarLicense());
			card.add(carLicenceLabel);
			lengthLabel = new JLabel("Length : " + ((Truck) Vehicle.getListVehicle().get(i)).getLength() + " ||");
			card.add(lengthLabel);
		}
		
		else if(Vehicle.getListVehicle().get(i) instanceof Car)
		{
			typeLabel = new JLabel("Type : Car ||");
			card.add(typeLabel);
			carLicenceLabel = new JLabel("Car Licence : " + Vehicle.getListVehicle().get(i).getCarLicense());
			card.add(carLicenceLabel);
			brandLabel = new JLabel("Brand : " + ((Car) Vehicle.getListVehicle().get(i)).getBrand() + " ||");
			card.add(brandLabel);
			nameLabel = new JLabel("Name : " + ((Car) Vehicle.getListVehicle().get(i)).getName() + " ||");
			card.add(nameLabel);
			yearLabel = new JLabel("Year : " + ((Car) Vehicle.getListVehicle().get(i)).getYear());
			card.add(yearLabel);
		}
		
		else if(Vehicle.getListVehicle().get(i) instanceof Motorbike)
		{
			typeLabel = new JLabel("Type : Motorbike ||");
			card.add(typeLabel);
			carLicenceLabel = new JLabel("Car Licence : " + Vehicle.getListVehicle().get(i).getCarLicense());
			card.add(carLicenceLabel);
			brandLabel = new JLabel("Brand : " + ((Motorbike) Vehicle.getListVehicle().get(i)).getBrand() + " ||");
			card.add(brandLabel);
			powerLabel = new JLabel("Power : " + ((Motorbike) Vehicle.getListVehicle().get(i)).getPower() + " ||");
			card.add(powerLabel);
		}
		
		rentedLabel = new JLabel("Rented : " + Vehicle.getListVehicle().get(i).isRented());
		card.add(rentedLabel);
		
		if(Vehicle.getListVehicle().get(i).isRented())
		{
			rentDateLabel = new JLabel("Rent date : " + Vehicle.getListVehicle().get(i).getRentDate());
			deadLineLabel = new JLabel("Return deadline : " + Vehicle.getListVehicle().get(i).getDeadLineRent());
			card.add(rentDateLabel);
			card.add(deadLineLabel);
		}
		return card;
	}
	
	public Rent()
	{
		this.setTitle("Vehicles");
		this.setSize(330, 200);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel card1 = new JPanel();
		card1 = createPannel(0);
		this.listContent.add("CARD_1");
		
		JPanel card2 = new JPanel();
		card2 = createPannel(1);
		this.listContent.add("CARD_2");
		
		JPanel card3 = new JPanel();
		card3 = createPannel(2);
		this.listContent.add("CARD_3");
		
		
		JPanel boutonPane = new JPanel();
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) 
			{
				if(++indice > 2)
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
				System.out.println("\n+-------------------------+");
				System.out.println("|       End of rent       |");
				System.out.println("+-------------------------+\n");
				setVisible(false);
			}
		});
		
		JButton rent = new JButton("Rent");
		rent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int option = JOptionPane.showConfirmDialog(null, "Do you wish to rent this vehicle ?", "Renting vehicle", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.OK_OPTION)
				{
					System.out.println("Renting...");
					try 
					{
						Vehicle.getListVehicle().get(indice).rent(Garage.getUser());
						setVisible(false);
					} 
					catch (RentException e1) 
					{
						System.out.println(e1.toString());
						JOptionPane.showMessageDialog(null, "Vehicle already rented.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		boutonPane.add(next);
		boutonPane.add(rent);
		boutonPane.add(cancel);
		
		content.setLayout(cl);
		content.add(card1);
		content.add(card2);
		content.add(card3);
		
		this.getContentPane().add(boutonPane, BorderLayout.NORTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.setVisible(true);
		System.out.println("Vehicle number " + (indice+1));
	}
}

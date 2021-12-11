

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

public class JCarlysCatering extends JFrame implements ItemListener, ActionListener
{

	
	
	JLabel topBanner = new JLabel("Carly's Catering");
	JLabel askGuestNum = new JLabel("Please enter number of guests: ");
	JTextField guestNum = new JTextField(10);
	JLabel selectEntree = new JLabel("Choose an Entree");
	JLabel selectSide = new JLabel("Choose 2 Side Dishes");
	JLabel selectDessert = new JLabel("Choose a Dessert");
	JLabel orderSummaryLabel = new JLabel("Order Summary");
	JLabel orderSummary = new JLabel("");
	
	/*
	 * Create check box for Entree
	 */
	JCheckBox primeRib = new JCheckBox("Entree-Prime Rib");
	JCheckBox grilledSalmon = new JCheckBox("Entree-Grilled Salmon");
	JCheckBox roastedChicken = new JCheckBox("Entree-Roasted Chicken");
	JCheckBox greenGoddess = new JCheckBox("Entree-Green Goddess Buddha Bowl");
			
	/*
	 * Create check box for side dish
	 */
	JCheckBox chefSalad = new JCheckBox("Side-Chef Salad");
	JCheckBox creamedSpinach = new JCheckBox("Side-Creamed Spinach");
	JCheckBox cheesyBroccolli = new JCheckBox("Side-Cheesy Brocolli");
	JCheckBox asianCucumber = new JCheckBox("Side-Asian Cucumber");
	JCheckBox bakedPotato = new JCheckBox("Side-Baked Potato");
	JCheckBox mashedPotato = new JCheckBox("Side-Mashed Potato");
	
	/*
	 * Create check box for dessert
	 */
	JCheckBox strawberryCake = new JCheckBox("Dessert-Strawberry Short Cake");
	JCheckBox iceCream = new JCheckBox("Dessert-Ice Cream");
	JCheckBox coconutPie = new JCheckBox("Dessert-Coconut Cream Pie");
	JCheckBox ricePudding = new JCheckBox("Dessert-Rice Pudding");
	JCheckBox applePie = new JCheckBox("Dessert-Apple Pie");
	JCheckBox cremeBrulee = new JCheckBox("Dessert-Creme Brulee");
	/*
	 * Create Button Group
	 */
	ButtonGroup entreeGroup= new ButtonGroup();
	ButtonGroup dessertGroup= new ButtonGroup();
	
	final int PRICE_PER_GUEST=35;
	private int totalPrice=0;
	private int sideDishCounter=0;
	private String entree="";
	private String dessert="";
	private String sideDish="";
	
	
	public JCarlysCatering()
	{
		super("Carly's Catering");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		

		/*
		 * Change Styles, Font size
		 */
		topBanner.setFont(new Font("TimesRoman",Font.BOLD|Font.ITALIC,30));
		gbc.gridx=0;
		gbc.gridy=0;
		add(topBanner,gbc);
		
		
		
		gbc.gridx=0;
		gbc.gridy=1;
		add(askGuestNum,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		add(guestNum,gbc);
		
		selectEntree.setFont(new Font("TimesRoman",Font.ITALIC,20));
		gbc.gridx=0;
		gbc.gridy=2;
		add(selectEntree,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		add(primeRib,gbc);
		primeRib.setFocusable(false);
		
		gbc.gridx=1;
		gbc.gridy=3;
		add(grilledSalmon,gbc);
		grilledSalmon.setFocusable(false);
		
		gbc.gridx=0;
		gbc.gridy=4;
		add(roastedChicken,gbc);
		roastedChicken.setFocusable(false);
		
		gbc.gridx=1;
		gbc.gridy=4;
		add(greenGoddess,gbc);
		greenGoddess.setFocusable(false);
		
		/*
		 * Added to group so user can only choose 1
		 */
		entreeGroup.add(primeRib);
		entreeGroup.add(grilledSalmon);
		entreeGroup.add(roastedChicken);
		entreeGroup.add(greenGoddess);

		
		selectSide.setFont(new Font("TimesRoman",Font.ITALIC,20));
		gbc.gridx=0;
		gbc.gridy=5;
		add(selectSide,gbc);
		
		gbc.gridx=0;
		gbc.gridy=6;
		add(chefSalad,gbc);
		chefSalad.setFocusable(false);

		gbc.gridx=1;
		gbc.gridy=6;
		add(creamedSpinach,gbc);
		creamedSpinach.setFocusable(false);
		
		gbc.gridx=2;
		gbc.gridy=6;
		add(cheesyBroccolli,gbc);
		cheesyBroccolli.setFocusable(false);
		
		gbc.gridx=0;
		gbc.gridy=7;
		add(asianCucumber,gbc);
		asianCucumber.setFocusable(false);

		gbc.gridx=1;
		gbc.gridy=7;
		add(bakedPotato,gbc);
		bakedPotato.setFocusable(false);
		
		gbc.gridx=2;
		gbc.gridy=7;
		add(mashedPotato,gbc);
		mashedPotato.setFocusable(false);
		
		
		selectDessert.setFont(new Font("TimesRoman",Font.ITALIC,20));
		gbc.gridx=0;
		gbc.gridy=8;
		add(selectDessert,gbc);
		
		gbc.gridx=0;
		gbc.gridy=9;
		add(coconutPie,gbc);
		coconutPie.setFocusable(false);
		
		gbc.gridx=1;
		gbc.gridy=9;
		add(ricePudding,gbc);
		ricePudding.setFocusable(false);
		
		gbc.gridx=0;
		gbc.gridy=10;
		add(applePie,gbc);
		applePie.setFocusable(false);
		
		gbc.gridx=1;
		gbc.gridy=10;
		add(cremeBrulee,gbc);
		cremeBrulee.setFocusable(false);
		
		gbc.gridx=2;
		gbc.gridy=10;
		add(iceCream,gbc);
		iceCream.setFocusable(false);
		
		gbc.gridx=2;
		gbc.gridy=9;
		add(strawberryCake,gbc);
		strawberryCake.setFocusable(false);
		
		/*
		 * Added to group so user can only choose 1
		 */
		dessertGroup.add(coconutPie);
		dessertGroup.add(ricePudding);
		dessertGroup.add(applePie);
		dessertGroup.add(cremeBrulee);
		dessertGroup.add(iceCream);
		dessertGroup.add(strawberryCake);
		
		orderSummaryLabel.setFont(new Font("TimesRoman",Font.BOLD,20));
		
		gbc.gridx=1;
		gbc.gridy=11;
		add(orderSummaryLabel,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=12;
		gbc.gridwidth=4;
		add(orderSummary,gbc);
		
		guestNum.addActionListener(this);
		primeRib.addItemListener(this);
		roastedChicken.addItemListener(this);
		grilledSalmon.addItemListener(this);
		greenGoddess.addItemListener(this);
		
		chefSalad.addItemListener(this);
		asianCucumber.addItemListener(this);
		creamedSpinach.addItemListener(this);
		bakedPotato.addItemListener(this);
		cheesyBroccolli.addItemListener(this);
		mashedPotato.addItemListener(this);
		
		coconutPie.addItemListener(this);
		applePie.addItemListener(this);
		ricePudding.addItemListener(this);
		cremeBrulee.addItemListener(this);
		strawberryCake.addItemListener(this);
		iceCream.addItemListener(this);
		
		

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==guestNum)
		{
			try
			{
				totalPrice=Integer.parseInt(guestNum.getText())*PRICE_PER_GUEST;
			}
			catch(Exception ex)
			{
				totalPrice=0;
				guestNum.setText("0");
			}
		}
		orderSummary.setText("Total $"+totalPrice+"-"+entree+sideDish+"--"+dessert+"-");
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		// TODO Auto-generated method stub
		int check = e.getStateChange();
		
		if(check==ItemEvent.SELECTED)
		{
			if(e.getSource()==primeRib)
			{
				entree="Prime Rib";
			}
			else if(e.getSource()==grilledSalmon)
			{
				entree="Grilled Salmon";
			}
			else if(e.getSource()==roastedChicken)
			{
				entree="Roasted Chicken";
			}
			else if(e.getSource()==greenGoddess)
			{
				entree="Green Goddess Buddha Bowl";
			}
		}
		
		
		if(e.getSource()==chefSalad||e.getSource()==asianCucumber||e.getSource()==creamedSpinach||
				e.getSource()==bakedPotato||e.getSource()==cheesyBroccolli||e.getSource()==mashedPotato)
		{
			if(check==ItemEvent.SELECTED)
			{
				sideDishCounter++;
			}
			else
			{
				sideDishCounter--;
				sideDish="";
			}
			
			if(sideDishCounter<=2)
			{
				if(chefSalad.isSelected())
				{
					sideDish+="--Chef Salad";
				}
				if(asianCucumber.isSelected())
				{
					sideDish+="--Asian Cucumber";
				}
				if(creamedSpinach.isSelected())
				{
					sideDish+="--Creamed Spinach";
				}
				if(bakedPotato.isSelected())
				{
					sideDish+="--Baked Potato";
				}
				if(cheesyBroccolli.isSelected())
				{
					sideDish+="--Cheesy Broccolli";
				}
				if(mashedPotato.isSelected())
				{
					sideDish+="--Mashed Potato";
				}
			}
			else
			{
				chefSalad.setSelected(false);
				asianCucumber.setSelected(false);
				creamedSpinach.setSelected(false);
				bakedPotato.setSelected(false);
				mashedPotato.setSelected(false);
				cheesyBroccolli.setSelected(false);
			}
		}
		if(check==ItemEvent.SELECTED)
		{
			if(e.getSource()==coconutPie)
			{
				dessert="Coconut Cream Pie";
			}
			else if(e.getSource()==applePie)
			{
				dessert="Apple Pie";
			}
			else if(e.getSource()==ricePudding)
			{
				dessert="Rice Pudding";
			}
			else if(e.getSource()==cremeBrulee)
			{
				dessert="Creme Brulee";
			}
			else if(e.getSource()==strawberryCake)
			{
				dessert="Strawberry Short Cake";
			}
			else if(e.getSource()==iceCream)
			{
				dessert="Ice Cream";
			}
		}
		try
		{
			
			totalPrice=Integer.parseInt(guestNum.getText())*PRICE_PER_GUEST;
		}
		catch(Exception ex)
		{
			totalPrice=0;
			guestNum.setText("0");
		}
		orderSummary.setText("Total $"+totalPrice+"-"+entree+sideDish+"--"+dessert+"-");
	}
	

	public static void main(String[] args) {
		
		JCarlysCatering frame = new JCarlysCatering();
	     frame.setSize(700, 550);
	     frame.setVisible(true);
		

	}

}

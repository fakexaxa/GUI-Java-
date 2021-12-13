import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class JSAmmysSeashore extends JFrame implements ItemListener, ActionListener {

    /**
	 * 
	 */
	
	JLabel topBanner = new JLabel("Sammy's Seashore Rentals");
    JLabel askRentalHours = new JLabel("Please enter hours for rental:  ");
    JTextField rentalHours = new JTextField(10);
    JLabel selectEquipment = new JLabel("Select Rental Equipment");
    JLabel askLesson = new JLabel("Lessons?");
    JLabel orderSummaryLabel = new JLabel("Order Summary");
    JLabel orderSummary = new JLabel("");

    /*
     * Create checkboxes
     */
    JCheckBox watercraft = new JCheckBox("Personal Watercraft");
    JCheckBox pontoonBoat = new JCheckBox("Pontoon Boat");
    JCheckBox rowBoat = new JCheckBox("Raw Boat");
    JCheckBox canoe = new JCheckBox("Canoe");
    JCheckBox kayak = new JCheckBox("Kayak");
    JCheckBox beachChair = new JCheckBox("Beach Chair");
    JCheckBox umbrella = new JCheckBox("Umbrella");
    JCheckBox lesson = new JCheckBox("Lesson");
    JCheckBox noLesson = new JCheckBox("No lesson");
    JButton exitButton = new JButton("Exit");

    /*
     * Create Button Group
     */
    ButtonGroup equipGroup = new ButtonGroup();
    ButtonGroup lessonGroup = new ButtonGroup();

    private double totalPrice=0;
    private int equipmentPrice=0;
    private int lessonPrice=0;
    private String equipmentDetails="";
    private String lessonDetails="";
    private String rentalHoursString="";



    public JSAmmysSeashore()
    {
        super("Sammy's Seashore Rentals");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;

        topBanner.setFont(new Font("TimesRoman",Font.BOLD|Font.ITALIC,30));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        add(topBanner,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        add(askRentalHours,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        add(rentalHours,gbc);

        selectEquipment.setFont(new Font("TimesRoman",Font.ITALIC,20));
        gbc.gridx=0;
        gbc.gridy=2;
        add(selectEquipment,gbc);

        gbc.gridx=0;
        gbc.gridy=3;
        add(pontoonBoat,gbc);

        gbc.gridx=0;
        gbc.gridy=4;
        add(rowBoat,gbc);

        gbc.gridx=0;
        gbc.gridy=5;
        add(canoe,gbc);

        gbc.gridx=0;
        gbc.gridy=6;
        add(kayak,gbc);

        gbc.gridx=1;
        gbc.gridy=3;
        add(beachChair,gbc);

        gbc.gridx=1;
        gbc.gridy=4;
        add(watercraft,gbc);

        gbc.gridx=1;
        gbc.gridy=5;
        add(umbrella,gbc);

        /*
         * Add equipments to button group
         */
        equipGroup.add(pontoonBoat);
        equipGroup.add(watercraft);
        equipGroup.add(rowBoat);
        equipGroup.add(canoe);
        equipGroup.add(kayak);
        equipGroup.add(beachChair);
        equipGroup.add(umbrella);


        askLesson.setFont(new Font("TimesRoman",Font.ITALIC,20));
        gbc.gridx=0;
        gbc.gridy=7;
        add(askLesson,gbc);

        gbc.gridx=0;
        gbc.gridy=8;
        add(lesson,gbc);

        gbc.gridx=1;
        gbc.gridy=8;
        add(noLesson,gbc);

        /*
         *add lessons to button group
         */
        lessonGroup.add(lesson);
        lessonGroup.add(noLesson);

        orderSummaryLabel.setFont(new Font("TimesRoman",Font.BOLD,20));
        gbc.gridx=0;
        gbc.gridy=9;
        add(orderSummaryLabel,gbc);

        gbc.gridx=0;
        gbc.gridy=10;
        gbc.gridwidth=4;
        add(orderSummary,gbc);
        
        gbc.gridx=0;
        gbc.gridy=12;
        gbc.weighty=1;
        gbc.gridwidth=4;
        exitButton.setFocusable(false);
        add(exitButton,gbc);

        rentalHours.addActionListener(this);
        exitButton.addActionListener(this);
        watercraft.addItemListener(this);
        pontoonBoat.addItemListener(this);
        rowBoat.addItemListener(this);
        canoe.addItemListener(this);
        kayak.addItemListener(this);
        beachChair.addItemListener(this);
        umbrella.addItemListener(this);
        lesson.addItemListener(this);
        noLesson.addItemListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    	if(e.getSource()==exitButton)
    	{
    		System.exit(0);
    	}
    	
        if(e.getSource()==rentalHours)
        {
            try
            {
                totalPrice=(Integer.parseInt(rentalHours.getText())*equipmentPrice)+lessonPrice;
                rentalHoursString=" for "+ rentalHours.getText()+" hours--";
            }
            catch(Exception ex)
            {
                totalPrice=0;
                rentalHours.setText("0");
                rentalHoursString=" for "+ rentalHours.getText()+" hours--";
            }
        }
        orderSummary.setText("Total $"+totalPrice+equipmentDetails+rentalHoursString+lessonDetails);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        int check= e.getStateChange();

        if(check==ItemEvent.SELECTED)
        {
            if(e.getSource()==lesson)
            {
                lessonPrice=5;
                lessonDetails="lesson @ $"+lessonPrice;
            }
            if(e.getSource()==noLesson)
            {
                lessonPrice=0;
                lessonDetails="No lesson Selected";
            }
        }

        if(check==ItemEvent.SELECTED)
        {
            if(e.getSource()==watercraft)
            {
                equipmentPrice=40;
                equipmentDetails="--Personal Watercraft @ $"+equipmentPrice ;
            }
            if(e.getSource()==pontoonBoat)
            {
                equipmentPrice=40;
                equipmentDetails="--Pontoon Boat @ $"+equipmentPrice ;
            }
            if(e.getSource()==rowBoat)
            {
                equipmentPrice=20;
                equipmentDetails="--Row Boat @ $"+equipmentPrice ;
            }
            if(e.getSource()==canoe)
            {
                equipmentPrice=20;
                equipmentDetails="--Canoe @ $"+equipmentPrice ;
            }
            if(e.getSource()==kayak)
            {
                equipmentPrice=20;
                equipmentDetails="--Kayak @ $"+equipmentPrice ;
            }
            if(e.getSource()==beachChair)
            {
                equipmentPrice=7;
                equipmentDetails="--Pontoon Boat @ $"+equipmentPrice ;
            }
            if(e.getSource()==umbrella)
            {
                equipmentPrice=7;
                equipmentDetails="--Beach Chair @ $"+equipmentPrice ;
            }

        }

        try
        {
            totalPrice=(Integer.parseInt(rentalHours.getText())*equipmentPrice)+lessonPrice;
            rentalHoursString=" for "+ rentalHours.getText()+" hours--";
        }
        catch(Exception ex)
        {
            totalPrice=0;
            rentalHours.setText("0");
            rentalHoursString=" for "+ rentalHours.getText()+" hours--";
        }
        orderSummary.setText("Total $"+totalPrice+equipmentDetails+rentalHoursString+lessonDetails);
    }

    public static void main(String[] args) {

        JSAmmysSeashore frame = new JSAmmysSeashore();
        frame.setSize(600, 450);
        frame.setVisible(true);


    }
}
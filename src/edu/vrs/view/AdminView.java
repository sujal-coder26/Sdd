package edu.vrs.view; // name of the package

import edu.vrs.controller.AdminController;// importing class from package
import edu.vrs.model.Loan;// importing class from package
import edu.vrs.model.Vehicle;// importing class from package
import edu.vrs.model.Customer;// importing class from package
import edu.vrs.service.FleetHandler;// importing class from package
import javax.swing.*; //importing all
import javax.swing.border.Border;//importing classes
import javax.swing.border.MatteBorder;// importing classes
import javax.swing.border.TitledBorder;//importing classes
import javax.swing.table.DefaultTableModel;// importing classes
import java.awt.*;// importing all from the given package
import java.awt.event.*;// importing all from the given package

public class AdminView extends JFrame {
    JButton vehicleRegistrationButton = new JButton("Vehicle");// making a jbutton
    JButton vehicleLoanButton = new JButton("Loan");// making a jbutton
    Border border1 = BorderFactory.createLineBorder(Color.gray);
    JLabel adminPic = new JLabel(new ImageIcon("pics/admin.png"));
    JPanel panelLeft = new JPanel();// making a panel
    JPanel panelRight = new JPanel();// making a panel
    JPanel panelDown = new JPanel();// creating a panel
    JButton customersInformationButton = new JButton("Customers");// making a jbutton
    JButton logoutButton = new JButton("Exit");// making a jbutton
    JButton addCustomer = new JButton("Add");// making a jbutton
    JButton deleteCustomer = new JButton("Delete");// making a jbutton
    JButton actualLoanButton = new JButton("Loan");// making a jbutton
    JButton actualUnLoanButton = new JButton("UnLoan");// making a jbutton
    JButton addVehicle = new JButton("Add");// making a jbutton
    JButton deleteVehicle = new JButton("Delete");// making a jbutton
    JLabel admin = new JLabel("-Admin");// making a jlabel
    int selectedCellValueVehicle = 0; // setting variable's value to 0
     int selectedCellValueCustomer = 0;// setting variable's value to 0
    AdminController adminController;
    static DefaultTableModel defaultTableModel; // creating a table model
    JTable table = new JTable(defaultTableModel);// creating a table
    static DefaultTableModel defaultTableModelVehicles;// creating a table model
    JTable tableVehicle = new JTable(defaultTableModelVehicles);// creating a table
    static DefaultTableModel defaultTableModelCusLoan;// creating a table model
    JTable tableCusLoan = new JTable(defaultTableModelCusLoan);// creating a table
    static DefaultTableModel defaultTableModelVehiclesLoan;// creating a table model
    JTable tableVehicleLoan = new JTable(defaultTableModelCusLoan);// creating a table
    static DefaultTableModel defaultTableModelCusUnLoan;// creating a table model
    JTable tableCusUnLoan = new JTable(defaultTableModelCusUnLoan);// creating a table
    static DefaultTableModel defaultTableModelVehiclesUnLoan;// creating a table model
    JTable tableVehicleUnLoan = new JTable(defaultTableModelCusUnLoan);// creating a table

    public void jFrame() {
        AdminView jFrame = new AdminView(); // creating frame
        jFrame.setSize(1200, 800);// setting size
        jFrame.setLocationRelativeTo(null);// will keep frame to middle
        jFrame.setResizable(false);// size cant be changed
        jFrame.setTitle("Admin Panel");//setting title
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// will close the overall system on clicking on close
        jFrame.setVisible(true);// setting visible true
        jFrame.showWindow();// calling a function
    }

    public void showWindow() { // creating method for the components
        adminController = new AdminController();// creating object of class admin controller
        Container window2 = getContentPane();// creating a container
        window2.setLayout(null);// setting layout to null
        panelLeft.setBounds(0, 0, 200, 800);// setting bound of the component
        panelLeft.setBorder(border1); // setting the border
        window2.add(panelLeft);//adding to the window

        panelRight.setBounds(200, 0, 1000, 150);// setting bound of the component
        panelRight.setBorder(border1);// setting the border
        window2.add(panelRight);// adding to the window

        panelLeft.setLayout(null);// setting layout
        Font f = new Font("serif", Font.PLAIN, 20);// setting font
        panelDown.setBounds(200, 150, 1000, 800);// setting bound of the component
        panelDown.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Customers", TitledBorder.CENTER, TitledBorder.TOP)); // setting border
        panelDown.setLayout(null); // setting layout
        window2.add(panelDown);// adding to the window

        tableCusUnLoan.setVisible(false); // setting visible false
        tableVehicleUnLoan.setVisible(false);// setting visible false
        tableVehicleUnLoan.getTableHeader().setVisible(false);// setting visible false
        tableCusUnLoan.getTableHeader().setVisible(false);// setting visible false

        panelRight.setLayout(null); // setting layout null
        vehicleRegistrationButton.setBounds(10, 200, 150, 50);// setting bound of the component
        panelLeft.add(vehicleRegistrationButton); //adding to the panel
        vehicleRegistrationButton.addActionListener(e -> {
            actualUnLoanButton.setVisible(false);// setting component's visible false
            tableCusUnLoan.setVisible(false);// setting component's visible false
            tableVehicleUnLoan.setVisible(false);// setting component's visible false
            tableVehicleUnLoan.getTableHeader().setVisible(false);// setting component's visible false
            tableCusUnLoan.getTableHeader().setVisible(false);// setting component's visible false
            tableVehicle.setVisible(false);// setting component's visible false
            tableVehicle.getTableHeader().setVisible(false);// setting component's visible false
            table.setVisible(false);// setting component's visible false
            tableVehicleLoan.setVisible(false);// setting component's visible false
            tableVehicleLoan.getTableHeader().setVisible(false);// setting component's visible false

            tableCusLoan.getTableHeader().setVisible(false);// setting component's visible false
            tableCusLoan.setVisible(false);// setting component's visible false
            panelRight.setBounds(200, 0, 1000, 150);// setting bound of the component
            panelDown.setBounds(200, 150, 1000, 800);// setting bound of the component
            panelDown.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Fleet", TitledBorder.CENTER, TitledBorder.TOP));
            componentsTrue();// calling a function
            actualLoanButton.setVisible(false);// setting component's visible false
            addCustomer.setVisible(false);// setting component's visible false
            deleteCustomer.setVisible(false);// setting component's visible false
            addVehicle.setVisible(true);// setting component's visible true
            deleteVehicle.setVisible(true);// setting component's visible true
            table.setEnabled(false);// setting component's visible false
            viewTableVehicle(); // calling a function

        });
        tableVehicle.setVisible(false);// setting component's visible false
        tableVehicle.getTableHeader().setVisible(false);// setting component's visible false
        vehicleRegistrationButton.setBackground(Color.orange); //  setting color
        vehicleRegistrationButton.setFont(f);// setting font

        adminPic.setBounds(10, 30, 150, 150);// setting bound of the component
        panelLeft.add(adminPic); //adding to the panel
        adminPic.setIcon(new ImageIcon(new ImageIcon("pics/admin.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT))); // adding image
        adminPic.setVisible(true);// setting component's visible true

        admin.setBounds(130,170,50,30);// setting bound of the component
        panelLeft.add(admin); // adding to the panel
        logoutButton.setBounds(10, 470, 150, 50);// setting bound of the component
        panelLeft.add(logoutButton); // adding to the panel
        logoutButton.addActionListener(e -> System.exit(0)); // exiting the system
        logoutButton.setBackground(Color.orange); // setting the color
        logoutButton.setFont(f); // setting the font

        actualLoanButton.setBounds(470, 70, 80, 40);// setting bound of the component
        actualLoanButton.setFont(f); // setting the font
        panelDown.add(actualLoanButton);// adding to the panel
        actualLoanButton.setVisible(false);// setting component's visible false

        actualUnLoanButton.setBounds(580, 450, 140, 40);// setting bound of the component
        actualUnLoanButton.setFont(f);// setting the font
        panelDown.add(actualUnLoanButton); // adding to the panel
        actualUnLoanButton.setVisible(false);// setting component's visible false
        actualUnLoanButton.addActionListener(e ->{
            unLoan();// calling the function
            JOptionPane.showMessageDialog(null, "Vehicle Has been UnLoaned. Refresh to see change "); // showing message dialog box

        } );

        addCustomer.setBounds(530, 80, 150, 50);// setting bound of the component
        panelRight.add(addCustomer); // adding to the panel
        addCustomer.setFont(f);// setting the font
        addCustomer.addActionListener(e ->{
            addCustomer();});// calling the function

        deleteCustomer.setBounds(700, 80, 150, 50);// setting bound of the component
        deleteCustomer.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(panelRight,"Sure? You want to Delete?", "Customer Delete",
                    JOptionPane.YES_NO_OPTION, // confirmation dialogue box
                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){ // checking if the result is yes
                deleteCustomer(); // then calling the function
            }else if (result == JOptionPane.NO_OPTION){

            }
        });
        panelRight.add(deleteCustomer);// adding to the panel
        deleteCustomer.setFont(f);// setting the font

        addVehicle.setBounds(530, 80, 150, 50);// setting bound of the component
        panelRight.add(addVehicle); // adding to the panel
        addVehicle.setFont(f);// setting the font

        tableVehicleLoan.setVisible(false); // setting component's visible false
        tableVehicleLoan.getTableHeader().setVisible(false); // setting component's visible false

        tableCusLoan.getTableHeader().setVisible(false); // setting component's visible false
        tableCusLoan.setVisible(false);// setting component's visible false

        deleteVehicle.setBounds(700, 80, 150, 50);// setting bound of the component
        deleteVehicle.addActionListener(e ->{
            int result = JOptionPane.showConfirmDialog(panelRight,"Sure? You want to Delete?", "Vehicle Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE); // confirmation dialogue
            if(result == JOptionPane.YES_OPTION){ // if the result is yes
                deleteVehicle();// then call the function
            }else if (result == JOptionPane.NO_OPTION){

            }
        });
        panelRight.add(deleteVehicle); // adding to the panel
        deleteVehicle.setFont(f);// setting the font

        customersInformationButton.setBounds(10, 270, 150, 50);// setting bound of the component
        vehicleLoanButton.setBackground(Color.orange); // setting the color
        panelLeft.add(customersInformationButton);// adding to the panel
        tableVehicle.getTableHeader().setVisible(false);// setting component's visible false
        tableVehicle.setVisible(false);// setting component's visible false
        customersInformationButton.addActionListener(e -> {
            actualUnLoanButton.setVisible(false);// setting component's visible false
            tableCusUnLoan.setVisible(false);// setting component's visible false
            tableVehicleUnLoan.setVisible(false);// setting component's visible false
            tableVehicleUnLoan.getTableHeader().setVisible(false);// setting component's visible false
            tableCusUnLoan.getTableHeader().setVisible(false);// setting component's visible false
            table.setVisible(false);// setting component's visible false
            table.getTableHeader().setVisible(false);// setting component's visible false
            tableVehicle.setVisible(false);// setting component's visible false
            tableVehicleLoan.setVisible(false);// setting component's visible false
            tableVehicleLoan.getTableHeader().setVisible(false);// setting component's visible false
            deleteVehicle.setVisible(false);// setting component's visible false
            addVehicle.setVisible(false);// setting component's visible false
            tableCusLoan.getTableHeader().setVisible(false);// setting component's visible false
            tableCusLoan.setVisible(false);// setting component's visible false
            panelRight.setBounds(200, 0, 1000, 150);// setting bound of the component
            panelDown.setBounds(200, 150, 1000, 800);// setting bound of the component
            panelDown.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Customers", TitledBorder.CENTER, TitledBorder.TOP)); // setting the botder
            componentsTrue(); componentsCustomer(); // calling function
            viewTable(); // calling function
        });
        addVehicle.addActionListener(e ->{
            addVehicle(); // calling the function
        });

        vehicleLoanButton.setBackground(Color.orange); // setting the background color
        vehicleLoanButton.setFont(f); // setting the font
        vehicleLoanButton.setBounds(10, 340, 150, 50);// setting bound of the component
        panelLeft.add(vehicleLoanButton);// adding to the panel
        vehicleLoanButton.addActionListener(e -> {
            table.getTableHeader().setVisible(true); // setting component's visible true
            loan(); // calling the function
            JOptionPane.showMessageDialog(null, "Vehicle Has been Loaned. Refresh to see change "); // showing message dialog box
        });
        customersInformationButton.setFont(f); // setting the font
    }
    public void loan() {
        componentsFalse(); //calling the function
        actualUnLoanButton.setVisible(true);// setting component's visible false
        actualLoanButton.setVisible(true);// setting component's visible false
        table.setVisible(false);// setting component's visible false
        table.getTableHeader().setVisible(false);// setting component's visible false
        tableVehicle.setVisible(false);// setting component's visible false
        tableVehicle.getTableHeader().setVisible(false);// setting component's visible false
        String[] column = {"Id","Name Corporation", "Address", "Email"}; // this will be the column of the table
        defaultTableModelCusLoan = new DefaultTableModel(column, 0); // creating instance
        tableCusLoan = new JTable(defaultTableModelCusLoan) {
            public boolean isCellEditable(int r, int c) {
                return false;
            } // making cell uneditable
        };
        for (Customer customer : FleetHandler.getCustomers()) { // using for loop to get values
            defaultTableModelCusLoan.addRow(new Object[]{customer.getCustomerId(), customer.getNameOfCorporation(), customer.getAddress(), customer.getEmailAddress()});
       // adding the data as a row
        }
        tableCusLoan.getTableHeader().setBounds(10, 40, 400, 30);// setting bound of the component
        panelDown.add(tableCusLoan.getTableHeader()); // adding the component
        Color color = UIManager.getColor("Table.gridColor"); // giving color effect
        MatteBorder border = new MatteBorder(2, 2, 2, 2, color); // giving border
        tableCusLoan.getTableHeader().setBorder(border); // setting border
        tableCusLoan.setBounds(10, 70, 400, ((tableCusLoan.getRowCount()) * 17));// setting bound of the component
        panelDown.add(tableCusLoan); // adding to the panel

        String[] columnVehicle = {"Id", "Make", "Model", "Registration No"};// this will be the column of the table
        defaultTableModelVehiclesLoan = new DefaultTableModel(columnVehicle, 0);// creating instance
        tableVehicleLoan = new JTable(defaultTableModelVehiclesLoan) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }// making cell uneditable
        };

        for (Vehicle vehicle : FleetHandler.getVehicles()) {// using for loop to fet values
            if(FleetHandler.getLoans().size() > 0) { // checking the size
                boolean isVehicleLoaned = false; // creating a boolean
                for(Loan loan : FleetHandler.getLoans()) { // using for loop to get values
                    if(vehicle.getId() == loan.getVehicle().getId()) { // checking condition
                        isVehicleLoaned = true; // setting value of the boolean
                    }
            }
                if(!isVehicleLoaned) { // if true then
                    defaultTableModelVehiclesLoan.addRow(new Object[]{vehicle.getId(), vehicle.getMake(), vehicle.getModel(), vehicle.getRegistrationNumber()});
                    //adding the data as the row
                }
            } else {
                defaultTableModelVehiclesLoan.addRow(new Object[]{vehicle.getId(), vehicle.getMake(), vehicle.getModel(), vehicle.getRegistrationNumber()});
                // if not then also adding
            }

        }
        tableVehicleLoan.getTableHeader().setBounds(600, 40, 350, 30);// setting bound of the component
        panelDown.add(tableVehicleLoan.getTableHeader()); // adding component to the panel
        Color colorVehicleTable = UIManager.getColor("Table.gridColor"); // getting color
        MatteBorder borderVehicle = new MatteBorder(2, 2, 2, 2, colorVehicleTable); // making a border
        tableVehicleLoan.getTableHeader().setBorder(borderVehicle); // setting the border
        tableVehicleLoan.setBounds(600, 70, 350, ((tableVehicleLoan.getRowCount()) * 17));// setting bound of the component
        panelDown.add(tableVehicleLoan); //adding to the panel

        String[] columnVehicleUnloan = {"Id", "Make", "Model", "Registration No", "Name Corporation", "Email"}; // this will be the column of the table
        defaultTableModelVehiclesUnLoan = new DefaultTableModel(columnVehicleUnloan, 0); // creating the instance
        tableVehicleUnLoan = new JTable(defaultTableModelVehiclesUnLoan) {
            public boolean isCellEditable(int r, int c) {
                return false;
            } // making cell uneditable
        };
        for (Loan loan : FleetHandler.getLoans()) { // getting value from the for loop
            defaultTableModelVehiclesUnLoan.addRow(new Object[]{loan.getLoanId(), loan.getVehicle().getMake(), loan.getVehicle().getModel(), loan.getVehicle().getRegistrationNumber(), loan.getUser().getNameOfCorporation(), loan.getUser().getEmailAddress()});
            // adding data to the row of the table
        }
        tableVehicleUnLoan.getTableHeader().setBounds(20, 400, 500, 30);// setting bound of the component
        panelDown.add(tableVehicleUnLoan.getTableHeader()); // adding component to the table
        Color colorVehicleTableUnloan = UIManager.getColor("Table.gridColor"); // getting the color
        MatteBorder borderVehicleUnloan = new MatteBorder(2, 2, 2, 2, colorVehicleTableUnloan); // creating the border
        tableVehicleUnLoan.getTableHeader().setBorder(borderVehicleUnloan); // setting the border
        tableVehicleUnLoan.setBounds(20, 430, 500, ((tableVehicleUnLoan.getRowCount()) * 17));// setting bound of the component
        panelDown.add(tableVehicleUnLoan); // adding component to the panel

        Loan loan = new Loan(0,null,null); // creating loan instance
        tableCusLoan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                selectedCellValueCustomer = (int) tableCusLoan.getModel().getValueAt(tableCusLoan.getSelectedRow() , 0); // getting value at the clicked row
                System.out.println(selectedCellValueCustomer); // printing the detail
                for (Customer customer: FleetHandler.getCustomers()) // using for loop to get the data
                      if (customer.getCustomerId() == selectedCellValueCustomer){ // checking the condition
                          loan.setCustomer(customer);// if true then setting the customer to the loan
                      }
                    }
                });
        tableVehicleLoan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                selectedCellValueVehicle = (int) tableVehicleLoan.getModel().getValueAt(tableVehicleLoan.getSelectedRow(), 0);// getting value at the clicked row
                System.out.println(selectedCellValueVehicle); // printing the detail
                for (Vehicle vehicle : FleetHandler.getVehicles()) {// using for loop to get the data
                    if (vehicle.getId() == selectedCellValueVehicle) { // checking the condition
                        if (vehicle.getType() == Vehicle.Type.MINI_BUS) { // checking the condition
                            JFrame jframes = new JFrame(); // creating frame
                            JPanel popUp = new JPanel(); // creating panel
                            popUp.setLayout(new GridLayout(0, 2, 2, 2)); // setting layout

                            JTextField seatCapacity = new JTextField(5); // creating textfield
                            popUp.add(new JLabel("Enter Intended Number Of Passenger: ")); // creating jlabel
                            popUp.add(seatCapacity);// adding to the panel
                            int option = JOptionPane.showConfirmDialog(jframes, popUp, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                            // confirm dialouge box
                            if (option == JOptionPane.YES_OPTION) {// if clicked to yes option then
                                int seatCapacityText = Integer.parseInt(seatCapacity.getText());  // getting text from textfield

                                if (seatCapacityText > Integer.parseInt(vehicle.getSeatCapacity())) { // checking the value
                                    JOptionPane.showMessageDialog(null, "Intended No. of passenger is larger than the capacity "); // printing message after checking
                                }
                                if (seatCapacityText < Integer.parseInt(vehicle.getSeatCapacity())) { // checking the value
                                    loan.setVehicle(vehicle); // setting the vehicle
                                    adminController.addLoan(loan); // adding loan to the file
                                    JOptionPane.showMessageDialog(null, "Vehicle Has been Loaned. Refresh to see change "); // message box popping
                                    break;
                                }
                            }
                        }
                        if (vehicle.getType() == Vehicle.Type.LORRY) { // checking the condition
                            JFrame jframes = new JFrame(); // creating the frame
                            JPanel popUp = new JPanel();// creating the panel
                            popUp.setLayout(new GridLayout(0, 2, 2, 2)); // setting layout

                            JTextField loadCapacity = new JTextField(5); // creating textfield
                            popUp.add(new JLabel("Enter Intended Number Of Load: ")); // adding jlabel to the panel
                            popUp.add(loadCapacity); // adding to the panel
                            int option = JOptionPane.showConfirmDialog(jframes, popUp, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                            // confirmation dialog box
                            if (option == JOptionPane.YES_OPTION) { // if clicked on yes
                                int loadCapacityText = Integer.parseInt(loadCapacity.getText()); // getting text

                                if (loadCapacityText > Integer.parseInt(vehicle.getLoadCapacity())) { // again checking the text
                                    JOptionPane.showMessageDialog(null, "Intended No. of passenger is larger than the load Capacity "); // printing message
                                }
                                if (loadCapacityText < Integer.parseInt(vehicle.getLoadCapacity())) { // // checking the text
                                    loan.setVehicle(vehicle); // setting vehicle
                                    adminController.addLoan(loan); // adding to the file
                                    JOptionPane.showMessageDialog(null, "Vehicle Has been Loaned. Refresh to see change "); // showing confirmation dialog
                                    break;
                                }
                            }
                        }
                        if (vehicle.getType() == Vehicle.Type.CAR) { // checking the condition
                            int result = JOptionPane.showConfirmDialog(panelDown, "Sure?", "Loan Car",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE); // confirmation dialog box
                            if (result == JOptionPane.YES_OPTION) { // if clicked on yes then
                                loan.setVehicle(vehicle); // setting vehicle to the loan
                                adminController.addLoan(loan); // adding to the file
                                JOptionPane.showMessageDialog(null, "Vehicle Has been Loaned. Refresh to see change "); // showing message dialog box
                                break;
                            } else if (result == JOptionPane.NO_OPTION) {
                            }
                        }
                    }
                }
            }
                });
            }
            public void unLoan(){ // creating a method for unloan purpose
                   int rowVehicle = tableVehicleUnLoan.getSelectedRow(); // getting the selected row's index
                   int loan_id = (int) tableVehicleUnLoan.getModel().getValueAt(rowVehicle, 0); // getting loan id
                       adminController.removeLoan(loan_id); // removing the loan id
                   }

    public void viewTable() { // creating the method for viewing table
        String[] column = {"Id", "Name Corporation", "Address", "Phone No", "Email", "Username", "Password"}; // this will be the column of the table
        tableVehicle.setVisible(false); // setting visible false
       defaultTableModel = new DefaultTableModel(column, 0);// creating model instance and keeping column
        table = new JTable(defaultTableModel){ // creating the table
            public boolean isCellEditable(int r, int c) {
                return false;
            } // making cell uneditable
        };
        for (Customer customer : FleetHandler.getCustomers()) { // using forloop to get the values
            defaultTableModel.addRow(new Object[]{customer.getCustomerId(), customer.getNameOfCorporation(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmailAddress(), customer.getUserName(), customer.getPassword()});
            //adding the data to the row
        }
        tableVehicle.getTableHeader().setVisible(false); // setting the visible false
        table.getTableHeader().setBounds(20, 40, 750, 30);// setting bound of the component
        panelDown.add(table.getTableHeader()); // adding to the panel
        Color color = UIManager.getColor("Table.gridColor"); // getting color
        MatteBorder border = new MatteBorder(2, 2, 2, 2, color); // creating the border
        table.getTableHeader().setBorder(border); // setting border
        table.setBounds(20, 70, 750, ((table.getRowCount())*17));// setting bound of the component
        panelDown.add(table); // adding to the panel
    }
    private void addCustomer() { // method to add customer
        JFrame jframes = new JFrame(); // creating the jframe
        JPanel popUp = new JPanel(); // creating the panel
        popUp.setLayout(new GridLayout(0, 2, 2, 2)); // setting layout

        JTextField nameOfCorporations = new JTextField(5); // creating textfields
        JTextField addresss = new JTextField(5);// creating textfields
        JTextField phoneNumbers = new JTextField(5);// creating textfields
        JTextField emailAddresss = new JTextField(5);// creating textfields
        JTextField userNames= new JTextField(5);// creating textfields
        JTextField passwords = new JTextField(5);// creating textfields

        popUp.add(new JLabel("Enter Name Of Corporation")); // creating and adding jlabels
        popUp.add(nameOfCorporations); // adding component to the panel
        popUp.add(new JLabel("Enter Address"));// creating and adding jlabels
        popUp.add(addresss);// adding component to the panel
        popUp.add(new JLabel("Enter PhoneNumber"));// creating and adding jlabels
        popUp.add(phoneNumbers);// adding component to the panel
        popUp.add(new JLabel("Enter Email Address"));// creating and adding jlabels
        popUp.add(emailAddresss);// adding component to the panel
        popUp.add(new JLabel("Enter Username"));// creating and adding jlabels
        popUp.add(userNames);// adding component to the panel
        popUp.add(new JLabel("Enter Password"));// creating and adding jlabels
        popUp.add(passwords);// adding component to the panel

        int option = JOptionPane.showConfirmDialog(jframes, popUp, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        //storing the information

        if (option == JOptionPane.YES_OPTION) { // the yes then
            String nameOfCorporation = nameOfCorporations.getText(); // getting text from textfield
            String address = addresss.getText();// getting text from textfield
            String phoneNumber = phoneNumbers.getText();// getting text from textfield
            String emailAddress = emailAddresss.getText();// getting text from textfield
            String userName = userNames.getText();// getting text from textfield
            String password = passwords.getText();// getting text from textfield

            if (nameOfCorporation.equals("")) { // if the value is empty then
                JOptionPane.showMessageDialog(null, "Please fill in the Name Of Corporation field! "); // shows the confirmation dialog box
                addCustomer(); // calling function
            } else {
            //validate
            Customer customer = new Customer(nameOfCorporation, address, phoneNumber, emailAddress, userName, password); // creating the obuject
            adminController.addCustomer(customer); //adding the object
                table.setBounds(20, 70, 750, table.getHeight() + 17);// setting bound of the component
            defaultTableModel.addRow(new Object[]{customer.getCustomerId(), customer.getNameOfCorporation(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmailAddress(), customer.getUserName(), customer.getPassword()});
            // adding data as a row to the table
            defaultTableModel.fireTableDataChanged(); // triggers the change
        }
        }
    }


    private void deleteCustomer() {// method for deleting the customer
        int row = table.getSelectedRow(); // getting the selected row's index
        int customerId = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 0); //getting the customer id of the selected row
        adminController.removeCustomer(customerId); // removing the customer with the same id
        defaultTableModel.removeRow(row); // removing row
        table.setBounds(20, 70, 750, (table.getHeight() - 17 ));// setting bound of the component
        defaultTableModel.fireTableDataChanged(); // trigger the change in the table

    }
    public void viewTableVehicle() {
        String[] column = {"Id", "Make", "Model", "Top Speed", "Registration No", "Daily Hire %", "No of Door", "Fuel Type", "Seat Capacity", "Load Capacity"}; // will the be column name of the table
        table.setVisible(false); // setting visible false
        defaultTableModelVehicles = new DefaultTableModel(column, 0); // creating instance
        tableVehicle = new JTable(defaultTableModelVehicles) {
            public boolean isCellEditable(int r, int c) {
                return false;
            } // making cell uneditable
        };
        for (Vehicle vehicle : FleetHandler.getVehicles()) { // getting values using for loop
            defaultTableModelVehicles.addRow(new Object[]{vehicle.getId(), vehicle.getMake(), vehicle.getModel(), vehicle.getTopSpeed(), vehicle.getRegistrationNumber(), vehicle.getDailyHireRate(), vehicle.getFuelType(), vehicle.getFuelType(),vehicle.getSeatCapacity(),vehicle.getLoadCapacity()});
       // adding data as a row to the table
        }
        table.getTableHeader().setVisible(false); // setting visible false of the component
        tableVehicle.getTableHeader().setBounds(20, 50, 900, 30);// setting bound of the component
        panelDown.add(tableVehicle.getTableHeader()); // adding table header
        Color color = UIManager.getColor("Table.gridColor"); // getting color
        MatteBorder border = new MatteBorder(2, 2, 2, 2, color); // creating border
        tableVehicle.getTableHeader().setBorder(border); // setting border
        tableVehicle.setBounds(20, 80, 900, ((tableVehicle.getRowCount())*17));// setting bound of the component
        panelDown.add(tableVehicle); // adding to component to the panel
    }
private void addVehicle() {
    JFrame jframes = new JFrame(); // creating the frame
    JPanel popUp = new JPanel(); // creating the panel
    popUp.setLayout(new BoxLayout(popUp, BoxLayout.Y_AXIS)); // setting layout

    JTextField make = new JTextField(5); // creating textfields
    JTextField model = new JTextField(5);// creating textfields
    JTextField topSpeed = new JTextField(5);// creating textfields
    JTextField registrationNo = new JTextField(5);// creating textfields;
    JTextField noOfDoor= new JTextField(5);// creating textfields
    JTextField dailyHireRate= new JTextField(5);// creating textfields
    JTextField fuelType = new JTextField(5);// creating textfields
    JTextField seatCapacity = new JTextField(5);// creating textfields
    JTextField loadingCapacity= new JTextField(5);// creating textfields
    JComboBox<Vehicle.Type> type = new JComboBox<>(); // creating combo box
    ComboBoxModel vehicleModel = new DefaultComboBoxModel( Vehicle.Type .values());
    type.setModel(vehicleModel); // setting model to the combo box

    JLabel typeJlabel = new JLabel("Enter Type"); // creating jlabel
    popUp.add(typeJlabel);// adding to the panel
    popUp.add(type);//adding to the panel
    JLabel makeJlabel =  new JLabel("Enter Make");// creating jlabel
    popUp.add(makeJlabel);// adding to the panel
    popUp.add(make);//adding to the panel
    JLabel modelJlabel = new JLabel("Enter Model");// creating jlabel
    popUp.add(modelJlabel);// adding to the panel
    popUp.add(model);// adding to the panel
    JLabel topSpeedlabel= new JLabel("Enter Speed");// creating jlabel
    popUp.add(topSpeedlabel);// adding to the panel
    popUp.add(topSpeed);// adding to the panel
    JLabel registrationNosJlabel =  new JLabel("Enter Registration No");// creating jlabel
    popUp.add(registrationNosJlabel);// adding to the panel
    popUp.add(registrationNo);// adding to the panel
    JLabel dailyJlabel = new JLabel("Enter Daily HireRate");// creating jlabel
    popUp.add(dailyJlabel);// adding to the panel
    popUp.add(dailyHireRate);// adding to the panel
    JLabel fuelTypeJlabel = new JLabel("Enter Fuel Type");// creating jlabel
    popUp.add(fuelTypeJlabel);// adding to the panel
    popUp.add(fuelType);// adding to the panel
    JLabel noOfDoorJlabel =  new JLabel("Enter No. of Door");// creating jlabel
    popUp.add(noOfDoorJlabel);// adding to the panel
    popUp.add(noOfDoor);// adding to the panel
    JLabel seatCapacityJlabel = new JLabel("Enter Seat Capacity");// creating jlabel
    popUp.add(seatCapacityJlabel);// adding to the panel
    popUp.add(seatCapacity);// adding to the panel
    JLabel loadingCapacityJlabel = new JLabel("Enter Loading Type");// creating jlabel
    popUp.add(loadingCapacityJlabel);// adding to the panel
    popUp.add(loadingCapacity);// adding to the panel
    seatCapacity.setVisible(false);// setting the component's visible to false
    seatCapacityJlabel.setVisible(false);// setting the component's visible to false
    loadingCapacity.setVisible(false);// setting the component's visible to false
    loadingCapacityJlabel.setVisible(false);// setting the component's visible to false
    type.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {

            switch ((Vehicle.Type )type.getSelectedItem()) { // checking the value
                case CAR:  // if its car then
                   seatCapacity.setVisible(false);// setting the component's visible to false
                   seatCapacityJlabel.setVisible(false);// setting the component's visible to false
                   loadingCapacity.setVisible(false);// setting the component's visible to false
                   loadingCapacityJlabel.setVisible(false);// setting the component's visible to false
                    noOfDoor.setVisible(true);// setting the component's visible to true
                    noOfDoorJlabel.setVisible(true);// setting the component's visible to true
                    fuelType.setVisible(true);// setting the component's visible to true
                    fuelTypeJlabel.setVisible(true);// setting the component's visible to true
                    break;
                case MINI_BUS: // if its minibus then
                    seatCapacity.setVisible(true);// setting the component's visible to true
                    seatCapacityJlabel.setVisible(true);// setting the component's visible to true
                    loadingCapacity.setVisible(false);// setting the component's visible to false
                    loadingCapacityJlabel.setVisible(false);// setting the component's visible to false
                    noOfDoor.setVisible(false);// setting the component's visible to false
                    noOfDoorJlabel.setVisible(false);// setting the component's visible to false
                    fuelType.setVisible(false);// setting the component's visible to false
                    fuelTypeJlabel.setVisible(false);// setting the component's visible to false
                    break;
                case LORRY: // if its lorry then
                    seatCapacity.setVisible(false);// setting the component's visible to false
                    seatCapacityJlabel.setVisible(false);// setting the component's visible to false
                    loadingCapacity.setVisible(true);// setting the component's visible to true
                    loadingCapacityJlabel.setVisible(true);// setting the component's visible to false
                    noOfDoor.setVisible(false);// setting the component's visible to false
                    noOfDoorJlabel.setVisible(false);// setting the component's visible to false
                    fuelType.setVisible(false);// setting the component's visible to false
                    fuelTypeJlabel.setVisible(false);// setting the component's visible to false
                    break;
            }
        }
    });
int option = JOptionPane.showConfirmDialog(jframes, popUp, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

    if (option == JOptionPane.YES_OPTION) {
        System.out.println("HEllo");
        String makes = make.getText();
        String models = model.getText();
        String topSpeeds = topSpeed.getText();
        String registrationNos = registrationNo.getText();
        String daillyHireRate = dailyHireRate.getText();
        String fuelTypes = fuelType.getText();
        String noOfDoors = noOfDoor.getText();
        String seatCapacitys = seatCapacity.getText();
        String loadCapacitys = loadingCapacity.getText();

        if (makes.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the make field! ");
            addVehicle();
        } else {
            switch ((Vehicle.Type) type.getSelectedItem()) {
                case CAR:
                    Vehicle car = new Vehicle(makes, models, topSpeeds, registrationNos, daillyHireRate, fuelTypes, noOfDoors, "-----", "-----", Vehicle.Type.CAR);
                    adminController.addVehicle(car);
                    tableVehicle.setBounds(20, 80, 900, tableVehicle.getHeight() + 17);// setting bound of the component
                    defaultTableModelVehicles.addRow(new Object[]{car.getId(), car.getMake(), car.getModel(), car.getTopSpeed(), car.getRegistrationNumber(), car.getDailyHireRate(), car.getNoOfDoors(), car.getFuelType(), car.getSeatCapacity(),car.getLoadCapacity()});
                    defaultTableModelVehicles.fireTableDataChanged();
                    break;
                case MINI_BUS:
                    Vehicle miniBus = new Vehicle(makes, models, topSpeeds, registrationNos, daillyHireRate, "-----","-----" , seatCapacitys,"----",Vehicle.Type.MINI_BUS);
                    adminController.addVehicle(miniBus);
                    tableVehicle.setBounds(20, 80, 900, tableVehicle.getHeight() + 17);// setting bound of the component
                    defaultTableModelVehicles.addRow(new Object[]{miniBus.getId(), miniBus.getMake(), miniBus.getModel(), miniBus.getTopSpeed(), miniBus.getRegistrationNumber(), miniBus.getDailyHireRate(),miniBus.getFuelType(),  miniBus.getNoOfDoors(), miniBus.getSeatCapacity(),miniBus.getLoadCapacity()});
                    defaultTableModelVehicles.fireTableDataChanged();
                    break;
                case LORRY:
                    Vehicle lorry = new Vehicle(makes, models, topSpeeds, registrationNos, daillyHireRate, "-----", "-----", "-----", loadCapacitys, Vehicle.Type.LORRY);
                    adminController.addVehicle(lorry);
                    tableVehicle.setBounds(20, 80, 900, tableVehicle.getHeight() + 17);// setting bound of the component
                    defaultTableModelVehicles.addRow(new Object[]{lorry.getId(), lorry.getMake(), lorry.getModel(), lorry.getTopSpeed(), lorry.getRegistrationNumber(), lorry.getDailyHireRate(), lorry.getFuelType(), lorry.getNoOfDoors(), lorry.getSeatCapacity(),lorry.getLoadCapacity()});
                    defaultTableModelVehicles.fireTableDataChanged();
                    break;
            }
        }
    }
}

    public void deleteVehicle() {
        System.out.println("wassup");
        int row = tableVehicle.getSelectedRow(); // getting the index of the row selected
        int vehicleId = (Integer) tableVehicle.getModel().getValueAt(tableVehicle.getSelectedRow(), 0); // getting vehicle id from that row
        adminController.removeVehicle(vehicleId);// removing vehicle with the given id
        defaultTableModelVehicles.removeRow(row); // removing row
        tableVehicle.setBounds(20, 80, 900, (tableVehicle.getHeight() - 17 ));// setting bound of the component
        defaultTableModelVehicles.fireTableDataChanged(); // triggering the change

    }

    public void componentsTrue(){
        addCustomer.setVisible(true);// setting the component's visible to true
        deleteCustomer.setVisible(true);// setting the component's visible to true
    }
    public void componentsFalse(){
        addCustomer.setVisible(false);// setting the component's visible to false
        deleteCustomer.setVisible(false);// setting the component's visible to false
        addVehicle.setVisible(false);// setting the component's visible to false
        deleteVehicle.setVisible(false);// setting the component's visible to false
        panelDown.setBorder(null); // setting border to null

    }
    public void componentsCustomer(){
        tableVehicle.setVisible(false);// setting the component's visible to false
        actualLoanButton.setVisible(false);// setting the component's visible to false
        tableVehicle.getTableHeader().setVisible(false); // setting the component's visible to false

    }

}
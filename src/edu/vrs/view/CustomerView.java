package edu.vrs.view;

import edu.vrs.controller.AdminController;
import edu.vrs.model.Loan;
import edu.vrs.model.Session;
import edu.vrs.model.Vehicle;
import edu.vrs.service.FleetHandler;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static edu.vrs.view.AdminView.*;

public class CustomerView extends JFrame {
    JButton myVehicle = new JButton("My Vehicle");
    JButton freeVehicleButton= new JButton("Free Vehicle");
    Border border1 = BorderFactory.createLineBorder(Color.gray);
    JLabel cusPic = new JLabel(new ImageIcon("pics/cus.jpg"));
    JPanel panelLeft = new JPanel();
    JPanel panelRight = new JPanel();
    JPanel panelDown = new JPanel();
    JButton logoutButton = new JButton("Exit");
    JLabel customer = new JLabel();
    static DefaultTableModel defaultTableModelVehiclesLoan;
    JTable tableVehicleLoan = new JTable(defaultTableModelCusLoan);
    static DefaultTableModel defaultTableModelVehiclesUnLoan;
    JTable tableVehicleUnLoan = new JTable(defaultTableModelCusUnLoan);
    AdminController adminController;

    public void jFrame() {
        CustomerView jFrame = new CustomerView();
        jFrame.setSize(1200, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setTitle("Customer Panel");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.showWindow();
        jFrame.setVisible(true);
    }

    public void showWindow() {
        adminController = new AdminController();
        Container window2 = getContentPane();
        window2.setLayout(null);
        panelLeft.setBounds(0, 0, 200, 800);
        panelLeft.setBorder(border1);
        window2.add(panelLeft);

        panelRight.setBounds(200, 0, 1000, 150);
        panelRight.setBorder(border1);
        window2.add(panelRight);

        panelLeft.setLayout(null);
        Font f = new Font("serif", Font.PLAIN, 20);
        panelDown.setBounds(200, 150, 1000, 800);
        panelDown.setLayout(null);
        window2.add(panelDown);

        customer.setBounds(150,150,50,30);
        customer.setText(("-"+ String.valueOf(Session.getCurrentUser().getUserName())));
        panelLeft.add(customer);

        panelRight.setLayout(null);
        myVehicle.setBounds(5, 200, 170, 50);
        panelLeft.add(myVehicle);
        myVehicle.setFont(f);
        myVehicle.addActionListener(e -> {
            tableVehicleLoan.getTableHeader().setVisible(false);
            tableVehicleLoan.setVisible(false);
            String[] columnVehicleUnloan = {"Id", "Make", "Model", "Registration No"};
            defaultTableModelVehiclesUnLoan = new DefaultTableModel(columnVehicleUnloan, 0);
            tableVehicleUnLoan = new JTable(defaultTableModelVehiclesUnLoan) {
                public boolean isCellEditable(int r, int c) {
                    return false;
                }
            };
            for (Loan loan : FleetHandler.getLoans()) {
                if (Session.getCurrentUser().getEmailAddress().equals(loan.getUser().getEmailAddress()))
                defaultTableModelVehiclesUnLoan.addRow(new Object[]{loan.getLoanId(), loan.getVehicle().getMake(), loan.getVehicle().getModel(), loan.getVehicle().getRegistrationNumber()});
            }
            tableVehicleUnLoan.getTableHeader().setBounds(200, 40, 500, 30);
            panelDown.add(tableVehicleUnLoan.getTableHeader());
            Color colorVehicleTableUnloan = UIManager.getColor("Table.gridColor");
            MatteBorder borderVehicleUnloan = new MatteBorder(2, 2, 2, 2, colorVehicleTableUnloan);
            tableVehicleUnLoan.getTableHeader().setBorder(borderVehicleUnloan);
            tableVehicleUnLoan.setBounds(200, 70, 500, ((tableVehicleUnLoan.getRowCount()) * 17));
            panelDown.add(tableVehicleUnLoan);

        });

        freeVehicleButton.setBounds(10, 300, 170, 50);
        panelLeft.add(freeVehicleButton);
        freeVehicleButton.setFont(f);
        freeVehicleButton.addActionListener(e -> {
            tableVehicleUnLoan.setVisible(false);
            tableVehicleUnLoan.getTableHeader().setVisible(false);
            String[] columnVehicle = {"Id", "Make", "Model", "Registration No"};
            defaultTableModelVehiclesLoan = new DefaultTableModel(columnVehicle, 0);
            tableVehicleLoan = new JTable(defaultTableModelVehiclesLoan) {
                public boolean isCellEditable(int r, int c) {
                    return false;
                }
            };

            for (Vehicle vehicle : FleetHandler.getVehicles()) {
                if(FleetHandler.getLoans().size() > 0) {
                    boolean isVehicleLoaned = false;
                    for(Loan loan : FleetHandler.getLoans()) {
                        if(vehicle.getId() == loan.getVehicle().getId()) {
                            isVehicleLoaned = true;
                        }
                    }
                    if(!isVehicleLoaned) {
                        defaultTableModelVehiclesLoan.addRow(new Object[]{vehicle.getId(), vehicle.getMake(), vehicle.getModel(), vehicle.getRegistrationNumber()});
                    }
                } else {
                    defaultTableModelVehiclesLoan.addRow(new Object[]{vehicle.getId(), vehicle.getMake(), vehicle.getModel(), vehicle.getRegistrationNumber()});
                }

            }
            tableVehicleLoan.getTableHeader().setBounds(200, 70, 350, 30);
            panelDown.add(tableVehicleLoan.getTableHeader());
            Color colorVehicleTable = UIManager.getColor("Table.gridColor");
            MatteBorder borderVehicle = new MatteBorder(2, 2, 2, 2, colorVehicleTable);
            tableVehicleLoan.getTableHeader().setBorder(borderVehicle);
            tableVehicleLoan.setBounds(200, 100, 350, ((tableVehicleLoan.getRowCount()) * 17));
            panelDown.add(tableVehicleLoan);
        });

        cusPic.setBounds(20, 30, 150, 150);
        panelLeft.add(cusPic);
        cusPic.setIcon(new ImageIcon(new ImageIcon("pics/cus.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        cusPic.setVisible(true);

        logoutButton.setBounds(10, 470, 150, 50);
        panelLeft.add(logoutButton);
        logoutButton.addActionListener(e -> System.exit(0));
        logoutButton.setBackground(Color.orange);
        logoutButton.setFont(f);

    }


    }

package edu.vrs.view;

import edu.vrs.model.Customer;
import edu.vrs.model.Session;
import edu.vrs.service.FleetHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginView extends JFrame {
    JLabel label = new JLabel();
    JLabel pic = new JLabel(new ImageIcon("pics/admin.png"));
    JTextField usernameField = new JTextField(8);
    JPasswordField passwordField = new JPasswordField(8);
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JLabel error = new JLabel();
    JButton button = new JButton("CANCEL");
    JButton button2 = new JButton("LOGIN");
    JPanel jpanel1 = new JPanel();
    JPanel jpanel2 = new JPanel();

    public LoginView()
    {
        setSize(1300,700);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        prepareGUI();
        setVisible(true);
//        login();
    }
    public void login(){
        JFrame loginFrame = new JFrame();
        JPanel popUpLogin = new JPanel();
        popUpLogin.setLayout(new GridLayout(0, 2, 2, 2));

        JTextField userName = new JTextField(5);
        JTextField password = new JTextField(5);

        popUpLogin.add(new JLabel("Enter Username"));
        popUpLogin.add(userName);
        popUpLogin.add(new JLabel("Enter Password"));
        popUpLogin.add(password);
        int option = JOptionPane.showConfirmDialog(loginFrame, popUpLogin, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

            String userNameAdmin = userName.getText();
            String passwordAdmin = password.getText();

            if (userNameAdmin.equals("admin") || passwordAdmin.equals("admin")) {
                AdminView adminView = new AdminView();
                adminView.jFrame();
            }
            if (userNameAdmin.equals("")){
                JOptionPane.showMessageDialog(null, "Please fill in the Username field! ");
                login();
            }
        }
    }

    void prepareGUI() {

        Container window = getContentPane();
        window.setLayout(null);

        jpanel1.setBounds(0,20,320,700);
        window.add(jpanel1);
        jpanel1.setLayout(null);
        jpanel1.setBackground(Color.decode("#16c8d9"));

        jpanel2.setBounds(321,20,980,700);
        jpanel2.setLayout(null);
        jpanel2.setBackground(Color.decode("#820a0a"));
        window.add(jpanel2);
        pic.setBounds(0, 20, 900, 400);
        jpanel2.add(pic);
        pic.setIcon(new ImageIcon(new ImageIcon("pic/2.jpg").getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT)));

        username.setBounds(50, 90, 120, 50);
        username.setForeground(Color.white);
        jpanel1.add(username);
        usernameField.setBounds(50, 125, 150, 25);
        jpanel1.add(usernameField);

        password.setBounds(50, 145, 100, 50);
        jpanel1.add(password);
        password.setForeground(Color.white);

        passwordField.setBounds(50, 180, 150, 25);
        jpanel1.add(passwordField);

        button2.setBounds(50,240,85, 20);
        jpanel1.add(button2);
        button2.setBackground(Color.green.darker());
        button2.setForeground(Color.white);

        button.setBounds(150,240,85, 20);
        jpanel1.add(button);
        button.setBackground(Color.red);
        button.setForeground(Color.white);

        jpanel1.add(label);
        error.setForeground(Color.white);
        error.setBounds(20,300,250, 20);
        error.setFont(new Font("", Font.BOLD, 15));/* Giving fonts,size and style*/
        jpanel1.add(error);

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if (username.equals("admin") && password.equals("admin")) {
                    AdminView adminView = new AdminView();
                    adminView.jFrame();
                    removeGui();
            }
                if (username.equals("admin") && !password.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Username Or Password");
                }

                for (Customer customer: FleetHandler.getCustomers()){
                    if ((username.equals(customer.getUserName()) && (!password.equals(customer.getPassword())))){
                        JOptionPane.showMessageDialog(null, "Please Enter Correct Username Or Password");
                    }
                    if ((username.equals(customer.getUserName()) && (password.equals(customer.getPassword())))){
                        CustomerView customerView = new CustomerView();
                        Session.setCurrentUser(customer);
                        customerView.jFrame();
                    }
                }
                if (username.equals("") || password.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter Username Or Password");
                }
        }

    });
    }
    public void removeGui(){
        this.dispose();
    }

}


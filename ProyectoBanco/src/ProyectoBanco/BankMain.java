package ProyectoBanco;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BankMain {
    
    HashMap<String,String>userData = new HashMap<String,String>();
    int tries= 3;
    double initial=2000;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String username;
        String password;
        int opcion;
        BankMain bank = new BankMain();
        do {
            opcion= Integer.parseInt(JOptionPane.showInputDialog("Welcome to the bank \n Select an option to continue \n 1.) Register \n 2.)Login \n 3.) Exit"));
            if(opcion==1) {
                username = JOptionPane.showInputDialog("Enter your username");
                password = JOptionPane.showInputDialog("Enter your password");
                bank.register(username, password);
            }else if(opcion == 2) {
                bank.login();
               
            }
        }while(opcion !=3);
        
    }
    
      void  register(String username, String password) {
       
        userData.put("username", username);
        userData.put("password", password);
        JOptionPane.showMessageDialog(null, "You've been register successfully");
    }
      
    boolean login() {
        System.out.println("intentos: "+tries);
        System.out.println(userData.get("username"));
        BankMain bank=new BankMain();
        String username = JOptionPane.showInputDialog("Enter your username");
        String password = JOptionPane.showInputDialog("Enter your password");
        
        if(username.equalsIgnoreCase(userData.get("username")) && password.equalsIgnoreCase(userData.get("password"))) {
            JOptionPane.showMessageDialog(null, "Welcome to the bank");
            boolean stay = false;
            do {
                stay =bank.bank(username);
            }while(!stay);
            
            return true;
        }else if(tries ==1){
            JOptionPane.showMessageDialog(null,"You reach the number of tries, your user will be blocked");
            System.exit(0);
            return false;      
            
        }else {
            tries--;
            JOptionPane.showMessageDialog(null, "Failed attempt, please try again, you have:"+tries);
            return false;
        }
        
        
    }
    
    boolean bank(String username) {
       
        int option = Integer.parseInt(JOptionPane.showInputDialog("Welcome " + username + " here you can choose multiple options \n 1.)Deposit \n 2.)Withdraw \n 3.)View \n 4.)Transfer Money"));
        switch(option) {        
        
        case 1:
            double deposit = Double.parseDouble(JOptionPane.showInputDialog("enter the amount"));
            initial = deposit(deposit,initial);
            System.out.println(initial);
            return false;        
        case 2:
            double withdraw = Double.parseDouble(JOptionPane.showInputDialog("enter the amount"));
            initial= withdraw(withdraw, initial);
            return false;
        case 3:
            view(initial);
            return false;
        case 4:
            double transfer = Double.parseDouble(JOptionPane.showInputDialog("enter the amount"));
            initial =tranfer( transfer,  initial);
            return false;
        default:
            return true;
        }
        
    }
    double deposit(double deposit, double initial) {
        if(deposit >0) {
            return initial+=deposit;
        }else {
            JOptionPane.showMessageDialog(null, "Must be a positive number");
            return 0;
        }
    }
    void view(double account) {
        JOptionPane.showInputDialog("Amount: " + account);
    }
    double withdraw(double withdraw, double initial) {
        if((initial-withdraw) >=0) {
            return initial-=withdraw;
            
        }else {
            JOptionPane.showMessageDialog(null, "The amount can't over pass the avalaible in your account");
            return initial;
        }
    }
    double tranfer(double transfer, double initial) {
        if((initial-transfer) >=0) {
            return initial-=transfer;
            
        }else {
            JOptionPane.showMessageDialog(null, "The amount can't over pass the avalaible in your account");
            return initial;
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;




/**
 *
 * @author Ranjan Kumar Patra
 */
public class Login extends JFrame implements ActionListener{
    JButton reset, submit, close;
    JTextField tf;
    JPasswordField pf;
  
    
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lb1 = new JLabel("Username");
        lb1.setBounds(20,20,100,20);
        add(lb1);
        
        tf = new JTextField();
        tf.setBounds(130,20,200,20);
        add(tf);
        
        JLabel lb2 = new JLabel("Password");
        lb2.setBounds(20,60,100,20);
        add(lb2);
        
        pf = new JPasswordField();
        pf.setBounds(130,60,200,20);
        add(pf);
        
         reset = new JButton("Reset");
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this);
        add(submit);
        
         close = new JButton("Close");
        close.setBounds(120,160,120,20);
        close.addActionListener(this);
        add(close);
        
    setSize(400, 250);
    setVisible(true);
    setLocation(600, 250);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username = tf.getText();
            String password = pf.getText();
            
            try{
                Conn c = new Conn();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
              ResultSet rs =  c.s.executeQuery(query);
              
              if(rs.next()){
                  new Home();
                  setVisible(false);
                  
                  
              } else {
                  JOptionPane.showMessageDialog(null, "Invalid username or password");
                  setVisible(false);
              }
              
              
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == close){
            setVisible(false);
        } else if (ae.getSource() == reset){
            tf.setText("");
            pf.setText("");
        }
        
    }
    public static void main(String[] args){
        new Login();
            
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Himanshu Agarwal
 */
public class Register extends JFrame {
    JLabel l[] = new JLabel[]{new JLabel("id"),new JLabel("Username"),new JLabel("Phone Number"),new JLabel("Email"),new JLabel("Password")}; 
    JTextField t[] = new JTextField[4];
    JPasswordField p1;
    JButton b1;
    Register(){
        ImageIcon i1 = new ImageIcon("C:/Users/Himanshu Agarwal/Documents/NetBeansProjects/Event_Management_System/src/event_management_system/images/man_logo.jpg");
        Image q1 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(q1);
        JLabel l3 = new JLabel(i2);
        l3.setBounds(350,10,200,200);
        add(l3);
        getContentPane().setBackground(Color.WHITE);
        int j = 0;
        for(int i=0;i<5;i++){
            l[i].setBounds(40,20+j,100,30);
            add(l[i]);
            j+= 50;
            
        }
        j =0;
        for(int i=0;i<5;i++){
            if (i==4){
                p1 = new JPasswordField();
                p1.setBounds(150,20+j,150,30);
                add(p1);
            }
            else{
                t[i] = new JTextField();
                t[i].setBounds(150,20+j,150,30);
                add(t[i]);
                j+= 50;
            }
        }
        b1 = new JButton("Register");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,260,100,30);
        add(b1);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                conn c =new conn();
                String q = null;
                 try{
                     String x = "customer";
                     q = "insert into user values("+t[0].getText()+", '"+t[1].getText()+"', "+t[2].getText()+", '"+t[3].getText()+"','"+x+"','"+p1.getText()+"')";
                        System.out.print(q);
                        setVisible(false);
            
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Successfully Added");
                setVisible(false);
            
        }catch (SQLException ex) {
            Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
        }
            

            }
        });
        JButton b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(220,260,100,30);
       
	b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    setVisible(false);
                    new Event_Management_System().setVisible(true);
                
                
                }catch(Exception e ){}
                
    }
        }
        );
	
	add(b2);
        
       
        
        
        setLayout(null);
        setBounds(500,300,700,500);
        setVisible(true);
        
        
        
        
    }
    public static void main(String args[]){
        Register r = new Register();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman Kedia
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FlightList {
    FlightList( Flights flight[],int count)
    {
         JFrame fltLst = new JFrame("FLIGHTS AVAILABLE");
         JLabel g = new JLabel( "Flight List");
        // fltLst.add(g);
        fltLst.setSize(1200,400);
        fltLst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fltLst.setLayout(new GridLayout(1,0));
         Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int x=(d.width-fltLst.getWidth())/2;
        int y=(d.height-fltLst.getHeight())/2;
        fltLst.setLocation(x, y);
        String colhead[]={"Domestic PLANE ID","FROM","TO","DEPARTURE TIME(IST)","ARRIVAL TIME(IST)","International PLANE ID","FROM","TO","DEPARTURE TIME(IST)","ARRIVAL TIME(MST)","JOURNEY DURATION(in mins)"};               
        String data[][]=new String[count][11];
       for(int i=0;i<count;i++)
       {
        data[i][0]= flight[i].domesticplane;
        data[i][1]= flight[i].source;
        data[i][2]= flight[i].via;
        data[i][3]= flight[i].dep_timed;
        data[i][4]= flight[i].arr_timed;
        data[i][5]= flight[i].interplane;
        data[i][6]= flight[i].via;
        data[i][7]= "Singapore";
        data[i][8]= flight[i].dep_timei;
        data[i][9]= flight[i].arr_timei;
        data[i][10]=flight[i].duration+"mins";
       }
        JTable tab= new JTable(data,colhead);
        //tab.setMinimumSize(new Dimension(4000,1400));
        //tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane jsp= new JScrollPane(tab);
        //jsp.setMinimumSize(new Dimension(4000,400));
        //jsp.add(tab);
        fltLst.add(jsp);
        //fltLst.add(tab);
        fltLst.setVisible(true);
    }
    
   
}

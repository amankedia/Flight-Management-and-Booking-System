//This class is used to create the initial search page

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
public class Search_Page {
    JTextField jtf = new JTextField(15);
    JTextField jtf2 = new JTextField(15);
    JTextField jtf3 = new JTextField(15);
    Search_Page()
    {
        JFrame search = new JFrame("Search Your Flight");
        search.setSize(300,200);
        search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        search.setLayout(new GridLayout(4,0));
        //JLabel jl = new JLabel();
        //search.add(jl);
        JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel jl1 = new JLabel("Enter Source City");  
        
        
        jp1.add(jl1);
        jp1.add(jtf);
        search.add(jp1);
        JLabel jl2 = new JLabel("Enter Date:            ");
        
        jp2.add(jl2);
        jp2.add(jtf2);
        search.add(jp2);
        JLabel jl3 = new JLabel("Enter No of seats:");
        
        jp3.add(jl3);
        jp3.add(jtf3);
        search.add(jp3);
        JButton jok1 = new JButton("OK");
        jp4.add(jok1);
       class Search_ok_listener implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                String s1,s2,s3;
                
                   System.out.println(s1=jtf.getText());
                   System.out.println(s2=jtf2.getText());
                   System.out.println(s3=jtf3.getText());
                   FlightManager f1 = new FlightManager(s1,s2,Integer.parseInt(s3));
                try {
                    f1.getFlight();
                    f1.sortarr();
                    FlightList f2=new FlightList(f1.arr,f1.numbers);
                    SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new FlightList(f1.arr,f1.numbers);
                    }
                });
                } catch (IOException ex) {
                    
                }
    }
            
    }
       jok1.addActionListener(new Search_ok_listener());
        search.add(jp4);
        search.setVisible(true);
    }
    
}

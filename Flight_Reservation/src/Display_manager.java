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

public class Display_manager {
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new Search_Page();
                    }
                });
    
    }
}

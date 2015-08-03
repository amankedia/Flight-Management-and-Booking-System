/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman Kedia
 */
public class Flights {
    String domesticplane,interplane;
    String source,via;
    int arrhrd,arrmind,dephrd,depmind;
    int arrhri,arrmini,dephri,depmini;
    static int no=0;
    String dep_timed,arr_timed,dep_timei,arr_timei;
    int duration; //calculate the time takes to fly throught this route 
    Flights(String domesticplane,String interplane,String source,String via,int arrhrd,int arrmind,int dephrd,int depmind,int arrhri,int arrmini,int dephri,int depmini)
    {
       
       this.domesticplane=domesticplane;
       this.interplane=interplane;
       this.source=source;
       this.via=via;
       this.arrhrd=arrhrd;
       this.arrmind=arrmind;
       this.dephrd=dephrd;
       this.depmind=depmind;
       this.arrhri=arrhri;
       this.arrmini=arrmini;
       this.dephri=dephri;
       this.depmini=depmini;
       arr_timed=""+arrhrd+":"+arrmind;
       dep_timed=""+dephrd+":"+depmind;
       arr_timei=""+arrhri+":"+arrmini;
       dep_timei=""+dephri+":"+depmini;
       duration=(arrhri-dephrd)*60+(arrmini-depmind);
       
       if(duration<0)
           duration=duration+24*60;
       duration=duration-150;
    }
    void display()
    {
        System.out.println("Flights from " + source +" via " + via + " to Singapore:");
        System.out.println("Flight from " + source +" to " + via );    
        System.out.println("Plane Id::"+domesticplane);
        System.out.println("Departure Time::"+dephrd+":"+depmind);
        System.out.println("Arrival Time::"+arrhrd+":"+arrmind);  
        System.out.println("Flight from " + via +" to Singapore");  
        System.out.println("Plane Id::"+interplane);
        System.out.println("Departure Time::"+dephri+":"+depmini);
        System.out.println("Arrival Time::"+arrhri+":"+arrmini);
    }
}

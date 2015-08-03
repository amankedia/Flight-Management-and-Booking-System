/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman Kedia
 */
import java.io.*;
import java.util.*;
public class FlightManager {
    String src;
    String Date;
    int no;
    public int numbers;
    public Flights arr[]=new Flights[100];
    FlightManager(String src, String Date, int no)
    {
        //System.out.println("In Flightmanager");
        this.src = src;
        this.Date= Date;
        this.no = no;
        numbers=0;
    }
    void sortarr()
    {
        int i,j;
        for (i=0;i<numbers-1;i++)
        {
            for (j=i+1;j<numbers;j++)
            {    
                if (arr[i].duration>arr[j].duration)
                {
                    Flights temp = new Flights(arr[i].domesticplane,arr[i].interplane,arr[i].source,arr[i].via,arr[i].arrhrd,arr[i].arrmind,arr[i].dephrd,arr[i].depmind,arr[i].arrhri,arr[i].arrmini,arr[i].dephri,arr[i].depmini);
                    temp.display();
                    arr[i] = new Flights(arr[j].domesticplane,arr[j].interplane,arr[j].source,arr[j].via,arr[j].arrhrd,arr[j].arrmind,arr[j].dephrd,arr[j].depmind,arr[j].arrhri,arr[j].arrmini,arr[j].dephri,arr[j].depmini);
                    arr[j] = new Flights(temp.domesticplane,temp.interplane,temp.source,temp.via,temp.arrhrd,temp.arrmind,temp.dephrd,temp.depmind,temp.arrhri,temp.arrmini,temp.dephri,temp.depmini);
                
                }    
            }            
        }
//sort the Flights arr[] according to duration
    }
    void getint(String dep,String inter,String planename,int dephr,int demin,int arh,int arm,String file) throws IOException
    {
        int h,m;
        try
        {
            BufferedReader brstream = new BufferedReader( new FileReader(file));
            //BufferedWriter bwstream = new BufferedWriter( new FileWriter("flighttemp.txt",true));
            String inputline,date,intplanename,time,time1;
            int intdephr,intdemin,intarh,intarm;
            //System.out.println("Flight availaible on "+Date+" from" + inter + "to Singapore:");
            while(true)
            {
                inputline = brstream.readLine();
                if(inputline == null)
                    break;
                StringTokenizer tok = new StringTokenizer(inputline);
                date = tok.nextToken();
                if(date.equals(Date))
                {
                    intplanename =tok.nextToken();
                    time=tok.nextToken();
                    StringTokenizer toki = new StringTokenizer(time,":");
                    intdephr = Integer.parseInt(toki.nextToken());
                    intdemin= Integer.parseInt(toki.nextToken());
                    time1=tok.nextToken();
                    StringTokenizer toki1 = new StringTokenizer(time1,":");
                    intarh = Integer.parseInt(toki1.nextToken());
                    intarm= Integer.parseInt(toki1.nextToken());
                   /* System.out.println("Plane Id::"+intplanename);
                    System.out.println("Departure Time::"+intdephr+":"+intdemin);
                    System.out.println("Arrival Time::"+intarh+":"+intarm);*/
                    h=intdephr-arh;
                    m=intdemin-arm;
                    if(m<0)
                    {
                        m=m+60;
                        h--;
                    }
                    m=h*60+m;
                    if(m>120 && m<360)
                    {
                    /*System.out.println("Flights possible on "+Date+" from " + dep +" via " + inter + " to Singapore:");    
                    System.out.println("Plane Id::"+planename);
                    System.out.println("Departure Time::"+dephr+":"+demin);
                    System.out.println("Arrival Time::"+arh+":"+arm);    
                    System.out.println("Plane Id::"+intplanename);
                    System.out.println("Departure Time::"+intdephr+":"+intdemin);
                    System.out.println("Arrival Time::"+intarh+":"+intarm);*/
                    arr[numbers++]=new Flights(planename,intplanename,dep,inter,arh,arm,dephr,demin,intarh,intarm,intdephr,intdemin);
                    }
                }
            }
            brstream.close();               
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Not found");
        }
    }
    void dom(String dep,String s,String inter) throws IOException
    {
        try
        {
            BufferedReader brstream = new BufferedReader( new FileReader(s));
            //BufferedWriter bwstream = new BufferedWriter( new FileWriter("flighttemp.txt",true));
            String inputline,date,planename,time,time1;
            int dephr,demin,arh,arm;
            //System.out.println("Flight availaible on "+Date+" from" + dep + "to"+ inter);
            while(true)
            {
                inputline = brstream.readLine();
                if(inputline == null)
                    break;
                StringTokenizer tok = new StringTokenizer(inputline);
                date = tok.nextToken();
                if(date.equals(Date))
                {
                    planename =tok.nextToken();
                    time=tok.nextToken();
                    StringTokenizer toki = new StringTokenizer(time,":");
                    dephr = Integer.parseInt(toki.nextToken());
                    demin= Integer.parseInt(toki.nextToken());
                    time1=tok.nextToken();
                    StringTokenizer toki1 = new StringTokenizer(time1,":");
                    arh = Integer.parseInt(toki1.nextToken());
                    arm= Integer.parseInt(toki1.nextToken());
                    /*System.out.println("Plane Id::"+planename);
                    System.out.println("Departure Time::"+dephr+":"+demin);
                    System.out.println("Arrival Time::"+arh+":"+arm);*/
                    if (inter.equals("Kolkata"))
                            getint(dep,inter,planename,dephr,demin,arh,arm,"Kol_Sing.txt");
                    else if (inter.equals("Hydrabad"))
                            getint(dep,inter,planename,dephr,demin,arh,arm,"Hyd_Sing.txt");
                    else if (inter.equals("Chennai"))
                             getint(dep,inter,planename,dephr,demin,arh,arm,"Chen_Sing.txt");
                    else  
                             getint(dep,inter,planename,dephr,demin,arh,arm,"Bang_Sing.txt");
                    //arr[numbers++]=new Flights(planename,deptime,artime);*/
                }
            }
            brstream.close();
            //bwstream.close(); 
                    
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Not found");
        }
    }
    void getFlight() throws IOException
    {
        System.out.println(src + "  "+ Date + "  "+ no);
        if(src.equals("Delhi"))
        {   
            dom(src,"Del_Kol.txt","Kolkata");
            dom(src,"Del_Bang.txt","Bangalore");
            dom(src,"Del_Hyd.txt","Hydrabad");
            dom(src,"Del_Chen.txt","Chennai");
        
        }
        else if(src.equals("Mumbai"))
        {
            dom(src,"mumbai_kolkata.txt","Kolkata");
            dom(src,"mumbai_bengaluru.txt","Bangalore");
            dom(src,"mumbai_hyderabad.txt","Hydrabad");
            dom(src,"mumbai_chennai.txt","Chennai");
        }
        else if(src.equals("Pune"))
         {
            dom(src,"Pun_Che.txt","Chennai");
            dom(src,"Pun_Hyd.txt","Hydrabad");
            dom(src,"Pun_Ban.txt","Bangalore");
        }  
    }
}

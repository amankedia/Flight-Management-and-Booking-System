/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightmanager;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 *
 * @author Aman Kedia
 */
public class FlightManager extends PersistanceManager {

    /**
     * @param args the command line arguments
     */
    void search(){
    PersistanceManager p1=new PersistanceManager();
    p1.readschedule();
    String day,depcity,arrcity;
           DayFromDate date1;
           date1 = new DayFromDate();
           int number=p1.fileno;
           //fileno 0 means before 25th oct & fileno 1 means after 25th october
           System.out.println("\n"+number);
           day = date1.datetoday(number);
           if(day!="")
           {
           String f=day.substring(0,3);
           System.out.println(day);
           System.out.println(f);
           Scanner s= new Scanner(System.in);
           System.out.print("Enter Departure city:");
           depcity=s.nextLine();
           System.out.print("Enter Arrival city:");
           arrcity=s.nextLine();
           System.out.println("The city you have chosen for departure is:"+depcity);
           System.out.println("The city you have chosen for arrival is:"+arrcity);
           System.out.println("Enter the number of seats wanted:");
           int seats_reqd=s.nextInt();
           int cnt=0;
           int icnt[]=new int[50];
           int jcnt[]=new int[50];
           int seats_spice[]=new int[50];
           int seats_silk[]=new int[50];
           Arrays.fill(seats_spice,15);
           Arrays.fill(seats_silk,15);
    for(int i=0;i<p1.origin1.size();i++)
    {
        String ss1="";
        int flag=0;
        String ss = p1.origin1.get(i);
        for(int a=0;a<ss.length();a++)
        {
            if(ss.charAt(a)!=' ')
            {
                ss1=ss1+ss.charAt(a);
            }
        }
        if(depcity.equalsIgnoreCase(ss1))
        {
                for(int k=0;k<7;k++)
                {
                    if(p1.f1[i][k]=="")
                        break;
                    else if(day.equalsIgnoreCase(p1.f1[i][k]))
                    {
                        String des1=p1.dest1.get(i).trim();
                        for(int j=0;j<p1.origin2.size();j++)
                        {
                            if(p1.origin2.get(j).trim().equalsIgnoreCase(des1))
                            {
                                for(int m=0;m<7;m++)
                                {
                                    if(p1.f2[j][m]=="")
                                        break;
                                    else if(f.equalsIgnoreCase(p1.f2[j][m]))
                                    {
                                        StringTokenizer aman=new StringTokenizer(p1.arrtime1.get(i),": ");
                                        String tm1=aman.nextToken();
                                        String tm2=aman.nextToken();
                                        String tm3=aman.nextToken();
                                        int hours=Integer.parseInt(tm1);
                                        int minutes=Integer.parseInt(tm2);     
                                        if(tm3.equalsIgnoreCase("PM"))
                                            hours=hours+12;
                                        int spice_dur=hours*60+minutes;
                                        String silk_tm=p1.deptime2.get(j);
                                        int silk_time=Integer.parseInt(silk_tm);
                                        int silk_hours=silk_time/100;
                                        int silk_minutes=silk_time%100;
                                        int silk_dur=silk_hours*60+silk_minutes;
                                        int diffdur=silk_dur-spice_dur;
                                        if(diffdur>120&&diffdur<360)
                                        {
                                            if(seats_reqd<=seats_spice[i]&&seats_reqd<=seats_silk[j])
                                            {
                                                icnt[cnt]=i;
                                                jcnt[cnt]=j;
                                                //System.out.println(i+" "+j);
                                                cnt++;
                                                System.out.println(cnt+"."+day+" "+p1.origin1.get(i)+" "+p1.dest1.get(i)+" "+p1.flytno1.get(i)+" "+p1.deptime1.get(i)+" "+p1.arrtime1.get(i)+" "+p1.via.get(i)+" "+p1.flytno2.get(j)+" "+p1.deptime2.get(j)+" "+p1.arrtime2.get(j));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        flag=1;
                        break;
                    }
                }
        }
    }
    System.out.println("Enter your choice no:");
    int choice=s.nextInt();
    seats_spice[icnt[choice-1]]-=seats_reqd;
    seats_silk[jcnt[choice-1]]-=seats_reqd;
    for(int d=0;d<41;d++)
        System.out.print(seats_spice[d]+" ");
    System.out.println();
    for(int d=0;d<8;d++)
        System.out.print(seats_silk[d]+" ");
    System.out.println();
   }
    }
    public static void main(String[] args) {
           
           FlightManager p= new FlightManager();
           p.search();
    }
    
}

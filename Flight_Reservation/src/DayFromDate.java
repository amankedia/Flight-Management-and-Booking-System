/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightmanager;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author Aman Kedia
 */

public class DayFromDate {
    public String datetoday(int number)
    {
    //fileno 0 means before 25th oct & fileno 1 means after 25th october
    System.out.println("Enter the date(dd/mm/yyyy):");
    Scanner s=new Scanner(System.in);
    String Date=s.nextLine();
    String day,r="";
        day = "0";
    try{
        boolean dateValid=dateValidate(Date,number);
        if(dateValid==true)
        {
            SimpleDateFormat d = new SimpleDateFormat( "dd/MM/yy" );  
            java.util.Date date = d.parse(Date);   
            d.applyPattern( "EEEEEE" );  
            day= d.format( date );//the variable day contains which day is that date 
        }
        else
        {
            System.out.println("Invalid Date!!!");
            return r;
        }
    }
    catch(Exception e)
    {
        System.out.println("Invalid Date Formats!!!");
        return r;
    }
    return day;
 }

public static boolean dateValidate(String d,int number)

 {
//fileno 0 means before 25th oct & fileno 1 means after 25th october
    String dateArray[]= d.split("/");
    int day=Integer.parseInt(dateArray[0]);
    int month=Integer.parseInt(dateArray[1]);
    int year=Integer.parseInt(dateArray[2]);
    //System.out.print(day+"\n"+month+"\n"+year+"\n");
    if(number==0)
    {
        if(year!=2014)
            return false;
        if(month!=10||day>25)
        {
            return false;
        }
    }
    else if(number==1)
    {
        //System.out.println("abcf");
        if(year!=2014&&year!=2015)
        {
            //System.out.println("abcg");
            return false;
        }
        if(year==2014)
        {
        if(month>=1&&month<=9)
        {
            //System.out.println("abc");
            return false;
        }
        else if(month==10&&day<=25)
        {
            //System.out.println("abcd");
            return false;
        }
        }
        if(year==2015)
        {
        if(month==3&&day>28)
        {
            //System.out.println("abce");
            return false;
        }
        else if(month>=4)
            return false;
        }
    }
    boolean leapYear=false;
  if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
    {
         leapYear=true;
    }

    if(year>2099 || year<1900)
        return false;

    if(month<13)
    {
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
        {
            if(day>31)
                return false;
        }
        else if(month==4||month==6||month==9||month==11)
        {
            if(day>30)
                return false;
        }
        else if(leapYear==true && month==2)
        {
            if(day>29)
              return false;
        }
        else if(leapYear==false && month==2)
        {
            if(day>28)
              return false;
        }
        return true;    
    }
    else return false;
 }
}

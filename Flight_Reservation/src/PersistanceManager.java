/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightmanager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 *
 * @author Aman Kedia
 */
public class PersistanceManager {
    static String f1[][]=new String[100][100];
    static String f2[][]=new String[100][100];
    static ArrayList <String>remark=new ArrayList<>();
    static ArrayList <String>origin1=new ArrayList<>();
    static ArrayList <String>dest1=new ArrayList<>();
    static ArrayList <String>freq1=new ArrayList<>();
    static ArrayList <String>flytno1=new ArrayList<>();
    static ArrayList <String>deptime1=new ArrayList<>();
    static ArrayList <String>arrtime1=new ArrayList<>();
    static ArrayList <String>via=new ArrayList<>();
    static ArrayList <String>efrom=new ArrayList<>();
    static ArrayList <String>etill=new ArrayList<>();
    static ArrayList <String>origin2=new ArrayList<>();
    static ArrayList <String>dest2=new ArrayList<>(); 
    static ArrayList <String>freq2=new ArrayList<>();
    static ArrayList <String>flytno2=new ArrayList<>();
    static ArrayList <String>deptime2=new ArrayList<>();
    static ArrayList <String>arrtime2=new ArrayList<>();
    static int ab[]=new int[2];
    static int fileno=0;
    public void readschedule() 
	   {
	       int i=0,j=0;
	      String filename1="C:\\Users//Ashok//Downloads//spicejet.Schedule.csv";
	     File f=new File(filename1);
             
             try{
		Scanner br=new Scanner(f);
		br.nextLine();
                
                while(br.hasNext()){
                  
			String line=br.nextLine();
                         StringTokenizer st =new StringTokenizer(line,",");
              j=0;
                         while(st.hasMoreTokens()){
                             
                            origin1.add(i,st.nextToken());
                            dest1.add(i,st.nextToken());
                     
                            String temp=new String();
                            temp=(st.nextToken()).trim();
                            
                       
                            if(temp.charAt(0)=='"'){
                               
                                freq1.add(i,(temp+','));
                                int t=0;
                               
                                
                             while(temp.charAt((temp.length())-1)!='"'){
                                   
                                temp=(st.nextToken()).trim();
                  
                                    freq1.add(i,freq1.get(i)+temp+',');
                                    
                               }
                           }
                            
                            else{
                                if(temp.equals("Daily")){
                     freq1.add(i,"Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday");
                 }
                                else
                                {
                                 freq1.add(i,temp);
                            }
                            }
              int l=0;
             String s=freq1.get(i);
             StringTokenizer st1 =new StringTokenizer(s,",");
              j=0;
              String ss="",ss1="";
                while(st1.hasMoreTokens()){
                      ss=st1.nextToken();
                      int a=0;
                      while(a<ss.length())
                      {
                          if(ss.charAt(a)!='"')
                              ss1=ss1+ss.charAt(a);
                          a++;
                      }
                      f1[i][l++]=ss1;
                      ss1="";
                 j++;
                 }
                           flytno1.add(i,st.nextToken());
                           deptime1.add(i,st.nextToken());
                           arrtime1.add(i,st.nextToken());
                           via.add(i,st.nextToken());
                           efrom.add(i,st.nextToken());
                           etill.add(i,st.nextToken());
                           if(st.hasMoreTokens())
                               remark.add(i,st.nextToken());
                           else
                               remark.add(i," ");
                                }
                         i++;
             }   
                ab[0]=i;
                if(ab[0]==36)
                    fileno=1;
                //fileno 0 means before25th oct & fileno 1 means after 25th october
                System.out.print(ab[0]);
           }catch(FileNotFoundException e){
               e.printStackTrace();
           }
             catch(NullPointerException e){
                 e.printStackTrace();
             }
              String filename2="C:\\Users//Ashok//Downloads//silkair.Schedule.csv";
	     File file2=new File(filename2);
             try{
		Scanner br2=new Scanner(file2);
		br2.nextLine();
                br2.nextLine();
                br2.nextLine(); 
                i=0;
		while(br2.hasNext()){
                  
			String line=br2.nextLine();
                        StringTokenizer st =new StringTokenizer(line,",(/");
                        while(st.hasMoreTokens()){
                        origin2.add(i,st.nextToken().toUpperCase());
                        st.nextToken();
                        String temp=new String();
                            temp=(st.nextToken()).trim();
                       
                            if(temp.charAt(0)=='"'){
                                freq2.add(i,(temp+','));
                               
                                int t=0;
                               
                                
                             while(temp.charAt((temp.length())-1)!='"'){
                                   
                                temp=(st.nextToken()).trim();
                  
                                    freq2.add(i,freq2.get(i)+temp+',');
                   
                               }
                            }
                            int l=0;
                            String s1=freq2.get(i);
             StringTokenizer st2 =new StringTokenizer(s1,",");
              j=0;
                String ss="",ss1="";
                while(st2.hasMoreTokens()){
                      ss=st2.nextToken();
                      int a=0;
                      while(a<ss.length())
                      {
                          if(ss.charAt(a)!='"')
                              ss1=ss1+ss.charAt(a);
                          a++;
                      }
                      f2[i][l++]=ss1;
                      ss1="";
                 j++;
                 //System.out.print(f2[i][l]+" ");
                 }
                 //System.out.println();
                            flytno2.add(i,st.nextToken());
                            deptime2.add(i,st.nextToken());
                            arrtime2.add(i,st.nextToken());
                            
                         }
                         i++;
                }
                ab[1]=i;
             }catch(FileNotFoundException e){
               e.printStackTrace();
           }             
             
           }


}

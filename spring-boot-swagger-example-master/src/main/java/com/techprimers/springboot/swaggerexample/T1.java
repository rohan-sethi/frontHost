package com.techprimers.springboot.swaggerexample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class T1 {
	
	static public  JSONObject topData() throws IOException  {
		 BufferedReader sb;
			
			sb = new BufferedReader(new FileReader("C:\\Users\\rohansethi\\Desktop\\topData1new1.txt"));
		Scanner s=null ;
		

		JSONObject j = new JSONObject();
		JSONObject json = new JSONObject();
		JSONObject jsonIn = new JSONObject();

       String lin= sb.readLine();
		
		int i =1;
		while(lin!=null){
			if(lin==null)break;
			
			String line = lin;
			System.out.println(line);
			String[] tokens = line.split("breakmeup");
			
			String id,title,channel,vc,lc,dl,cc,isAuto;
			
			id= tokens[0];
			title= tokens[1];
			channel= tokens[2];
			vc= tokens[3];
			lc= tokens[4];
			dl= tokens[5];
			cc= tokens[6];
			isAuto=tokens[7];
			jsonIn = new JSONObject();
			jsonIn.put("id",id);
			jsonIn.put("title",title);
			jsonIn.put("channel",channel);
			jsonIn.put("views",vc);
			jsonIn.put("likes",lc);
			jsonIn.put("dislikes",dl);
			jsonIn.put("comments",cc);
			jsonIn.put("isAuto",isAuto);
			
			json.put(i, jsonIn);
			System.out.println(i);
			i++;	
			lin=sb.readLine();
		}
		
		j.put("first",json);
		
		json = new JSONObject();
		 i =1;
		 try {
		 
		
			sb = new BufferedReader(new FileReader("C:\\Users\\rohansethi\\Desktop\\topData2new2.txt"));
	
		 String inline = sb.readLine();
			while(inline !=null){
				
				
				if(inline==null)break;
				String[] tokens = inline.split("breakmeup");
				
				String id,title,channel,vc,lc,dl,cc,isAuto;
				
				id= tokens[0];
				title= tokens[1];
				channel= tokens[2];
				vc= tokens[3];
				lc= tokens[4];
				dl= tokens[5];
				cc= tokens[6];
				isAuto=tokens[7];
				jsonIn = new JSONObject();
				jsonIn.put("id",id);
				jsonIn.put("title",title);
				jsonIn.put("channel",channel);
				jsonIn.put("views",vc);
				jsonIn.put("likes",lc);
				jsonIn.put("dislikes",dl);
				jsonIn.put("comments",cc);
				jsonIn.put("isAuto",isAuto);
				
				json.put(i, jsonIn);
				
				i++;	
				inline= sb.readLine();
			}
		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			j.put("second",json);
		
			json = new JSONObject();
			 i =1;
			 try {
			//	s= new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\topData3new.txt"));
				sb = new BufferedReader(new FileReader("C:\\Users\\rohansethi\\Desktop\\topData3new3.txt"));
			String l = sb.readLine();
				while(l!=null){
					
					String[] tokens = l.split("breakmeup");
					
					String id,title,channel,vc,lc,dl,cc,isAuto;
					
					id= tokens[0];
					title= tokens[1];
					channel= tokens[2];
					vc= tokens[3];
					lc= tokens[4];
					dl= tokens[5];
					cc= tokens[6];
					isAuto=tokens[7];
					jsonIn = new JSONObject();
					jsonIn.put("id",id);
					jsonIn.put("title",title);
					jsonIn.put("channel",channel);
					jsonIn.put("views",vc);
					jsonIn.put("likes",lc);
					jsonIn.put("dislikes",dl);
					jsonIn.put("comments",cc);
					jsonIn.put("isAuto",isAuto);
					
					json.put(i, jsonIn);
					
					i++;
					l = sb.readLine();
				}
				
				j.put("third",json);
			
		sb.close();
		System.out.println(j);
			 } catch (FileNotFoundException e) {
					
				} 
		return j;
		
	}

	public static void main(String[] args) throws ParseException, IOException {
		

	//	System.out.println(T1.topData());
		
		Writer wr = new FileWriter("C:\\Users\\rohansethi\\Desktop\\topData3new.txt");
		Scanner s=null ;
		 s= new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\top50.txt"));
		 Scanner s1=null ;
		 s1= new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\topData3.txt"));
		/* Scanner s2=null ;
		 s2= new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\topData2.txt"));
		 Scanner s3=null ;
		 s3= new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\topData3.txt"));*/
		 List<String> top = new ArrayList<>();
		 while(s.hasNext()){		
			 top.add(s.nextLine());
		 }
		 
		 System.out.println(top);
		 JSONObject json;
		 while(s1.hasNext()){
			 
			 String line = s1.nextLine();
			 
			 String[] tokens = line.split("breakmeup");
				
				String id,title,channel,vc,lc,dl,cc;
				
				id= tokens[0];
				title= tokens[1];
				channel= tokens[2];
				vc= tokens[3];
				lc= tokens[4];
				dl= tokens[5];
				cc= tokens[6];
				
				if(top.contains(id))
				{
					
					wr.write(line+"breakmeup1");
					wr.write(System.getProperty( "line.separator" ));	
					
				}
				else
				{
					wr.write(line+"breakmeup0");
					wr.write(System.getProperty( "line.separator" ));	
					
				}
				
				System.out.println(id);
				
				
				
		 }
		 
		 wr.flush();
		 wr.close();
		 
	}

}

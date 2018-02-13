import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Tt {
	
	
	public static void main(String[] args) throws ParseException, IOException {
		

		//	System.out.println(T1.topData());
			
			Writer wr = new FileWriter("C:\\Users\\rohansethi\\Desktop\\topData1new1.txt");
			Scanner s=null ;
			 s= new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\topData1new.txt"));
			
			 List<String> top = new ArrayList<>();
			 while(s.hasNext()){		
				 top.add(s.nextLine());
			 }
			 
			 System.out.println(top);
			 /*JSONObject json;
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
*/	
			 
			 wr.flush();
			 wr.close();
	}

}

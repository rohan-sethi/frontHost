package com.techprimers.springboot.swaggerexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import com.techprimers.springboot.swaggerexample.resource.Util;

public class Test {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		
		
		Writer wr1 = new FileWriter("C:\\Users\\rohansethi\\Desktop\\topData1.txt");
		Writer wr2 = new FileWriter("C:\\Users\\rohansethi\\Desktop\\topData2.txt");
		Writer wr3 = new FileWriter("C:\\Users\\rohansethi\\Desktop\\topData3.txt");
	
		Scanner sfiltered =new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\topFilterData.txt"));
		Scanner stop =new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\top50Data.txt"));
		int i=1;
		while(stop.hasNext()){
			
			wr1.write(sfiltered.nextLine());
			wr1.write(System.getProperty("line.separator"));
			
			wr2.write(sfiltered.nextLine());
			wr2.write(System.getProperty("line.separator"));
			
			wr3.write(sfiltered.nextLine());
			wr3.write(System.getProperty("line.separator"));
			
			if(i==4){wr1.write(stop.nextLine());wr1.write(System.getProperty("line.separator"));}
			
			if(i==8){wr2.write(stop.nextLine());	wr2.write(System.getProperty("line.separator"));}
			
			if(i==12){i=0;wr3.write(stop.nextLine());wr3.write(System.getProperty("line.separator"));}
			
			i++;
			System.out.println(i);
			
		}
		
		wr1.flush();
		wr1.close();
		
		wr2.flush();
		wr2.close();
		
		wr3.flush();
		wr3.close();
		sfiltered.close();
		stop.close();
		/*String idQuery = " SELECT videoId, title, id FROM tubedata GROUP BY  videoId, title  HAVING COUNT(*) > 1";
		try (Connection conn = Util.getUtil().getConnection();
		//		PreparedStatement psmt = conn.prepareStatement(query);
				PreparedStatement psmtforId = conn.prepareStatement(idQuery);) {
			ResultSet rs = psmtforId.executeQuery();
			while(rs.next()){
				
				System.out.println(rs.getString("videoId"));
				String query = "delete from tubedata where id = ?";
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setInt(1,rs.getInt("id"));

			      // execute the preparedstatement
			      preparedStmt.execute();
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		*/
		
		// SELECT videoId, title FROM tubedata GROUP BY  videoId, title  HAVING COUNT(*) > 1;
		
		
		
		
		/*//new FileReader("e://package.json")
		JSONObject  arrayObj   = (JSONObject) new JSONParser().parse(new FileReader("e://package.json"));
		
		JSONArray array = (JSONArray) arrayObj.get("arr");
        
		Iterator iter = array.iterator();
		
		
		while (iter.hasNext()) {
			
			JSONObject  item = (JSONObject) (iter.next());
			
			System.out.println(item);
	       // System.out.println(item.get("videoId"));
	    }
		
	*/
	
	}
	
	
}

package com.techprimers.springboot.swaggerexample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.techprimers.springboot.swaggerexample.resource.Util;

public class Test4 {

public static void main(String[] args) throws IOException, SQLException {
		
		ArrayList<String> arr = new ArrayList<>();
	
		
		Writer wr = new FileWriter("C:\\Users\\rohansethi\\Desktop\\topFilterData.txt");
		
		Scanner s =new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\topData.txt"));
		//s.useDelimiter("\n");
		String idQuery;
		Connection conn = Util.getUtil().getConnection();
		PreparedStatement psmtforId;
		int i =0;
		try{
		while(s.hasNext()){
			
			String val = s.nextLine();
		System.out.println(val);
			idQuery = " SELECT * from tubedata where videoId=?";
			psmtforId = conn.prepareStatement(idQuery);
			psmtforId.setString(1,val);
			ResultSet rs = psmtforId.executeQuery();
			rs.next();
			
			wr.write(rs.getString("videoId")+"breakmeup"+rs.getString("title")+"breakmeup"+
					rs.getString("channelTitle")+"breakmeup"+rs.getString("viewCount")+"breakmeup"+
					rs.getString("likeCount")+"breakmeup"+rs.getString("dislikeCount")+"breakmeup"+rs.getString("commentCount"));
			wr.write(System.getProperty( "line.separator" ));

			System.out.println(i++);
			
			
		}
		}
		catch(Exception e ){
			wr.flush();
			wr.close();
		}
		
		
	
		
		
				

			
	
		
		
	}


}

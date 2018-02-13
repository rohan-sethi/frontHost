package com.techprimers.springboot.swaggerexample;

import java.io.File;
import java.io.FileNotFoundException;
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

public class Test3 {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> arr = new ArrayList<>();
	
		
		Writer wr = new FileWriter("C:\\Users\\rohansethi\\Desktop\\topData.txt");
		Scanner s =new Scanner(new File("C:\\Users\\rohansethi\\Desktop\\top50.txt"));
		
		while(s.hasNext()){
			
			arr.add(s.nextLine());
			
		}
		
		System.out.println(arr);
		String idQuery = " SELECT id,videoId,title from tubedata order by CAST(viewCount AS UNSIGNED ) desc LIMIT 1000";
		int i=1;
		
		try (Connection conn = Util.getUtil().getConnection();
		//		PreparedStatement psmt = conn.prepareStatement(query);
				PreparedStatement psmtforId = conn.prepareStatement(idQuery);) {
			ResultSet rs = psmtforId.executeQuery();
			while(rs.next()){
		if(rs.getString("title").matches("\\A\\p{ASCII}*\\z") && !arr.contains(rs.getString("videoId"))){
			
			System.out.println(rs.getString("title")+"  "+rs.getInt("id"));
			wr.write(rs.getString("videoId"));
			wr.write(System.getProperty( "line.separator" ));
			i++;
			
		}
			
			}
			
			System.out.println(i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		wr.flush();
		wr.close();
		
	}

}

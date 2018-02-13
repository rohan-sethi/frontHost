package com.techprimers.springboot.swaggerexample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import com.techprimers.springboot.swaggerexample.resource.Util;

public class Test2 {
	
public static JSONObject getList(){
		

	
	
		return new JSONObject();
		
	}
	
	
	
	
	public static JSONObject getMapData(){
		
		
		
		Map<String,String> ids = new HashMap<>();
		
		
		String idQuery = " SELECT id,videoId from tubedata";
		try (Connection conn = Util.getUtil().getConnection();
		//		PreparedStatement psmt = conn.prepareStatement(query);
				PreparedStatement psmtforId = conn.prepareStatement(idQuery);) {
			ResultSet rs = psmtforId.executeQuery();
			while(rs.next()){
				
		//		System.out.println(rs.getString("videoId"));
				ids.put(rs.getInt("id")+"",rs.getString("videoId"));
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		JSONObject arr = new JSONObject();
		arr.putAll(ids);
		return arr;
		
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		
		Map<String,String> ids = new HashMap<>();
		
		
		String idQuery = " SELECT id,videoId from tubedata LIMIT 10";
		try (Connection conn = Util.getUtil().getConnection();
		//		PreparedStatement psmt = conn.prepareStatement(query);
				PreparedStatement psmtforId = conn.prepareStatement(idQuery);) {
			ResultSet rs = psmtforId.executeQuery();
			while(rs.next()){
				
				//System.out.println(rs.getString("videoId"));
				ids.put(rs.getInt("id")+"",rs.getString("videoId"));
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		JSONObject arr = new JSONObject();
		arr.putAll(ids);
		
		System.out.println(arr);
		
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

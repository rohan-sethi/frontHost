package org.sample.rest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Test {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		
		
		
		JSONObject  arrayObj   = (JSONObject) new JSONParser().parse(new FileReader("e://package.json"));
		
		JSONArray array = (JSONArray) arrayObj.get("arr");
        
		Iterator iter = array.iterator();
		
		
		while (iter.hasNext()) {
			
			JSONObject  item = (JSONObject) (iter.next());
			
			System.out.println(item);
	        System.out.println(item.get("videoId"));
	        System.out.println(null == item.get("vijjjdeoId"));
	    }
		
	
	
	}
	
	
}

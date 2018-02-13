package com.techprimers.springboot.swaggerexample.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import com.techprimers.springboot.swaggerexample.T1;
import com.techprimers.springboot.swaggerexample.Test2;
import com.techprimers.springboot.swaggerexample.resource.Util;



@RestController
@RequestMapping("/rest/getListId")
@Api(value = "HelloWorld Resource", description = "shows hello world")
public class HelloResource {

	
	
  
    @RequestMapping(  value = "/stats", method = RequestMethod.POST,consumes = "text/plain")
    @ApiOperation(value = "Returns stats of youtube")

    public String helloStats(@RequestBody  String hello) {
		
    	JSONObject arrayObj;
    
    	if(hello==null)return "";
    	
    		try {
				arrayObj = (JSONObject) new JSONParser().parse(hello);
				System.out.println(arrayObj.get("id").toString());
				
			 String viewCount= arrayObj.get("viewCount") != null? arrayObj.get("viewCount").toString():"-";
			 String likeCount= arrayObj.get("likeCount") != null? arrayObj.get("likeCount").toString():"-";
			 String dislikeCount= arrayObj.get("dislikeCount")!= null? arrayObj.get("dislikeCount").toString():"-";
			 String favoriteCount= arrayObj.get("favoriteCount") != null? arrayObj.get("favoriteCount").toString():"-";
			 String commentCount= arrayObj.get("commentCount") != null? arrayObj.get("commentCount").toString():"-";

				
				
String query = "update tubedata set viewCount=?,likeCount=?,dislikeCount=?,favoriteCount=?,commentCount=? where id=?";
				try (Connection conn = Util.getUtil().getConnection(); PreparedStatement psmt = conn.prepareStatement(query)) {
					psmt.setString(1, viewCount);
					psmt.setString(2, likeCount);
					psmt.setString(3, dislikeCount);
					psmt.setString(4, favoriteCount);
					psmt.setString(5, commentCount);
					psmt.setString(6, arrayObj.get("id").toString());
					psmt.executeUpdate();
				} catch (SQLException |NullPointerException e) {
					System.out.println(e);
				}
 
    		
            
            
            
    		} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	return hello;
    }
	
	
	
    @RequestMapping(  value = "/getvid", method = RequestMethod.GET)
    public JSONObject getListVideos() throws IOException {
    	
    	
    		return T1.topData();   
    }   
	
	
	
    @ApiOperation(value = "Returns Hello World")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful Hello World")
            }
    )
    @GetMapping
    public JSONObject hello() {
        return Test2.getMapData();
    }
    @RequestMapping(  value = "/post", method = RequestMethod.POST,consumes = "text/plain")
    @ApiOperation(value = "Returns Hello World")

    public String helloPost(@RequestBody  String hello) {
    	boolean added =true;
    	
    	hello = hello.replaceAll("\\\\x\\p{XDigit}{2}", "");
    	//System.out.println(hello);
	JSONObject arrayObj;
	try {
		arrayObj = (JSONObject) new JSONParser().parse(hello);
        JSONArray array = (JSONArray) arrayObj.get("arr");
        System.out.println(array);
		Iterator iter = array.iterator();
	
		
	while (iter.hasNext()) {
			
			JSONObject  item = (JSONObject) (iter.next());
			
		//	System.out.println(item);
	       // System.out.println(item.get("videoId"));
			
			
			 added = true;
			String query = "insert into tubedata(publishedAt,fromTime,videoId,title,url,toTime,channelTitle) values(?,?,?,?,?,?,?)";
			try (Connection conn = Util.getUtil().getConnection(); PreparedStatement psmt = conn.prepareStatement(query)) {
				psmt.setString(1, item.get("publishedAt").toString());
				psmt.setString(2, item.get("fromTime").toString());
				psmt.setString(3, item.get("videoId").toString());
				psmt.setString(4, item.get("title").toString());
				psmt.setString(5, item.get("url").toString());
				psmt.setString(6, item.get("toTime").toString());
				psmt.setString(7, item.get("channelTitle").toString());
			
				int status = psmt.executeUpdate();
				if (status == 0) {
					added = false;
				}
			} catch (SQLException |NullPointerException e) {
				System.out.println("null");
			}
	    }
    	
	
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
		
	
    	
        return added+"";
    }

    @ApiOperation(value = "Returns Hello World")
    @PutMapping("/put")
    public String helloPut(@RequestBody final String hello) {
        return hello;
    }
}


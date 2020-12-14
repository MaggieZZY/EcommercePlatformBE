package com.mercury.FinalProjectDemo.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercury.FinalProjectDemo.http.Response;

public class SecurityUtil {
	
	private static final ObjectMapper mapper = new ObjectMapper();

    public static void sendResponse(HttpServletResponse response, int status, String message, Exception exception) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        
//        mapper.writeValueAsString(new Object());// convert a Java object into JSON format string
//        mapper.readValue(new Object(), "abc");	// convert a JSON format string into an java object
        
        writer.write(mapper.writeValueAsString(new Response(exception == null ? true : false, status, message))); // write to replace
        response.setStatus(status);
        writer.flush();
        writer.close();
    }
	
}

package rpc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class RpcHelper
 */
@WebServlet("/RpcHelper")
public class RpcHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RpcHelper() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static void writeJsonArray(HttpServletResponse response, JSONArray array) throws IOException {
 		PrintWriter out = response.getWriter();	
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		out.print(array);
		out.close();
 	}

    // Writes a JSONObject to http response.
 	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) throws IOException {		
 		PrintWriter out = response.getWriter();	
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		out.print(obj);
		out.close();
 	}

 	public static JSONObject readJSONObject(HttpServletRequest request) {
 		StringBuilder sBuilder = new StringBuilder();
		try (BufferedReader reader = request.getReader()) {
 			String line = null;
 			while((line = reader.readLine()) != null) {
 				sBuilder.append(line);
 			}
 			return new JSONObject(sBuilder.toString());
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return new JSONObject();
 	}
}

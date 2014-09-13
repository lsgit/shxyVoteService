package com.shxy.votes.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

public class CheckServer extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Ckecks c = new Ckecks();
		c.setResult("success");
		String s=JSON.toJSONString(c);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(s);	
		out.flush();
		out.close();
	}

}
class Ckecks{
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String s) {
		this.result = s;
	}
	
}

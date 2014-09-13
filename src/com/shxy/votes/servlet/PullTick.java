package com.shxy.votes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.shxy.votes.dao.TickDao;


public class PullTick extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		class Results{
			private String result;

			public String getResult() {
				return result;
			}

			public void setResult(String result) {
				this.result = result;
			}
		}
		Results result = new Results();
		String s = null;
		request.setCharacterEncoding("utf-8");
		int voteid = Integer.parseInt(request.getParameter("vid"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		String imei = request.getParameter("imei");
		//获取score若为null代表是投票项目 否则是评分项目
		String scoreString = request.getParameter("score");
		TickDao tdao = new TickDao();
		Boolean b = true;
		if (scoreString==null) {
			b=tdao.pullTick(voteid, cid, imei);
		} else {
			b=tdao.pullTick(voteid, cid, imei, Double.parseDouble(scoreString));
		}
		
		if(b){
			s="success";
		}else{
			s="failed";
		}

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		result.setResult(s);
		String ss = JSON.toJSONString(result);
		out.print(ss);
		out.flush();
		out.close();
		result.setResult(s);
		
	}

}

package com.shxy.votes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.shxy.votes.dao.VoteDao;
import com.shxy.votes.domain.VoteBean;

public class getVoteList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		List<VoteBean> list = new VoteDao().voteALLList(page);
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String s = JSON.toJSONString(list);
		out.print(s);
		out.flush();
		out.close();
	}

}

package com.shxy.votes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shxy.votes.domain.CandidateBean;
import com.shxy.votes.util.JdbcUtils;

public class CandiadateDao 
{
	public List<CandidateBean> getCandList(int voteId,String imei){
		//判断当前的投票类型 确定SQL 语句 1投票项目 0评分项目
		
		int flag = new VoteDao().getVoteType(voteId);
		String sql = null;
		switch (flag) {
		case 0:
			sql = "select candidate_id,candidate_name from t_candidate where candidate_id not in (select candidate_id from t_tick where tick_imei = ?) and vote_id = ?";
			break;
		case 1:
			sql = "select candidate_name,candidate_id from t_candidate where not exists (select candidate_id from t_tick where tick_imei = ? and vote_id = ?)and vote_id = ?";
			break;
		default:
			break;
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CandidateBean> candList = new ArrayList<CandidateBean>();
		try{
			conn = JdbcUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, imei);
			stmt.setInt(2, voteId);
			if(flag==1){
				stmt.setInt(3, voteId);
			}
			rs = stmt.executeQuery();
System.out.println(sql);
			while(rs.next()){
				CandidateBean cander = new CandidateBean();
				cander.setId(rs.getInt("candidate_id"));
				cander.setName(rs.getString("candidate_name"));
				cander.setVoteId(voteId);
System.out.println(cander.getName());
				candList.add(cander);
			}
			return candList;
		}catch(Exception e){
		}finally{
			JdbcUtils.release(rs, stmt, conn);
		}
		return null;
		
	}
}

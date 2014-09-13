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
			sql = "select DISTINCT t_candidate.candidate_id,t_candidate.candidate_name from t_candidate join t_tick on t_tick.vote_id = t_candidate.vote_id join t_vote on t_vote.vote_id = t_candidate.vote_id join t_rule on t_rule.rule_id = t_vote.rule_id where t_rule.rule_ticks > (select count(*) from t_tick where t_tick.vote_id =t_candidate.vote_id and t_tick.tick_imei = ? ) and t_candidate.vote_id = ? and t_candidate.candidate_id not in (select candidate_id from t_tick where t_tick.tick_imei = ? );";
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
				stmt.setString(3, imei);
			}
			rs = stmt.executeQuery();
//System.out.println(sql);
			while(rs.next()){
				CandidateBean cander = new CandidateBean();
				cander.setId(rs.getInt("candidate_id"));
				cander.setName(rs.getString("candidate_name"));
				cander.setVoteId(voteId);
//System.out.println(cander.getName());
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

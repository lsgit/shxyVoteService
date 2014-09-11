package com.shxy.votes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shxy.votes.domain.VoteBean;
import com.shxy.votes.domain.VotingRuleBean;
import com.shxy.votes.util.JdbcUtils;

public class VoteDao {
	
	/**
	 * 查找数据库 返回当前的投票项目列表 条件查询
	 * @param flag 0代表已结束的投票项目 1 代表正在进行的投票项目
	 * @return 投票项目列表
	 */
	public List<VoteBean> voteList(int flag,int page){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<VoteBean> voteList = new ArrayList<VoteBean>();
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select vote_id,vote_title,vote_text,rule_id,vote_date from t_vote where vote_flag=? ORDER BY vote_id DESC limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, flag);
			stmt.setInt(2, (page-1)*10);
			stmt.setInt(3, 10);
			rs = stmt.executeQuery();
			while(rs.next()){
				VoteBean voteBean = new VoteBean();
				voteBean.setId(rs.getInt("vote_id"));
				voteBean.setTitle(rs.getString("vote_title"));
				voteBean.setText(rs.getString("vote_text"));
				VotingRuleBean rule = new RuleDao().getRule(rs.getInt("rule_id"));
				voteBean.setDate(rs.getString("vote_date"));
				voteBean.setVoteFlag(flag);
				voteBean.setRule(rule);
				voteList.add(voteBean);
			}
			return voteList;
		}catch(Exception e){
		}finally{
			JdbcUtils.release(rs, stmt, conn);
		}
		return null;
	}
}

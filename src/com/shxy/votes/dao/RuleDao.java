package com.shxy.votes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shxy.votes.domain.VoteBean;
import com.shxy.votes.domain.VotingRuleBean;
import com.shxy.votes.util.JdbcUtils;

public class RuleDao {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	/**
	 *  返回一个规则Bean对象
	 * @param id 规则主键
	 * @return
	 */
	public VotingRuleBean getRule(int id){
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select rule_id,rule_judge,rule_range from t_rule where rule_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			VotingRuleBean ruleBean = null;
			if(rs.next()){
				ruleBean = new VotingRuleBean();
				ruleBean.setId(rs.getInt("rule_id"));
				ruleBean.setJudge(rs.getInt("rule_judge"));
				ruleBean.setRange(rs.getString("rule_range"));
				return ruleBean;
			}
			return ruleBean;
		}catch(Exception e){
			
		}finally{
			JdbcUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	
}

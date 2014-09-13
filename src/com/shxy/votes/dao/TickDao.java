package com.shxy.votes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shxy.votes.domain.VoteBean;
import com.shxy.votes.domain.VotingRuleBean;
import com.shxy.votes.util.JdbcUtils;

public class TickDao 
{
	/**
	 * 投一个评分票
	 * @param vid
	 * @param cid
	 * @param imei
	 * @param score
	 * @return
	 */
	public boolean pullTick(int vid,int cid,String imei,double score)
	{
		boolean flag = false;
		//判断能否插入 若不能跳出函数直接返回false 插入规则当前返回的候选人列表不为空
		CandiadateDao cdao = new CandiadateDao();
		if(cdao.getCandList(vid, imei).size()==0){
			return false;
		}
		if(!(this.judgeNotExist(vid, cid, imei))){
			return false;
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			VoteDao vdao = new VoteDao();
			//1 投票项目 0 评分项目
			int ruleFlag = vdao.getVoteType(vid);
			String sql=null;
			if (ruleFlag==1) {
				sql= "insert into t_tick (vote_id,candidate_id,tick_imei)values(?,?,?)";
			}else{
				sql= "insert into t_tick (vote_id,candidate_id,tick_imei,tick_score)values(?,?,?,?)";
			}
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vid);
			stmt.setInt(2, cid);
			stmt.setString(3, imei);
			if(ruleFlag==0){
				stmt.setDouble(4, score);
			}
			stmt.executeUpdate();
			flag = true;
		}catch(Exception e){
			
		}finally{
			JdbcUtils.release(rs, stmt, conn);
		}
		return flag;
	}
	/**
	 * 投一个选票
	 * @param vid
	 * @param cid
	 * @param imei
	 * @return
	 */
	public boolean pullTick(int vid,int cid,String imei){
		return pullTick(vid, cid, imei, 0);
	}
	/**
	 * 判断当前票不存在  不存在返回true 否则返回false
	 * @param vid
	 * @param cid
	 * @param imei
	 * @return
	 */
	public boolean judgeNotExist(int vid,int cid,String imei){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select tick_id from t_tick where vote_id=? and candidate_id=? and tick_imei=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vid);
			stmt.setInt(2, cid);
			stmt.setString(3, imei);
			rs = stmt.executeQuery();
			if(rs.next()){
				return false;
			}
			return true;
		}catch(Exception e){
		}finally{
			JdbcUtils.release(rs, stmt, conn);
		}
		return false;
	}
}

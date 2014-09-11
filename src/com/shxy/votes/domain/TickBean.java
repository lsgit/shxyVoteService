package com.shxy.votes.domain;
/**
 * 一个票Bean
 * @author lanou3g
 *
 */
public class TickBean {
	private int id;
	/**
	 * 投票项目id
	 */
	private int voteId;
	/**
	 * 获选人id
	 */
	private int canadidateId;
	/**
	 * 分数
	 */
	private double score;
	/**
	 * 用户唯一标识ʶ
	 */
	private String imei;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public int getCanadidateId() {
		return canadidateId;
	}
	public void setCanadidateId(int canadidateId) {
		this.canadidateId = canadidateId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	
}

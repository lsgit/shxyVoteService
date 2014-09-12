package com.shxy.votes.domain;

/**
 * 获选人Bean
 * @author lanou3g
 *
 */
public class CandidateBean {
	private int id;
	/**
	 * 投票项目id
	 */
	private int voteId;
	private String name;
	/**
	 * 最终得分
	 */
	private double finalScore;
	/**
	 * 最终项目
	 */
	private int finalTicks;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(double finalScire) {
		this.finalScore = finalScire;
	}
	public int getFinalTicks() {
		return finalTicks;
	}
	public void setFinalTicks(int finalTicks) {
		this.finalTicks = finalTicks;
	}
}

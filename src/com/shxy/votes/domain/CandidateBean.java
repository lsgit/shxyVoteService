package com.shxy.votes.domain;

/**
 * ��ѡ��Bean
 * @author lanou3g
 *
 */
public class CandidateBean {
	private int id;
	/**
	 * ͶƱ��Ŀ��id
	 */
	private int voteId;
	private String name;
	/**
	 * ���յ÷�
	 */
	private double finalScire;
	/**
	 * ���յ�Ʊ
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
	public double getFinalScire() {
		return finalScire;
	}
	public void setFinalScire(double finalScire) {
		this.finalScire = finalScire;
	}
	public int getFinalTicks() {
		return finalTicks;
	}
	public void setFinalTicks(int finalTicks) {
		this.finalTicks = finalTicks;
	}
}

package com.shxy.votes.domain;
/**
 * һ��ͶƱBean
 * @author lanou3g
 *
 */
public class TickBean {
	private int id;
	/**
	 * ͶƱ��Ŀ��id
	 */
	private int voteId;
	/**
	 * ѡͶƱid
	 */
	private int canadidateId;
	/**
	 * һ�ε÷�
	 */
	private double score;
	/**
	 * �û�Ψһ��ʶ
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

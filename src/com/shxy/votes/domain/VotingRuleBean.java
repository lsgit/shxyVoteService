package com.shxy.votes.domain;
/**
 * Í¶Æ±¹æÔòBean
 * @author lanou3g
 *
 */
public class VotingRuleBean {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJudge() {
		return judge;
	}
	public void setJudge(int judge) {
		this.judge = judge;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	private int judge;
	private String range;
}

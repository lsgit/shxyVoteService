package com.shxy.votes.domain;
/**
 * 投票Bean
 * @author lanou3g
 *
 */
public class VoteBean {

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public VotingRuleBean getRule() {
		return rule;
	}
	public void setRule(VotingRuleBean rule) {
		this.rule = rule;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String title;
	private String text;
	private VotingRuleBean rule;
	private String date;
	private int voteFlag;
	public int getVoteFlag() {
		return voteFlag;
	}
	public void setVoteFlag(int voteFlag) {
		this.voteFlag = voteFlag;
	}
}

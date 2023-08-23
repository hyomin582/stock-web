package com.naver.phone.dto;

public class PhoneDto {

	private String userid;
	private String userpw;
	private String checkpw;
	private String nickname;

	private String mbnm;
	private String mbph;
	private String mbad;
	private String mbgno;
	private String mbid;

	private String groupname;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getCheckpw() {
		return checkpw;
	}

	public void setCheckpw(String checkpw) {
		this.checkpw = checkpw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMbnm() {
		return mbnm;
	}

	public void setMbnm(String mbnm) {
		this.mbnm = mbnm;
	}

	public String getMbph() {
		return mbph;
	}

	public void setMbph(String mbph) {
		this.mbph = mbph;
	}

	public String getMbad() {
		return mbad;
	}

	public void setMbad(String mbad) {
		this.mbad = mbad;
	}

	public String getMbgno() {
		return mbgno;
	}

	public void setMbgno(String mbgno) {
		this.mbgno = mbgno;
	}

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@Override
	public String toString() {
		return "PhoneDto [userid=" + userid + ", userpw=" + userpw + ", checkpw=" + checkpw + ", nickname=" + nickname
				+ ", mbnm=" + mbnm + ", mbph=" + mbph + ", mbad=" + mbad + ", mbgno=" + mbgno + ", mbid=" + mbid
				+ ", groupname=" + groupname + "]";
	}
}

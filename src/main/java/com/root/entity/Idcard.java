package com.root.entity;

public class Idcard {
    private Integer id;

    private String username;

    private String idno;

    private String bankno;

    private String telphone;

    private String descption;

    private Integer num;

    private String loanno;

    private String contno;

    private String batchno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getDescption() {
        return descption;
    }

    public void setDescption(String descption) {
        this.descption = descption == null ? null : descption.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getLoanno() {
        return loanno;
    }

    public void setLoanno(String loanno) {
        this.loanno = loanno == null ? null : loanno.trim();
    }

    public String getContno() {
        return contno;
    }

    public void setContno(String contno) {
        this.contno = contno == null ? null : contno.trim();
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

	@Override
	public String toString() {
		String str= "Idcard [id=" + id + ", username=" + username + ", idno=" + idno + ", bankno=" + bankno + ", telphone="
				+ telphone + ", descption=" + descption + ", num=" + num + ", loanno=" + loanno + ", contno=" + contno
				+ ", batchno=" + batchno + "]";
	
		System.out.println(str);
		return str;
	}
    
    
    
}
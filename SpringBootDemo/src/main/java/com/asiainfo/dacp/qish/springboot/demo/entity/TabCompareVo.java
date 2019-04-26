package com.asiainfo.dacp.qish.springboot.demo.entity;


public class TabCompareVo {

	private String flag;
	private String mtabName;
	private String gtabName;
	private String mfieldName;
	private String gfieldName;
	private String mdatatype;
	private String gdatatype;
	private Integer mlength;
	private Object glength;
	
	
	
	public String getFlag() {
		return flag;
	}



	public void setFlag(String flag) {
		this.flag = flag;
	}



	public String getMtabName() {
		return mtabName;
	}



	public void setMtabName(String mtabName) {
		this.mtabName = mtabName;
	}



	public String getGtabName() {
		return gtabName;
	}



	public void setGtabName(String gtabName) {
		this.gtabName = gtabName;
	}



	public String getMfieldName() {
		return mfieldName;
	}



	public void setMfieldName(String mfieldName) {
		this.mfieldName = mfieldName;
	}



	public String getGfieldName() {
		return gfieldName;
	}



	public void setGfieldName(String gfieldName) {
		this.gfieldName = gfieldName;
	}



	public String getMdatatype() {
		return mdatatype;
	}



	public void setMdatatype(String mdatatype) {
		this.mdatatype = mdatatype;
	}



	public String getGdatatype() {
		return gdatatype;
	}



	public void setGdatatype(String gdatatype) {
		this.gdatatype = gdatatype;
	}



	public Integer getMlength() {
		return mlength;
	}



	public void setMlength(Integer mlength) {
		this.mlength = mlength;
	}



	public Object getGlength() {
		return glength;
	}



	public void setGlength(Object glength) {
		this.glength = glength;
	}



	public static void main(String[] args) {
		TabCompareVo tcv = new TabCompareVo();
		tcv.setFlag("1111");
		tcv.setGlength("234");
		MysqlDBUtil mdb = new MysqlDBUtil();
		String sql = "insert into dacp_tab_compare(flag,glength) values(?,?)";
		Object[] obj = {tcv.getFlag(),tcv.getGlength()};
		mdb.execUpdate(sql, obj);
	}
}

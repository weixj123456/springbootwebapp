package com.root.entity;

public class Channel {
    private Integer id;

    private String name;

    private String channelid;

    private String manager;

    private String projectleader;

    private String hexinnemdianid;

    private Integer productqixian;

    private String description;

    private String ipaddress;

    private Short portnumber;

    private String serviceip;

    private String filepath;

    private String docname;

    private Boolean isenable;

    private String lasttimestamp;

    private String cooperationtype;

    private Short status;

    private Boolean isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getProjectleader() {
        return projectleader;
    }

    public void setProjectleader(String projectleader) {
        this.projectleader = projectleader == null ? null : projectleader.trim();
    }

    public String getHexinnemdianid() {
        return hexinnemdianid;
    }

    public void setHexinnemdianid(String hexinnemdianid) {
        this.hexinnemdianid = hexinnemdianid == null ? null : hexinnemdianid.trim();
    }

    public Integer getProductqixian() {
        return productqixian;
    }

    public void setProductqixian(Integer productqixian) {
        this.productqixian = productqixian;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public Short getPortnumber() {
        return portnumber;
    }

    public void setPortnumber(Short portnumber) {
        this.portnumber = portnumber;
    }

    public String getServiceip() {
        return serviceip;
    }

    public void setServiceip(String serviceip) {
        this.serviceip = serviceip == null ? null : serviceip.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname == null ? null : docname.trim();
    }

    public Boolean getIsenable() {
        return isenable;
    }

    public void setIsenable(Boolean isenable) {
        this.isenable = isenable;
    }

    public String getLasttimestamp() {
        return lasttimestamp;
    }

    public void setLasttimestamp(String lasttimestamp) {
        this.lasttimestamp = lasttimestamp == null ? null : lasttimestamp.trim();
    }

    public String getCooperationtype() {
        return cooperationtype;
    }

    public void setCooperationtype(String cooperationtype) {
        this.cooperationtype = cooperationtype == null ? null : cooperationtype.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

	@Override
	public String toString() {
		String str= "Channel [id=" + id + ", name=" + name + ", channelid=" + channelid + ", manager=" + manager
				+ ", projectleader=" + projectleader + ", hexinnemdianid=" + hexinnemdianid + ", productqixian="
				+ productqixian + ", description=" + description + ", ipaddress=" + ipaddress + ", portnumber="
				+ portnumber + ", serviceip=" + serviceip + ", filepath=" + filepath + ", docname=" + docname
				+ ", isenable=" + isenable + ", lasttimestamp=" + lasttimestamp + ", cooperationtype=" + cooperationtype
				+ ", status=" + status + ", isdelete=" + isdelete + "]";
	  System.out.println(str);
	  return str;
	
	}
    
    
    
}
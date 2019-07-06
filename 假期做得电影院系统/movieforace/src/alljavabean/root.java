package alljavabean;

public class root {
    private String rootid="";
    private String rootname="";
    private String password="";
    private String phone="";
    private String recentime="";
    public String getRootid() {
        return rootid;
    }
    public void setRootid(String rootid) {
        this.rootid = rootid;
    }
    public String getRootname() {
        return rootname;
    }
    public void setRootname(String rootname) {
        this.rootname = rootname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRecentime() {
        return recentime;
    }
    public void setRecentime(String recentime) {
        this.recentime = recentime;
    }
    @Override
    public String toString() {
	return "root [rootid=" + rootid + ", rootname=" + rootname + ", password=" + password + ", phone=" + phone
		+ ", recentime=" + recentime + "]";
    }
    


}

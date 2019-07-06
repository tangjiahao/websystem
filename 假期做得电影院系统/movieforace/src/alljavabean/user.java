package alljavabean;

public class user {
    private String userid="";
    private String username="";
    private String sex="";
    private String phone="";
    private String password="";
    private String age="";
    private String recentime="";
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getRecentime() {
        return recentime;
    }
    public void setRecentime(String recentime) {
        this.recentime = recentime;
    }
    @Override
    public String toString() {
	return "user [userid=" + userid + ", username=" + username + ", sex=" + sex + ", phone=" + phone + ", age="
		+ age + ", recentime=" + recentime + "]";
    }
    

}

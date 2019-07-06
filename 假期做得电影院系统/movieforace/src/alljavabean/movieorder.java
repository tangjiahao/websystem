package alljavabean;

public class movieorder {
    private int orderid=-1;
    private String userid="";
    private String username="";
    private String moviename="";
    private String watchtime="";
    private String place="";
    private String seat="";
    private double price=-1;
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getOrderid() {
        return orderid;
    }
    public void setOrderid(int orderid) {
        this.orderid = orderid;
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
    public String getMoviename() {
        return moviename;
    }
    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
    public String getWatchtime() {
        return watchtime;
    }
    public void setWatchtime(String watchtime) {
        this.watchtime = watchtime;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }
    @Override
    public String toString() {
	return "order [userid=" + userid + ", username=" + username + ", moviename=" + moviename + ", watchtime="
		+ watchtime + ", place=" + place + ", seat=" + seat + "]";
    }
    
	

}

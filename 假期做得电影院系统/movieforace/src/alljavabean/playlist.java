package alljavabean;

public class playlist {
    private String moviename="";
    private String showtime1="";
    private String showtime2="";
    private String place="";
    private int remainder=0;
    private int movieid=0;
    private double price=0;
    
    public int getMovieid() {
        return movieid;
    }
    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getMoviename() {
        return moviename;
    }
    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
    public String getShowtime1() {
        return showtime1;
    }
    public void setShowtime1(String showtime1) {
        this.showtime1 = showtime1;
    }
    public String getShowtime2() {
        return showtime2;
    }
    public void setShowtime2(String showtime2) {
        this.showtime2 = showtime2;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public int getRemainder() {
        return remainder;
    }
    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }
    @Override
    public String toString() {
	return "playlist [moviename=" + moviename + ", showtime1=" + showtime1 + ", showtime2=" + showtime2 + ", place="
		+ place + ", remainder=" + remainder + ", movieid=" + movieid + ", price=" + price + "]";
    }
    

}

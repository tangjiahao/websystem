package alljavabean;

public class evaluate {
    private String userid="";
    private String moviename="";
    private String time="";
    private String score="";
    private String comment="";
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getMoviename() {
        return moviename;
    }
    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
	return "evaluate [userid=" + userid + ", moviename=" + moviename + ", time=" + time + ", score=" + score
		+ ", comment=" + comment + "]";
    }
    

}

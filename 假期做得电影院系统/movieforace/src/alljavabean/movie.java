package alljavabean;

public class movie {
    private String moviename="";
    private int movieid=-1;
    private String type="";
    private String actors="";
    private String summary="";//电影简介
    private String score="";
    private String cover="";//封面路径
    private String recommend="no";
    
    
    public String getRecommend() {
        return recommend;
    }
    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
    public int getMovieid() {
        return movieid;
    }
    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }
    public String getMoviename() {
        return moviename;
    }
    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
    public String getActors() {
        return actors;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setActors(String actors) {
        this.actors = actors;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    @Override
    public String toString() {
	return "movie [moviename=" + moviename + ", type=" + type + ", actors=" + actors + ", summary=" + summary
		+ ", score=" + score + ", cover=" + cover + "]";
    }
    

}


public class pageStu {
     int pageindex;
     int pagemax;
     int datacount;
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagemax() {
		return pagemax;
	}
	public void setPagemax(int pagemax) {
		this.pagemax = pagemax;
	}
	public int getDatacount() {
		return datacount;
	}
	public void setDatacount(int datacount) {
		this.datacount = datacount;
	}
	@Override
	public String toString() {
		return "pageStu [pageindex=" + pageindex + ", pagemax=" + pagemax + ", datacount=" + datacount + "]";
	}
     
}

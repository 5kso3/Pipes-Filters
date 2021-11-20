package Framework;

public class Filter {
	    private CommonFilter filter;
	    private int port;
	    public Filter(CommonFilter filter, int port) {
	    	this.filter = filter;
	    	this.port = port;
	    }
	    public Filter(CommonFilter filter) {
	    	this.filter = filter;
	    	this.port = 0;
	    }
		public CommonFilter getFilter() {return filter;}
		public int getPort() {return port;}
}

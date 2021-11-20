/**
 * Copyright(c) 2019 All rights reserved by JU Consulting
 */
package Framework;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;

public interface CommonFilter extends Runnable{
    public void connectOutputTo(ArrayList<CommonFilter> filters) throws IOException;
    public void connectInputTo(ArrayList<Filter> filterList) throws IOException;
    public ArrayList<PipedInputStream> getPipedInputStream();
    public ArrayList<PipedOutputStream> getPipedOutputStream();
}

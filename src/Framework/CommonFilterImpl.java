package Framework;

import java.io.EOFException;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;

import Utility.Line;

public abstract class CommonFilterImpl implements CommonFilter {
	protected ArrayList<PipedInputStream> in = new ArrayList<PipedInputStream>();
	protected ArrayList<PipedOutputStream> out = new ArrayList<PipedOutputStream>();
	abstract public boolean specificComputationForFilter() throws IOException;

	public CommonFilterImpl(int outSize) {
		for(int i = 0; i < outSize; i++) {out.add(new PipedOutputStream());}
	}
	public CommonFilterImpl() {out.add(new PipedOutputStream());}
	
	public void connectOutputTo(ArrayList<CommonFilter> nextFilter) throws IOException {
	}
	
	@Override
	public void connectInputTo(ArrayList<Filter> filterList) throws IOException {
		for(int i = 0; i < filterList.size(); i++) {
			PipedInputStream in = new PipedInputStream();
			CommonFilter filter = filterList.get(i).getFilter();
			int port = filterList.get(i).getPort();
			this.in.add(in);
			in.connect(filter.getPipedOutputStream().get(port));
		}
	}

	public void run() {
		try {
			specificComputationForFilter();
		} catch (IOException e) {
			if (e instanceof EOFException) return;
			else System.out.println(e);
		} finally {
			closePorts();
		}
	}
	
	private void closePorts() {
		try {
			for(PipedOutputStream out : out) {out.close();}
			for(PipedInputStream in : in) {in.close();}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(int byte_read) throws IOException {
		for(PipedOutputStream out : out) {
			out.write(byte_read);
		}
	}
	public void write(int byte_read, int i) throws IOException {
		out.get(i).write(byte_read);
	}
	public ArrayList<PipedInputStream> getPipedInputStream() {return in;}
	public ArrayList<PipedOutputStream> getPipedOutputStream() {return out;}
}

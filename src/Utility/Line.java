package Utility;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Line {
	public static String readLine(PipedInputStream in) throws IOException {
		String line = null;
		int databyte = 0;
		while (databyte != '\n' && databyte != -1) {
			databyte = in.read();
			if (databyte != '\n' && databyte != -1) {line+=((char)databyte);}
		}
		if(line!=null) {line = line.substring(4);} // remove "null"
		return line;
	}

	public static void writeLine(String line, PipedOutputStream out) throws IOException {
		line+="\r\n";
		for (int i = 0; i < line.length(); i++) {out.write(line.charAt(i));}
	}
}

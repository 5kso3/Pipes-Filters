package Framework;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class AddFiler extends CommonFilterImpl {
	
	@Override
	public boolean specificComputationForFilter() throws IOException {
        int byte_read = 0;
        int idx = 0;
        boolean check12345 = false;
        boolean check23456 = false;
        while(true) {
        	byte[] buffer = new byte[64];
            while(byte_read != '\n' && byte_read != -1) {
            	byte_read = in.get(0).read();
            	if(byte_read != -1) buffer[idx++] = (byte)byte_read;
            }
            if (byte_read == -1) {return true;}
            String line = new String(buffer);
        	Scanner sc = new Scanner(line);
        	line = line.substring(0, idx - 2);
        	while(sc.hasNext()) {
        		String word = sc.next();
        		if(word.matches("12345")) {check12345 = true;} 
        		else if(word.matches("23456")) {check23456 = true;}
        	}
        	if(!check12345) {line += " 12345";}
        	if(!check23456) {line += " 23456";}
        	line += "\n";
            //this.writeAll(line.getBytes());
            idx = 0;
            byte_read = '\0';
            check12345 = false;
            check23456 = false;
        }
	}
}

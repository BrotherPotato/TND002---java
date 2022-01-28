package course;

import java.io.BufferedReader;
import java.io.Writer;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Filess extends Writer{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		BufferedReader b = new BufferedReader(new FileReader("text.txt"));
		String fname = "";
		File f = new File(fname);
		f.createNewFile();
		boolean overwrite = false;
		//Writer w2 = new BufferedWriter(new FileWriter(f, overwrite));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("foo.out")));
		
		/*
		String s;
		
		while((s = b.readLine()) != null) {
			System.out.println(s);
		}
		*/
		/*
		String out = b.readLine();
		System.out.println(out);
		out = b.readLine();
		System.out.println(out);
		*/
		/*
		do {
			System.out.println("Input: ");
			in = b.readLine();
			System.out.println(in);
		} while(!in.equals("end"));
		*/
		b.close();
		
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}



}

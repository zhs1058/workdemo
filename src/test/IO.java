package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

public class IO {
	public static void main(String[] args) {
		File file = new File("D:/ios");
		if(!file.isDirectory()) {
			System.out.println("创建文件夹");
			file.mkdirs();
		}
		file = new File("D:/ios/test.txt");
		try {
			if(!file.exists()) {
				System.out.println("创建文件");
				file.createNewFile();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter("D:/ios/test.txt"));
			for(int i = 0; i < 999; i ++) {
				out.write("我今天真开心啊！");
				out.newLine();
			}
			
			BufferedReader in = new BufferedReader(new FileReader("D:/ios/test.txt"));
			
			while(in.read() > -1) {
				System.out.println(in.readLine());
				
			}
			
			InputStream imgIn = new FileInputStream("D:/ios/summer.jpg");
			byte[] bytes = new byte[1024];
			OutputStream imgOut = new FileOutputStream("D:/ios/summer-copy.jpg");
			int l = 0;
			while((l = imgIn.read(bytes)) != -1) {
				imgOut.write(bytes, 0, l);
			}
			imgOut.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

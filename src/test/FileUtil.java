package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileUtil {
	
	
	public static void TransUpload(String sourceUrl,String targetUrl) throws RuntimeException, IOException{
		
		BufferedInputStream  bis = null;
        OutputStream bos = null;
        try {
            URL url1 = new URL(sourceUrl);
            URL url2 = new URL(targetUrl);
            URLConnection con = url1.openConnection();
            URLConnection tarcon = url2.openConnection();
            
            bis = new BufferedInputStream(con.getInputStream());
            
            bos=new BufferedOutputStream(tarcon.getOutputStream());
            int len=-1;
            byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf,0,len);
            }
            bos.flush();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bis) {
                    bis.close();
                }
                if(null != bos) {
                	bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
	};
}

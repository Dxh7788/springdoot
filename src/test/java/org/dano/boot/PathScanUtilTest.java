package org.dano.boot;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author dongxiaohong
 * @date 2018/12/13 16:48
 */
public class PathScanUtilTest {

    @Test
    public void doScanPackages() throws IOException, URISyntaxException {
        String path = "org.dano.boot";
        path = path.replace(".","/")+ File.separator;
        ClassLoader c = PathScanUtilTest.class.getClassLoader();
        Enumeration<URL> urls = null;
        if (c != null){
            urls =  c.getResources(path);
        }
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            /**
             * url转uri,需要把' '转换成%20
             * */
            String urlStr = url.toString();
            URI uri = new URI(urlStr.replace(" ", "%20"));
            File file = new File(uri);
            if (file.isDirectory()){
                //列出所有文件
                File[] files = file.listFiles();
                for (File f:files){
                    if (f.isDirectory()){
                        continue;
                    }
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}

package com.example.kafkademo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author user
 */
@RestController
public class TestController {

    @GetMapping(value = "/download")
    public void download(HttpServletResponse httpServletResponse) throws IOException {

        // 以流的形式下载文件。
       InputStream fis = new BufferedInputStream(new FileInputStream("E://1.pdf"));
       byte[] buffer = new byte[fis.available()];
       fis.read(buffer);
       fis.close();
       // 清空response
        httpServletResponse.reset();
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.addHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode("test.pdf", "UTF-8"));
        OutputStream os = httpServletResponse.getOutputStream();
        os.write(buffer);
        os.flush();
        os.close();
    }

}

package br.com.casadocodigo.loja.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Component
public class FileSaver {
    @Autowired
    private HttpServletRequest request;

    public String write(String baseFolder, MultipartFile file) {
        String realPath = request.getServletContext().getRealPath("/"+baseFolder);
        String path = realPath+"/"+file.getOriginalFilename();
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return baseFolder+"/"+file.getOriginalFilename();
    }
}

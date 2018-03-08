package me.threeq.service.upload;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    /**
     * 上传文件
     * 测试方法：
     * TODO 只是一个demo，没有做任何处理
     * @param file 待上传文件
     * @return 文件在服务器上的据对路径
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam(value = "file", required = true)MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, fileToSave);
        return  fileToSave.getAbsolutePath();
    }

}

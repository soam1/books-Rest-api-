package com.akashsoam.bootJpaExample.helper;

import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

//	public final String UPLOAD_DIR = "/home/akash-soam/software-workspaces/sts-workspace/BootRestBook/src/main/resources/static/images";
	public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws Exception {
		
	}
	public boolean uploadFile(MultipartFile file) {
		boolean f = false;
		try {
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}

package com.akashsoam.bootJpaExample.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.akashsoam.bootJpaExample.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload_file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		// upload file code
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
		
		if (file.isEmpty()) {
			return ResponseEntity.status(500).body("File is empty");
		}
		
		if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
			return ResponseEntity.status(500).body("Only jpeg or png files are allowed");
		}
		
		// upload the file
		try {
			if (fileUploadHelper.uploadFile(file)) {
//				return ResponseEntity.ok("File is uploaded at location: " + fileUploadHelper.UPLOAD_DIR + "/" + file.getOriginalFilename());
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(500).body("Something went wrong");

	}

}

package com.book.uploadfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class uploadfilehelper {
	
//	private final String upload_dir = "C:\\Users\\AJAZ BHAT\\OneDrive\\Documents\\java_learning\\apibook\\src\\main\\resources\\static\\images";
	private final String upload_dir = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	public uploadfilehelper()throws IOException{
		
	}
	public boolean fileupload(MultipartFile file) {
		boolean f=false;
		try {
			System.out.println(upload_dir);
			Files.copy(file.getInputStream(), Paths.get(upload_dir+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
			return f;
		}
		return f;
	}

}

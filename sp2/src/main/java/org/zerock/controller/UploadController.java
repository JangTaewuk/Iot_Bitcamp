package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j

public class UploadController {

	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {

		String uploadFolder = "C:\\Upload";

		for (MultipartFile multipartFile : uploadFile) {

			log.info("-------------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());

			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

			try {
				multipartFile.transferTo(saveFile);
				
//				FileOutputStream thumbnail = new FileOutputStream(
//						uploadFolder, "s_"+multipartFile.getOriginalFilename());
				
				   FileOutputStream thumbnail = 
			                new FileOutputStream(new File(uploadFolder, "s_" + multipartFile.getOriginalFilename()));
				
				   
				
				Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
			} catch (Exception e) {
				log.error(e.getMessage());
			} // end catch
			
			

		}
	}

}

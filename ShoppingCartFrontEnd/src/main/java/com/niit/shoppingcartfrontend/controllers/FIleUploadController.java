package com.niit.shoppingcartfrontend.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FIleUploadController {

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
            @RequestParam("file") MultipartFile file){
        String name = file.getOriginalFilename();
       String path = "C:\\Users\\Owner\\workspace\\ShoppingCartFrontEnd\\src\\main\\webapp\\resources\\fileupload";
        if (!file.isEmpty()) {
            try {
            	
            	File imgDirectory = new File(path);
            	if(!imgDirectory.exists())
            	{
            		imgDirectory.mkdir();
            	}
            	
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path+"\\"+name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
   }
}

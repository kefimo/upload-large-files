package com.kefi.app.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/uploadServices")
public class UploadWebServices {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<Object> hello() {
			try {
				return new ResponseEntity<Object>("hello",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);				
    }
	
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value="/uploadFile")
	@ResponseBody
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("type") String type) {
			try {
				return new ResponseEntity<Object>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);				
    }
	
}
package com.multi.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NaverController {

	@Autowired
	NaverService service;
	
	@RequestMapping("naverLogin")
	public void insert(NaverVO naverVO) {
		//전처리해서 db처리하자.
		service.insert(naverVO);
	}
	
	@RequestMapping("naverOcr")
	public void ocr(	HttpServletRequest request,
						MultipartFile file, 
						Model model) throws IOException {
		//파일첨부한 경우에는 file이름 텍스트 + 이미지파일자체 
		
		//1. 파일의 이름 + 파일 저장 위치를 알아와야한다. ==> String!
		String savedName = file.getOriginalFilename();
		String uploadPath= request.getSession().getServletContext().getRealPath("resources/upload");
		System.out.println(uploadPath + "/" + savedName);
		
		//2. File객체(폴더/디렉토리 + 파일명)를 생성 ==> 파일을 인식(램에 저장)
		File target = new File(uploadPath + "/" + savedName);
		
		//3. 서버 컴퓨터에 파일을 저장시켜야한다. ==> resources아래에 저장! 
		file.transferTo(target);
		
		네이버_OCR2 ocr2 = new 네이버_OCR2();
		String fileName = uploadPath + "/" + savedName;
		ArrayList<String> list = ocr2.ocr(fileName);
		model.addAttribute("list", list);
		model.addAttribute("savedName", savedName);
	}
	
}

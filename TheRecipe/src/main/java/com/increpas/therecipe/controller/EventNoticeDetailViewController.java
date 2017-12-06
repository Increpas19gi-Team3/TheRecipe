package com.increpas.therecipe.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.increpas.therecipe.dto.UploadFileDTO;
import com.increpas.therecipe.service.EventNoticeViewRegService;
import com.increpas.therecipe.vo.EventNoticeRegVO;
import com.increpas.therecipe.vo.EventNoticeVO;
import com.increpas.therecipe.vo.EventVO;

/**
 * 공지사항과 이벤트의 상세보기와 등록 Controller
 * @author 손대성
 *
 */
@Controller
public class EventNoticeDetailViewController {

	@Autowired
	EventNoticeViewRegService ndvs;

	/**
	 * 공지사항 상세보기	 
	 * @param model
	 * @param req
	 * @param resp
	 * @return "NoticeDetailView"
	 */
	@RequestMapping(value = "/adminNoticeDetailView.do", method = RequestMethod.GET)
	public String GET_NoticeDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("공시사항 상세페이지 입니다.");
		int Ncode = Integer.parseInt(req.getParameter("e_evtcode"));
		EventVO nVo = ndvs.getNoticeVODetail(Ncode);
		model.addAttribute("nVo", nVo);
		return "adminNoticeDetailView";
	}

	/**
	 * 공지사항 등록으로 들어감(GET)	  
	 * @param model
	 * @return "noticeReg"
	 */
	@RequestMapping(value = "/adminNoticeReg.do", method = RequestMethod.GET)
	public String GET_NoticeReg(Model model) {
		System.out.println("공시사항 리스트에서 등록버튼을 눌렀음 등록페이지로 넘어감");
		return "adminNoticeReg";
	}

	/**
	 * 공지사항 등록(POST)
	 * @param erVo
	 * @param errors
	 * @param model
	 * @return "redirect:NoticeList.do"
	 */
	@RequestMapping(value = "/adminNoticeReg.do", method = RequestMethod.POST)
	public String POST_NoticeReg(@Valid @ModelAttribute("noticeCom") EventNoticeRegVO erVo, Errors errors, Model model) {

		System.out.println("▶▶▶▶▶ EventNoticeDetailViewController ; adminNoticeReg.do ; POST");

		MultipartFile file = erVo.getUpfile();

		String path = "C:/images/";
		String originalFilename = "";
		originalFilename = file.getOriginalFilename();
		String systemFilename = UUID.randomUUID() + "_" + originalFilename;

		if (!file.isEmpty()) {			
			try {
				file.transferTo(new File(path, systemFilename));
				System.out.println("▶▶▶▶▶ "+ systemFilename + " 업로드완료.");
				UploadFileDTO fileDTO = new UploadFileDTO();
				fileDTO.setOriginalFilename(originalFilename);
				fileDTO.setSystemFilename(systemFilename);
				fileDTO.setFileSize(file.getSize());

				erVo.setE_ntimgname(systemFilename);
				
				System.out.println("▶▶▶▶▶ model.addAttribute()");
				model.addAttribute("fileDTO", fileDTO);				
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (errors.hasErrors()) {
			System.out.println("errors.getAllErrors()"+errors.getAllErrors());
			System.out.println("▶▶▶▶▶ 에러 입니다.");
			return "adminNoticeReg";
		}

		System.out.println("▶▶▶▶▶ 이미지 저장후 'NoticeDetailViewService' 이동");
		ndvs.insertWrtNoticeVO(erVo);

		System.out.println("▶▶▶▶▶ 등록 마지막 단계");
		
		return "redirect:adminNoticeList.do";
	}

	// ===========================================이벤트===============================================================
	
	/**
	 * 이벤트 상세보기 페이지로 이동(GET)
	 * @param model
	 * @param req
	 * @param resp
	 * @return "EventDetailView"
	 */
	@RequestMapping(value = "/adminEventDetailView.do", method = RequestMethod.GET)
	public String GET_EventDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("1. '이벤트 상세페이지'입니다.");
		int Ecode = Integer.parseInt(req.getParameter("e_evtcode"));
		EventNoticeVO eVo = ndvs.getEventVODetail(Ecode);
		System.out.println(">>>>>>>>>>> eVo = " + eVo.toString());
		model.addAttribute("eVo", eVo);
		return "adminEventDetailView";
	}
	
	/**
	 * 이벤트 등록()
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adminEventReg.do", method = RequestMethod.GET)
	public String GET_EventReg(Model model) {

		System.out.println("1. '이벤트 등록'입니다.");
		return "eventReg";
	}
	
	@RequestMapping(value = "/adminEventReg.do", method = RequestMethod.POST)
	public String POST_EventReg(@Valid @ModelAttribute("eventCom") EventNoticeRegVO erVo, Errors errors, Model model) {

		System.out.println("▶▶▶▶▶ EventNoticeDetailViewController ; adminEventReg.do ; POST ; ");

		MultipartFile file = erVo.getUpfile();

		String path = "C:/images/";
		String originalFilename = "";
		originalFilename = file.getOriginalFilename();
		String systemFilename = UUID.randomUUID() + "_" + originalFilename;

		if (!file.isEmpty()) {
			// 업로드파일객체를 지정한 파일에 복사
			try {
				file.transferTo(new File(path, systemFilename));
				System.out.println("▶▶▶▶▶ "+ systemFilename + " 업로드완료.");
				UploadFileDTO fileDTO = new UploadFileDTO();
				fileDTO.setOriginalFilename(originalFilename);
				fileDTO.setSystemFilename(systemFilename);
				fileDTO.setFileSize(file.getSize());

				erVo.setE_ntimgname(systemFilename);
				
				System.out.println("▶▶▶▶▶ model.addAttribute()");
				model.addAttribute("fileDTO", fileDTO);				
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (errors.hasErrors()) {
			System.out.println("errors.getAllErrors()"+errors.getAllErrors());
			System.out.println("▶▶▶▶▶ 에러 입니다.");
			return "adminNoticeReg";
		}

		System.out.println("▶▶▶▶▶ 이미지 저장후 'NoticeDetailViewService' 이동");
		ndvs.insertWrtEventVO(erVo);

		System.out.println("▶▶▶▶▶ 이벤트 등록 마지막 단계");
	
		return "redirect:adminEventList.do";
	}
}

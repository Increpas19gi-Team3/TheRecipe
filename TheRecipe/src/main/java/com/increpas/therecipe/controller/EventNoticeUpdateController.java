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
import com.increpas.therecipe.service.EventNoticeUpdateService;
import com.increpas.therecipe.vo.EventNoticeRegVO;

/**
 * 공지사항과 이벤트의 수정 Controller
 * 
 * @author 손대성
 *
 */
@Controller
public class EventNoticeUpdateController {

	@Autowired
	EventNoticeUpdateService enuService;
	
	/**
	 * 공지사항 수정	 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/NoticeUpdate.do", method = RequestMethod.GET)
	public String GET_NoticeUpdate(Model model, HttpServletRequest req) {
		String e_evtcode = req.getParameter("e_evtcode");
		model.addAttribute("e_evtcode", e_evtcode);
		System.out.println("1. 공시사항_상세보기에서 수정버튼을 눌렀음 수정페이지로 넘어감 e_evtcode:"+e_evtcode);
		return "noticeUpdate";
	}
	
	/**
	 * 공지사항 수정
	 * @param erVo
	 * @param errors
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/NoticeUpdate.do", method = RequestMethod.POST)
	public String POST_NoticeUpdate(@Valid @ModelAttribute("noticeUpdateCom") EventNoticeRegVO enrVo, Errors errors, HttpServletRequest req, HttpServletResponse resp, Model model) {
		
		System.out.println("2. POST : NoticeUpdate.do : 공지사항 수정중입니다.");
		System.out.println("3. req.getParameter(e_evtcode) "+ req.getParameter("e_evtcode"));
		
		String e_evtcode = req.getParameter("e_evtcode");
		EventNoticeRegVO preDTO = enuService.getSelectNoticeEvent(e_evtcode);

		// MultipartFile 파일 객체
		MultipartFile file = enrVo.getUpfile();
		String path = "C:/images/";
		// 제목, 내용, 시작날짜, 종료날짜, 이미지
		if (enrVo.getE_nttilte().isEmpty()) {
			enrVo.setE_nttilte(preDTO.getE_nttilte());
		}		
		if (enrVo.getE_ntcontens().isEmpty()) {
			enrVo.setE_ntcontens(preDTO.getE_ntcontens());
		}
		
		// 왜 날짜는 'isEmpty'를 사용하지 못하는가?
//		if (enrVo.getE_startdate().isEmpty()) {
//			enrVo.setE_startdate(preDTO.getE_startdate());
//		}
//		if (enrVo.getE_enddate().isEmpty()) {
//			enrVo.setE_enddate(preDTO.getE_enddate());
//		}		

		if (!file.isEmpty()) {			
			try {
				String originalFilename = file.getOriginalFilename();
				String systemFilename = UUID.randomUUID() + "_" + originalFilename;

				file.transferTo(new File(path, systemFilename));
				System.out.println(systemFilename + " 업로드완료.");
				UploadFileDTO fileDTO = new UploadFileDTO();
				fileDTO.setOriginalFilename(originalFilename);
				fileDTO.setSystemFilename(systemFilename);
				fileDTO.setFileSize(file.getSize());
				
				// 모델에 fileDTO 추가
				enrVo.setE_ntimgname(systemFilename);
				
				model.addAttribute("fileDTO", fileDTO);
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			enrVo.setE_ntimgname(preDTO.getE_ntimgname());
		}

		if (errors.hasErrors()) {
			return "noticeUpdate";
		}
		
		System.out.println("enrVo.getE_nttilte() >>> " + enrVo.getE_nttilte());
		System.out.println("enrVo.getE_ntcontens() >>> " + enrVo.getE_ntcontens());
		System.out.println("enrVo.getE_startdate() >>> " + enrVo.getE_startdate());
		System.out.println("enrVo.getE_enddate() >>> " + enrVo.getE_enddate());
		System.out.println("enrVo.getE_discount() >>> " + enrVo.getE_discount());
		System.out.println("enrVo.getE_ntimgname()>>> " + enrVo.getE_ntimgname());		

		enuService.updatetWrtNoticeVO(enrVo);

		return "redirect:NoticeList.do";
	}
	
	/**
	 * 공지사항 삭제 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/NoticeDelete.do", method = RequestMethod.GET)
	public String NoticeDelete(HttpServletRequest request, Model model) {

		System.out.println("1. 공지사항 삭제입니다. NoticeDelete : e_evtcode : " + request.getParameter("e_evtcode"));
		String e_Num = request.getParameter("e_evtcode");
		enuService.DeleteNotice(e_Num);
		System.out.println("5. 공시사항 삭제 완료 ");

		return "redirect:NoticeList.do";
	}
	
	
	
	//==================================== 이벤트 ==========================================
	
	
	/**
	 * 이벤트 수정	 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/EventUpdate.do", method = RequestMethod.GET)
	public String GET_EventUpdate(Model model, HttpServletRequest req) {
		String e_evtcode = req.getParameter("e_evtcode");
		model.addAttribute("e_evtcode", e_evtcode);
		System.out.println("1. 이벤트_상세보기에서 수정버튼을 눌렀음 수정페이지로 넘어감 e_evtcode:"+e_evtcode);
		return "eventUpdate";
	}
	
	/**
	 * 이벤트 수정
	 * @param erVo
	 * @param errors
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/EventUpdate.do", method = RequestMethod.POST)
	public String POST_EventUpdate(@Valid @ModelAttribute("noticeUpdateCom") EventNoticeRegVO enrVo, Errors errors, HttpServletRequest req, HttpServletResponse resp, Model model) {
		
		System.out.println("2. POST : EventUpdate.do : 이벤트 수정중입니다.");
		System.out.println("3. req.getParameter(e_evtcode) "+ req.getParameter("e_evtcode"));
		
		String e_evtcode = req.getParameter("e_evtcode");
		EventNoticeRegVO preDTO = enuService.getSelectNoticeEvent(e_evtcode);

		// MultipartFile 파일 객체
		MultipartFile file = enrVo.getUpfile();
		String path = "C:/images/";
		// 제목, 내용, 시작날짜, 종료날짜, 이미지
		if (enrVo.getE_nttilte().isEmpty()) {
			enrVo.setE_nttilte(preDTO.getE_nttilte());
		}		
		if (enrVo.getE_ntcontens().isEmpty()) {
			enrVo.setE_ntcontens(preDTO.getE_ntcontens());
		}
		
		// 왜 날짜는 'isEmpty'를 사용하지 못하는가?
//		if (enrVo.getE_startdate().isEmpty()) {
//			enrVo.setE_startdate(preDTO.getE_startdate());
//		}
//		if (enrVo.getE_enddate().isEmpty()) {
//			enrVo.setE_enddate(preDTO.getE_enddate());
//		}		

		if (!file.isEmpty()) {			
			try {
				String originalFilename = file.getOriginalFilename();
				String systemFilename = UUID.randomUUID() + "_" + originalFilename;

				file.transferTo(new File(path, systemFilename));
				System.out.println(systemFilename + " 업로드완료.");
				UploadFileDTO fileDTO = new UploadFileDTO();
				fileDTO.setOriginalFilename(originalFilename);
				fileDTO.setSystemFilename(systemFilename);
				fileDTO.setFileSize(file.getSize());
				
				// 모델에 fileDTO 추가
				enrVo.setE_ntimgname(systemFilename);
				
				model.addAttribute("fileDTO", fileDTO);
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			enrVo.setE_ntimgname(preDTO.getE_ntimgname());
		}

		if (errors.hasErrors()) {
			return "eventUpdate";
		}
		
		System.out.println("enrVo.getE_nttilte() >>> " + enrVo.getE_nttilte());
		System.out.println("enrVo.getE_ntcontens() >>> " + enrVo.getE_ntcontens());
		System.out.println("enrVo.getE_startdate() >>> " + enrVo.getE_startdate());
		System.out.println("enrVo.getE_enddate() >>> " + enrVo.getE_enddate());
		System.out.println("enrVo.getE_discount() >>> " + enrVo.getE_discount());
		System.out.println("enrVo.getE_ntimgname()>>> " + enrVo.getE_ntimgname());		

		enuService.updatetWrtEventVO(enrVo);

		return "redirect:EventList.do";
	}
	
	
	/**
	 * 이벤트 삭제
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Eventdelete.do", method = RequestMethod.GET)
	public String EventDelete(HttpServletRequest request, Model model) {

		System.out.println("1. 이벤트 삭제입니다. Eventdelete : e_evtcode : " + request.getParameter("e_evtcode"));
		String e_Num = request.getParameter("e_evtcode");
		enuService.DeleteEvent(e_Num);
		System.out.println("5. 이벤트 삭제 완료 ");

		return "redirect:EventList.do";
	}
}

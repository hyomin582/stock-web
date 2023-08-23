package com.naver.phone.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.phone.dao.PhoneDao;
import com.naver.phone.dto.PhoneDto;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	@Autowired
	PhoneDao phoneDao;
	String userid = "";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	로그인
	@GetMapping("/loginaf")
	public String After(Model model, HttpSession session) {
		if(session.getAttribute("userid")!=null) {
			model.addAttribute("id",session.getAttribute("userid"));
		}
		return "phoneList";
	}
	
	@PostMapping("/loginSuccess")
	public String loginSuccess(@ModelAttribute PhoneDto phoneDto, Model model, ServletRequest request) {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();

		session.setAttribute("userid", phoneDto.getUserid());

		List<PhoneDto> originUsers;

		try {
			originUsers = phoneDao.getUser();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("회원불러오기 에러");
			model.addAttribute("회원 불러오기에서 에러가 발생했는데");
			return "login";
		}

		Iterator<PhoneDto> it = originUsers.iterator();

		int i = 0;
		while (it.hasNext()) {
			PhoneDto u = it.next();
			if (phoneDto.getUserid().equals(u.getUserid()) && phoneDto.getUserpw().equals(u.getUserpw())) {
				userid = phoneDto.getUserid();
				i++;
			}
		}
		if (i != 0) {
			model.addAttribute("id",session.getAttribute("userid"));
			return "redirect:/phone/list";
		} else {
			model.addAttribute("error","로그인 실패했습니다.");
			return "redirect:/phone/login";
		}
	}

	// 번호 목록 보기
	@GetMapping("/list")
	public String listPhones(Model model, HttpSession session) {
		List<PhoneDto> list;
		userid = session.getAttribute("userid").toString();
		try {
			list = phoneDao.getAll(userid);
			model.addAttribute("phoneList", list);
		} catch (Exception e) {
			e.printStackTrace(); 
			logger.warn("이것은 전화번호 목록 생성 과정에서 문제 발생"); 
			model.addAttribute("error", "전화번호 목록이 정상적으로 처리되지 않았습니다. "); 
		}
		return "phoneList";
	}

	// 회원 추가버튼
	@GetMapping("/addButton")
	public String addButton() {
		return "phoneAdd";
	}
	
	// 회원 추가
	@PostMapping("/add")
	public String addPhone(PhoneDto phoneDto, HttpSession httpSession, RedirectAttributes rdir) {
		String changeType = String.valueOf(httpSession.getAttribute("userid"));
		phoneDto.setUserid(changeType);
		
		if(phoneDto.getGroupname().equals("가족")) {
			phoneDto.setMbgno("10");
		}else if(phoneDto.getGroupname().equals("친구")) {
			phoneDto.setMbgno("20");
		}else if(phoneDto.getGroupname().equals("기타")){
			phoneDto.setMbgno("30");
		}else {
			rdir.addFlashAttribute("msg","<script>alert('그룹명 잘못입력');</script>");
			return "redirect:/phone/list";
		}
		try {
			phoneDao.addPhone(phoneDto);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("회원 추가 오류");
		}
		rdir.addFlashAttribute("msg","<script>alert('회원추가 완료');</script>");
		return "redirect:/phone/list";
	}

	//로그인 화면
	@GetMapping("/login")
	public String login(@ModelAttribute PhoneDto phoneDto) {
		return "login";
	}
	
	@GetMapping("/frind")
	public String frind() {
		System.out.println("가족버튼");
		return "redirect:/phone/list";
	}

	// 회원가입 화면
	@GetMapping("/join")
	public String join(@ModelAttribute PhoneDto phoneDto) {
		return "joinUser";
	}
	
	// 회원가입처리
	@PostMapping("/newMember")
	public String newMember(@ModelAttribute PhoneDto phoneDto, RedirectAttributes rdir) {
		List<PhoneDto> list = new ArrayList<>();
		
		// USERPW, CHECKPW 비교
		if(phoneDto.getUserpw().equals(phoneDto.getCheckpw())) {
			}else {
			rdir.addFlashAttribute("msg","비밀번호가 맞지않습니다.");
			return "redirect:/phone/join";
			}
		// USERID 비교
		try {
			list = phoneDao.selectMember();
			for(int i = 0; i<list.size(); i++){
				if(phoneDto.getUserid().equals(list.get(i).getUserid())) {
						rdir.addFlashAttribute("msg","아이디 중복");
						return "redirect:/phone/join";
					}
				}
				phoneDao.newMember(phoneDto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/phone/login";
		}
	
	// 회원 수정 화면 띄우기
	@GetMapping("/update/{mbph}")
	public String memUpdate(@PathVariable String mbph, RedirectAttributes rdir) {
		userid = mbph;
		System.out.println(userid);
		return "alter";
	}	
	
	// 회원 수정
	@PostMapping("/updateMem")
	public String updateMem(@ModelAttribute PhoneDto phoneDto, HttpSession session,Model model) {
		
		if(phoneDto.getGroupname().equals("가족")) {
			phoneDto.setMbgno("10");
		}else if(phoneDto.getGroupname().equals("친구")) {
			phoneDto.setMbgno("20");
		}else if(phoneDto.getGroupname().equals("기타")){
			phoneDto.setMbgno("30");
		}
		
		try {
			phoneDao.update(phoneDto, userid);
			System.out.println("다오 207번줄");
		} catch (Exception e) {
			System.out.println("회원 수정 오류");
		}
		model.addAttribute("id",session.getAttribute("userid"));
		return "redirect:/phone/list";
	}
	
	// 회원 삭제
	@GetMapping("/delete/{mbph}")
	public String delete(@PathVariable String mbph, RedirectAttributes rdir) {
		
		try {
			phoneDao.delMem(mbph);
			rdir.addFlashAttribute("msg","<script>alert('회원삭제 완료');</script>");
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("삭제실패");
		}
		return "redirect:/phone/list";
	}
	
	// 로그아웃 
	@GetMapping("/logout")
	public String logout(RedirectAttributes redir, HttpSession session) {
		session.removeAttribute("userid");
		session.removeAttribute("userpw");
		redir.addFlashAttribute("msg","<script>alert('로그아웃');</script>");
		return "redirect:/phone/login";
	}
}

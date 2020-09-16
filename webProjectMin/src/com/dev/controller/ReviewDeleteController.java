package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVo;
import com.dev.model.ReviewDAO;
import com.dev.model.ReviewVo;

public class ReviewDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("회원삭제");
		
		//파라미터
		String id = (String) request.getSession().getAttribute("id");
		String saying_number = request.getParameter("saying_number");
		
		//유효성 체크 id값이 널인가아닌가
		/*
		 * if (id.isEmpty()) { request.setAttribute("error", "id를 입력하시오"); // search페이지로
		 * 포워드 request.getRequestDispatcher("/member/memberDelete.jsp").forward(request,
		 * response); return; }
		 */  // search로 검색하고 나온그사람을 삭제하기때문에 여기서 id널값처리 필요없음.
		
		//vo
		ReviewVo reviewVo = new ReviewVo();
		reviewVo.setId(id);
		reviewVo.setSaying_number(saying_number);
		System.out.println(reviewVo.getId());
		System.out.println(reviewVo.getSaying_number());
		
		//서비스
		int r = ReviewDAO.getInstance().delete(reviewVo);
		System.out.println(r);
		//결과저장
		//request.setAttribute("deleteReview", r);
		
		//뷰페이지이동
		response.sendRedirect("/webProjectMin/reviewList.do");
		//request.getRequestDispatcher("/reviewList.do").forward(request, response);

	}

}

package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.ReviewDAO;
import com.dev.model.ReviewVo;
import com.dev.model.SayingDAO;
import com.dev.model.SayingVo;

public class ReviewUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println(num);
		SayingVo sayingVo = new SayingVo();
		sayingVo.setSaying_number(num);
		sayingVo = SayingDAO.getInstance().selectOne(sayingVo);
		request.setAttribute("saying", sayingVo);
	
		
		//명언num 세션에서 사용자 id들고오기.
		String id = (String) request.getSession().getAttribute("id");
		String review = request.getParameter("review");
		ReviewVo reviewVo = new ReviewVo();
		reviewVo.setId(id);
		reviewVo.setSaying_number(num);
		reviewVo.setReview(review);
		int r = ReviewDAO.getInstance().update(reviewVo);
		request.setAttribute("reviewone", r);
		
		response.sendRedirect("/webProjectMin/reviewList.do");
		
	}

}

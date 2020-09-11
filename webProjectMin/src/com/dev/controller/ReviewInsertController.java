package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.ReviewDAO;
import com.dev.model.ReviewVo;
import com.dev.model.SayingDAO;
import com.dev.model.SayingVo;

public class ReviewInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리뷰등록");
		
		
		String id = (String) request.getSession().getAttribute("id");
		System.out.println(id);
		String saying_number = request.getParameter("num");
		String review = request.getParameter("review");
		ReviewVo reviewVo = new ReviewVo();
		
		reviewVo.setId(id);
		reviewVo.setSaying_number(saying_number);
		reviewVo.setReview(review);
		
		int r = ReviewDAO.getInstance().insert(reviewVo);
		
		request.setAttribute("reviewinsert", r);
		
		request.getRequestDispatcher("/reviewList.do").forward(request, response);
		
	}

}

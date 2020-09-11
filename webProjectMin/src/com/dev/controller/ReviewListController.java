package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.ReviewDAO;
import com.dev.model.ReviewVo;

public class ReviewListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내리뷰리스트");
		
		String id = (String) request.getSession().getAttribute("id");
		
		ReviewVo reviewVo = new ReviewVo();
		reviewVo.setId(id);
	
		
		List<ReviewVo> rlist = ReviewDAO.getInstance().reviewList(reviewVo);
		request.setAttribute("rlist", rlist);
		
		request.getRequestDispatcher("/review/reviewList.jsp").forward(request, response);
		
	}

}

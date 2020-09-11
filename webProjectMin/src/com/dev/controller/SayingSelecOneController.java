package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.ReviewDAO;
import com.dev.model.ReviewVo;
import com.dev.model.SayingDAO;
import com.dev.model.SayingVo;

public class SayingSelecOneController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("명언선택");
		
		String num = request.getParameter("num");
		SayingVo sayingVo = new SayingVo();
		sayingVo.setSaying_number(num);
		sayingVo = SayingDAO.getInstance().selectOne(sayingVo);
		request.setAttribute("saying", sayingVo);
	
		
		//명언num 세션에서 사용자 id들고오기.
		String id = (String) request.getSession().getAttribute("id");
		ReviewVo reviewVo = new ReviewVo();
		reviewVo.setId(id);
		reviewVo.setSaying_number(num);
		//selectOne해서 vo가 리턴ㅇㅇ
		reviewVo = ReviewDAO.getInstance().selectOne(reviewVo);
		request.setAttribute("reviewone", reviewVo);
		//리턴된 vo를 null 체크 후 null이면 insert로 아니면 vo룰 
		if(reviewVo == null) {
			request.getRequestDispatcher("/saying/sayingSelectOne.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/review/reviewUpdate.jsp").forward(request, response);
			
		}

	}

}

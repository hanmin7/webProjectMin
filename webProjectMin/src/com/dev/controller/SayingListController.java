package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.SayingDAO;
import com.dev.model.SayingVo;

public class SayingListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("명언전체리스트");
		
		List<SayingVo> slist = SayingDAO.getInstance().selectAll();
		
		request.setAttribute("slist", slist);
		
		request.getRequestDispatcher("/saying/sayingAll.jsp").forward(request, response);
	}

}

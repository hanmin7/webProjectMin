package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.SayingDAO;
import com.dev.model.SayingVo;

public class SayingListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("명언전체리스트");
		List<SayingVo> slist = new ArrayList<SayingVo>();
		String cate = request.getParameter("cate");
		
		System.out.println(cate);
		if(cate == null || cate.equals("all")) {
			slist = SayingDAO.getInstance().selectAll();
		}else {
			SayingVo cateVo = new SayingVo();
			cateVo.setCategory(cate);
			slist = SayingDAO.getInstance().selectCate(cateVo); // where절
		}
		
		List<String> clist = new ArrayList<String>();
		clist = SayingDAO.getInstance().selectCateDISTINCT();
		
		
		
		request.setAttribute("clist", clist);
		request.setAttribute("slist", slist);
		request.getRequestDispatcher("/saying/sayingAll.jsp").forward(request, response);
	}

}

package com.dev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.common.ConnectionManager;

public class SayingDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	// 싱글톤
	static SayingDAO instance;

	public static SayingDAO getInstance() {
		if (instance == null)
			instance = new SayingDAO();
		return instance;
	}
		
	
	
	//전체조회
	public ArrayList<SayingVo> selectAll(){
		SayingVo resultVo = null;
		ResultSet rs = null;
		ArrayList<SayingVo> list = new ArrayList<SayingVo>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT saying_number, saying, person, category"
						+ " FROM sayings "
						+ " ORDER BY saying_number";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) { //list니까 while문 사용
				resultVo = new SayingVo();
				resultVo.setSaying_number(rs.getString("saying_number"));
				resultVo.setSaying(rs.getString("saying"));
				resultVo.setPerson(rs.getString("person"));
				resultVo.setCategory(rs.getString("category"));
				list.add(resultVo); //resultVo를 list에 담음
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;  //담은 list를 리턴.
	}//selectAll
	
	
	
	
	//단건조회
	public SayingVo selectOne(SayingVo sayingVo) {
		SayingVo resultVo = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT saying_number, saying, person, category"
						+ " FROM sayings "
						+ "WHERE saying_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sayingVo.getSaying_number());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVo = new SayingVo();
				resultVo.setSaying_number(rs.getString("saying_number"));
				resultVo.setSaying(rs.getString("saying"));
				resultVo.setPerson(rs.getString("person"));
				resultVo.setCategory(rs.getString("category"));
			} else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVo; // 리턴값 필요!
	} //selectOne
	
	
}

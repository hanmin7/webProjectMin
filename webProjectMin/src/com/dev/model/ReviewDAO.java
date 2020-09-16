package com.dev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.common.ConnectionManager;

public class ReviewDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	// 싱글톤
	static ReviewDAO instance;

	public static ReviewDAO getInstance() {
		if (instance == null)
			instance = new ReviewDAO();
		return instance;
	}
		
	
	public int insert(ReviewVo reviewVo) {
		int r =0;
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			
			// 2. sql 구문 실행
			String sql = "insert into reviews(saying_number, id, review)"
					 	+ "values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewVo.getSaying_number());		
			pstmt.setString(2, reviewVo.getId());		
			pstmt.setString(3, reviewVo.getReview());		
			
					
			r = pstmt.executeUpdate();

			// 3. 결과 처리
			if (r == 1) {
				System.out.println(r + "건이 처리됨");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4. 연결 해제 (연결횟수제한으로인해 해제까지 해줘야함)
			ConnectionManager.close(conn);
		}
		return r;
	} //인서트
	
	
	public int update(ReviewVo reviewVo) {
		int r=0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE reviews SET review = ? WHERE saying_number = ? AND id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewVo.getReview());
			pstmt.setString(2, reviewVo.getSaying_number()); 
			pstmt.setString(3, reviewVo.getId());

			r = pstmt.executeUpdate(); // 이때는 executeUpdate()에 sql안들어감.
			System.out.println(r + "건이 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return r;
	} //업뎃
	
	
	//내리뷰 리스트 reviewList
	public ArrayList<ReviewVo> reviewList(ReviewVo reviewVo){
		ReviewVo resultVo = null;
		ResultSet rs = null;
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select r.id,r.saying_number, s.saying, s.person, r.review"
						+ " from sayings s"
						+ " join reviews r"
						+ " on (s.SAYING_NUMBER = r.SAYING_NUMBER)"
						+ " where r.id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewVo.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				resultVo = new ReviewVo();
				resultVo.setId("id");
				resultVo.setSaying_number(rs.getString("saying_number"));
				resultVo.setReview(rs.getString("review"));
				resultVo.setPerson(rs.getString("person"));
				resultVo.setSaying(rs.getString("saying"));
				list.add(resultVo); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list; 
	}//reviewList
	
	
	//reviewSelectOne
	public ReviewVo selectOne(ReviewVo reviewVo) {
		ReviewVo resultVo = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT saying_number, review, id"
						+ " FROM reviews "
						+ "WHERE saying_number=? and id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewVo.getSaying_number());
			pstmt.setString(2, reviewVo.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVo = new ReviewVo();
				resultVo.setSaying_number(rs.getString("saying_number"));
				resultVo.setId(rs.getString("id"));
				resultVo.setReview(rs.getString("review"));
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
	
	
	public int delete(ReviewVo reviewVo) {
		int r=0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE reviews WHERE ID=? and saying_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewVo.getId());
			pstmt.setString(2, reviewVo.getSaying_number());
			r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		return r;
	} //삭제
	
	
	
}

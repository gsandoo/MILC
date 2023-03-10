package com.closet.san;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.closet.eun.MemberDTO;
import com.closet.rent.sanController;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	


	@Autowired
	private SqlSessionTemplate sqlSession;
	
	


	@Override
	public List<BoardDTO> selectList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			list=sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}		
		return list;
	}


	@Override
	public BoardDTO selectOne(int bdNum) {
		BoardDTO dto = null;
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOne",bdNum);
		} catch (Exception e) {
			e.printStackTrace();			
			// TODO: handle exception
		}
		return dto;
	}

	
	@Override
	public int delete(int bdNum) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete",bdNum);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return res;
	}

	


	@Override
	public int insert(BoardDTO dto) {
		// TODO Auto-generated method stub
		int res= 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+ "insert",dto);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return res;
	}
	
	
	@Override
	public int update(BoardDTO dto) {
		// TODO Auto-generated method stub
		int res= 0;
		
		try {
			res = sqlSession.update(NAMESPACE+ "update",dto);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return res;
	}



	@Override
	public int updateVisit(int num, BoardDTO dto) {
		int res= 0;
		
		try {
			res = sqlSession.update(NAMESPACE+ "updateVisit",dto);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return res;
	}
	
	

}

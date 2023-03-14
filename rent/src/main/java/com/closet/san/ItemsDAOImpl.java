package com.closet.san;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemsDAOImpl implements ItemsDAO {
	private static final Logger log = LoggerFactory.getLogger(ItemsDAOImpl.class);

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int itemsEnroll(ItemsDTO dto) {
		int res= 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"ItemsEnroll",dto);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return res;
		
	}

	@Override
	public List<ItemsDTO> getItemsPaging(Criteria cri) {
		int pageNum = cri.getPageNum();
		int amount = cri.getAmount();
		List<ItemsDTO> list = new ArrayList<ItemsDTO>();
		try {
			list=sqlSession.selectList(NAMESPACE + "selectList",pageNum );
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}		
		return list;
		
	}

	@Override
	public List<ItemsDTO> topsList() {
		
		log.info("상의 페이지 이동");
		
		// TODO Auto-generated method stub
		List<ItemsDTO> list = new ArrayList<ItemsDTO>();
		try {
			list=sqlSession.selectList(NAMESPACE + "topsList"); 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ItemsDTO> bottomsList() {
		// TODO Auto-generated method stub
		log.info("하의 페이지 이동");
		
		// TODO Auto-generated method stub
		List<ItemsDTO> list = new ArrayList<ItemsDTO>();
		try {
			list=sqlSession.selectList(NAMESPACE + "bottomsList"); 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ItemsDTO> onepieceList() {
		// TODO Auto-generated method stub
		log.info("원피스 페이지 이동");
		
		// TODO Auto-generated method stub
		List<ItemsDTO> list = new ArrayList<ItemsDTO>();
		try {
			list=sqlSession.selectList(NAMESPACE + "onepieceList"); 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ItemsDTO> accsList() {
		// TODO Auto-generated method stub
		log.info("악세서리 페이지 이동");
		
		// TODO Auto-generated method stub
		List<ItemsDTO> list = new ArrayList<ItemsDTO>();
		try {
			list=sqlSession.selectList(NAMESPACE + "accsList"); 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ItemsDTO priceHigh(int cate_code) {
		log.info("가격 높은 순");
		List<ItemsDTO> list = new ArrayList<ItemsDTO>();
		try {
			list=sqlSession.selectList(NAMESPACE + "priceHigh" , cate_code); 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return (ItemsDTO) list;
	}
	
	
	@Override
	public ItemsDTO priceLow(int cate_code) {
		// TODO Auto-generated method stub
		log.info("가격 낮은 순");
		List<ItemsDTO> list = new ArrayList<ItemsDTO>();
		try {
			list=sqlSession.selectList(NAMESPACE + "priceLow" , cate_code);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	

}

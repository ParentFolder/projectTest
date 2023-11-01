package com.Dapao.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dapao.domain.EntVO;
import com.Dapao.domain.ProdVO;

@Repository
public class ProdDAOImpl implements ProdDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.Dapao.mapper.ProdMapper";
	@Override
	public List<ProdVO> searchProd(ProdVO vo) {
		logger.debug(" DAO->searchProd(ProdVO vo)호출 ");
		logger.debug(" sqlsession : "+sqlSession.selectList(NAMESPACE+".searchProd", vo));
		return sqlSession.selectList(NAMESPACE+".searchProd", vo);
	}
	
	@Override
	public List<ProdVO> listProd(EntVO vo) {
		logger.debug(" DAO -> listProd(EntVO vo) 호출 ");
		return sqlSession.selectList(NAMESPACE+".listProd", vo);
	}

	@Override
	public void updateProd(ProdVO vo) {
		logger.debug(" DAO -> updateProd(ProdVO vo) 호출 ");
		sqlSession.update(NAMESPACE+".updateProd", vo);
	}
	@Override
	public void insertProd(ProdVO vo) {
		logger.debug(" DAO -> insertProd(ProdVO vo) 호출 ");
		sqlSession.insert(NAMESPACE+".insertProd", vo);
	}
	
}

package com.Dapao.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dapao.domain.ProdVO;

@Repository
public class ProdDAOImpl implements ProdDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdDAOImpl.class);
	
	@Autowired
	private SqlSession sqlsession;
	private static final String NAMESPACE = "com.Dapao.mapper.ProdMapper";
	@Override
	public List<ProdVO> searchProd(ProdVO vo) {
		logger.debug(" DAO->searchProd()호출 ");
		logger.debug(" sqlsession : "+sqlsession.selectList(NAMESPACE+".searchProd", vo));
		return sqlsession.selectList(NAMESPACE+".searchProd", vo);
	}
	@Override
	public void updateProd(ProdVO vo) {
		logger.debug(" DAO -> updateProd(ProdVO vo) 호출 ");
		sqlsession.update(NAMESPACE+".updateProd", vo);
	}
	@Override
	public void insertProd(ProdVO vo) {
		logger.debug(" DAO -> insertProd(ProdVO vo) 호출 ");
		sqlsession.insert(NAMESPACE+".insertProd", vo);
	}
	
}

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
	private static final String NAMESPACE = "com.Dapao.mapper.prodMapper";
	@Override
	public List<ProdVO> searchProd(ProdVO vo) {
		logger.debug(" DAO->searchProd()호출 ");
		
		return sqlsession.selectOne(NAMESPACE+"", vo);
	}

}

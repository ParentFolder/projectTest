package com.Dapao.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dapao.domain.EntVO;
import com.Dapao.domain.PageVO;
import com.Dapao.domain.TradeVO;

@Repository
public class EntDAOImpl implements EntDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EntDAOImpl.class);
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.Dapao.mapper.EntMapper";
	@Override
	public void entUpdate(EntVO vo) {
		logger.debug(" DAO -> EntUpdate(EntVO vo) 호출 ");
		sqlSession.update(NAMESPACE+".entUpdate",vo );
	}
	@Override
	public List<EntVO> listEnt(EntVO vo) {
		logger.debug(" DAO listEnt(String own_id) 호출 ");
		return sqlSession.selectList(NAMESPACE+".listEnt", vo);
	}
	@Override
	public List<TradeVO> searchTrade(PageVO vo) {
		logger.debug("DAO listTrade(String own_id) 호출 ");
		return sqlSession.selectList(NAMESPACE+".searchTrade", vo);
	}
	@Override
	public int searchTradeCount(PageVO vo) {
		logger.debug(" DAO searchTradeCount(PageVO vo) 호출 ");
		return sqlSession.selectOne(NAMESPACE+".searchTradeCount", vo);
	}
	@Override
	public void refund(TradeVO vo) {
		logger.debug(" DAO refund(TradeVO vo) 호출 ");
		sqlSession.delete(NAMESPACE+".refund", vo);
	}
	@Override
	public void entJoin(EntVO vo) throws Exception {
		logger.debug("DAOImpl entJoin() 실행 ");
		sqlSession.insert(NAMESPACE+".entJoin",vo);
		
	}
	@Override
	public EntVO entLogin(EntVO vo) throws Exception {
		logger.debug("DAOImpl entLogin() 실행");
		
		return sqlSession.selectOne(NAMESPACE+".entLogin",vo);
	}
	
}

package com.Dapao.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dapao.domain.EntVO;

@Repository
public class EntDAOImpl implements EntDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EntDAOImpl.class);
	@Autowired
	private SqlSession sqlsession;
	private static final String NAMESPACE = "com.Dapao.mapper.EntMapper";
	@Override
	public void entUpdate(EntVO vo) {
		logger.debug(" DAO -> EntUpdate(EntVO vo) 호출 ");
		sqlsession.update(NAMESPACE+".entUpdate",vo );
	}
	@Override
	public List<EntVO> listEnt(EntVO vo) {
		logger.debug(" DAO listEnt(String own_id) 호출 ");
		return sqlsession.selectList(NAMESPACE+".listEnt", vo);
	}
	
}

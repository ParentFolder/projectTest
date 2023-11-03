package com.Dapao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dapao.domain.EntVO;
import com.Dapao.domain.PageVO;
import com.Dapao.domain.TradeVO;
import com.Dapao.persistence.EntDAO;

@Service
public class EntServiceImpl implements EntService {
	
	private static final Logger logger = LoggerFactory.getLogger(EntServiceImpl.class);
	@Autowired
	private EntDAO edao;
	@Override
	public void entUpdate(EntVO vo) {
		logger.debug(" service -> entUpdate(EntVO vo) 호출 ");
		edao.entUpdate(vo);
		
	}

	@Override
	public List<EntVO> listEnt(EntVO vo) {
		logger.debug(" sevice listEnt(String own_id) 호출 ");
		return edao.listEnt(vo);
	}

	@Override
	public List<TradeVO> searchTrade(PageVO vo) {
		logger.debug(" seviced listTrade(String own_id) 호출 ");
		return edao.searchTrade(vo);
	}
	
}

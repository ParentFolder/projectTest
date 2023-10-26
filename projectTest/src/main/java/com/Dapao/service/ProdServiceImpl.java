package com.Dapao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dapao.domain.ProdVO;
import com.Dapao.persistence.ProdDAO;

public class ProdServiceImpl implements ProdService{
	
	private static final Logger logger = LoggerFactory.getLogger(ProdServiceImpl.class);
	@Autowired
	private ProdDAO pdao;
	@Override
	public List<ProdVO> searchProd(ProdVO vo) throws Exception{
		
		return pdao.searchProd(vo);
	}

}

package com.Dapao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dapao.domain.EntVO;
import com.Dapao.domain.PageVO;
import com.Dapao.domain.ProdVO;
import com.Dapao.persistence.ProdDAO;

@Service
public class ProdServiceImpl implements ProdService{
	
	private static final Logger logger = LoggerFactory.getLogger(ProdServiceImpl.class);
	@Autowired
	private ProdDAO pdao;
	@Override
	public List<ProdVO> searchProd(PageVO vo) throws Exception{
		logger.debug(" service searchProd(PageVO vo) 호출 ");
		return pdao.searchProd(vo);
	}
	
	@Override
	public List<ProdVO> listProd(EntVO vo) {
		logger.debug(" service listProd(EntVO vo) 호출 ");
		return pdao.listProd(vo);
	}

	@Override
	public void updateProd(ProdVO vo) throws Exception {
		logger.debug(" updatePord(ProdVO vo) 호출 ");
		pdao.updateProd(vo);
	}
	@Override
	public void insertProd(ProdVO vo) throws Exception {
		logger.debug(" insertPord(ProdVO vo) 호출 ");
		pdao.insertProd(vo);
	}

	@Override
	public int getProdList(String own_id) throws Exception {
		logger.debug(" getProdList(String own_id) 호출 ");
		return pdao.getProdList(own_id);
	}

	@Override
	public List<ProdVO> getListPage(PageVO vo) throws Exception {
		logger.debug("  getListPage(ProdVO vo) 호출 ");
		return pdao.getListPage(vo);
	}
	
}

package com.Dapao.service;

import java.util.List;

import com.Dapao.domain.ProdVO;

public interface ProdService {
	// 검색조건에 맞는 상품 검색 동작
	public List<ProdVO> searchProd(ProdVO vo) throws Exception;
	// 상품 수정하기
	public void updateProd(ProdVO vo) throws Exception;
	// 상품 등록하기
	public void insertProd(ProdVO vo) throws Exception;
	
}

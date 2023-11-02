package com.Dapao.service;

import java.util.List;

import com.Dapao.domain.EntVO;
import com.Dapao.domain.PageVO;
import com.Dapao.domain.ProdVO;

public interface ProdService {
	// 검색조건에 맞는 상품 검색 동작
	public List<ProdVO> searchProd(PageVO vo) throws Exception;
	// 특정 사업자 상품리스트 조회
	public List<ProdVO> listProd(EntVO vo);
	// 상품 수정하기
	public void updateProd(ProdVO vo) throws Exception;
	// 상품 등록하기
	public void insertProd(ProdVO vo) throws Exception;
	// 상품 전체 갯수
	public int getProdList(String own_id) throws Exception;
	// 페이징처리 후 리스트 목록조회
	public List<ProdVO> getListPage(PageVO vo) throws Exception;
	
	
}

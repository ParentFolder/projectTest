package com.Dapao.persistence;

import java.util.List;

import com.Dapao.domain.ProdVO;

public interface ProdDAO {
	// 특정 조건 상품검색
	public List<ProdVO> searchProd(ProdVO vo);
	// 상품 수정하기
	public void updateProd(ProdVO vo);
	// 상품 등록하기
	public void insertProd(ProdVO vo);
}

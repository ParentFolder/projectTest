package com.Dapao.persistence;

import java.util.List;

import com.Dapao.domain.ProdVO;

public interface ProdDAO {
	//특정 조건 상품검색
	public List<ProdVO> searchProd(ProdVO vo);
}

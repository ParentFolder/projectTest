package com.Dapao.persistence;

import java.util.List;

import com.Dapao.domain.EntVO;
import com.Dapao.domain.PageVO;
import com.Dapao.domain.TradeVO;

public interface EntDAO {
	// 가게 데이터 수정하기
	public void entUpdate(EntVO vo);
	// 특정 가게 데이터 조회
	public List<EntVO> listEnt(EntVO vo);
	// 가게 검색조건에 따른 주문 리스트 조회
	public List<TradeVO> searchTrade(PageVO vo);
	// 가게 검색조건에 따른 주문 리스트 총갯수
	public int searchTradeCount(PageVO vo);
	
}

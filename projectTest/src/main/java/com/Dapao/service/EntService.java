package com.Dapao.service;

import java.util.List;

import com.Dapao.domain.EntVO;
import com.Dapao.domain.PageVO;
import com.Dapao.domain.TradeVO;

public interface EntService {
	// 상점 정보 수정
	public void entUpdate(EntVO vo);
	// 특정 상점 정보 조회
	public List<EntVO> listEnt(EntVO vo);
	// 가게 주문 리스트 조회
	public List<TradeVO> searchTrade(PageVO vo);
	// 가게 주문 리스트 갯수
	public int searchTradeCount(PageVO vo);
	// 주문 환불
	public void refund(TradeVO vo);
}

package com.Dapao.service;

import java.util.List;

import com.Dapao.domain.EntVO;

public interface EntService {
	// 상점 정보 수정
	public void entUpdate(EntVO vo);
	// 특정 상점 정보 조회
	public List<EntVO> listEnt(EntVO vo);
}

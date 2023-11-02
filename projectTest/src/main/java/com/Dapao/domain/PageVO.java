package com.Dapao.domain;

import lombok.Data;

/*
 *  페이징 처리(+페이지 블럭)
 * 
 *  ex) 총 : 122개 / 페이지당 10개씩 출력
 *  	-> 페이지수 13
 *  
 * 		 	startPage		endPage		prev	next
 * (3페이지) 	1				10		 X		 O
 * (10페이지)	1				10		 X		 O
 * (12페이지)	11				20->13	 O		 X
 * 
 * 	endPage = (int)(Math.ceil(page / (double)displayPageNum)*displayPageNum);
 * 
 * 	만약 endPage / 필요한 총 페이지수를 비교하여 endpage가 더 클 때
 * 
 * 	startPage = (endPage - displayPageNum) +1;
 * 
 * 	prev = startPage == 1? false:true;
 * 	prev = startPage != 1;
 * 
 * 	next = endPage * pageSize >= totalCount? false : true;
 * 	next = endPage * pageSize < totalCount;
 * 
 * 	totalCount 
 * 
 */

@Data
public class PageVO {
	private int total_count; // 총 글의 수
	private int start_page; // 페이지의 블럭 시작 번호
	private int end_page; // 페이지의 블럭 끝 번호
	private int page = 1;
	private int page_size = 10;
	
	private boolean prev; // 이전
	private boolean next; // 다음
	private ProdVO p_vo;
	private int displayPageNum = 10; // 페이지 블럭의 크기
	
	public int getPage_start() {
		// 출력문 ( 필요에 따라 )
		return (this.page - 1) * page_size;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return ;
		}
		this.page = page;
	}
	public void setPageSize(int page_size) {
		if(page_size <= 0 || page_size > 100) {
			this.page_size = 10;
			return;
		}
		this.page_size = page_size;
	}
	public void setTotalCount(int totalCount) {
		this.total_count = totalCount;
		calcPageData();
	}

	// 페이징처리에 필요한 정보를 계산하는 메서드
	public void calcPageData() {
		end_page = (int)( Math.ceil(page / (double)displayPageNum) * displayPageNum);

		start_page = (end_page - displayPageNum) + 1;
	

		int tmpEndPage = (int) Math.ceil((total_count / (double) page_size));

		if (end_page > tmpEndPage) {
			end_page = tmpEndPage;
		}
		prev = start_page != 1;

		next = end_page * page_size < total_count;

	}

}

package com.Dapao.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewVO {
	
	private Integer rv_no;
	private String rv_own_id;
	private String rv_us_id;
	private String rv_buy_id;
	private String rv_content;
	private Integer rv_star;
	private Integer rv_state;
	private Date rv_regdate;
	private Date rv_outdate;

}

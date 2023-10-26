package com.Dapao.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class AccusationVO {
	
	private Integer ac_no;
	private Integer us_id;
	private String ac_own_id;
	private String ac_us_id;
	private String ac_cate;
	private String ac_content;
	private Integer ac_item;
	private Date ac_regdate;
	private Integer ac_state;
	private String ac_result;
	

}

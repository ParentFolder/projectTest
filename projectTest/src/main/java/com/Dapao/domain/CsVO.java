package com.Dapao.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class CsVO {
	
	private Integer cs_no;
	private String cs_title;
	private String cs_content;
	private Integer cs_group;
	private Integer cs_board;
	private Integer cs_state;
	private Integer cs_view;
	private Date cs_regdate;
	private Date cs_update;
	

}

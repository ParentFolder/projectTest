package com.Dapao.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class AdVO {
	
	private Integer ad_no;
	private String own_id;
	private Integer ad_board;
	private Integer ad_state;
	private Integer ad_view;
	private Date ad_regdate;
	private Date ad_update;
	private Date ad_upload;

}

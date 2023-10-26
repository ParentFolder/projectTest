package com.Dapao.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ExpListVO {
	
	private Integer exp_list_no;
	private Integer exp_no;
	private String own_id;
	private String us_id;
	private String exp_blog;
	private String exp_instar;
	private Date exp_regdate;

}

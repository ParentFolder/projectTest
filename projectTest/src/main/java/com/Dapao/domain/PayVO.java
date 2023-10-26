package com.Dapao.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class PayVO {
	
	private Integer pay_id;
	private String pay_tell;
	private Integer pay_price;
	private Integer pay_group;
	private Date pay_date;
	private Integer pay_state;
	private String pay_pg;
	private String pay_method;
	private String own_id;
	private String us_id;
	

}

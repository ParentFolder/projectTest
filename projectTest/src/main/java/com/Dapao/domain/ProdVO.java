package com.Dapao.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ProdVO {
	
	private Integer prod_no;
	private String prod_name;
	private String prod_price;
	private String prod_con;
	private String prod_content;
	private String prod_cate;
	private String prod_state;
	private Date prod_regdate;
	private Date prod_outdate;
	private String own_id;
	private String prod_img;

}

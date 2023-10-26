package com.Dapao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/ent/*")
public class EntController {

		private static final Logger logger = LoggerFactory.getLogger(EntController.class);
		// http://localhost:8088/ent/shopMain
		@RequestMapping(value = "/shopMain", method = RequestMethod.GET)
		public void entMainGET() {
			logger.debug(" shopMainGET() ");
			logger.debug(" 연결된 뷰페이지(/views/ent/shopMain.jsp) 출력 ");
		}

		// http://localhost:8088/ent/productManage
		@RequestMapping(value = "/productManage", method = RequestMethod.GET)
		public void productManageGET() {
			logger.debug(" entMainGET() ");
			logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
		}

		// http://localhost:8088/ent/order
		@RequestMapping(value = "/order", method = RequestMethod.GET)
		public void orderGET() {
			logger.debug(" orderGET() ");
			logger.debug(" 연결된 뷰페이지(/views/board/order.jsp)출력 ");
		}
}


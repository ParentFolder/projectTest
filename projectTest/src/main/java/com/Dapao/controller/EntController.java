package com.Dapao.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Dapao.domain.ProdVO;
import com.Dapao.service.ProdService;

@Controller
@RequestMapping(value = "/ent/*")
public class EntController {

		private static final Logger logger = LoggerFactory.getLogger(EntController.class);
		@Autowired
		private ProdService pService; 
		// http://localhost:8088/ent/shopMain
		@RequestMapping(value = "/shopMain", method = RequestMethod.GET)
		public void entMainGET() {
			logger.debug(" shopMainGET() ");
			logger.debug(" 연결된 뷰페이지(/views/ent/shopMain.jsp) 출력 ");
		}

		// http://localhost:8088/ent/productManage
		@RequestMapping(value = "/productManage", method = RequestMethod.GET)
		public void productManageGET() {
			logger.debug(" productManageGET()");
			logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
		}
		// http://localhost:8088/ent/productManage
		@RequestMapping(value = "/productManage", method = RequestMethod.POST)
		public void productManagePOST(ProdVO vo, Model model) throws Exception {
			logger.debug(" productManagerPOST() ");
			logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
			List<ProdVO> plist = pService.searchProd(vo);
			model.addAttribute("plist", plist);
			
		}

		// http://localhost:8088/ent/order
		@RequestMapping(value = "/entOrder", method = RequestMethod.GET)
		public void orderGET() {
			logger.debug(" entOrderGET() ");
			logger.debug(" 연결된 뷰페이지(/views/entOrder.jsp)출력 ");
		}
}


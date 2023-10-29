package com.Dapao.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
		public void shopMainGET() {
			logger.debug(" shopMainGET() ");
			logger.debug(" 연결된 뷰페이지(/views/ent/shopMain.jsp) 출력 ");
		}
		// http://localhost:8088/ent/shopMainManage
		@RequestMapping(value = "/shopMainManage", method = RequestMethod.GET)
		public void shopMainManageGET() {
			logger.debug(" shopMainGET() ");
			logger.debug(" 연결된 뷰페이지(/views/ent/shopMain.jsp) 출력 ");
		}

		// http://localhost:8088/ent/productManage
		@RequestMapping(value = "/productManage", method = RequestMethod.GET)
		public void productManageGET(HttpSession session) {
			logger.debug(" productManageGET()");
			logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
			Integer modal_cate = 0;
			session.setAttribute("modal_cate", modal_cate);
			session.setAttribute("own_id", 7);
		}
		// http://localhost:8088/ent/productManage
		@RequestMapping(value = "/productManage", method = RequestMethod.POST)
		public void productManagePOST(ProdVO vo, Model model) throws Exception {
			logger.debug(" productManagerPOST() ");
			logger.debug(" vo : "+vo);
			Integer modal_cate = 0;
			List<ProdVO> plist = pService.searchProd(vo);
			model.addAttribute("plist", plist);
			model.addAttribute("modal_cate", modal_cate);
			
			logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
		}

		// http://localhost:8088/ent/order
		@RequestMapping(value = "/entOrder", method = RequestMethod.GET)
		public void orderGET() {
			logger.debug(" entOrderGET() ");
			logger.debug(" 연결된 뷰페이지(/views/entOrder.jsp)출력 ");
		}
		@RequestMapping(value = "/productUpdate", method = RequestMethod.POST)
		public String productUpdatePOST(ProdVO vo, Integer modal_cate) throws Exception {
			logger.debug(" productUpdatePOST() 호출 ");
			logger.debug(" vo : "+vo);
			logger.debug(" modal_cate : "+modal_cate);
			if(modal_cate == 1) {
				pService.updateProd(vo);
				logger.debug(" update ");
			}else {
				pService.insertProd(vo);
				logger.debug(" insert ");
			}
			return "redirect:/ent/productManage";
		}
}


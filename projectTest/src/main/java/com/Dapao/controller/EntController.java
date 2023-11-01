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

import com.Dapao.domain.EntVO;
import com.Dapao.domain.ProdVO;
import com.Dapao.domain.ReviewVO;
import com.Dapao.domain.TradeVO;
import com.Dapao.service.EntService;
import com.Dapao.service.ProdService;

@Controller
@RequestMapping(value = "/ent/*")
public class EntController {

		private static final Logger logger = LoggerFactory.getLogger(EntController.class);
		@Autowired
		private ProdService pService; 
		@Autowired
		private EntService eService;
		
		// http://localhost:8088/ent/shopMain
		@RequestMapping(value = "/shopMain", method = RequestMethod.GET)
		public void shopMainGET(EntVO eVo, ReviewVO rVo, Model model) throws Exception {
			logger.debug(" shopMainGET(EntVO eVO, ProdVO pVO, ReviewVO rVO, Model model) 호출 ");
			String own_id = "6";
			eVo.setOwn_id(own_id);
			logger.debug("eService.listEnt(eVo): "+eService.listEnt(eVo));
			List<ProdVO> plist = pService.listProd(eVo);
			logger.debug(" plist : "+plist);
			
			model.addAttribute("ent", eService.listEnt(eVo));
			model.addAttribute("plist", plist);
			
			logger.debug(" 연결된 뷰페이지(/views/ent/shopMain.jsp) 출력 ");
		}
		
		// http://localhost:8088/ent/shopMainManage
		@RequestMapping(value = "/shopMainManage", method = RequestMethod.GET)
		public void shopMainManageGET(EntVO eVo, Model model) {
			logger.debug(" shopMainManageGET(EntVO eVo, Model model) 호출 ");
			String own_id = "6";
			eVo.setOwn_id(own_id);
			logger.debug(" eVO: "+eVo);
			logger.debug("eService.listEnt(eVo): "+eService.listEnt(eVo));
			model.addAttribute("ent", eService.listEnt(eVo));
			
			logger.debug(" 연결된 뷰페이지(/views/ent/shopMain.jsp) 출력 ");
		}
		// http://localhost:8088/ent/shopMainManage
		@RequestMapping(value = "/shopMainManage", method = RequestMethod.POST)
		public void shopMainManagePOST(EntVO eVo, Model model) {
			logger.debug(" shopMainManagePOST(EntVO eVo, Model model) 호출 ");
			String id = "6";
			eVo.setOwn_id(id);
			logger.debug(" eVo : "+eVo);
			eService.entUpdate(eVo);
			logger.debug("eService.listEnt(eVo): "+eService.listEnt(eVo));
			model.addAttribute("ent", eService.listEnt(eVo));
			
			logger.debug(" 연결된 뷰페이지(/views/ent/shopMainManage.jsp) 출력 ");
		}

		// http://localhost:8088/ent/productManage
		@RequestMapping(value = "/productManage", method = RequestMethod.GET)
		public void productManageGET(HttpSession session) {
			logger.debug(" productManageGET()");
			logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
			Integer modal_cate = 0;
			session.setAttribute("modal_cate", modal_cate);
			session.setAttribute("own_id", 6);
		}
		// http://localhost:8088/ent/productManage
		@RequestMapping(value = "/productManage", method = RequestMethod.POST)
		public void productManagePOST(ProdVO vo, EntVO eVO, Model model) throws Exception {
			logger.debug(" productManagerPOST() ");
			logger.debug(" vo : "+vo);
			List<ProdVO> plist = pService.searchProd(vo);
			Integer modal_cate = 0;
			eVO.setOwn_id("6");
			model.addAttribute("ent", eVO);
			model.addAttribute("plist", plist);
			model.addAttribute("modal_cate", modal_cate);
			
			logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
		}

		// http://localhost:8088/ent/entOrder
		@RequestMapping(value = "/entOrder", method = RequestMethod.GET)
		public void orderGET(EntVO vo, Model model) {
			logger.debug(" entOrderGET() ");
			
			
			logger.debug(" 연결된 뷰페이지(/views/entOrder.jsp)출력 ");
		}
		// http://localhost:8088/ent/entOrder
		@RequestMapping(value = "/entOrder", method = RequestMethod.GET)
		public void orderPOST(EntVO eVo,String search_cate, String search, Model model) {
			logger.debug(" entOrderPOST(EntVO eVo, String search, Model model) 호출 ");
			logger.debug(" eVo : "+eVo);
			
			
			
			
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


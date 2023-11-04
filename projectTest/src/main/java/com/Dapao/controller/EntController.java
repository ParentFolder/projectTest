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
import org.springframework.web.bind.annotation.RequestParam;

import com.Dapao.domain.EntVO;
import com.Dapao.domain.PageVO;
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
			session.setAttribute("own_id", "6");

		}
		// http://localhost:8088/ent/productManage
		@RequestMapping(value = "/productManage", method = RequestMethod.POST)
		public void productManagePOST(ProdVO vo, EntVO eVo, Model model,PageVO pVo) throws Exception {
			logger.debug(" productManagerPOST() ");
			logger.debug(" vo : "+vo);
			pVo.setP_vo(vo);
			pVo.setTotalCount(pService.getProdList(vo.getOwn_id()));
			logger.debug(" pVo : "+pVo);
			List<ProdVO> plist = pService.searchProd(pVo);
			Integer modal_cate = 0;
			model.addAttribute("ent", eVo);
			model.addAttribute("plist", plist);
			model.addAttribute("modal_cate", modal_cate);
			model.addAttribute("pageVO", pVo);
			
			logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
		}

		// http://localhost:8088/ent/entOrder
		// http://localhost:8088/ent/entOrder?own_id=6
		@RequestMapping(value = "/entOrder", method = RequestMethod.GET)
		public void orderGET(@RequestParam("own_id") String own_id, Model model) {
			logger.debug(" entOrderGET() ");
			logger.debug(" own_id : "+own_id);
		
			model.addAttribute("own_id", own_id);
			
			logger.debug(" 연결된 뷰페이지(/views/entOrder.jsp)출력 ");
		}
		// http://localhost:8088/ent/entOrder
		@RequestMapping(value = "/entOrder", method = RequestMethod.POST)
		public void orderPOST(PageVO vo ,String search_cate, String search, String own_id, Model model) throws Exception {
			logger.debug(" entOrderPOST(PageVO vo, String search, Model model) 호출 ");
			ProdVO pVo = new ProdVO();
			logger.debug(" pageVo "+vo);
			logger.debug(" own_id : "+own_id);
			pVo.setOwn_id(own_id);
			
			List<TradeVO> tlist; 
			if(search_cate.contains("prod")) {
				// 검색조건이 상품명일경우
				logger.debug("상품명 주문조회");
				pVo.setProd_name(search);
				TradeVO tVo = new TradeVO();
				Integer tr_no = null; // 안넣으면 비교를 못함
				tVo.setTr_no(tr_no); 
				vo.setT_vo(tVo);
				vo.setP_vo(pVo);
				vo.setTotal_count(eService.searchTradeCount(vo));
				logger.debug(" pageVo "+vo);
				// trade게시판 own_id이 가지고 있는 검색한 상품명을 검색
				tlist = eService.searchTrade(vo);
				logger.debug(" tlist : "+tlist);
				model.addAttribute("tlist", tlist);
				
			}else if(search_cate.contains("tr_no")) {
				logger.debug("주문번호 주문조회");
				// 검색조건이 주문번호일 경우
				TradeVO tVo = new TradeVO();
				Integer tr_no = Integer.parseInt(search);
				tVo.setTr_no(tr_no);
				vo.setP_vo(pVo);
				vo.setT_vo(tVo);
				vo.setTotal_count(eService.searchTradeCount(vo));
				logger.debug(" pageVo "+vo);
				// own_id이 받은 검색한 주문번호에 해당하는 것을 검색
				tlist = eService.searchTrade(vo);
				model.addAttribute("tlist", tlist);
			}
			
			
			model.addAttribute("pageVO", vo);
			
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
		// 게시판 목록조회(페이징처리)
		// http://localhost:8088/board/listPage
		@RequestMapping(value = "/listPage", method = RequestMethod.GET)
		public void listPageGET(PageVO vo, Model model, HttpSession session) throws Exception {
			logger.debug(" listPageGET() 호출 ");
			// 페이징처리( 페이지 블럭 처리 객체)
			String own_id =(String) session.getAttribute("own_id");
			logger.debug(" own_id : "+own_id);
			ProdVO pVo = new ProdVO();
			pVo.setOwn_id(own_id);
			vo.setP_vo(pVo);
			vo.setTotalCount(pService.getProdList(own_id));
			logger.debug("TotalCount : "+vo.getTotal_count());
			logger.debug(" vo : "+vo);
			List<ProdVO> plist = pService.searchProd(vo);

			// 리스트 사이즈 확인
			logger.debug(" 글 개수 : " +plist.size());

			// Model 객체에 리스트 정보를 저장
			model.addAttribute("plist", plist);
			model.addAttribute("pageVO", vo);
		}

}


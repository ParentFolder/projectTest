package com.Dapao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public void shopMainGET(HttpSession session, ReviewVO rVo, Model model) throws Exception {
		logger.debug(" shopMainGET(EntVO eVO, ProdVO pVO, ReviewVO rVO, Model model) 호출 ");
		String own_id = "6";
//		String own_id = (String) session.getAttribute("own_id");

		EntVO eVo = new EntVO();
		eVo.setOwn_id(own_id);
		logger.debug("eService.listEnt(eVo): " + eService.listEnt(eVo));
		List<ProdVO> plist = pService.listProd(eVo);
		logger.debug(" plist : " + plist);
		String fileList[] = new String[plist.size()];
		for (int i = 0; i < plist.size(); i++) {
			fileList[i] = plist.get(i).getProd_img().substring(plist.get(i).getProd_img().lastIndexOf("\\") + 1);
//			fileList[i]=plist.get(i).getProd_img();
			logger.debug(" fileList[i] : " + fileList[i]);

//			logger.debug(" plist.get(i).getProd_img().split(\"@\"): "+plist.get(i).getProd_img().split("@"));
		}
		logger.debug("fileList : " + fileList);
		String name = "상점 메인페이지";
		model.addAttribute("fileList", fileList);
		model.addAttribute("ent", eService.listEnt(eVo));
		model.addAttribute("plist", plist);
		model.addAttribute("name", name);

		session.setAttribute("own_id", own_id);

		logger.debug(" 연결된 뷰페이지(/views/ent/shopMain.jsp) 출력 ");
	}

	// http://localhost:8088/ent/shopMainManage
	@RequestMapping(value = "/shopMainManage", method = RequestMethod.GET)
	public void shopMainManageGET(HttpSession session, Model model) {
		logger.debug(" shopMainManageGET(EntVO eVo, Model model) 호출 ");
		String own_id = "6";
//		String own_id = (String) session.getAttribute("own_id");
		String name = "상점 메인페이지 수정";
		EntVO eVo = new EntVO();
		eVo.setOwn_id(own_id);
		logger.debug(" eVO: " + eVo);
		logger.debug("eService.listEnt(eVo): " + eService.listEnt(eVo));
		model.addAttribute("ent", eService.listEnt(eVo));
		model.addAttribute("name", name);
		session.setAttribute("own_id", own_id);
		logger.debug(" 연결된 뷰페이지(/views/ent/shopMain.jsp) 출력 ");
	}

	// http://localhost:8088/ent/shopMainManage
	@RequestMapping(value = "/shopMainManage", method = RequestMethod.POST)
	public void shopMainManagePOST(EntVO eVo, Model model, MultipartHttpServletRequest mhsr,
			HttpServletResponse response) throws IllegalStateException, IOException {
		logger.debug(" shopMainManagePOST(EntVO eVo, Model model) 호출 ");
		String id = "6";
		String name = "상점 메인페이지 수정";
		eVo.setOwn_id(id);
		logger.debug(" eVo : " + eVo);
		List<MultipartFile> fileList = mhsr.getFiles("file");
		logger.debug(" fileList : " + fileList);
		ArrayList<String> imgList = new ArrayList<String>();
		String path = "C:\\upload"; // 경로
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		logger.debug(" path : " + path);
		for (MultipartFile mf : fileList) {
			String genId = UUID.randomUUID().toString(); // 중복 처리
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명

			String saveFile = path + "\\" + genId + "_" + originFileName; // 저장할 위치
			String saveFileName = genId + "_" + originFileName; // 저장할 파일명
			logger.debug(" saveFile : " + saveFile);
			imgList.add(saveFileName);
			logger.debug("imgList : " + imgList);
			mf.transferTo(new File(saveFile));
			logger.debug("mf 됨");
		}
		eVo.setEnt_img(String.join(",", imgList));
		eService.entUpdate(eVo);
		logger.debug("eService.listEnt(eVo): " + eService.listEnt(eVo));
		model.addAttribute("ent", eService.listEnt(eVo));
		model.addAttribute("name", name);
		logger.debug(" 연결된 뷰페이지(/views/ent/shopMainManage.jsp) 출력 ");
	}

	// http://localhost:8088/ent/productManage
	@RequestMapping(value = "/productManage", method = RequestMethod.GET)
	public void productManageGET(HttpSession session, Model model) {
		logger.debug(" productManageGET()");
		logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
		Integer modal_cate = 0;
		String name = "상품 조회/수정/등록";
		session.setAttribute("modal_cate", modal_cate);
		session.setAttribute("own_id", "6");
		model.addAttribute("name", name);
	}

	// http://localhost:8088/ent/productManage
	@RequestMapping(value = "/productManage", method = RequestMethod.POST)
	public void productManagePOST(ProdVO vo, Model model, PageVO pVo) throws Exception {
		logger.debug(" productManagerPOST() ");
		String name = "상품 조회/수정/등록";
		logger.debug(" vo : " + vo);
		pVo.setP_vo(vo);
		pVo.setTotalCount(pService.getProdList(vo.getOwn_id()));
		logger.debug(" pVo : " + pVo);
		List<ProdVO> plist = pService.searchProd(pVo);
		Integer modal_cate = 0;
		model.addAttribute("plist", plist);
		model.addAttribute("modal_cate", modal_cate);
		model.addAttribute("pageVO", pVo);
		model.addAttribute("name", name);
		logger.debug(" 연결된 뷰페이지(/views/ent/productManage.jsp)출력 ");
	}

	// http://localhost:8088/ent/entOrder
	// http://localhost:8088/ent/entOrder?own_id=6
	@RequestMapping(value = "/entOrder", method = RequestMethod.GET)
	public void orderGET(@RequestParam("own_id") String own_id, Model model) {
		logger.debug(" entOrderGET() ");
		logger.debug(" own_id : " + own_id);
		String name = "주문관리";
		model.addAttribute("own_id", own_id);
		model.addAttribute("name", name);
		logger.debug(" 연결된 뷰페이지(/views/entOrder.jsp)출력 ");
	}

	// http://localhost:8088/ent/entOrder
	@RequestMapping(value = "/entOrder", method = RequestMethod.POST)
	public void orderPOST(PageVO vo, String search_cate, String search, String own_id, Model model) throws Exception {
		logger.debug(" entOrderPOST(PageVO vo, String search, Model model) 호출 ");
		ProdVO pVo = new ProdVO();
		String name = "주문관리";
		logger.debug(" pageVo " + vo);
		logger.debug(" own_id : " + own_id);
		pVo.setOwn_id(own_id);

		List<TradeVO> tlist;
		if (search_cate.contains("prod")) {
			// 검색조건이 상품명일경우
			logger.debug("상품명 주문조회");
			pVo.setProd_name(search);
			TradeVO tVo = new TradeVO();
			Integer tr_no = null; // 안넣으면 비교를 못함
			tVo.setTr_no(tr_no);
			vo.setT_vo(tVo);
			vo.setP_vo(pVo);
			vo.setTotal_count(eService.searchTradeCount(vo));
			logger.debug(" pageVo " + vo);
			// trade게시판 own_id이 가지고 있는 검색한 상품명을 검색
			tlist = eService.searchTrade(vo);
			logger.debug(" tlist : " + tlist);
			model.addAttribute("tlist", tlist);

		} else if (search_cate.contains("tr_no")) {
			logger.debug("주문번호 주문조회");
			// 검색조건이 주문번호일 경우
			TradeVO tVo = new TradeVO();
			Integer tr_no = Integer.parseInt(search);
			tVo.setTr_no(tr_no);
			vo.setP_vo(pVo);
			vo.setT_vo(tVo);
			vo.setTotal_count(eService.searchTradeCount(vo));
			logger.debug(" pageVo " + vo);
			// own_id이 받은 검색한 주문번호에 해당하는 것을 검색
			tlist = eService.searchTrade(vo);
			model.addAttribute("tlist", tlist);
		}
		model.addAttribute("name", name);
		model.addAttribute("pageVO", vo);

		logger.debug(" 연결된 뷰페이지(/views/entOrder.jsp)출력 ");
	}

	@RequestMapping(value = "/productUpdate", method = RequestMethod.POST)
	public String productUpdatePOST(ProdVO vo, Integer modal_cate, Model model, final MultipartHttpServletRequest mhsr,
			HttpServletResponse response) throws Exception {
		logger.debug(" productUpdatePOST() 호출 ");
		logger.debug(" vo : " + vo);
		logger.debug(" modal_cate : " + modal_cate);
		String name = "상품 조회/수정/등록";
		List<MultipartFile> fileList = mhsr.getFiles("file");
		logger.debug(" fileList : " + fileList);
		ArrayList<String> imgList = new ArrayList<String>();
//		String path = mhsr.getServletContext().getRealPath("\\upload"); // 경로
		String path = "C:\\upload"; // 경로
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		logger.debug(" path : " + path);
		for (MultipartFile mf : fileList) {
			String genId = UUID.randomUUID().toString(); // 중복 처리
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명

			String saveFile = path + "\\" + genId + "_" + originFileName; // 저장할 경로
			String saveFileName = genId + "_" + originFileName; // 저장할 파일명
			logger.debug(" saveFile : " + saveFile);
			imgList.add(saveFileName);
			logger.debug("imgList : " + imgList);
			mf.transferTo(new File(saveFile));
			logger.debug("mf 됨");
		}
		vo.setProd_img(String.join(",", imgList));
		if (modal_cate == 1) {
			pService.updateProd(vo);
			logger.debug(" update ");
		} else {

			pService.insertProd(vo);
			logger.debug(" insert ");
		}
		model.addAttribute("name", name);
		return "redirect:/ent/productManage";
	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPageGET(PageVO vo, Model model, HttpSession session) throws Exception {
		logger.debug(" listPageGET() 호출 ");
		// 페이징처리( 페이지 블럭 처리 객체)
		String own_id = (String) session.getAttribute("own_id");
		logger.debug(" own_id : " + own_id);
		String name = "상품 조회/수정/등록";
		ProdVO pVo = new ProdVO();
		pVo.setOwn_id(own_id);
		vo.setP_vo(pVo);
		vo.setTotalCount(pService.getProdList(own_id));
		logger.debug("TotalCount : " + vo.getTotal_count());
		logger.debug(" vo : " + vo);
		List<ProdVO> plist = pService.searchProd(vo);

		// 리스트 사이즈 확인
		logger.debug(" 글 개수 : " + plist.size());

		// Model 객체에 리스트 정보를 저장
		model.addAttribute("plist", plist);
		model.addAttribute("pageVO", vo);
		model.addAttribute("name", name);
	}

	@RequestMapping(value = "/refund", method = RequestMethod.GET)
	public String refundGET(TradeVO vo) {
		logger.debug(" refundGET(TradeVO vo) 호출 ");
		eService.refund(vo);
		return "redirect:/ent/entOrder";
	}

	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response,
			HttpServletRequest req) throws Exception {
		// String downFile = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
//		String downFile = req.getRealPath("/upload") + "\\" + imageFileName;
		String downFile = "C:\\upload" + "\\" + imageFileName;
		logger.debug(" downFile : " + downFile);
		File file = new File(downFile);

		// 한글 파일의 경우 인코딩문제로 인하여 다운로드 문제 발생(파일이름 오류)
		imageFileName = URLEncoder.encode(imageFileName, "UTF-8");

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(file);

		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer);
			if (count == -1)
				break;
			out.write(buffer, 0, count);
		}
		out.close();
		in.close();
	}

	@RequestMapping(value = "/entJoin", method = RequestMethod.POST)
	public String entJoinPOST(/* @ModelAttribute */ EntVO vo) throws Exception {
		logger.debug("entJoinPOST() 호출");
		// 전달정보 저장(회원가입 정보)
		logger.debug("vo : " + vo);

		// DAOImpl -> DB에 정보 저장
		// mdao.insertMember(vo);
		eService.entJoin(vo);

		logger.debug("회원가입 완료!");

		// 로그인 페이지로 이동(redirect)
		return "redirect:/ent/entLogin";
	}

	// http://localhost:8088/ent/entLogin
	@RequestMapping(value = "/entLogin", method = RequestMethod.GET)
	public void entLoginGET() throws Exception {
		logger.debug("entLoginGET() 호출");
		logger.debug("연결된 view 페이지 호출 (/views/etn/entLogin.jsp)");
	}

	@RequestMapping(value = "/entLogin", method = RequestMethod.POST)
	public String entLoginPOST(EntVO vo, HttpSession session) throws Exception {
		logger.debug("entLoginPOST() 호출");
		logger.debug("vo : " + vo);

		EntVO resultVO = eService.entLogin(vo);
		logger.debug("resultVO : " + resultVO);

		// 로그인 실패
		if (resultVO == null) {
			return "redirect:/member/login";
		}
		// 로그인 성공 아이디 세션에 저장
		session.setAttribute("own_id", resultVO.getOwn_id());

		return "redirect:/ent/entMain";
	}

	// http://localhost:8088/ent/entMain
	@RequestMapping(value = "/entMain", method = RequestMethod.GET)
	public void entMainGET(HttpSession session) throws Exception {
		logger.debug("entMainGET() 호출");
		logger.debug("연결된 view 페이지 호출 (/views/etn/entMain.jsp)");
	}

	@RequestMapping(value = "/entLogout", method = { RequestMethod.GET, RequestMethod.POST })
	public String entLogoutGET(HttpSession session) {
		logger.debug("logoutGET() 호출");

		// 로그아웃 처리 => 세션정보 초기화
		session.invalidate();
		// 메인페이지로 이동

		return "redirect:/ent/entMain";
	}
}

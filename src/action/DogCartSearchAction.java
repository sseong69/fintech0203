package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogCartSearchService;
import vo.ActionForward;
import vo.Cart;

public class DogCartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DogCartSearchService dogCartSearchService = new DogCartSearchService();
		// 장바구니 항목에 대해 시작금액과 종료금액을 주고 조회처리
		int startMoney = Integer.parseInt(request.getParameter("startMoney"));
		int endMoney = Integer.parseInt(request.getParameter("endMoney"));
		// 장바구니 검색처리
		ArrayList<Cart> cartList = dogCartSearchService.getCartSearchList(startMoney,endMoney,request);
		// 금액구간에 대한 장바구니 내역이 cartList에 대입되어 있다.
		request.setAttribute("cartList", cartList);
		request.setAttribute("startMoney", startMoney);
		request.setAttribute("endMoney", endMoney);
		int totalMoney = 0;
		int money = 0 ;
		// 장바구니 검색후 해당리스트를 화면에 출력
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		// 장바구니에서 검색한 내역을 보여주기 위해 장바구니 리스트로 이동
		ActionForward forward = new ActionForward("dogCartList.jsp", false);
		return forward;
	}
	
}

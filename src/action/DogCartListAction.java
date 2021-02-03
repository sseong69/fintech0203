package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogCartListService;
import vo.ActionForward;
import vo.Cart;

public class DogCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 장바구니 목록보기를  구현하는 비지니스 로직
		DogCartListService dogCartListService = new DogCartListService();
		// 전체 장바구니 내역을 가져와서 Cart형태의 ArrayList 구조에 대입시킨다
		ArrayList<Cart> cartList = dogCartListService.getCartList(request);
		//총금액계산
		int totalMoney = 0;
		int money = 0 ;
		
		for (int i = 0; i < cartList.size(); i++) {
			// 장바구니 소계계산 = 강아지 가격 * 마리 수
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money; // 총 합계 금액에 소계를 누적시킨다.
		}
		// request scope (영역)에 합계금액과 장바구니 리스트 정보를 속성으로 지정하여 응답처리전까지 유효
		// scope(영역) ? page < request < session < application
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("dogCartList.jsp", false);
		return forward;
	}

}

package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

public class DogCartListService {
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 세션속성인 cartList의 내역을 가져와서 ArrayList형태로 받아 리턴
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		return cartList;
	}
	
}

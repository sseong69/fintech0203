package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

public class DogCartSearchService {

	@SuppressWarnings("unchecked")
	public ArrayList<Cart> getCartSearchList(int start_money, int end_money, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 장바구니 검색전  리스트
		ArrayList<Cart> oldCartList = (ArrayList<Cart>)session.getAttribute("cartList");
		// 금액구간에 대한 검색처리 이후의  장바구니 리스트
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		
		for (int i = 0; i < oldCartList.size(); i++) {
			
			if(oldCartList.get(i).getPrice()>=start_money && oldCartList.get(i).getPrice()<=end_money){
				cartList.add(oldCartList.get(i));
			}
			
		}
		
		return cartList;
	}
	
}
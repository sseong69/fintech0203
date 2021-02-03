package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

public class DogCartQtyUpService {

	
	@SuppressWarnings("unchecked")
	public void upCartQty(String kind, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		//장바구니에 같은 품종이면 수량만1 증가
		for (int i = 0; i < cartList.size(); i++) {
			
			if(cartList.get(i).getKind().equals(kind)){
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
			}
			
		}
		
	}
	
}

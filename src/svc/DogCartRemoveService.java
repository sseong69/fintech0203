package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

public class DogCartRemoveService {
	// kindArray? 장바구니에서 삭제하려고 선택한 품종을 가지고 있는 배열
	@SuppressWarnings("unchecked")
	public void cartRemove(HttpServletRequest request, String[] kindArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		// 삭제시킬 품종을 반복해서 장바구니 항목과 비교한 후 삭제처리
		for (int i = 0; i < kindArray.length; i++) {
			
			for (int j = 0; j < cartList.size(); j++) {
				
				if(cartList.get(j).getKind().equals(kindArray[i])){
						cartList.remove(cartList.get(j));
					
				}
				
			}
			
		}
		
	}
}
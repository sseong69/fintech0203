package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogCartAddService;
import vo.ActionForward;
import vo.Dog;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 장바구니에 강아지 내역을 추가하는 비지니스로직을 처리
		DogCartAddService dogCartAddService = new DogCartAddService();
		// 장바구니에 강아지 정보를 담기 위해 해당강아지 아이디 값을 가져온다.
		int id = Integer.parseInt(request.getParameter("id"));
		// 해당 강아지 정보를 가져오는 메서드
		Dog cartDog = dogCartAddService.getCartDog(id);
		// 장바구니 세션에 해당 강아지 정보를 추가시킨다.
		dogCartAddService.addCart(request,cartDog);
		// 장바구니 리스트로 리다이렉트(강제로 보냄) 시킨다 
		ActionForward forward = new ActionForward("dogCartList.dog", true);
		return forward;
	}

}

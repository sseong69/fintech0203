package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import action.Action;
import action.DogCartAddAction;
import action.DogCartListAction;
import action.DogCartQtyDownAction;
import action.DogCartQtyUpAction;
import action.DogCartRemoveAction;
import action.DogCartSearchAction;
import action.DogListAction;
import action.DogRegistAction;
import action.DogRegistFormAction;
import action.DogViewAction;

@WebServlet("*.dog")
public class DogFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1. 요청파악
		String requestURI = request.getRequestURI();
		//요청 URL : http://localhost:8088/DogShopping/dogRegistForm.dog
		//requestURI : /DogShopping/dogRegistForm.dog 반환
		
		String contextPath = request.getContextPath();
		//   /DogShopping 반환
		String command = requestURI.substring(contextPath.length());
		//   /dogRegistForm.dog 반환
		
		Action action = null;
		ActionForward forward = null;
		
		//2.각 요청별로 비지니스로직 호출
		if(command.equals("/dogList.dog")){ //강아지 전체보기
			action = new DogListAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogView.dog")){//특정 강아지 상세보기
			action = new DogViewAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartAdd.dog")){//강아지 장바구니 담기
			action = new DogCartAddAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartList.dog")){//장바구니 리스트
			action = new DogCartListAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartSearch.dog")){//장바구니 검색
			action = new DogCartSearchAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartRemove.dog")){//장바구니 삭제
			action = new DogCartRemoveAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartQtyUp.dog")){//장바구니 구매갯수 1증가 시키기
			action = new DogCartQtyUpAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartQtyDown.dog")){//장바구니 구매갯수 1감소 시키기
			action = new DogCartQtyDownAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogRegist.dog")){//강아지 신규 등록 처리
			action = new DogRegistAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogRegistForm.dog")){//강아지 신규 입력 폼
			action = new DogRegistFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//3. 포워딩
		if(forward !=null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
		
	}
	
}

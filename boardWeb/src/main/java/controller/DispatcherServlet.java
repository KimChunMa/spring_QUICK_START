package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request,response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response )  throws ServletException, IOException {
	 String uri = request.getRequestURI();
	 String path = uri.substring(uri.lastIndexOf("/"));
	 System.out.println(uri.lastIndexOf("/"));
	 System.out.println(path);
	 
	 if(path.equals("/login.do")) {
		 System.out.println("로그인 처리");
	 }
	 else if(path.equals("/logout.do")) {
		 System.out.println("로그아웃 처리");
	 }
	 else if(path.equals("/insertBoard.do")) {
		 System.out.println("글 등록");
	 }
	 else if(path.equals("/deleteBoard.do")) {
		 System.out.println("글 삭제");
	 }
	 else if(path.equals("/updateBoard.do")) {
		 System.out.println("글 수정");
	 }
	 else if(path.equals("/getBoard.do")) {
		 System.out.println("글 상세 조회");
	 }
	 else if(path.equals("/getBoardList.do")) {
		 System.out.println("글 전체 조회");
	 }
	}

}

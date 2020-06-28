package main;

import dao.MemberDao;

public class MainClass {

	public static void main(String[] args) {	
		// dao의 excution를 실행해서 메뉴선택창 출력.
		MemberDao dao = new MemberDao();	
		dao.excution();	
		
	}
}
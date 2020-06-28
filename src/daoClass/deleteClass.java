package daoClass;

import java.util.Scanner;

import daoInterface.daoSet;
import single.Singleton;

public class deleteClass implements daoSet{
	Singleton sl; 
	public deleteClass() {}
	public void excution() {
		Scanner sc =new Scanner(System.in);
		sl = Singleton.getInstance();
		
		System.out.print("검색하고 싶은 선수명 = ");
		String name = sc.next();
		
		if(name.equals("")) {
			System.out.println("입력하지 않았습니다.");
			return;
		}
		// 입력한 이름을 searchClass에게 매개변수로 줘서 인덱스번호 리턴.
		searchClass sr = new searchClass();
		int findIndex = sr.excution(name);
		// 이름을 못찾았을 떄 리턴해서 종료.
		if(findIndex == -1) {
			System.out.println("선수 명단에 없습니다.");
			return;
		}
		// 찾은 인덱스로 리스트 삭제.
		sl.list.remove(findIndex);
	}
}

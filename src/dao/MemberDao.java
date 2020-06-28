package dao;

import java.util.Scanner;
import daoClass.DefenceRankClass;
import daoClass.HitRankClass;
import daoClass.allprintClass;
import daoClass.deleteClass;
import daoClass.insertClass;
import daoClass.selectClass;
import daoClass.updateClass;
import daoInterface.daoSet;
import file.fileLoad;
import file.fileSave;

public class MemberDao {
	Scanner sc = new Scanner(System.in);	
	public MemberDao() {}
		
	public void excution() {
		// 로드클래스 인스턴스 생성.
		daoSet ds= new fileLoad();
		// singleton의 리스트에 데이터를 로드해서 저장.
		((fileLoad)ds).excution();	
			
		while(true) {
			// 메뉴
			System.out.println("1. 선수 등록");
			System.out.println("2. 선수 삭제");
			System.out.println("3. 선수 검색");
			System.out.println("4. 선수 수정");
			System.out.println("5. 선수 출력");			
			System.out.println("6. 데이터 저장");
			System.out.println("7. 타율순으로 정렬");
			System.out.println("8. 방어율순으로 정렬");			
			System.out.println("10. 프로그램 종료");		
			System.out.print("메뉴 번호 입력 >>>");
			
			int choice = sc.nextInt();
			
			switch( choice ) {
				case 1:
					// 입력클래스 인스턴스 생성.
					ds = new insertClass();
					break;	
					// 삭제클래스 인스턴스 생성.
				case 2:
					ds = new deleteClass();
					break;
					// 검색클래스 인스턴스 생성.
				case 3:
					ds = new selectClass();
					break;
					// 수정클래스 인스턴스 생성.
				case 4:
					ds = new updateClass();
					break;
					// 출력클래스 인스턴스 생성.
				case 5:
					ds = new allprintClass();
					break;	
					// 저장클래스 인스턴스 생성.
				case 6:
					ds = new fileSave();
					break;
					// 타율랭크클래스 인스턴스 생성.
				case 7:
					ds = new HitRankClass();
					break;
					// 방어율랭크클래스 인스턴스 생성.
				case 8:
					ds = new DefenceRankClass();
					break;	
					// 프로그램 종료.
				case 9:
					System.out.println("프로그램을 종료합니다");
					System.exit(0);					
					break;								
			}
			// 생성한 인스턴스의 excution() 실행.
			ds.excution();
		}
	}
}
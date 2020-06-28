package daoClass;

import java.util.Scanner;

import daoInterface.daoSet;
import dto.Batter;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class selectClass implements daoSet {
	Singleton sl;
	public selectClass() {}
	
	public void excution() {
		Scanner sc = new Scanner(System.in);
		sl = Singleton.getInstance();
		searchClass sr = new searchClass();
		
		System.out.print("검색하고 싶은 선수명 = ");
		String name = sc.next();
		
		if(name.equals("")) {
			System.out.println("입력하지 않았습니다.");
			return;
		}
		// 이름을 입력해서 인덱스 번호 리턴.
		int findIndex = sr.excution(name);
		
		if(findIndex == -1) {
			System.out.println("선수 명단에 없습니다.");
		}
		else {
			Human human = sl.list.get(findIndex);
			// 공통데이터 저장		
			System.out.println("번호:" + human.getNumber());
			System.out.println("이름:" + human.getName());
			System.out.println("나이:" + human.getAge());
			System.out.println("신장:" + human.getHeight());
			// 투수일 경우
			if(human instanceof Pitcher) {
				System.out.println("승리:" + ((Pitcher)human).getWin() );
				System.out.println("패전:" + ((Pitcher)human).getLose() );
				System.out.println("방어율:" + ((Pitcher)human).getDefence() );
			}
			
			// 타자일 경우
			else if(human instanceof Batter) {
				System.out.println("타수:" + ((Batter)human).getBatcount() );
				System.out.println("안타수:" + ((Batter)human).getHit() );
				System.out.println("타율:" + ((Batter)human).getHitAvg() );
			}		
		}		
	}
}

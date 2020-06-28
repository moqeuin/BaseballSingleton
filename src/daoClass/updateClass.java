package daoClass;

import java.util.Scanner;

import daoInterface.daoSet;
import dto.Batter;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class updateClass implements daoSet{
	Singleton sl;
		
	public updateClass() {}
	
	public void excution() {
		
		Scanner sc = new Scanner(System.in);
		sl = Singleton.getInstance();
		searchClass sr = new searchClass();
		
		System.out.print("수정하고 싶은 선수명 = ");
		String name = sc.next();
		
		if(name.equals("")) {
			System.out.println("입력하지 않았습니다.");
			return;
		}
		// 입력한 이름으로 리스트에서 인덱스 번호 리턴.
		int findIndex = sr.excution(name);
		
		if(findIndex == -1) {
			System.out.println("선수 명단에 없습니다.");
			return;
		}
		
		Human human =sl.list.get(findIndex);
		// 투수일 경우.
		if(human instanceof Pitcher) {
			
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			Pitcher pit = (Pitcher)human;
			
			pit.setWin(win);
			pit.setLose(lose);
			pit.setDefence(defence);			
		}
		//타자일 경우.
		else if(human instanceof Batter) {
			
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			Batter bat = (Batter)human;
			
			bat.setBatcount(batcount);
			bat.setHit(hit);
			bat.setHitAvg(hitAvg);			
		}	
	}
}

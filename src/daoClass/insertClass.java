package daoClass;

import java.util.Scanner;

import daoInterface.daoSet;
import dto.Batter;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class insertClass implements daoSet{
	int memberNumber;
	Singleton sl;
	
	public insertClass() {
		
		sl = Singleton.getInstance();
		// 파일에 데이터가 없으면 1000으로 셋팅.
		if(sl.list.size() == 0) {
			sl.memberNumber = 1000;
		}
		else {
		// 싱글다오에 저장된 마지막 데이터를 대입.
		Human human = sl.list.get(sl.list.size()-1);
		// 싱글다오에서 저장된 등록번호의 1000미만 자릿수만 구해서 1000을 더해서 등록번호 입력.
		sl.memberNumber = 1000 + (human.getNumber() % 1000);
		}
		// 다음 선수를 등록해야하기 때문에 1을 더해준다.
		sl.memberNumber = sl.memberNumber + 1;
	}
	
	public void excution() {
		sl = Singleton.getInstance();
		this.memberNumber = sl.memberNumber;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("투수(1)/타자(2) = ");
		int pos = sc.nextInt();
		
		// human
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("신장 = ");
		double height = sc.nextDouble();
		
			
		// 투수	1000 ~ 
		if(pos == 1) {
			// win
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			// lose
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			// defense
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			Human h =new Pitcher(memberNumber, name, age, height, win, lose, defence);
			
			sl.list.add(h);
		}		
		// 타자  2000 ~ 
		else if(pos == 2) {
			
			
			Batter bat = new Batter();			
			
			// 선수 등록 번호
		
			bat.setNumber(memberNumber + 1000);
			bat.setName(name);
			bat.setAge(age);
			bat.setHeight(height);			
						
			// 타수
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			bat.setBatcount(batcount);
						
			// 안타수
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			bat.setHit(hit);
			
			// 타율
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			bat.setHitAvg(hitAvg);
			
			Human human =bat;
			sl.list.add(human);		
		}	
	}
}

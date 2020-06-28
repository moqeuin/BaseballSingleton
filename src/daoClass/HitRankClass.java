package daoClass;

import java.util.ArrayList;

import daoInterface.daoSet;
import dto.Batter;
import dto.Human;

public class HitRankClass implements daoSet{
	
	public HitRankClass() {}
	
	public void excution() {
		ArrayList<Human> sortList = new ArrayList<Human>();
		// 타자데이터만 저장된 리스트를 리턴받음.
		sortList = new positionCheck(2).excution();
			
		for (int i = 0; i < sortList.size()-1; i++) {
			for (int j = i + 1; j < sortList.size(); j++) {
				
				Human tmp = null;
				Batter b1 = (Batter)sortList.get(i);
				Batter b2 = (Batter)sortList.get(j);
				// 앞에 인덱스번호(i)의 타율이 더 작은 경우 뒤에 인덱스번호(j)와 데이터를 바꾸어준다. 
				if(b1.getHitAvg()<b2.getHitAvg()) {
					tmp = b1;
					sortList.set(i, b2);
					sortList.set(j, tmp);
				}		
			}	
		}
		//정렬된 데이터 출력.
		for (int i = 0; i < sortList.size(); i++) {
			Human h = sortList.get(i);
			System.out.println(h.toString());
		}
	}
}

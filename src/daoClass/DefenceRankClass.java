package daoClass;

import java.util.ArrayList;

import daoInterface.daoSet;
import dto.Human;
import dto.Pitcher;

public class DefenceRankClass implements daoSet{
	
	public DefenceRankClass() {}
	
	public void excution() {
		ArrayList<Human> sortList = new ArrayList<Human>();
		// 투수데이터만 저장된 리스트를 리턴받음.
		sortList = new positionCheck(1).excution();
						
		for (int i = 0; i < sortList.size()-1; i++) {			
			for (int j = i + 1; j < sortList.size(); j++) {
				
				Human tmp = null;
				Pitcher p1 = (Pitcher)sortList.get(i);
				Pitcher p2 = (Pitcher)sortList.get(j);
				// 앞에 인덱스번호(i)의 방어율이 더 큰 경우 뒤에 인덱스번호(j)와 데이터를 바꾸어준다. 
				if(p1.getDefence()>p2.getDefence()) {
					tmp = p1;
					sortList.set(i, p2);
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

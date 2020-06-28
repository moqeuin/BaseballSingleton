package daoClass;

import java.util.ArrayList;

import dto.Human;
import single.Singleton;

public class positionCheck {
	int position;
	public positionCheck(int position) {
		this.position = position;
	}
	
	public ArrayList<Human> excution() {
		Singleton sl = Singleton.getInstance();
		//선택한 포지션의 데이터를 저장할 리스트.
		ArrayList<Human> reList = new ArrayList<Human>();
				
		for (int i = 0; i < sl.list.size(); i++) {
			Human h = sl.list.get(i);
			//투수로 선택했을 경우.
			if(position==1) {
				if(h.getNumber()<2000) {
					reList.add(h);
				}
			}
			//타자로 선택했을 경우.
			else {
				if(h.getNumber()>=2000) {
					reList.add(h);
				}
			}
		}
			return reList;
	}	
}
package daoClass;

import dto.Human;
import single.Singleton;

public class searchClass {
	
	public searchClass() {}
	
	public int excution(String name) {
		Singleton sl = Singleton.getInstance();
		int index = -1;	
		
		for (int i = 0; i < sl.list.size(); i++) {
			Human human = sl.list.get(i);
			// 입력한 이름이 리스트의 데이터의 있는지 비교 후 있으면 인덱스번호 리턴, 없으면 -1 리턴
			if(human.getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}
}

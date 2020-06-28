package daoClass;

import daoInterface.daoSet;
import single.Singleton;

public class allprintClass implements daoSet{
	Singleton sl;
	
	public allprintClass() {}
	
	public void excution() {
		sl = Singleton.getInstance();
		//singledao에서 리스트를 가져와서 선수 모두 출력.
		for (int i = 0; i < sl.list.size(); i++) {	 
			System.out.println(sl.list.get(i).toString());						
		}	
	}
}

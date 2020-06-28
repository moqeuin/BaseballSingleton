package single;

import java.util.ArrayList;
import dto.Human;

public class Singleton {
	
	private static Singleton sl = null;
	// 클래스끼리 공통으로 데이터를 저장할 리스트.
	public ArrayList<Human> list = new ArrayList<Human>();
	public int memberNumber;
	
	private Singleton() {}	
	// 처음에 인스턴스를 생성하고 다음부터는 무조건 리턴.
	public static Singleton getInstance() {
		
		if(sl==null) {
			sl = new Singleton();	
		}
		return sl;
	}
}
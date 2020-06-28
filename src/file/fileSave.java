package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import daoInterface.daoSet;
import single.Singleton;

public class fileSave implements daoSet{
	Singleton sl;
	File file = new File("d:\\tmp\\baseball.txt");;
	public fileSave() {}
	public void excution() {
		sl = Singleton.getInstance();
				
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < sl.list.size(); i++) {
				pw.println(sl.list.get(i).toString());
			}			
			pw.close();
			System.out.println("파일을 저장했습니다.");
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import daoInterface.daoSet;
import dto.Batter;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class fileLoad implements daoSet{

	File file = new File("d:\\tmp\\baseball.txt");
	
	public fileLoad() {				
		createfile();
	}
	
	public void createfile() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("동일한 이름의 파일이 이미 존재합니다.");
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}	
	public void excution() {
		Singleton  sl = Singleton.getInstance();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String str;
				while( (str = br.readLine()) != null ) {
					
					String data[] = str.split("-");		
					int title = Integer.parseInt(data[0]);
					
					Human human = null;
					if(title < 2000) {		// 투수				
						human = new Pitcher(	Integer.parseInt(data[0]), 
												data[1], 
												Integer.parseInt(data[2]), 
												Double.parseDouble(data[3]), 
												Integer.parseInt(data[4]), 
												Integer.parseInt(data[5]), 
												Double.parseDouble(data[6]) );
					}
				
					else {
						human = new Batter(	Integer.parseInt(data[0]), 
												data[1], 
												Integer.parseInt(data[2]), 
												Double.parseDouble(data[3]), 
												Integer.parseInt(data[4]), 
												Integer.parseInt(data[5]), 
												Double.parseDouble(data[6]) );
					}
					sl.list.add(human);
				}
			}catch (FileNotFoundException e) {			
				e.printStackTrace();
				}
			catch (NumberFormatException | IOException e) {	
				e.printStackTrace();
		}		 
	}	
}

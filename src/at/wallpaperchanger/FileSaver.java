package at.wallpaperchanger;

import java.util.Random;
import java.util.TreeMap;

public class FileSaver {
	TreeMap<Integer, String> map = new TreeMap<Integer, String>();
	public void putToTreeMap(String fileName){
		int size = map.size();
		map.put(size+1, fileName);
	}
	public String randomFile(){
		int size = map.size();
		Random rand = new Random();
		int randomNum = rand.nextInt(size - 1 + 1) + 1;
		return map.get(randomNum);
	}
}
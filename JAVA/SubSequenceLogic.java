import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class SubSequenceLogic {
	public static void main(String[] args) {
		String[] splited = "abcde".split("");
		
		List<String> binarys = new ArrayList<>();
		List<String> toReturn = new ArrayList<String>();
		
		String binaryResult = "";
		for(int i = 0; i < splited.length; i++){
			binaryResult += "1";
		}
		
		Integer init = 0;
		
		do{
			binarys.add(String.format("%0" + splited.length + "d", Integer.valueOf(Integer.toBinaryString(init))));
			init++;
		}while(!String.format("%0" + splited.length + "d", Integer.valueOf(Integer.toBinaryString(init))).equals(binaryResult) );
		
		binarys.add(binaryResult);
		
		for(String s : binarys){
			String[] bSplited = s.split("");
			String toConcat = "";
			
			for(int i = 0; i < bSplited.length; i++){
				if(bSplited[i].equals("1")){
					toConcat += splited[i];
				}
			}
			if(toConcat.length() > 0){
				toReturn.add(toConcat);
			}
		}
		
		Collections.sort(toReturn);

		for (String sss : toReturn) {
			System.out.println(sss);
		}
	}
}

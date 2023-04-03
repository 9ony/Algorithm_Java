package leetcode.medium;

public class Zigzag_Conversion {
	/*
	 	6. Zigzag Conversion
	   	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
		
		P   A   H   N
		A P L S I I G
		Y   I   R
		And then read line by line: "PAHNAPLSIIGYIR"
		
		Write the code that will take a string and make this conversion given a number of rows:
		
		string convert(string s, int numRows);
		 
		
		Example 1:
		Input: s = "PAYPALISHIRING", numRows = 3
		Output: "PAHNAPLSIIGYIR"
		
		Example 2:
		Input: s = "PAYPALISHIRING", numRows = 4
		Output: "PINALSIGYAHRPI"
		
		Explanation:
		P     I    N
		A   L S  I G
		Y A   H R
		P     I
		
		Example 3:
		Input: s = "A", numRows = 1
		Output: "A"
		 
		Constraints:
		1 <= s.length <= 1000
		s consists of English letters (lower-case and upper-case), ',' and '.'.
		1 <= numRows <= 1000
*/
	public String convert(String s, int numRows) {
		
		int slen = s.length();
		int numCols = 1;
		if(slen<1) {
			return "문자를 입력해주세요";
		}else if(numRows==1) {
			return s;
		}else if(slen<=numRows) {
			numCols = 1;
		}else {
			numCols = 1+((slen-numRows)/(numRows+(numRows-2)))*(numRows-1);
			//slen의 크기가 numrows보다 작거나같으면 1값이 고정이니까 slen의 값에 numRows 값을 빼준다
			int remainder = (slen-numRows)%(2*numRows-2); //나머지값을 구해서 cols크기를 더해준다
			if(remainder>(numRows-2)) {
				remainder=numRows-1;
				//단, cols에 1개의 로우만 입력되고 나머지는 공백인 패턴은 
				//(numRows-2)보다크면 위에서부터 차례대로 numRows크기 만큼 입력된다
			}
			//System.out.println(remainder);
			numCols+=remainder;
		}
		String[][] temp = new String[numRows][numCols];
		System.out.println("slen==>"+slen+"/  numRows=>"+numRows+"/ numCols==>"+numCols);
		
		int n =0;
		for(int j=0; j<numCols; j++) {
			for(int i=0; i<numRows; i++) {
				if(j%(numRows-1)!=0 && n<slen) {
					if(i==((numRows-1)-(j%(numRows-1)))) {
						temp[i][j]=s.charAt(n)+"";
						n++;
					}else {
						temp[i][j]=" ";
					}
				}else if(n<slen){
					temp[i][j]=s.charAt(n)+"";
					n++;
				}
			}
		}
		
		//test
		StringBuilder str = new StringBuilder();
		for(int i=0; i<numRows; i++) {
			for(int j=0; j<numCols; j++) {
				if(temp[i][j]!=null)
					str.append(temp[i][j]);
			}
			str.append("\n");
		}
		
		
        return str.toString();
    }
}

package leetcode;

public class Count_and_Say {
	/*
	 	38. Count and Say
		Companies
		The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
		countAndSay(1) = "1"
		countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
		To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit.
		Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
		
		For example, the saying and conversion for digit string "3322251":
		
			string input : "3322251"
		two 3's, three 2's, one 5, and one 1
			2 3 + 3 2 + 1 5 + 1 1
				output : "23321511"
			
		Given a positive integer n, return the nth term of the count-and-say sequence.
		
		Example 1:
		Input: n = 1
		Output: "1"
		Explanation: This is the base case.

		Example 2:
		Input: n = 4
		Output: "1211"

		Explanation:
		countAndSay(1) = "1"
		countAndSay(2) = say "1" = one 1 = "11"
		countAndSay(3) = say "11" = two 1's = "21"
		countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
		
		Constraints:
		1 <= n <= 30
	 */
	// 문제이해가 힘들었음 위에는 3322251이 주어지고 숫자갯수를 세어주는 예시를 보여쭷는데
	// 밑에 예제1,2 는 int n을 파라미터로 받아서 결과를 출력하라해서
	// 문제 설명  
	// n이 1일때 1을 반환 (기본조건)
	// n=2일때 countAndSay(1)의 값을 숫자로 표현 countAndSay(1) == "1" 이었으므로 1이 1개인 걸 숫자로 표현하면 "11"됨
	// n=3일때 countAndSay(2)의 값을 똑같이 숫자로 표현하면 "11"을 컨버팅해주면 1이 2개이므로 21이됨
	// n의 파라미터만큼 계속반복해주면됨
	
	//22ms 소요 bottom-up?
    public String countAndSay(int n) {
		if(n==1) return "1"; //기본 조건
		String dpStr = "1"; //i 가 증가하면서 계속 변경될 변수;
		int i = 2 ; //iter 변수
		while(i<=n) {
			String currStr = dpStr; // i-1값에 의해 저장된 dp_result를 저장할 변수
			String tempStr=""; // currStr값의 숫자의 갯수 + 숫자를 저장할 변수
			int slen = currStr.length(); //countAndSay의 길이
			int si = 0; //countAndSay의 인덱스 증가값			
			while(si+1<=slen) {
				int count = 1;
				while(si+1<slen && currStr.charAt(si)==currStr.charAt(si+1)) {
					count++;
					si++;
				}
				tempStr += ""+count+currStr.charAt(si);
				si++;
			}
			i++;
			dpStr = tempStr;
		}
		
		return dpStr;
    }
    //String => StringBuilder로 변경 22ms -> 6ms
    public String countAndSay_2(int n) {
		if(n==1) return "1"; //기본 조건
		String dpStr = "1"; //i 가 증가하면서 계속 변경될 변수;
		int i = 2 ; //iter 변수
		while(i<=n) {
			String currStr = dpStr; // i-1값에 의해 저장된 dp_result를 저장할 변수
			StringBuilder tempStr= new StringBuilder(); // currStr값의 숫자의 갯수 + 숫자를 저장할 변수
			int slen = currStr.length(); //countAndSay의 길이
			int si = 0; //countAndSay의 인덱스 증가값			
			while(si+1<=slen) {
				int count = 1;
				while(si+1<slen && currStr.charAt(si)==currStr.charAt(si+1)) {
					count++;
					si++;
				}
				tempStr.append(count).append(currStr.charAt(si));
				si++;
			}
			i++;
			dpStr = tempStr.toString();
		}
		
		return dpStr;
    }
    
    //dp top-down 방식
    //21ms소요
    public String countAndSay2(int n) {
		if(n==1) return "1"; //기본 조건
		String dpStr = countAndSay2(n-1); //i 가 증가하면서 계속 변경될 변수;
		String tempStr=""; // currStr값의 숫자의 갯수 + 숫자를 저장할 변수
		int slen = dpStr.length(); //countAndSay의 길이
		int si = 0; //countAndSay의 인덱스 증가값			
		while(si+1<=slen) {
		int count = 1;
			while(si+1<slen && dpStr.charAt(si)==dpStr.charAt(si+1)) {
				count++;
				si++;
			}
			tempStr += ""+count+dpStr.charAt(si);
			si++;
		}
		return tempStr;
    }
    
    //String => StringBuilder로 변경 21ms -> 2ms
    public String countAndSay2_2(int n) {
		if(n==1) return "1"; //기본 조건
		String dpStr = countAndSay2(n-1); //i 가 증가하면서 계속 변경될 변수;
		StringBuilder tempStr= new StringBuilder(); // currStr값의 숫자의 갯수 + 숫자를 저장할 변수
		int slen = dpStr.length(); //countAndSay의 길이
		int si = 0; //countAndSay의 인덱스 증가값			
		while(si+1<=slen) {
		int count = 1;
			while(si+1<slen && dpStr.charAt(si)==dpStr.charAt(si+1)) {
				count++;
				si++;
			}
			tempStr.append(count).append(dpStr.charAt(si));
			si++;
		}
		return tempStr.toString();
    }
}


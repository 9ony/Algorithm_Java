package programmers.LV0;

public class 문자열밀기 {
	/*
	 문제 설명
	문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다.
	이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때, A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 
	밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
	
	제한사항
	0 < A의 길이 = B의 길이 < 100
	A, B는 알파벳 소문자로 이루어져 있습니다.
	입출력 예
	A		   B	result
	"hello"	"ohell"	  1
	"apple"	"elppa"	 -1
	"atat"	"tata"	  1
	"abc"	"abc"	  0
	입출력 예 설명
	입출력 예 #1
	
	"hello"를 오른쪽으로 한 칸 밀면 "ohell"가 됩니다.
	입출력 예 #2
	
	"apple"은 몇 번을 밀어도 "elppa"가 될 수 없습니다.
	입출력 예 #3
	
	"atat"는 오른쪽으로 한 칸, 세 칸을 밀면 "tata"가 되므로 최소 횟수인 1을 반환합니다.
	입출력 예 #4
	
	"abc"는 밀지 않아도 "abc"이므로 0을 반환합니다.
	 */
	public int solution(String A, String B) {
        int answer = 0;
        if(A.equals(B)) return 0;
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<B.length(); i++){
            if(A.equals(B.substring(i-answer)+temp)) {
            	answer++;
            }else {
            	temp.append(B.charAt(i));
            }
        }
        //answer이 0이면 밀어서 같은 문자가 될수 없음 -1
        //최소값을 구하기위해  
        // answer이 주어진 문자열 A/2보다 크면 반대로민 값 = A.length()-answer로 출력
        // 아니면 answer
        // return (answer!=0) ? (answer>(A.length()/2)) ? A.length()-answer : answer : -1;
        return (answer!=0) ? A.length()-answer : -1;
	}
	public static void main(String[] args) {
		문자열밀기 app = new 문자열밀기();
		System.out.println(app.solution("hello", "elloh"));
	}

}

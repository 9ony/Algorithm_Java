package programmers.kakaoBlind2023;

public class example4 {
	public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i<numbers.length; i++) {
        	String number = binaryStr(numbers[i]);
        	System.out.println(number);
        	if(binaryTreeCheck(number)) {
        		answer[i]=1;
        	}else answer[i]=0;
        }
        return answer;
    }
	public String binaryStr(long number) {
		String temp="";
		//이진수 변환
		if(number==1) return "1";
		else {
			while(number>0) {
				temp = (number%2)+temp;
				number/=2;
			}
		}
		//if(temp.length()>1&&temp.length()%2==0) temp = "0"+temp; //길이가 짝수일시 0추가
		//위에 코드는 단순하게 짝수일때 홀수를 맞추기위해 0을 추가했음 루트노드만을 구하기위해서 잘못된 생각
		
		//이진트리의 길이는 2^n -1이어야한다 즉 temp의 길이가 2^n-1보다 작으면 왼쪽에 0을 추가하면서 길이를 맞춰주는 작업을 해야함
		int n = 1;
		while(Math.pow(2, n)-1<temp.length()) n++;
		while(Math.pow(2, n)-1!=temp.length()) temp = "0"+temp;
		//이진순 변환 end
		
		//이진트리 표현가능한지 check
		return temp;
	}
	
	//이진트리 표현가능 유무 메서드
	public boolean binaryTreeCheck(String number) {
		boolean Check = true;
		
		int mid = (number.length()-1)/2;
		char root = number.charAt(mid);
		String l = number.substring(0,mid);
		String r = number.substring(mid+1,number.length());
		if(root == '0' && (l.charAt((l.length()-1)/2)=='1' || r.charAt((r.length()-1)/2)=='1')){
			return false;
		}
		
		if(l.length() >= 3) {
			Check = binaryTreeCheck(l);
			if(Check) Check = binaryTreeCheck(r);
		}
		return Check;
	}
}

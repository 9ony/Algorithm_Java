package leetcode.medium;

import java.util.Arrays;

public class Multiply_Strings {
	/*
	 	43. Multiply Strings
		Medium
		Companies
		Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
		Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
		
		Example 1:
		Input: num1 = "2", num2 = "3"
		Output: "6"

		Example 2:
		Input: num1 = "123", num2 = "456"
		Output: "56088"
		
		Constraints:
		1 <= num1.length, num2.length <= 200
		num1 and num2 consist of digits only.
		Both num1 and num2 do not contain any leading zero, except the number 0 itself.
	 */
	
	// 조건을보면 num1과 2 의 최대길이가 200이다
	// BigInteger 라이브러리와 정수로 변환하는 컨버터를 사용하면 안된다.
	// 그이유는 최대 길이가 200까지 되기때문에 int,long double 등등 크기를 초과해버리기때문
	public String multiply(String num1, String num2) {
		if(num1.equals("0")||num2.equals("0")) {
			return "0";
		}
		int[] arr = new int[num1.length()+num2.length()];
		for(int i = num1.length()-1 ; i >= 0; i--) {
			for(int j = num2.length()-1; j >= 0; j--) {
				//arr[마지막인덱스값 == num1.length()+num2.length()-1]부터 시작
				// 즉 arr[i+j+1]에 첫번째 times의 나머지값 or times값이 들어가야함
				int times = ((num1.charAt(i)-'0')*(num2.charAt(j)-'0'))+arr[i+j+1];
				//10보다 클경우
				if(times>9) {
					arr[i+j]+=(times)/10; //몫이 그다음수 arr배열의 i+j 즉 현재인덱스-1 인 위치에 저장
					arr[i+j+1]=times%10;
				}else arr[i+j+1]=times;
			}
		}
        return intArrayToString(arr);
    } //4ms 나옴
	public String intArrayToString(int[] arr) {
		// String --> StringBuilder로 바꿈
		// String + arr[i]값을 하게되면 기존문자열 추가가아니라 새로운객체를 만들어서 그객체를 참조함
		// 반면 StringBuilder는 문자열을 한 번 만들고 연산이 필요할 때마다 크기를 변경해가며 문자열을 변경한다. 따라서 변경될 때마다 새롭게 객체를 만드는 String 보다 더 빠르다.
		//  *StringBuffer 도있음 둘은 동기화차이 StringBuffer는 Sync적용이 되어있음
		// 10ms -> 4ms로 60% 상승
		StringBuilder result = new StringBuilder();
		int i = 0;
		
		//arr 첫번째인덱스에 0이있으면 0이없을때 동안 i값증가
		while(arr[i]==0) i++;
		
		for(int j = i; j<arr.length; j++) {
			result.append(arr[j]);
		}
		return result.toString();
	}
	
	//다른사람이푼 1ms 코드
	public String multiply2(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] s1 = new int[n1];
        int[] s2 = new int[n2];
        int[] pro = new int[n1 + n2];
        for(int i = n1 - 1; i >= 0; i--) s1[n1 - 1 - i] = num1.charAt(i) - '0';
        for(int i = n2 - 1; i >= 0; i--) s2[n2 - 1 - i] = num2.charAt(i) - '0';
        for(int i = 0; i < n1; i++)
            for(int j = 0; j < n2; j++){
                pro[i + j] += s1[i] * s2[j];
            }
        int c = 0;
        for(int i = 0; i < n1 + n2; i++){
            int temp = c + pro[i];
            pro[i] = temp % 10;
            c = temp / 10;
        }
        int j = n1 + n2 - 1;
        while(j > 0 && pro[j] == 0) j--;
        StringBuilder sb = new StringBuilder();
        while(j >= 0){
            sb.append(pro[j--]);
        }
        return sb.toString();
    }
}
package programmers.LV0;

public class 다음에올숫자 {
	/*
		문제 설명
		등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
		
		제한사항
		2 < common의 길이 < 1,000
		-1,000 < common의 원소 < 2,000
		common의 원소는 모두 정수입니다.
		등차수열 혹은 등비수열이 아닌 경우는 없습니다.
		등비수열인 경우 공비는 0이 아닌 정수입니다.
		입출력 예
		common      	result
		[1, 2, 3, 4]	  5
		[2, 4, 8]	     16
		입출력 예 설명
		입출력 예 #1
		[1, 2, 3, 4]는 공차가 1인 등차수열이므로 다음에 올 수는 5이다.
		입출력 예 #2
		[2, 4, 8]은 공비가 2인 등비수열이므로 다음에 올 수는 16이다.
	 */
	public int solution(int[] common) {
        boolean check = true; //등비,등차 구분
        //등차수열은 연결된 수의 차이의 값이 다 같음
        //길이가 몇이든 common의 3번째까지 조회하면 등차인지 등비인지 알수있음
        int curr = common[2]-common[1];
    	if(common[1]-common[0]==curr) check=false;

        //등차수열 다음값 구하는 식 : 마지막인덱스값 + 마지막인덱스값-(마지막인덱스-1)값 
    	// => common[common.length-1]+curr
    	//등비수열 다음값 구하는 식 : 마지막인덱스값 * ( 마지막인덱스값/(마지막인덱스-1)값 )
    	// => common[common.length-1]*(common[common.length-1]/common[common.length-2]);
        //check가 true면 등비식 false면 등차식 리턴
        return (check) ? 
        		common[common.length-1]*(common[common.length-1]/common[common.length-2])
        		: common[common.length-1]+curr ;
    }
	public static void main(String[] args) {
		다음에올숫자 app = new 다음에올숫자();
		int[] common = {1,2,3,4};
		int[] common2 = {2,4,6,8,10,12};
		int[] test = {3,-6,24};
		System.out.println(app.solution(common));
		System.out.println(app.solution(common2));
		System.out.println(app.solution(test));
	}
}

package leetcode.hard;

import java.util.Arrays;

public class Trapping_Rain_Water {
	/*
	 	42. Trapping Rain Water
		Hard
		Companies
		Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
		
			 ^0
			 |
			 |    
			3|	  						  -----
			 |                            | o |
			2|	          -----           ---------   -----
			 |            | o | w   w   w | o | o | w | o |
			1|    -----   ---------   --------------------------
			 |    | o | w | o | o | w | o | o | o | o | o | o |
			0|-------------------------------------------------
				1   2   3   4   5   6   7   8   9  10  11  12
				 
		Example 1:
		Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
		Output: 6
		Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

		Example 2:
		Input: height = [4,2,0,3,2,5]
		Output: 9
		 
		
		Constraints:
		n == height.length
		1 <= n <= 2 * 10^4
		0 <= height[i] <= 10^5
	 */
	
	//불록의 개수를 가진 배열이 주어진다.
	//블럭과 블럭사이에 물이 고이는 칸수를 출력
	//물이 고였다는건 블럭사이에 값이 작거나 0이라는 의미
	//  ==>	height[현재인덱스] > height[다음인덱스] 라면 현재값과 다음값을 빼주어서 해당값이 물이고인 블럭 수가된다
	//		그러나 인덱스가 계속 증가하면서 다음값들이 첫인덱스보다 클지 확인해야하는 문제가있다
	//		그래서 왼쪽 오른쪽값을 0으로 초기화하고 왼쪽은 첫index인 0을주고 오른쪽은 마지막 index인 파라미터로 들어온 (height의 길이)-1
	//		왼쪽 오른쪽인덱스를 비교하여 작은쪽 값의 인덱스에 진행방향에따라 (왼쪽일경우)++ or (오른쪽일경우)--로 증감식을 써준다
	//		인덱스 값이 증감되면서 Math.max함수를 통해 현재인덱스의 블럭개수와 변수에 할당된 최대 블락수를 비교하여 큰수를
	//		저장하고 저장된 값이 현재인덱스의 값보다 크다면 그차이 만큼 물이 고인 값을 증가시켜준다.
	//		이렇게 계속 인덱스를 증감하면서 서로 만나게 될때까지 반복하면 제일 큰기둥 index에서 반복문이 멈추게 될것이고
	//		물이 고인값을 출력할수 있다.
	public int trap(int[] height) {
		System.out.println(Arrays.toString(height));
		int lIdx = 0; 
        int rIdx = height.length - 1;
        int result = 0; 
        int lMax = 0; 
        int rMax = 0;
        while(lIdx <= rIdx){
        	lMax = Math.max(height[lIdx], lMax); //현재 lMax와 left위치의 height값 비교 후 큰수 할당
            rMax = Math.max(height[rIdx], rMax);	// rMax , height[right] 중 큰수 할당 		  
            
            //lmax가 rmax보다 작을시 lmax-height[left]값을 ans에 더해주고 left++
            if (lMax < rMax){
            	result += lMax - height[lIdx++];
            }
            else { // lmax가 rmax보다 같거나 클시 rMax-hight[right] 값 ans에 더해주고 right--
            	result += rMax - height[rIdx--];
            }
        }
        return result;
		//return 0;
    }
}

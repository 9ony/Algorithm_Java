package leetcode;

public class Container_With_Most_Water {
	/*
	 *  11. Container With Most Water
		You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
		
		Find two lines that together with the x-axis form a container, such that the container contains the most water.
		
		Return the maximum amount of water a container can store.
		
		Notice that you may not slant the container.
	 	
	 	Example 1:
		picture ==>
					8-|		 |                   |       
					7-|		 |                   |       |
					6-|		 |   |               |       |
					5-|		 |   |       |       |       |
					4-|		 |   |       |   |   |       |
					3-|		 |   |       |   |   |   |   |
					2-|		 |   |   |   |   |   |   |   |
					1-|  |   |   |   |   |   |   |   |   |
					0-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
					     1   8   6   2   5   4   8   3   7

		Input: height = [1,8,6,2,5,4,8,3,7]
		Output: 49
		Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

		Example 2:
		Input: height = [1,1]
		Output: 1
		 
		Constraints:
		n == height.length
		2 <= n <= 105
		0 <= height[i] <= 104
	 */
	//시간복잡도 초과 tc<O(n^2)
	/*
	 public int maxArea(int[] height) {
		 int maxh=0;
		 int maxarea = 0;
		 for(int i= 0 ; i < height.length; i++) {
			 for(int j =0; j<i; j++) {
				 maxh = Math.min( height[i] , height[j]);
				 maxarea = Math.max( maxarea ,maxh * (Math.max(i, j) - Math.min(i, j)));
			 }
		 }
		 return maxarea;
	 }
	 */
	//param = 막대 높이 , 막대사이 간격
	//높이 - 간격의 차가 작은것

	 public int maxArea(int[] height) {
		 int l=0;
		 int r=height.length-1;
		 int maxarea = 0;
		 while(l<r) {
			maxarea = Math.max( maxarea , (r-l) * Math.min(height[l],height[r]));
			if(height[l]>height[r]) {
				r--;
			}
			else l++;
		 } 
		return maxarea;
	 }
}

package leetcode.medium;

public class Pow_xn {
	/*
		50. Pow(x, n) (Medium)
		7.3K

		Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
		Example 1:
		Input: x = 2.00000, n = 10
		Output: 1024.00000

		Example 2:
		Input: x = 2.10000, n = 3
		Output: 9.26100

		Example 3:
		Input: x = 2.00000, n = -2
		Output: 0.25000

		Explanation: 2-2 = 1/2^2 = 1/4 = 0.25
		Constraints:
		
		-100.0 < x < 100.0
		-2^31 <= n <= 2^31-1
		n is an integer.
		-10^4 <= x^n <= 10^4
	 */
	public double myPow(double x, int n) {
	    if(n == 0) return 1;
	    if(n == Integer.MIN_VALUE){
	        x = x * x;
	        n = n/2;
	    }
	    if(n < 0) {
	        n = -n;
	        x = 1/x;
	    }
	    //System.out.println("n => "+n + "," + "x => "+x);
	    if(n%2 ==0) {
	    	return myPow(x*x,n/2);
	    }else 
	    	return x * myPow(x*x,n/2);	    
	}
}

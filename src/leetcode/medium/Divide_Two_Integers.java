package leetcode.medium;

public class Divide_Two_Integers {
	/*
	 	29. Divide Two Integers
		Companies
		Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
		The integer division should truncate toward zero, which means losing its fractional part.
		For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
		Return the quotient after dividing dividend by divisor.
		Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1].
		For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
		
		Example 1:
		Input: dividend = 10, divisor = 3
		Output: 3
		Explanation: 10/3 = 3.33333.. which is truncated to 3.

		Example 2:
		Input: dividend = 7, divisor = -3
		Output: -2
		Explanation: 7/-3 = -2.33333.. which is truncated to -2.
		
		Constraints:
		-2^31 <= dividend, divisor <= 2^31 - 1
		divisor != 0
	 */
	//문제 이해를 잘못함 나누기연산없이 나눗셈을 구현하는것임
	public int divideXX(int dividend, int divisor) {
		if(dividend >= Integer.MAX_VALUE) dividend = Integer.MAX_VALUE;
		if(dividend <= Integer.MIN_VALUE) dividend = Integer.MIN_VALUE;

		//System.out.println(Integer.MAX_VALUE); 2147483647
		//System.out.println(Integer.MIN_VALUE); -2147483648
		
		long mok = (long)dividend/divisor;
		
		return (mok>Integer.MAX_VALUE) ? Integer.MAX_VALUE:(int)mok;
    }
	
	public int divide(int dividend, int divisor) {
		//overflow handle
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
		
		if(dividend >= Integer.MAX_VALUE) dividend = Integer.MAX_VALUE;
		if(dividend <= Integer.MIN_VALUE) dividend = Integer.MIN_VALUE;
		
		
		int sign = 1;
		if((dividend<0 && divisor>=0) || (dividend>=0 && divisor<0)) sign = -1;
		long ldividend = Math.abs((long)dividend);
		long ldivisor = Math.abs((long)divisor);
		
		/*
		//Time Limit Error (brute force) 
		long sum=ldivisor;
		long result = 0;
		while(ldividend>=sum) {
			sum+=ldivisor;
			result++;
		}
		*/
		//비트연산자 사용
		long result = 0;
		while(ldividend >= ldivisor ) {
			System.out.println("------------ Start ---------------");
			long sum=0;
            while(ldividend >= (ldivisor << sum << 1)) {
            	System.out.println(ldividend+"-"+(ldivisor << sum << 1)+"="+(ldividend-(ldivisor << sum << 1))+","+sum);
            	sum++; 
            }
			System.out.println("------------ End---------------");
			System.out.println("=========================");
			System.out.print("result 값 : "+result +"+="+(1<<sum)+"=>");
				result += 1 << sum;
			System.out.println(result);
			System.out.print("ldividend 값 : "+ldividend +"-="+(ldivisor<<sum)+"=>");
				ldividend -= ldivisor << sum;
			System.out.println(ldividend);
			System.out.println("=========================");
		}
		
		return (int)result*sign;
    }
}

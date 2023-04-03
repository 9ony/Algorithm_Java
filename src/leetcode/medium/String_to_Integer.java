package leetcode.medium;

public class String_to_Integer {
	/*
	 	8. String to Integer (atoi)
		Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
		
		The algorithm for myAtoi(string s) is as follows:
		
		Read in and ignore any leading whitespace.
		Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
		Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
		Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
		If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
		Return the integer as the final result.
		Note:
		
		Only the space character ' ' is considered a whitespace character.
		Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
	*/
	 public int myAtoi(String s) {
			String result="";
			String sign="";
			//System.out.println(s);
			//System.out.println("s의 길이==>"+s.length());
			//System.out.println('0'+0); ['0'==48 ... '10'==58] ASCII CODE CHECK!
			for(int i=0;i<s.length();i++) {
				if(sign.equals("")&&(s.charAt(i)=='+'||s.charAt(i)=='-')) {
					//System.out.println("signcheck==>"+s.charAt(i));
					sign += s.charAt(i);
				}else if(sign.equals("")&&s.charAt(i)==' ') {
					//System.out.println("test==>"+s.charAt(i));
					continue;
				}else if(s.charAt(i)>=48&&s.charAt(i)<58) {
					//System.out.println("result test==>"+s.charAt(i));
					result += s.charAt(i);
					if(sign.equals("")) {
						sign="+";
					}
					if(!result.equals("")&&Long.parseLong(result)>Integer.MAX_VALUE) {
						return (sign.equals("-")) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
					}
					
				}else {
					//System.out.println("break!!!");
					break;
				}
			}
			if(result.equals("")) {
				return 0;
			}else
				return Integer.parseInt(sign+result);
		}
	 
	//Best Code
	public int myAtoi2(String s) {
        long num = 0;
        boolean neg = false;
        int sign = 0;
        
        for(int i=0; i<s.length(); i++) {
                        
            if(s.charAt(i) == ' ' && sign == 0) {
                continue;
            }
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num*10 + (s.charAt(i) - '0');
                sign = 1;
                System.out.println("num===>"+num);
                 if(num > Integer.MAX_VALUE) 
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            else if(s.charAt(i) == '+' && sign == 0) {
                neg = false;
                sign = 1;
            }
            else if(s.charAt(i) == '-' && sign == 0) {
                neg = true;
                sign = 1;
            }
            else 
                break;
        }
        return neg ? -(int)num : (int)num;
    }
}

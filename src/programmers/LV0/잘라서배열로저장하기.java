package programmers.LV0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 잘라서배열로저장하기 {
	public String[] solution(String my_str, int n) {
        
		List<String> answer = new ArrayList<>();
		while(my_str.length()>n) {
			answer.add(my_str.substring(0,n));
			my_str=my_str.substring(n);
        }
		if(!my_str.equals("")) answer.add(my_str); //남은 문자 잇을때
		
        return answer.toArray(new String[answer.size()]);
        /*
		int size = (int)Math.ceil((float)my_str.length()/n);
        String[] answer = new String[size];
        int idx=0;
        while(my_str.length()>n) {
			answer[idx++]=my_str.substring(0,n);
			my_str=my_str.substring(n);
        }
        if(!my_str.equals("")) answer[idx]=my_str; //남은 문자 잇을때
        return answer;
        */
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		잘라서배열로저장하기 app = new 잘라서배열로저장하기();
		System.out.println(Arrays.toString(app.solution("abc1Addfggg4556b", 6)));
	}

}

package common;

import java.util.Arrays;

import programmers.kakaoBlind2023.example1;

public class RunCode_programmers_kakaoblind2023 {
	public static void main(String[] args) {
		//카카오 2023 블라인드 코딩테스트
		
		
		// 개인정보 유효기간 검사 (lv1)
		example1 app = new example1();
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		System.out.println(Arrays.toString(app.solution(today, terms, privacies)));
		
	}
	
}

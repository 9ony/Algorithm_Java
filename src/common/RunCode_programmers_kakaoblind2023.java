package common;

import programmers.kakaoBlind2023.example2;

public class RunCode_programmers_kakaoblind2023 {
	public static void main(String[] args) {
		//카카오 2023 블라인드 코딩테스트
		
		/*
		// 개인정보 유효기간 검사 (lv1)
		example1 app = new example1();
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		System.out.println(Arrays.toString(app.solution(today, terms, privacies)));
		*/
		
		
		// 택배 배달과 수거하기 (lv2)
		
		
		example2 app = new example2();
		
		//TestCase1
		int cap = 4;
		int n = 5;
		int[] deliveries = {1,0,3,1,2};
		int[] pickups = {0,3,0,4,0};
		
		
		//TestCase2
		int cap2 = 2;
		int n2 = 7;
		int[] deliveries2 = {1,0,2,0,1,0,2};
		int[] pickups2 = {0,2,0,1,0,2,0};
		System.out.println("총 거리 ==>"+app.solution2(cap, n, deliveries, pickups));
		
		
	}
	
}

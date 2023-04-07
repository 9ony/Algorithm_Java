package common;

import programmers.kakaoBlind2023.example5;

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
		
		/*
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
		*/

		/*
		 // 이모티콘 할인행사 (lv2)
		
		example3 app = new example3();
		int[][] users = {{40, 10000}, {25, 10000}}; 
		int[] emoticons = {7000, 9000};
		System.out.println(Arrays.toString(app.solution2(users, emoticons)));
		*/
		
		/*
		 // 표현 가능한 이진트리 (lv3)
		
		example4 app = new example4();
		long[] numbers= {7,42,2,423};
		System.out.println(Arrays.toString(app.solution(numbers)));
		*/
		
		 // 표 병합 (lv3)
		
		example5 app = new example5();
		String[] param = {"UPDATE 1 1 menu", "UPDATE 1 2 category", 
				"UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", 
				"UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", 
				"UPDATE 3 2 korean", "UPDATE 3 3 noodle", 
				"UPDATE 3 4 instant", "UPDATE 4 1 pasta", 
				"UPDATE 4 2 italian", "UPDATE 4 3 noodle", 
				"MERGE 1 2 1 3", "MERGE 1 3 1 4", 
				"UPDATE korean hansik", "UPDATE 1 3 group", 
				"UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
		System.out.println(app.solution(param));
	}
	
}

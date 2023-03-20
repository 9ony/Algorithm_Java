package programmers.kakaoBlind2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class example3 {
	/*
	 	이모티콘 할인행사
		
		문제 설명
		카카오톡에서는 이모티콘을 무제한으로 사용할 수 있는 이모티콘 플러스 서비스 가입자 수를 늘리려고 합니다.
		이를 위해 카카오톡에서는 이모티콘 할인 행사를 하는데, 목표는 다음과 같습니다.
		이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
		이모티콘 판매액을 최대한 늘리는 것.
		1번 목표가 우선이며, 2번 목표가 그 다음입니다.

		이모티콘 할인 행사는 다음과 같은 방식으로 진행됩니다.
		n명의 카카오톡 사용자들에게 이모티콘 m개를 할인하여 판매합니다.
		이모티콘마다 할인율은 다를 수 있으며, 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.
		카카오톡 사용자들은 다음과 같은 기준을 따라 이모티콘을 사거나, 이모티콘 플러스 서비스에 가입합니다.
		
		각 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매합니다.
		각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
		다음은 2명의 카카오톡 사용자와 2개의 이모티콘이 있을때의 예시입니다.
		
			사용자	비율	가격
		1	40		10,000
		2	25		10,000
		이모티콘	가격
		1		7,000
		2		9,000
		1번 사용자는 40%이상 할인하는 이모티콘을 모두 구매하고, 이모티콘 구매 비용이 10,000원 이상이 되면 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
		2번 사용자는 25%이상 할인하는 이모티콘을 모두 구매하고, 이모티콘 구매 비용이 10,000원 이상이 되면 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
		
		1번 이모티콘의 가격은 7,000원, 2번 이모티콘의 가격은 9,000원입니다.
		
		만약, 2개의 이모티콘을 모두 40%씩 할인한다면, 1번 사용자와 2번 사용자 모두 1,2번 이모티콘을 구매하게 되고, 결과는 다음과 같습니다.
		
		사용자	구매한 이모티콘	이모티콘 구매 비용	이모티콘 플러스 서비스 가입 여부
		1		1, 2		9,600				X
		2		1, 2		9,600				X
		이모티콘 플러스 서비스 가입자는 0명이 늘어나고 이모티콘 판매액은 19,200원이 늘어납니다.
		
		하지만, 1번 이모티콘을 30% 할인하고 2번 이모티콘을 40% 할인한다면 결과는 다음과 같습니다.
		
		사용자	구매한 이모티콘	이모티콘  구매 비용	이모티콘 플러스 서비스 가입 여부
		1		2					5,400		X
		2		1, 2				10,300		O
		2번 사용자는 이모티콘 구매 비용을 10,000원 이상 사용하여 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입하게 됩니다.
		따라서, 이모티콘 플러스 서비스 가입자는 1명이 늘어나고 이모티콘 판매액은 5,400원이 늘어나게 됩니다.
		
		카카오톡 사용자 n명의 구매 기준을 담은 2차원 정수 배열 users, 이모티콘 m개의 정가를 담은 1차원 정수 배열 emoticons가 주어집니다. 이때, 행사 목적을 최대한으로 달성했을 때의 이모티콘 플러스 서비스 가입 수와 이모티콘 매출액을 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해주세요.
		
		제한사항
		1 ≤ users의 길이 = n ≤ 100
		users의 원소는 [비율, 가격]의 형태입니다.
		users[i]는 i+1번 고객의 구매 기준을 의미합니다.
		비율% 이상의 할인이 있는 이모티콘을 모두 구매한다는 의미입니다.
		1 ≤ 비율 ≤ 40
		가격이상의 돈을 이모티콘 구매에 사용한다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입한다는 의미입니다.
		100 ≤ 가격 ≤ 1,000,000
		가격은 100의 배수입니다.
		1 ≤ emoticons의 길이 = m ≤ 7
		emoticons[i]는 i+1번 이모티콘의 정가를 의미합니다.
		100 ≤ emoticons의 원소 ≤ 1,000,000
		emoticons의 원소는 100의 배수입니다.
		입출력 예
		users																					emoticons					result
		[[40, 10000], [25, 10000]]																[7000, 9000]				[1, 5400]
		[[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]]	[1300, 1500, 1600, 4900]	[4, 13860]
		입출력 예 설명
		입출력 예 #1
		
		문제의 예시와 같습니다.
		
		입출력 예 #2
		
		다음과 같이 할인하는 것이 이모티콘 플러스 서비스 가입자를 최대한 늘리면서, 이모티콘 판매액 또한 최대로 늘리는 방법입니다.
		
		이모티콘	할인율
		1		40
		2		40
		3		20
		4		40
		위와 같이 할인하면 4명의 이모티콘 플러스 가입자와 13,860원의 판매액을 달성할 수 있습니다. 다른 할인율을 적용하여 이모티콘을 판매할 수 있지만 이보다 이모티콘 플러스 서비스 가입자를 최대한 늘리면서, 이모티콘 판매액 또한 최대로 늘리는 방법은 없습니다.
		따라서, [4, 13860]을 return 하면 됩니다.
	 */
	public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = new int[2]; // 결과값 {가입자수,매출액}
		System.out.println("[ 유저가구매할 할인율 , 이모티콘플러스가입기준금액 ] ");
		for(int i[] : users) {
			System.out.print(Arrays.toString(i)+" ");
		}
		System.out.println();
		System.out.println("이모티콘금액 : "+Arrays.toString(emoticons));
		System.out.println("-------------파라미터값-------------------------");
		//이모티콘 할인률 10,20,30,40
		int emosales[][] = new int[emoticons.length][4]; //이모티콘별 할인률을 저장할 배열
		for(int i = 0 ; i<emoticons.length; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				int s = (emoticons[i]/10)*(j+1);
				int saleprice = (int)(emoticons[i]-s);
				emosales[i][j]=saleprice;
			}
		}
		/*
		// 이모티콘별 10%~40% 까지 할인된금액 저장값 출력
		for(int i[] : emosales) {
			System.out.print(Arrays.toString(i)+" ");
		}
		*/
		//1. 이모티콘을 전부 구매할 할인율 경우의수  : 4(할인율)^n(이모티콘개수)
		//2. 그경우의 수에 해당하는 가입자수 , 매출액 : 가입자수 = max(그전최대가입자수 , 현재가입자수),매출액
		//3. 
		
		
		for(int i = emoticons.length-1; i>=0; i--) {
			int join = 0; // 가입자 수
			int sell = 0; //이모티콘매출액
			for(int j = 0 ; j<users.length; j++) {
				
			} // 유저정보 반복
		}//할인율 반복
		
		
		
		return answer;
	}
	public int[] saleArr(int idx , int emolen , int[] s) {
		
		return null;
	}
	
	//------------------------------------------------------
	int dis[] = {10,20,30,40}; //할인율 배열
    int userLen, emoLen; //유저수와 이모트수 변수
    int[] answer = {0,0}; // 최대가입자수와 판매액 담을 배열
    public int[] solution2(int[][] users, int[] emoticons) {
        userLen= users.length;
        emoLen = emoticons.length;

        //모든 경우의 수를 dfs로 구한다. 
        dfs(users,emoticons, new int[emoLen], 0 );

        return answer;
    }
    public void dfs(int[][] u, int[] e,int[] disInfo, int level){
        if(level == emoLen){//base condition (종료조건)
            int buyCnt = 0;
            int buySum = 0;
            
            for(int i = 0 ;i < userLen ;i++){
                int sum = 0 ;
                for(int j =0 ; j< emoLen; j++){
                    if(disInfo[j] >= u[i][0]) 
                        sum+= e[j]/100*(100-disInfo[j]);
                }
                //이모티콘구매액이 유저의 이모티콘플러스 가입조건액 이상이면 buycnt++;
                if(sum >= u[i][1]){
                    buyCnt++;
                }else{ //아니면 합계액 증가;
                    buySum += sum;
                }    
            }
            
            //answer[0]에 담긴 buyCnt보다 현재 buyCnt가 크다면 answer에 buyCnt와 buySum을 저장한다
            if(answer[0]<buyCnt) {
            	answer[0]=buyCnt;
            	answer[1]=buySum;
            }else if (answer[0]==buyCnt) { // buyCnt가 같다면 buySum을 비교하여 큰값을 answer[1]에 저장
            	answer[1] = Math.max(answer[1], buySum);
            } //else {}
            //두조건에 해당안되면 Skip후 리턴
            
            
            
            return;
        }else{
            for(int i = 0 ;i < 4 ;i++){
                disInfo[level] = dis[i];
                dfs(u,e,disInfo, level+1);
            }
        }
    }
}

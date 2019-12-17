# 우아한 테크코스 (블랙잭 게임)

## 게임 규칙

- 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다. 플레이어는 게임을 시작하면 배팅금액을 결정한다. 
- 이 후 딜러와 사용자는 각각 2개의 카드를 받는다(딜러는 한장만, 플레이어는 모든 카드를 공개한다.)
- 처음 받은 카드가 블랙잭인 경우 딜러 또한 블랙잭이 아닌경우, 플레이어는 1.5배를 받는다.
- 위의 경우가 아닌 상황에서는 게임이 진행되는데 플레이어는 자신의 숫자를 21에 가깝게 하기 위해서 카드를 추가적으로 받을 수 있다. 단, 본인의 카드의 합이 21이 초과되는 경우는 받지 못한다.
- 딜러는 자의적 선택이 아니라 딜러가 가지고 있는 카드의 합이 16이하인 경우는 필수로 카드를 추가로 받아야하고, 17이상인 경우는 받고싶어도 받지 못한다.
- 최종적으로 딜러와 플레이어의 카드를 비교해 수익을 출력하는데, 수익은 플레이어가 배당한 금액 만큼 수익을 얻는다. (예를 들어 10000원을 배팅하고 이긴 경우 가져가는 돈은 20000원이 된다.)
- 딜러는 전체 배팅금액에서 수익을 낸 플레이어를 제외한 남은 금액을 가져가는 형태이다.

- 유의사항 : ACE 는 1또는 11로 계산될 수 있으며, King , Queen , Jack은 10으로 간주한다.

## 프로그램 사용 설명서

1. Git clone을 통해, 프로젝트를 import 한다.(gradle로 import하시거나, 인텔리제이의 경우 바로 clone으로 하시면 됩니다.)
2. gradle build 
3. src - main - java - Application main method 를 실행한다.

## 기능 구현

1. 프로그램을 실행하면, 게임에 참여 할 사람의 이름을 입력받는다. (쉼표 기준으로 분리)

    - [x] 문구 : 게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리) NEXT_LINE 
    - [x] 입력받기
    - [x] 예외처리
        - [x] 공백의 이름을 입력하는 경우
        - [x] 동일 인물을 입력하는 경우
        - [x] 사용자의 수는 최소 2명에서 최대 8명이다.

2. 이름을 입력 받은 후 각각의 사람들에게 배팅하고자 하는 금액을 입력받는다.

    - [x] 문구 : Names.get(i)님의 베팅 금액은 ? NEXT_LINE
    - [x] 입력받기
    - [x] 예외처리
        - [x] 0원을 입력하는 경우
        - [x] 포맷에 어긋나는 경우(double형이 아닌 경우)

3. 이름과 배팅금액을 입력받으면 이를 바탕으로 게임시작을 위한 플레이어,딜러,카드 를 생성한다.

    - [x] 플레이어 생성
    - [x] 딜러 생성
    - [x] 덱 생성
    
4. 각각의 플레이어와 딜러에게 덱에서 2장의 카드를 나누어 준다.
    
    - [x] 플레이어는 두장의 카드를 받음과 동시에 공개되며
    - [x] 딜러의 경우는 한장만 공개된다.
    - [x] 똑같은 카드가 중복사용되지 않도록 덱클래스를 관리한다.
    
5. 플레이어가 두장의 카드만으로 블랙잭인 경우(21인 경우)

    - [x] 플레이어의 수익을 계산한다. (수익 = 배팅액 * 1.5)
        - [x] 플레이어 클래스에 배율을 넘겨 계산
    - [x] 딜러 또한 블랙잭인 경우(플레이어와 딜러 모두 블랙잭)에 플레이어는 본인이 배팅한 금액만을 받는다.
        - [x] 결과에서, 비긴경우와 동일한 배율이 적용되기 떄문에 후에 처리
    
6. 각각의 사용자에게 추가카드를 받을 것인지 물어보고, 추가 카드를 지급한다.

    - [x] Names.get(i)님 한장의 카드를 더 받겠습니까?(Y / N)
    - [x] 플레이어는 지급 받기전, 카드의 합이 21미만이어야 하며
    - [x] 받을 의사가 있어야한다.
        - [x] 사용자 입력을 통해 Y / N 으로 입력받는다.
        - [x] 예외처리
            - [x] Y혹은 N이 입력되지 않은 경우
            - [x] 대소문자 구분없이 입력받기 위해 toUpperCase를 사용한다.
    - [x] 사용자의 카드가 21이상이거나, 받을 의사가 N이 나올 때 까지 계속해서 물어본다.
    - [x] 받게되는 경우와 받지 않는 경우 모두 현재의 카드를 출력한다.
    
7. 모든 사용자의 추가카드 지급이 끝나면 딜러에게 카드를 추가로 지급할 지를 판단한다.
   
    - [x] 딜러의 카드의 합이 16이하인 경우 강제로 지급하며
    - [x] 딜러의 카드의 합이 17이상인 경우 지급하지 않는다.
    - [x] 딜러는 16이하라 카드를 한장의 카드를 더 받았습니다.
    
8. 이후 딜러와 플레이어의 모든 카드를 출력하며 카드의 결과값(합계) 또한 함께 출력한다.
    
    - [x] 플레이어 출력
    - [x] 딜러 출력
    - [x] 각각의 결과 출력
    
9. 결과를 비교해 수익을 출력한다.
    
    - 수익은 게임 이후 수익금을(본인의 배팅액 제외) 의미하며 -인 경우 잃은 것을 의미한다.
    - 각 사용자와 비교를 통해 이긴경우는 그 사용자의 배팅액을, 가져가고 진 경우 배팅액만큼 - 한다.
    - [x] 규칙 (플레이어 기준 승리 비김 패배) - 계산을 쉽게하기 위해 버스트 인경우 합계는 0으로 간주한다.
        - [x] 승리하는 경우
            - [x] dealer.isBurst() && !player.isBurst()
            - [x] dealer.sumOfCard() < player.sumOfCard()
        - 비기는 경우
            - [x] dealer.sumOfCard() == player.sumOfCard() && !both.isBurst()
        - 패배하는 경우
            - [x] !dealer.isBurst() && player.isBurst()
            - [x] dealer.isBurst() && player.isBurst()
            - [x] dealer.sumOfCard() > player.sumOfCard()    
    - 출력한다.
    
## 추가적인 리팩토링 및 버그수정

1. 버그수정
 
    - [x] 딜러의 수익금 에러
    - [x] 사용자는 카드가 아직 21이 되지 않았는데, 추가로 카드를 받을지 묻지 않음.

2. 리팩토링
 
    - [x] if / else 제거하기
    - [x] method 길이 줄이기
    - [x] 클래스 및 메서드 주석 
    - [x] 자바 코드 컨벤션
    - [x] 메인함수 예외처리
    - [x] 네이밍 수정
    
3. 테스트 코드작성(도메인)
    - [x] 딜러, 플레이어, 게이머(부모 클래스)
    - [x] 카드 및 덱 관련 테스트
     

## 사용 툴

    - Build : Gradle
    - IDE : Intellij
    - JDK : 1.8
    - Test : Junit
    - Program : Command Line Program
    
## 프로그램 결과 화면 (커멘드라인 실행 화면)

<div>
<img width="900" alt="blackjack _result" src="https://user-images.githubusercontent.com/49060374/70980079-08ce4180-20f6-11ea-8649-cb42d5de3f0f.png">
</div>

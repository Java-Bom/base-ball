# 숫자 야구 게임
숫자 야구 게임을 진행한다.

## 게임 진행
컴퓨터는 랜덤한 숫자를 3개 뽑는다.  
숫자는 0부터 9까지 있다.  
이때 사용자는 컴퓨터가 뽑은 3개의 숫자를 모르는 상태이다.

사용자는 컴퓨터가 뽑은 숫자를 예측해서 입력을 한다.
사용자가 입력한 숫자에 따라 다음과 같은 결과가 나온다.
- 예측한 숫자가 번호는 같지만 순서가 다르다면 BALL
- 예측한 숫자가 번호도 순서도 같다면 STRIKE
- 예측한 숫자가 순서도, 번호도 틀리다면 OUT

3STRIKE를 한 경우 사용자의 승리로 게임은 끝나며 최종 시도 횟수를 출력하라. 

## 출력 예시
컴퓨터가 1,5,9를 뽑았다고 가정하자.
```
컴퓨터가 숫자를 뽑았습니다.

사용자 입력 : 1,2,3
1STRIKE 2OUT

사용자 입력 : 6,7,1
1BALL 2OUT

사용자 입력 : 1,9,5
2BALL 1STRIKE

사용자 입력 : 1,5,9
3STRIKE

최종 시도횟수 : 4회
```



## 제출시

1. 기능 요구사항을 반드시 작성해주세요.

2. 깃 커밋은 다음과 같은 템플릿을 이용해주세요.

   ```
   <type>: <subject>
   <BLANK LINE>
   <body>
   
   type: feat(기능추가),docs(문서작성),refactor(수정)
   subject: 해당 커밋의 제목
   body: 해당 커밋의 상세 내용
   ```

3. PR 생성시 클래스 다이어그램을 설명과 함께 첨부해 주세요.

4. 미션은 step1/[자신의 이니셜] 브랜치를 생성하고 진행해주세요.

5. PR은 step1/[자신의 이니셜]에서 [자신의 이니셜] 브랜치로 보내주세요

## 기능 구현 사항
1. 야구게임에 사용하는 숫자 클래스 BallNumber
2. 숫자를 미리 캐싱할 BallNumberCache
3. 숫자의 위치 Position
4. BallNumber 와 Position 값을 가지고 실제 게임에 참여하는 BaseBallNumber
5. BallNumber 를 생성하는 BallGenerator
6. BaseBallNumber 리스트를 감싸는 일급컬렉션 BaseBallNumbers
7. 숫자 야구 게임을 진행하는 BaseBallGame
8. Strike, Ball, Out 정보를 가지는 Rule
9. 예측 결과들을 가지는 PredicateResult
10. 출력 담당 OutputView
11. 입력 담당 InputView


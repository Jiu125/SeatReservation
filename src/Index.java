import FramePack.BasicsFrame;

import javax.swing.*;

/**
 * 자바 청주대학교 학교 급식 자리 예약 시스템 메인 클래스입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v0.0.2 ( 설계 )
 * @since
 *
 * {@code @created} 2024-11-09
 * {@code @lastModified}
 *
 * {@code @changelog}
 * <ul>
 *   <li>2024-11-09: 최초 생성</li>
 * </ul>
 */

/*
    본 프로그램은 JFrame을 활용할 것.
    예약 프로그램이므로 구매 화면과 좌석 선택 화면 총 2가지의 프레임이 필요.
    따라서 BuySeatFrame.java 와 ViewSeatFrame.java 로 파일을 나눌 것.

    실시간으로 사람이 자리에 있는지 없는지 확인.
    좌석을 예약하기에 필요한 기능들인 것들은 대부분 버튼을 활용해볼 것.
    버튼을 누르면 다른 프레임 화면이 뜨거나, 좌석을 선택, 구매와 취소하는 것
    따라서 각 기능을 클래스로 나눠 파일을 각각 나눌 것.
    ( MyButton 의 디자인을 상속 받고 기능을 추가하는 방식 )

    -- 버튼 기능 --
     1. SelectedBtn.java 좌석 선택과 선택 해제
        - SelectBtn.java
     2. MakeFrameBtn.java 결제 화면 생성
        - MakeBtn.java
     3. BuyBtn.java 좌석 구매 or 취소
        - BuyTicketAction.java

    -- UI Folder --
     1. 각 기능이 다른 버튼들의 모음
        - BuyBtn
        - MakeFrameBtn
        - SelectedBtn

    -- SelectBtn.java 기능 --
    1. 기본 버튼 배경색은 하늘색, 선택시 초록색으로 ( 구현 )
    2. 결제하여 자리가 이미 있는 상태는 핑크색으로 할 것.
       왜냐하면 사용자 입장에서 선택한 색과 다른 사람이 있는 자리 색이 같다면 헷갈릴 수 있음.

    3. 보라색이 배경인 버튼은 45분 후 자동으로 하늘색으로 바뀜.
    즉, 일정 시간이 지나면 좌석은 빈 좌석으로 상태가 전환됨.
    하지만, 프로토타입임으로 시간은 3분으로 교체하여 테스트 진행.

    -- MakeBtn.java 기능 --
    1. PurchaseFrame 생성 ( 구현 )
    2. BasicsFrame 좌석 버튼 비활성화
        - 어떻게 한 번에 모든 버튼을 관리해야할지 생각 중.

    -- BuyBtn.java 기능 --
    1. BasicsFrame 에 있는 구매 버튼을 활성화 시킴 ( 구현 )
    2. BasicsFrame 에 있는 좌석 상태를 변경
    3. Json 파일의 선택한 좌석 value 값을 변경
    3. 큐를 사용해서 현재 결제량을 계산 ( 컬렉션1 )


    ( 어떻게 구매를 인증하고 정보를 받을 것인지 검색
    아마도 API를 사용한다면
    아니면 흉내만 내고 작동은 안 하는 방식도 존재. => 이러면 너무 빨리 끝날 것 같음.
    카카오나 토스 간편 결제 시스템에 대해서 검색
    일단 추후에 적용 )

    ** 재실행 해도 좌석 정보가 유지하기 위한 일 **
     1. java 에서 mat 을 사용해서 버튼의 상태를 관리 ( 컬렉션 2 )
     3. key : value 로 나뉘고 key 는 String , value 은 boolean 자료형으로 한다. ( false: 자리 없음 , true: 자리 있음)
        ( 몇 번째 단어인지 확인 하는 메소드가 필요 )
     클릭한 버튼의 차례(좌석 번호)를 반환하고 반환한 수의 value 를 반대로 바꿈.
        => 방법 1.
            버튼의 text를 생성된 자신의 번호로 text를 대입.
            그리고 클릭하면 text를 반환하고 그에 맞는 줄의 정보를 반대로 바꿈.
            쉽게 구현 가능. 하지만 디자인이 안 예쁨.

  SeatReservation
        │
        ├── src.Index.java
        │
        ├── SeatData
        │    ├── SeatDataManager.java
        │    └── SeatCondition.gson
        │
        ├── FramePack
        │    ├── PurchaseFrame.java
        │    └── BasicsFrame.java
        │
        ├── UiPack
        │    ├── BuyBtn.java
        │    ├── MakeBtn.java
        │    └── SelectBtn.java
        │
        └── ActionListenerPack
             ├── MakeFrameBtnAction.java
             ├── BuyTicketAction.java
             └── SelectedBtnAction.java
 */
public class Index extends JFrame {
    public Index() {
        new BasicsFrame();
    }

    public static void main(String[] args) {
        new Index();
    }
}

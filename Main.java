import FramePack.BasicsFrame;
import FramePack.PurchaseFrame;

import javax.swing.*;

/**
 * 자바 청주대학교 학교 급식 자리 예약 시스템 메인 클래스입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v0.0.1 ( 설계 )
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
     1. MoveFrameBtn.java 화면 이동 ( 구매와 취소 버튼 )
     2. SelectedBtn.java 좌석 선택과 선택 해제

    -- UI Folder --
     1. MyButton.java 좌석의 형태를 만들어줄 버튼 클래스 ( JButton 을 상속받아 디자인 )

    -- 구매 기능 --
    어떻게 구매를 인증하고 정보를 받을 것인지 검색
    아마도 API를 사용한다면
    아니면 흉내만 내고 작동은 안 하는 방식도 존재. => 이러면 너무 빨리 끝날 것 같음.
    카카오나 토스 간편 결제 시스템에 대해서 검색
    일단 추후에 적용

    ** 재실행 해도 좌석 정보가 유지하기 위한 일 **
     1. java 로컬 만들기 ( 아마도 메모장(txt 파일)을 이용할 것 같음)
     2. 24줄의 앞글자 데이터를 0인지 1인지 구분하여 데이터를 읽는다.
     3. 앞글자에 따라서 버튼의 선택 유무가 달라짐. ( 0: 자리 있음 , 1: 자리 없음)
        ( 몇 번째 단어인지 확인 하는 메소드가 필요 )
     클릭한 버튼의 차례를 반환하고 반환한 수의 줄 앞자리를 반대로 바꿈.
        => 방법 1.
            버튼의 text를 생성된 자신의 번호로 text를 대입.
            그리고 클릭하면 text를 반환하고 그에 맞는 줄의 정보를 반대로 바꿈.
            쉽게 구현 가능. 하지만 디자인이 안 예쁨.

  SeatReservation
        │
        ├── Main.java
        │
        ├── FramePack
        │    ├── PurchaseFrame.java
        │    └── BasicsFrame.java
        │
        ├── UiPack
        │    ├── BuyBtn.java
        │    └── SelectBtn.java
        │
        └── ActionListenerPack
             ├── MoveFrameBtnAction.java
             └── SelectedBtnAction.java
 */
public class Main extends JFrame {
    public Main() {
        new BasicsFrame();
    }

    public static void main(String[] args) {
        new Main();
    }
}

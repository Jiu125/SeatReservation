package com;

import FramePack.BasicsFrame;

import javax.swing.*;

/**
 * 자바 청주대학교 학교 급식 자리 예약 시스템 메인 클래스입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v1.0.0
 * @since
 *
 * {@code @created} 2024-11-09
 * {@code @lastModified} 2024-11-29
 *
 * {@code @changelog}
 * <ul>
 *   <li>2024-11-09: 최초 생성</li>
 *   <li>2024-12-11: 배포 성공</li>
 *   <li>2024-12-16: 프로토타입 완성</li>
 * </ul>
 */

/*
  SeatReservation
        │
        ├── src.main.java
        │       │
        │       ├── com.Index.java
        │       │
        │       ├── SeatData
        │       │    ├── SeatDataManager.java
        │       │    └── SeatCondition.gson
        │       │
        │       ├── FramePack
        │       │    ├── PurchaseFrame.java
        │       │    └── BasicsFrame.java
        │       │
        │       ├── UiPack
        │       │    ├── BuyBtn.java
        │       │    ├── MakeBtn.java
        │       │    └── SelectBtn.java
        │       │
        │       └── ActionListenerPack
        │            ├── MakeFrameBtnAction.java
        │            ├── BuyTicketAction.java
        │            └── SelectedBtnAction.java
        │
        │
        └──────── pom.xml
 */
public class Index extends JFrame {
    public Index() {
        new BasicsFrame();
    }

    public static void main(String[] args) {
        new Index();
    }
}

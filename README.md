# School Cafeteria Seat Reservation
학교 급식 자리 예약 프로그램

## 목차
1. [개요](#개요)
   1. [목적](#1-목적)
   2. [대상](#2-대상)
2. [프로그램의 중요성 및 필요성](#프로그램의-중요성-및-필요성)
   1. [중요성](#1-중요성)
   2. [필요성](#2-필요성)
3. [프로그램 수행 절차](#프로그램-수행-절차)
   1. [절차 설명](#1-절차-설명)
   2. [다이어그램 (흐름도)](#2-다이어그램-흐름도)
   3. [클래스 다이어그램](#3-클래스-다이어그램)
4. 느낌점

## 개요
### 1. 목적
학교 식당에서 **식권 구매와 동시에 좌석을 예약**할 수 있는 시스템입니다.  
학생들이 빈자리를 찾는 시간을 줄이고, 효율적인 식사 환경을 제공합니다.  
이를 통해 **혼잡한 식당 문제를 개선**하고, **사용자 만족도를 높이는** 것이 목표입니다.

---

### 2. 대상
이 프로그램의 대상은 학교 식당을 이용하는 모든 사람입니다.  
학생뿐 아니라, 주변 지역 주민 등 외부 방문객도 포함됩니다.
- **학생**
- 교직원 (추후 개발 예정)
- 외부 방문객 (추후 개발 예정)
- 주변 지역 주민 (추후 개발 예정)

## 프로그램의 중요성 및 필요성
### 1. 중요성
- **효율적인 시간 관리**  
   학생들은 바쁜 일정을 소화해야 하며, 특히 점심시간은 학업과 휴식을 병행할 수 있는 중요한 시간입니다.  
   좌석을 미리 예약할 수 있는 시스템은 학생들이 식사에 소비하는 시간을 줄이고, 남은 시간을 학업이나 휴식에 투자할 수 있도록 돕습니다.


- **식당 운영의 체계화**  
   좌석 예약 시스템을 도입하면 식당 운영의 효율성을 높일 수 있습니다.  
   특정 시간대의 예약 데이터를 기반으로 인원을 관리하거나, 좌석 이용 현황을 실시간으로 확인해 혼잡도를 줄이는 데 기여할 수 있습니다.


- **고객 만족도 향상**  
   학생, 교직원, 외부 방문객 등 다양한 이용자가 편리하게 식사를 즐길 수 있도록 환경을 조성하여 식당에 대한 만족도가 향상될 것입니다.  
   특히, 대기 시간을 줄이고 원하는 좌석을 확보할 수 있다면 이용자의 전반적인 경험이 개선됩니다.


- **공정한 좌석 이용**  
   선착순이나 무질서한 자리 배정에서 벗어나, 예약 시스템을 통해 공정하고 질서 있는 좌석 이용 문화를 형성할 수 있습니다.

---

### 2. 필요성
- **혼잡한 식당 문제 해결**  
  인기 있는 시간대의 식당 혼잡은 학생들에게 스트레스를 주고, 귀중한 시간을 낭비하게 만듭니다.  
  좌석 예약 시스템은 이런 문제를 해결해 식당의 효율적 이용을 돕습니다.


- **다양한 이용자 요구 충족**  
  학교뿐만 아니라 지역 주민과 같은 외부 방문객도 식당을 이용하는 경우가 많습니다.  
  예약 시스템은 이러한 다양한 사용자층의 요구를 충족시키며, 더 많은 사람이 식당을 편리하게 이용할 수 있게 합니다.


- **디지털 환경 적응**  
  대부분의 학생들은 스마트폰과 같은 디지털 기기를 적극적으로 활용하고 있습니다.  
  이러한 기술적 기반을 활용한 좌석 예약 시스템은 학생들에게 친숙하며, 사용자 경험을 향상시킬 수 있습니다.


- **공간 자원의 효율적 활용**  
  좌석 예약 데이터를 분석하면, 특정 시간대에 비어 있는 좌석을 파악하거나, 부족한 좌석 수를 확인하여 운영 방안을 개선할 수 있습니다.  
  이는 식당 공간을 최대한 효율적으로 사용하는 데 기여할 것입니다. 

## 프로그램 수행 절차
### 1. 절차 설명
클래스 다이어그램과 구조를 바탕으로 **좌석 예약 프로그램**의 절차를 설명합니다.

1. **프로그램 실행 (Index 클래스)**
    - 프로그램 진입점인 `main()` 메서드를 실행합니다.
    - `BasicsFrame` 객체가 생성되어 전체 프레임이 화면에 표시됩니다.

2. **기본 프레임 설정 (BasicsFrame 클래스)**
    - `BasicsFrame` 클래스는 전체 UI 화면을 설정합니다.
    - `MakeBtn`, `SelectBtn`, `SeatDataManager` 객체가 생성됩니다.
    - 화면에는 `northPanel`, `mainPanel`, `southPanel`과 같은 레이아웃 영역이 설정됩니다.

3. **좌석 버튼 선택 (SelectBtn 클래스)**
    - 사용자(고객)는 `SelectBtn`을 클릭하여 좌석을 선택합니다.
    - `SelectedBtnAction`이 `actionPerformed()`를 실행해 선택된 버튼 정보를 `selectedButtons`에 저장합니다.
    - 선택된 좌석 정보는 `SeatDataManager`에 반영됩니다.

4. **구매 버튼 동작 (BuyBtn 클래스, BuyTicketAction 클래스)**
    - `BuyBtn` 클릭 시, `BuyTicketAction`의 `actionPerformed()`가 호출됩니다.
    - `checkBtnText()` 메서드를 통해 좌석이 선택되었는지 확인합니다.
    - `purchaseSeats()`를 호출하여 좌석 구매를 처리합니다.

5. **데이터 관리 (SeatDataManager 클래스)**
    - `SeatDataManager`는 선택된 좌석 데이터를 `seatMap`에 저장하거나 불러옵니다.
    - `loadSeatData()`, `saveSeatData()` 메서드를 통해 JSON 형식으로 데이터가 파일에 저장됩니다.

6. **결과 출력 및 화면 갱신 (PurchaseFrame 클래스)**
    - 좌석 구매가 완료되면 `PurchaseFrame`이 생성됩니다.
    - 결과 패널과 버튼들이 화면에 표시되며 사용자에게 구매 결과를 보여줍니다.
    - 필요 시 `cancelBtn`으로 작업을 취소하거나 다시 초기 화면으로 돌아갑니다.

---

### 2. 다이어그램 (흐름도)

아래 흐름도는 프로그램의 수행 절차를 단계별로 시각화한 것입니다.

```mermaid
graph TD
    A[프로그램 시작 Index.main] --> B[BasicsFrame 생성]
B --> C[SeatDataManager 초기화]
B --> D[화면 구성: 버튼 및 패널 생성]
D --> E[MakeBtn 클릭됨?]
E -- 예 --> F[MakeFrameBtnAction 동작]
F --> G[새로운 프레임 생성 좌석 선택]
D --> H[SelectBtn 클릭됨?]
H -- 예 --> I[SelectedBtnAction 동작]
I --> J[선택된 버튼 리스트 업데이트]
I --> K[SeatDataManager로 좌석 상태 관리]
D --> L[BuyBtn 클릭됨?]
L -- 예 --> M[BuyTicketAction 동작]
M --> N[선택된 좌석 예약]
N --> O[좌석 데이터 저장]
O --> P[PurchaseFrame 결과 화면 표시]
P --> Q[프로그램 종료]
L -- 아니오 --> Q[프로그램 종료]
H -- 아니오 --> Q[프로그램 종료]
E -- 아니오 --> Q[프로그램 종료]

```
---
### 3. 클래스 다이어그램

아래 흐름도는 프로그램의 클래스 다이어그램을 시각화한 것입니다.
```mermaid
classDiagram
    direction TB

    class Index {
        + main(String[]) void
        + Index()
    }

    class BasicsFrame {
        + getBtn() MakeBtn
        + getSelectedButtons() Set~SelectBtn~
        + getSelectedButtonsList() String
        - showNorth() void
        - showCenter() void
        - showSouth() void
        + BasicsFrame()
        - Set~SelectBtn~ selectedButtons
        # JPanel southPanel
        # JPanel mainPanel
        # JPanel northPanel
        + SelectBtn seatBtn
        + MakeBtn frameMakeBtn
        - SeatDataManager seatDataManager
    }

    class MakeBtn {
        + MakeBtn()
    }

    class BuyBtn {
        + getOtherButton() MakeBtn
        + setOtherButton(MakeBtn) void
        + BuyBtn(JFrame)
        - MakeBtn otherBtn
    }

    class BuyTicketAction {
        + checkBtnText(BuyBtn) void
        + actionPerformed(ActionEvent) void
        + BuyTicketAction(BuyBtn, Frame)
        - BuyBtn buyBtn
        - Frame targetFrame
    }

    class MakeFrameBtnAction {
        + actionPerformed(ActionEvent) void
        + MakeFrameBtnAction()
    }

    class PurchaseFrame {
        - showResult() void
        - showButton() void
        - showLabel() void
        + PurchaseFrame()
        ~ BuyBtn cancelBtn
        ~ JPanel btnPanel
        ~ JPanel labelPanel
        ~ JLabel resultLabel
        ~ BuyBtn buyBtn
        ~ JPanel resultPanel
    }

    class SeatDataManager {
        + saveSeatData() void
        + getSeatMap() HashMap~String, Boolean~
        + purchaseSeats(Set~SelectBtn~) void
        + initializeSeatData() void
        - loadSeatData() void
        - resetUnavailableSeats() void
        + SeatDataManager()
        - String FILE_PATH
        - Gson gson
        - HashMap~String, Boolean~ seatMap
    }

    class SelectBtn {
        + SelectBtn(String, boolean)
    }

    class SelectedBtnAction {
        + actionPerformed(ActionEvent) void
        + SelectedBtnAction(String, SelectBtn, Set~SelectBtn~)
        - String seatKey
        - Set~SelectBtn~ selectedButtons
        - SelectBtn button
    }

%% Relationships
    Index --> BasicsFrame : «create»

    BasicsFrame --> MakeBtn : «create»
    BasicsFrame "1" *--> "frameMakeBtn 1" MakeBtn
    BasicsFrame "1" *--> "seatDataManager 1" SeatDataManager
    BasicsFrame --> SeatDataManager : «create»
    BasicsFrame "1" *--> "selectedButtons *" SelectBtn
    BasicsFrame --> SelectBtn : «create»
    BasicsFrame --> SelectedBtnAction : «create»

    MakeBtn --> MakeFrameBtnAction : «create»
    MakeFrameBtnAction --> PurchaseFrame : «create»

    PurchaseFrame --> BuyBtn : «create»
    PurchaseFrame "1" *--> "buyBtn 1" BuyBtn

    BuyBtn --> BuyTicketAction : «create»
    BuyBtn "1" *--> "otherBtn 1" MakeBtn
    BuyTicketAction "1" *--> "buyBtn 1" BuyBtn

    SelectedBtnAction "1" *--> "selectedButtons *" SelectBtn


```

package FramePack;

import UiPack.BuyBtn;
import UiPack.MakeBtn;

import javax.swing.*;
import java.awt.*;

/**
 * 구매와 취소를 담당하는 프레임 클래스입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v0.0.2
 * @since
 *
 * {@code @created} 2024-11-11
 * {@code @lastModified}
 *
 * {@code @changelog}
 * <ul>
 *   <li>2024-11-11: 최초 생성</li>
 * </ul>
 */
public class PurchaseFrame extends JFrame {
    JPanel labelPanel, resultPanel, btnPanel;
    JLabel resultLabel;
    BuyBtn buyBtn, cancelBtn;
    public PurchaseFrame() {
        setTitle("구매 창");
        setSize(400, 600);
        setLocationRelativeTo(null);

        showLabel();
        showResult();
        showButton();

        setVisible(true);
    }

    /**
     * 결제하는 창을 알리는 label 을 나타내는 메소드입니다.
     *
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-16
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-16: 최초 생성</li>
     * <ul>
     */
    private void showLabel() {
        labelPanel = new JPanel();
        labelPanel.add(new JLabel("아래의 좌석이 선택한 좌석이 맞는지 다시 한 번 확인하세요!"));

        add(labelPanel, BorderLayout.NORTH);
    }

    /**
     * 총 가격과 선택한 좌석을 나타내는 메소드입니다.
     *
     * @version v0.0.4
     * @since
     *
     * {@code @created} 2024-11-16
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-16: 최초 생성</li>
     *   <li>2024-12-09: 가격 표 출력</li>
     * <ul>
     */
    private void showResult() {
//        int seatNum = BasicsFrame.getSelectedButtons().size();
//        String list = BasicsFrame.getSelectedButtonsList();


        resultPanel = new JPanel();

        resultLabel = new JLabel();
        String temp = String.format(
                "<html>" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "    <title>영수증</title>" +
                "    <style>" +
                "        body {" +
                "            font-family: 'Arial', sans-serif;" +
                "            margin: 20px;" +
                "            width: 300px;" +
                "        }" +
                "        .receipt {" +
                "            border: 1px solid #ddd;" +
                "            padding: 20px;" +
                "            line-height: 1.6;" +
                "        }" +
                "        .receipt-header {" +
                "            margin-bottom: 10px;" +
                "            text-align: center;" +
                "            font-weight: bold;" +
                "        }" +
                "        .receipt-section {" +
                "            margin-top: 5px;" +
                "            margin-bottom: 5px;" +
                "        }" +
                "        .receipt-section div {" +
                "            display: flex;" +
                "            justify-content: space-between;" +
                "        }" +
                "        .line {" +
                "            border-top: 1px dashed #000;" +
                "        }" +
                "        .total {" +
                "            font-weight: bold;" +
                "        }" +
                "    </style>" +
                "</head>" +
                "<body>" +
                "    <div class=\"receipt\">" +
                "        <div class=\"receipt-header\">" +
                "            소공점" +
                "        </div>" +
                "        <div class=\"receipt-section\">" +
                "            <div>사업자번호: 2023011794</div>" +
                "            <div>성명: 박지우</div>" +
                "            <div>주소: 충청북도 청주시 청원구 대성로 298</div>" +
                "            <div>전화: 010-4073-1235</div>" +
                "            <div>일자: 2018-04-25 10:12:12</div>" +
                "        </div>" +
                "        <div class=\"line\"></div>" +
                "        <div class=\"receipt-section\">" +
                "            <div style=\"font-weight: bold;\">" +
                "                <span>품명&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>단가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>수량&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>금액</span>" +
                "            </div>" +
                "        <div class=\"line\"></div>" +
                "            <div>" +
                "                <span>복숭아 아이스티</span>" +
                "                <span>2,500</span>" +
                "                <span>1</span>" +
                "                <span>2,500</span>" +
                "            </div>" +
                "        </div>" +
                "        <div class=\"line\"></div>" +
                "        <div class=\"receipt-section\">" +
                "            <div>" +
                "                <span>공급가액:</span>" +
                "                <span>2,273</span>" +
                "            </div>" +
                "            <div>" +
                "                <span>부가세:</span>" +
                "                <span>227</span>" +
                "            </div>" +
                "        </div>" +
                "        <div class=\"line\"></div>" +
                "        <div class=\"receipt-section total\">" +
                "            청구금액: 2,500" +
                "        </div>" +
                "    </div>" +
                "</body>" +
                "</html>");
//        String temp = String.format(
//                "<html><body style='text-align:center;'>" +
//                "--------------------------------------------------------------------------------<br/>" +
//                "상&nbsp;&nbsp;&nbsp;&nbsp;품&nbsp;&nbsp;&nbsp;&nbsp;명&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
//                        "단&nbsp;&nbsp;&nbsp;가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;수&nbsp;&nbsp;&nbsp;량&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
//                        "금&nbsp;&nbsp;&nbsp;액<br/>" +
//                "--------------------------------------------------------------------------------<br/>" +
//                "좌석 티켓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
//                        "6,000&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
//                        "%2d&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
//                        "%d<br/>" +
//                "--------------------------------------------------------------------------------<br/>" +
//                "고객님이 선택하신 좌석은 N번 좌석 입니다.<br/>" +
//                "선택한 총 좌석 가격(좌석당 가격: 6,000원): N * 6000 " +
//                "</body></html>", 1, 6000 * 1);
        resultLabel.setText(temp);
//        System.out.println(BasicsFrame.getSelectedButtonsList());
//        resultLabel.setText("좌석 당 가격: 6000원\n 선택한 좌석( 1, 2, 8 )\n 총 가격: 18,000원");

        resultPanel.add(resultLabel);

        add(resultPanel, BorderLayout.CENTER);
    }

    /**
     * 구매와 구매 취소 버튼을 나타내는 메소드입니다.
     *
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-16
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-16: 최초 생성</li>
     * <ul>
     */
    private void showButton() {
        MakeBtn makeBtn = BasicsFrame.getBtn();

        btnPanel = new JPanel();

        buyBtn = new BuyBtn(this);
        buyBtn.setText("결제");
        buyBtn.setOtherButton(makeBtn);
        
        cancelBtn = new BuyBtn(this);
        cancelBtn.setText("취소");
        cancelBtn.setOtherButton(makeBtn);

        btnPanel.add(cancelBtn);
        btnPanel.add(buyBtn);

        add(btnPanel, BorderLayout.SOUTH);
    }
}

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
 *   <li>2024-12-10: 영수증 화면 생성</li>
 * </ul>
 */
public class PurchaseFrame extends JFrame {
    JPanel labelPanel, resultPanel, btnPanel;
    JLabel resultLabel;
    BuyBtn buyBtn, cancelBtn;
    public PurchaseFrame() {
        setTitle("구매 창");
        setSize(400, 480);
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
        int seatNum = BasicsFrame.getSelectedButtons().size();
        int totalPrice= seatNum * 6000;
        int suttax = (int) (seatNum * 0.1 * 6000);
        int supplyPrice = totalPrice - suttax;


        String list = BasicsFrame.getSelectedButtonsList();


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
                "            margin: 10px;" +
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
                "            margin-top: 1px;" +
                "            margin-bottom: 5px;" +
                "        }" +
                "        .receipt-section div {" +
                "            display: flex;" +
                "            justify-content: space-between;" +
                "        }" +
                "        .line {" +
                "            margin-top: 5px;" +
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
                "            영수증" +
                "        </div>" +
                "        <div class=\"receipt-section\">" +
                "            <div>사업자번호:&nbsp;&nbsp;2023011794</div>" +
                "            <div>성명:&nbsp;&nbsp;박지우</div>" +
                "            <div>주소:&nbsp;&nbsp;충청북도 청주시 청원구 대성로 298</div>" +
                "            <div>전화:&nbsp;&nbsp;010-4073-1235</div>" +
                "            <div>일자:&nbsp;&nbsp;2018-04-25 10:12:12</div>" +
                "        </div>" +
                "        <div class=\"line\"></div>" +
                "        <div class=\"receipt-section\">" +
                "            <div style=\"font-weight: bold;\">" +
                "                <span>품&nbsp;명&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>단&nbsp;가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>수&nbsp;량&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>금&nbsp;액</span>" +
                "            </div>" +
                "        <div class=\"line\"></div>" +
                "            <div>" +
                "                <span>좌석&nbsp;티켓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>6000&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>%2d&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>%4d</span>" +
                "            </div>" +
                "        </div>" +
                "        <div class=\"line\"></div>" +
                "        <div class=\"receipt-section\">" +
                "            <div>" +
                "                <span>공급가액:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>%4d</span>" +
                "            </div>" +
                "            <div>" +
                "                <span>부가세:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                "                <span>%4d</span>" +
                "            </div>" +
                "        </div>" +
                "        <div class=\"line\"></div>" +
                "        <div class=\"receipt-section total\">" +
                "            청구금액:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        "%4d" +
                "        </div>" +
                "    </div>" +
                "</body>" +
                "</html>",seatNum , totalPrice, supplyPrice, suttax, totalPrice);
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

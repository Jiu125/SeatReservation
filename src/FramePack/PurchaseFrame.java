package src.FramePack;

import src.UiPack.BuyBtn;
import src.UiPack.MakeBtn;

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
        setSize(400, 300);

        showLabel();
        showResult();
        showButton();

        setVisible(true);
    }

    /**
     * 결제하는 창을 알리는 label를 나타내는 메소드입니다.
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
     */
    private void showLabel() {
        labelPanel = new JPanel();
        labelPanel.add(new JLabel("아래의 좌석이 선택한 좌석이 맞는지 다시 한 번 확인하세요"));

        add(labelPanel, BorderLayout.NORTH);
    }

    /**
     * 총 가격과 선택한 좌석을 나타내는 메소드입니다.
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
     */
    private void showResult() {
        resultPanel = new JPanel();

        resultLabel = new JLabel();
        resultLabel.setText("좌석 당 가격: 6000원\n 선택한 좌석( 1, 2, 8 )\n 총 가격: 18,000원");

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

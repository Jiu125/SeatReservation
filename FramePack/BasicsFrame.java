package FramePack;

import UiPack.BuyBtn;
import UiPack.SelectBtn;

import javax.swing.*;
import java.awt.*;

/**
 * 자리를 선택하고 예약할 수 있는 기본 프레임 클래스입니다.
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
 *   <li>2024-11-11: 좌석 버튼과 구매 버튼 생성</li>
 * </ul>
 */
public class BasicsFrame extends JFrame {
    JPanel mainPanel, southPanel, northPanel;
    SelectBtn seatBtn;
    BuyBtn buyBtn;
    public BasicsFrame() {
        setTitle("좌석 선택");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showNorth();
        showSouth();
        showCenter();

        setVisible(true);
    }

    /**
     *  학교 내에 있는 어디 식당인 나타내는 제목 메소드이다.
     *
     * {@code @created} 2024-11-12
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-12: 최초 생성</li>
     * </ul>
     */
    private void showNorth() {
        Font font = new Font("Dialog",Font.BOLD,15);
        northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel titel = new JLabel("청주대학교 OO식당 자리표");

        titel.setFont(font);

        northPanel.add(titel);

        add(northPanel, BorderLayout.NORTH);
    }

    /**
     *  학교 식당의 좌석 구조를 보여주는 메소드이다.
     *
     * {@code @created} 2024-11-12
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-12: 최초 생성</li>
     * </ul>
     */
    private void showCenter() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 6, 13, 42));

        for (int i = 0; i < 24; i++) {
            seatBtn = new SelectBtn();
            mainPanel.add(seatBtn);
        }

        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     *  하단에 구매 버튼을 나타내는 메소드이다.
     *
     * {@code @created} 2024-11-12
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-12: 최초 생성</li>
     * </ul>
     */
    private void showSouth() {
        southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 5));
        buyBtn = new BuyBtn();

        buyBtn.setText("구매");

        southPanel.add(buyBtn);

        add(southPanel, BorderLayout.SOUTH);
    }
}

package FramePack;

import UiPack.MakeBtn;
import ActionListenerPack.SelectedBtnAction;
import SeatData.SeatDataManager;
import UiPack.SelectBtn;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

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
    protected JPanel mainPanel, southPanel, northPanel;
    public SelectBtn seatBtn;
    public static MakeBtn frameMakeBtn;
    private SeatDataManager seatDataManager;
    private static Set<SelectBtn> selectedButtons = new HashSet<>();

    /**
     *  생성자 메소드입니다.
     *
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
    public BasicsFrame() {
        setTitle("좌석 선택");
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showNorth();
        showSouth();
        showCenter();

        setVisible(true);
    }

    /**
     * 초기화나 다른 Static 을 대신하기 위해서 사용하는 메소드 입니다.
     *
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
     *
     * @param reset 상태를 확인하는 변수
     *
     */
    public BasicsFrame(String reset) {
        if (Objects.equals(reset, "btn")) {
            this.frameMakeBtn = new MakeBtn();
        }
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
     *   <li>2024-11-30: 좌석 배치 </li>
     *   <li>2024-12-01: 좌석 배치 개선</li>
     * </ul>
     */
    private void showCenter() {
        seatDataManager = new SeatDataManager();

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 6, 13, 42));

        // 좌석 키를 정렬
        List<String> sortedKeys = new ArrayList<>(seatDataManager.getSeatMap().keySet());
        sortedKeys.sort(Comparator.comparingInt(key -> Integer.parseInt(key.replace("좌석 ", ""))));

        // 정렬된 키로 버튼 생성 및 추가
        for (String seatKey : sortedKeys) {
            boolean isAvailable = seatDataManager.getSeatMap().get(seatKey);
            seatBtn = new SelectBtn(seatKey, isAvailable);
            seatBtn.addActionListener(new SelectedBtnAction(seatKey, seatBtn, selectedButtons));
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
        frameMakeBtn = new MakeBtn();

        frameMakeBtn.setText("구매");

        southPanel.add(frameMakeBtn);

        add(southPanel, BorderLayout.SOUTH);
    }



    /**
     * 프레임의 MakeBtn 의 정보를 전달하는 접근자 메소드입니다.
     *
     * <p>
     * {@code @created} 2024-11-16
     * {@code @lastModified}
     * <p>
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-09: 최초 생성</li>
     * </ul>
     */
    public static MakeBtn getBtn() {
        return frameMakeBtn;
    }

    /**
     * Set(selectedButtons) 의 접근자 메소드입니다.
     *
     * <p>
     * {@code @created} 2024-12-01
     * {@code @lastModified} 2024-12-01
     * <p>
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-12-01: 최초 생성</li>
     * </ul>
     */
    public static Set<SelectBtn> getSelectedButtons() {
        return selectedButtons;
    }

    /**
     * Set(selectedButtons) 의 목록 접근자 메소드입니다.
     *
     * <p>
     * {@code @created} 2024-12-09
     * {@code @lastModified} 2024-12-09
     * <p>
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-12-09: 최초 생성</li>
     * </ul>
     */
    public static String getSelectedButtonsList() {
        String list = "";

        for (SelectBtn button : selectedButtons) {
            list += button.getText() + ", ";
//            System.out.println(list.length());
//            System.out.println(list);
        }
        list = list.substring(0, list.length() - 2);

        return list;
    }
}

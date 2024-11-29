package src.ActionListenerPack;

import src.UiPack.SelectBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

/**
 * 좌석 버튼에 대한 액션리스너 클래스입니다.
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
public class SelectedBtnAction implements ActionListener {
    private String seatKey;
    private SelectBtn button;
    private Set<SelectBtn> selectedButtons;

    public SelectedBtnAction(String seatKey, SelectBtn button, Set<SelectBtn> selectedButtons) {
        this.seatKey = seatKey;
        this.button = button;
        this.selectedButtons = selectedButtons;
    }

    /**
     * 배경색을 바꿔주는 AtctionListener 메소드 입니다.
     *
     * {@code @created} 2024-11-11
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-11: 최초 생성</li>
     *   <li>2024-11-16: 배경색을 바꾸는 기능</li>
     * </ul>
     * @param e 눌렀을 때의 상태
     */
    public void actionPerformed(ActionEvent e) {
        if (selectedButtons.contains(button)) {
            selectedButtons.remove(button); // 선택 해제
            button.setBackground(Color.CYAN); // 기본 색상 복원
        } else {
            selectedButtons.add(button); // 새로 선택
            button.setBackground(Color.GREEN); // 선택 상태 표시
        }

    }
}

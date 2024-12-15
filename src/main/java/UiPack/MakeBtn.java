package UiPack;

import ActionListenerPack.MakeFrameBtnAction;

import javax.swing.*;

/**
 * 좌석을 선택하고 구매할 때 누르는 버튼 클래스입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v1.0.0
 * @since v0.0.2
 *
 * {@code @created} 2024-11-11
 * {@code @lastModified} 2024-11-29
 *
 * {@code @changelog}
 * <ul>
 *   <li>2024-11-11: 최초 생성</li>
 *   <li>2024-11-16: 기능 추가</li>
 * </ul>
 */
public class MakeBtn extends JButton {
    public MakeBtn() {
        super();
        addActionListener(new MakeFrameBtnAction());
    }
}

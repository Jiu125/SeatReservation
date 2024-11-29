package UiPack;

import src.ActionListenerPack.MakeFrameBtnAction;

import javax.swing.*;

/**
 * 좌석을 선택하고 구매할 때 누르는 버튼 클래스입니다.
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
 *   <li>2024-11-16: 기능 추가</li>
 * </ul>
 */
public class MakeBtn extends JButton {
    public MakeBtn() {
        super();
        addActionListener(new MakeFrameBtnAction());
    }
}

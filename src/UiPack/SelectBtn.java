package UiPack;

import javax.swing.*;
import java.awt.*;

/**
 * 좌석 선택 버튼의 디자인을 담당하는 버튼 클래스입니다.
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
public class SelectBtn extends JButton {
    public SelectBtn(String text, boolean isAvailable) {
        super(text);
        setBackground(isAvailable ? Color.CYAN : Color.RED);
        setForeground(Color.BLACK);
        setEnabled(isAvailable);
    }
}

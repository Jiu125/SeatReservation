package UiPack;

import javax.swing.*;
import java.awt.*;

/**
 * 좌석 선택 버튼의 디자인을 담당하는 버튼 클래스입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v1.0.2
 * @since v1.0.0
 *
 * {@code @created} 2024-11-11
 * {@code @lastModified} 2024-11-29
 *
 * {@code @changelog}
 * <ul>
 *   <li>2024-11-11: 최초 생성</li>
 *   <li>2024-12-21: 디자인 개선</li>
 * </ul>
 */
public class SelectBtn extends JButton {
    public SelectBtn(String text, boolean isAvailable) {
        super(text);
        setForeground(Color.WHITE);
//        setForeground(Color.BLACK);
        setFocusPainted(false);
        setBorderPainted(false);
        setBackground(isAvailable ? new Color(71, 116, 149) : Color.RED);
        setEnabled(isAvailable);
    }
}

package ActionListenerPack;

import FramePack.PurchaseFrame;
import UiPack.MakeBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static FramePack.BasicsFrame.getSelectedButtons;


/**
 * 버튼을 누르면 결제 창이 생기는 클래스입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v1.0.0
 * @since v0.0.2
 *
 * {@code @created} 2024-11-11
 * {@code @lastModified} 2024-12-02
 *
 * {@code @changelog}
 * <ul>
 *   <li>2024-11-11: 최초 생성</li>
 *   <li>2024-11-16: 결제 프레임 생성하는 코드 작성</li>
 * </ul>
 */
public class MakeFrameBtnAction extends Component implements ActionListener {
    public void actionPerformed(ActionEvent e) {

        MakeBtn button = (MakeBtn) e.getSource();
        if (getSelectedButtons().isEmpty()) {
            JOptionPane.showMessageDialog(null, "좌석을 선택하세요!");
            return;
        }

        if(button.getText().equals("구매")) {
            button.setEnabled(false);
            new PurchaseFrame();
        }
    }
}

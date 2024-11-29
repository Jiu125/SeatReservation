package ActionListenerPack;

import FramePack.PurchaseFrame;
import UiPack.MakeBtn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 버튼을 누르면 결제 창이 생기는 클래스입니다.
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
 *   <li>2024-11-16: 결제 프레임 생성하는 코드 작성</li>
 * </ul>
 */
public class MakeFrameBtnAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {

        MakeBtn button = (MakeBtn) e.getSource();

        if(button.getText().equals("구매")) {
            button.setEnabled(false);
            new PurchaseFrame();
        }
    }
}

package ActionListenerPack;

import SeatData.SeatDataManager;
import UiPack.BuyBtn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static FramePack.BasicsFrame.getSelectedButtons;

/**
 * 결제와 취소 버튼의 기능 클래스입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v1.0.0
 * @since v0.0.2
 *
 * {@code @created} 2024-11-17
 * {@code @lastModified} 2024-12-02
 *
 * {@code @changelog}
 * <ul>
 *   <li>2024-11-17: 최초 생성</li>
 *   <li>2024-12-02: 결제 여부 확인 기능 추가</li>
 * </ul>
 */
public class BuyTicketAction implements ActionListener {
    private final BuyBtn buyBtn;
    private final Frame targetFrame;

    /**
     * 결제와 취소 버튼의 기능 클래스 생성자 메소드입니다.
     *
     * {@code @created} 2024-11-18
     * {@code @lastModified} 2024-11-29
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-18: 최초 생성</li>
     * </ul>
     *
     * @param buyBtn 구매 버튼 인스턴스입니다. 해당 버튼은 구매 기능을 수행합니다.
     * @param frame  구매 버튼이 속한 대상 프레임입니다. 이 프레임은 버튼 동작의 영향을 받습니다.
     */
    public BuyTicketAction(BuyBtn buyBtn,Frame frame) {
        this.buyBtn = buyBtn;
        this.targetFrame = frame;
    }

    /**
     * 취소하였을 때와 결제하였을 때 발생하는 이벤트 메소드입니다.
     *
     * {@code @created} 2024-11-18
     * {@code @lastModified} 2024-11-29
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-18: 최초 생성</li>
     *   <li>2024-12-02: 결제 여부 확인 기능 추가</li>
     * </ul>
     *
     * @param btn '취소'와 '결제'를 버튼의 텍스트를 구분합니다.
     */
    public void checkBtnText(BuyBtn btn) {
        if (Objects.equals(btn.getText(), "취소")) {
            System.out.println("취소하였습니다.");
        }
        else if (Objects.equals(btn.getText(), "결제")){
            System.out.println("구매하였습니다.");
            SeatDataManager.purchaseSeats(getSelectedButtons());
            getSelectedButtons().clear();
        }
    }

    /**
     * 버튼을 누르면 해당 프레임은 닫치고, buyBtn 의 상태를 활성화로 변경하는 메소드입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v1.0.0
     * @since v0.0.2
     *
     * {@code @created} 2024-11-18
     * {@code @lastModified} 2024-11-29
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-18: 최초 생성</li>
     * </ul>
     *
     * @param e 처리해야 할 이벤트입니다.
     */
    public void actionPerformed(ActionEvent e) {
        checkBtnText(buyBtn);
        if (buyBtn.getOtherButton() != null)
            buyBtn.getOtherButton().setEnabled(true);
        if (targetFrame != null) {
            targetFrame.dispose(); // 프레임 닫기
        }
    }
}

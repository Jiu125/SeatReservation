package src.ActionListenerPack;

import src.UiPack.BuyBtn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * 결제와 취소 버튼의 기능 클래스입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v0.0.2
 * @since
 *
 * {@code @created} 2024-11-17
 * {@code @lastModified}
 *
 * {@code @changelog}
 * <ul>
 *   <li>2024-11-17: 최초 생성</li>
 * </ul>
 */
public class BuyTicketAction implements ActionListener {
    /*
                   -- 예상 기능 --
       1. 구매 패널(PurchaseFrame)에서 버튼을 누르면 기본 패널(BasicsFrame)로 이동
       2. 버튼을 눌렀을 때 초록색 버튼의 갯수를 구함

    */
    private final BuyBtn buyBtn;
    private final Frame targetFrame;

    /**
     * 결제와 취소 버튼의 기능 클래스 생성자 메소드입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-18
     * {@code @lastModified}
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
    /*
        정보를 가져오는지 확인하는 메소드입니다.
        테스트 메소드
     */
    public void checkBtnText(BuyBtn btn) {
        if (Objects.equals(btn.getText(), "취소")) {
            System.out.println("취소하였습니다.");
        }
        else if (Objects.equals(btn.getText(), "결제")){
            System.out.println("구매하였습니다.");
        }

    }

    /**
     * 버튼을 누르면 해당 프레임은 닫치고, buyBtn 의 상태를 활성화로 변경하는 메소드입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-18
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-18: 최초 생성</li>
     * </ul>
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

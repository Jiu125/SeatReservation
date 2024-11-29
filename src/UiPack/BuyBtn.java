package UiPack;

import ActionListenerPack.BuyTicketAction;

import javax.swing.*;

/**
 * 결제와 취소 버튼의 디자인을 담당하는 버튼 클래스입니다.
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
public class BuyBtn extends JButton {
    private MakeBtn otherBtn;

    /**
     * 결제, 취소 버튼의 생성자 메소드 입니다.
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
     *   <li>2024-11-18: BuyTicketAction 클래스 기능 추가</li>
     * </ul>
     * @param frame 해당 프레임을 닫기 위한 매개변수
     */
    public BuyBtn(JFrame frame) {
        super();
        addActionListener(new BuyTicketAction(this, frame));
    }

    /**
     * otherBtn 의 상태 설정자 메소드입니다.
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
     * @param otherBtn 해당 버튼의 상태를 설정하기 위한 매개변수입니다.
     */
    public void setOtherButton(MakeBtn otherBtn) {
        this.otherBtn = otherBtn;
    }

    /**
     * otherBtn 의 상태 접근자 메소드입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v0.0.2
     * @since {@code @created} 2024-11-18
     * {@code @lastModified}
     * <p>
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-18: 최초 생성</li>
     * </ul>
     */
    public MakeBtn getOtherButton() {
        return otherBtn;
    }
}

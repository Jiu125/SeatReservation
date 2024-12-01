package SeatData;

import UiPack.SelectBtn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Timer;

/**
 * 좌석 데이터를 관리하는 클래스 입니다.
 *
 * @author Ji Woo Park (gav705@naver.com)
 * @version v0.0.2
 * @since
 *
 * {@code @created} 2024-11-28
 * {@code @lastModified}
 *
 * {@code @changelog}
 * <ul>
 *   <li>2024-11-28: 최초 생성</li>
 *   <li>2024-12-01: 데이터 관리 기능 추가</li>
 * </ul>
 */
public class SeatDataManager {
    private static final String FILE_PATH = "src/SeatData/Data/seat_data.json";
    private static HashMap<String, Boolean> seatMap = new HashMap<>();
    private static Gson gson = new Gson();

    /**
     * 좌석 데이터를 관리하는 클래스 생성자 입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-29
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-29: 최초 생성</li>
     * </ul>
     */
    public SeatDataManager() {
        loadSeatData();
    }

    /**
     * HashMap 의 접근자 메소드 입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-29
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-29: 최초 생성</li>
     * </ul>
     */
    public HashMap<String, Boolean> getSeatMap() {
        return seatMap;
    }

    /**
     * 좌석 데이터를 불러오는 메소드 입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-29
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-29: 최초 생성</li>
     * </ul>
     */
    private void loadSeatData() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            java.lang.reflect.Type type = new TypeToken<HashMap<String, Boolean>>() {}.getType();
            seatMap = gson.fromJson(reader, type);
            if (seatMap == null) {
                initializeSeatData();
            } else {
                // 좌석을 재설정하는 메소드
                resetUnavailableSeats();;
            }
        } catch (IOException e) {
            System.out.println("err");
        }

    }

    /**
     * gson 파일에 데이터를 추가하는 메소드 입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-30
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-30: 최초 생성</li>
     * </ul>
     */
    public void initializeSeatData() {
        for (int i = 1; i <= 24; i++) {
            seatMap.put("좌석 " + i, true);
        }
        saveSeatData();
    }

    /**
     * gson 파일에 데이터를 초기화하는 메소드 입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-30
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-30: 최초 생성</li>
     * </ul>
     */
    private void resetUnavailableSeats() {
        boolean modified = false;
        for (Map.Entry<String, Boolean> entry : seatMap.entrySet()) {
            if (!entry.getValue()) {
                entry.setValue(true);
                modified = true;
            }
        }
        if (modified) {
            saveSeatData();
        }
    }

    /**
     * gson 파일에 데이터를 저장하는 메소드 입니다.
     *
     * @author Ji Woo Park (gav705@naver.com)
     * @version v0.0.2
     * @since
     *
     * {@code @created} 2024-11-30
     * {@code @lastModified}
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-11-30: 최초 생성</li>
     * </ul>
     */
    public static void saveSeatData() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(seatMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 결제 버튼을 누르면 실행되는 메소드입니다.
     * <br>
     * 본 프로그램은 선택한 좌석은 식사시간 45분 뒤에 선택한 자리가 다시 재활성화 됩니다.
     * <br>
     * 하지만, 프로토타입임으로 3초 뒤에 재활성화 시켰습니다.
     *
     * <p>
     * {@code @created} 2024-12-01
     * {@code @lastModified}
     * <p>
     *
     * {@code @changelog}
     * <ul>
     *   <li>2024-12-01: 최초 생성</li>
     * </ul>
     *
     * @param selectedButtons 선택한 버튼의 정보를 담은 매개변수
     */
    public static void purchaseSeats(Set<SelectBtn> selectedButtons) {
        Set<SelectBtn> buttonsToUpdate = new HashSet<>(selectedButtons);

        for (SelectBtn button : buttonsToUpdate) {
            String seatKey = button.getText();
            seatMap.put(seatKey, false);
            button.setBackground(Color.PINK);
            button.setEnabled(false);
        }

        saveSeatData();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    for (SelectBtn button : buttonsToUpdate) {
                        String seatKey = button.getText();
                        seatMap.put(seatKey, true);
                        button.setBackground(Color.CYAN);
                        button.setEnabled(true);
                    }
                    saveSeatData();
                });
            }
        }, 3000);
    }
}

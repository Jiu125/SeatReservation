package src.SeatData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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
 * </ul>
 */
public class SeatDataManager {
    private static final String FILE_PATH = "seat_data.json";
    private HashMap<String, Boolean> seatMap = new HashMap<>();
    private Gson gson = new Gson();

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
                // 데이터 초기화 메소드 들어가야함.
            } else {
                // 좌석을 재설정하는 메소드
            }
        } catch (IOException e) {
            // 데이터 초기화 메소드 들어가야함.
        }
    }
}

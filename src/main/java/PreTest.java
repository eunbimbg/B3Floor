// 값은 args로 받는다.
// 잘못된 값이 입력되면 Insert right number 를 출력하고 종료한다. (ex) 한글, 값의 범위 이외의 수, 정수 외의 수 등
/**
 * Created by rounting_eunbi on 2017-12-02.
 */
public class PreTest {
    public static void main(String[] args) {

        // unit : 단위 한글명으로 치환한 리스트
        // digitList : 숫자 한글로 치환한 리스트
        String[] unit = {"", "십", "백", "천", "만"};
        String[] digitList = {"", "", "이", "삼", "사", "오", "육", "칠", "팔", "구"};

        StringBuilder sb = new StringBuilder();

        int input;
        int digit = 0;

            try {
                input = Integer.parseInt(args[0]);

                if (!(input > 1 && input < 99999)) {
                    throw new Exception("ERROR");
                }
            }catch (Exception e){
                System.out.println("Insert right number");
                return;
            }

        // digit = 현재 자리수의 숫자
        // Append : 숫자 -> 한글 치환 + 자리수 단위
        // i = 단위를 재기위한 10^4 ~ 10^0 에서의 10의 승수 (4~0)
        for (int i = 4; i >= 0; i--) {
            int num = (int) Math.pow(10, i);

            digit = input / num;
            if(digit!=0) sb.append(digitList[digit] + unit[i]);
            input = input % num;
        }
        // 1의자리의 숫자가 1일 때는 '일' 출력
        if (digit == 1) {
            sb.append("일");
        }
        System.out.println(sb.toString());
    }
}

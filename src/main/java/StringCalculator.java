/**
 * StringCalculator kata from http://osherove.com/tdd-kata-1/
 */
public class StringCalculator {

    public int add(String string) {
        if (string.isEmpty()) {
            return 0;
        }

        String[] strings = string.split(",");
        int sum = 0;

        for (String str : strings) {
            sum += Integer.parseInt(str);
        }

        return sum;
    }

}

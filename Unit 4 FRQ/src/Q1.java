import java.util.ArrayList;

public class Q1 {
    public static void longestStreak(String str) {
        ArrayList<Integer> counters = new ArrayList<Integer>();
        char longest = 0;
        int tempcounter = 1;
        char tempcon = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                tempcounter++;
                tempcon = str.charAt(i);
            } else {
                counters.add(tempcounter);
                for (int h = 1; h < counters.size(); h++) { //bubble sort
                    for (int j = 1; j < counters.size(); j++) {
                        if (counters.get(h) < counters.get(h - 1)) {
                            int temp = counters.get(h);
                            counters.set(h, counters.get(h - 1));
                            counters.set(h - 1, temp);
                        }
                    }
                }
                if (counters.get(counters.size() - 1) == tempcounter) { //if the largest counter in the arraylist is the curent one, set the current character to the longest streak cgaracter
                    longest = tempcon;
                }
                tempcounter = 1;
            }
        }
        System.out.println(longest + " " + counters.get(counters.size() - 1));
    }

    public static void main(String[] args) {
        String str = "CCAAT!";
        longestStreak(str);
    }
}

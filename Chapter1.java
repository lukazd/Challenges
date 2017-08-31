import java.util.HashMap;
import java.util.ArrayList;

public class Chapter1 {
    public static void main(String [] args) {
        // call the pertinent question
        question7();
    }

    public static void question1() {
        System.out.println("The following have uniqueness.");
        System.out.println("Test String: " + question1_execution("Test String"));
        System.out.println("Eh String: " + question1_execution("Eh String"));
        System.out.println("many old: " + question1_execution("many old"));
    }

    public static boolean question1_execution(final String string) {
        final char [] stringChars = string.toCharArray();
        final HashMap<Character, Boolean> map = new HashMap<>();
        for (Character c : stringChars) {
            if (map.containsKey(c)) {
                return false;
            }
            map.put(c, true);
        }
        return true;
    }

    public static void question2() {
        System.out.println("The following have uniqueness.");
        System.out.println("Test String: " + question1_execution("Test String"));
        System.out.println("Eh String: " + question1_execution("Eh String"));
        System.out.println("many old: " + question1_execution("many old"));
    }

    public static boolean question2_execution(final String string1, final String string2) {
        final char [] stringChars1 = string1.toCharArray();
        final char [] stringChars2 = string2.toCharArray();
        final HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : stringChars1) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (Character c : stringChars2) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                map.put(c, -1);
            }
        }

        // TODO: finish this

        return true;
    }

    public static void question3() {
        System.out.println("The following have uniqueness.");
        System.out.println("Test String: " + question1_execution("TEST"));
    }

    public static boolean question3_execution(final char [] string) {
        int lastIndex = 0;
        for (int i = string.length; i > 0; --i) {
           if (string[i] != ' ') {
               lastIndex = i;
               break;
           }
        }

        // TODO: finish
        for (int i = lastIndex; i > 0; --i) {
            if (string[i] == ' ') {

            }
        }

        return true;
    }

    public static void question4() {
        System.out.println("atcocta: " + question4_execution("at cocta"));
        System.out.println("atecota: " + question4_execution("ateco ta"));

    }

    public static boolean question4_execution(final String string) {
        final char [] chars = string.toCharArray();
        final HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ' ') {
                continue;
            }

            if (map.containsKey(chars[i])) {
                map.put(chars[i], !map.get(chars[i]));
            } else {
                map.put(chars[i], false);
            }
        }

        boolean usedOdd = false;
        for (Character c : map.keySet()) {
            if (map.get(c) == false) {
                if (!usedOdd) {
                    usedOdd=true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void question5() {
        question5_execution("test", "tests");
    }

    public static boolean question5_execution(final String a, final String b) {
        if (a.equals(b)) {
            return true;
        }

        if (a.length() - b.length() > 1 || b.length() - a.length() > 1) {
            return false;
        }

        int diffCount = 0;
        // TODO: different functions depending on how lengths differ

        return false;
    }

    public static void question6() {
        System.out.println("aabcccccaaa: " + question6_execution("aabcccccaaa"));
        System.out.println("aabcca: " + question6_execution("aabcca"));
    }

    public static String question6_execution(final String string) {
        final ArrayList<CompressedValue> frequencies = new ArrayList<>();
        char lastChar = '0';

        int frequencyIndex = -1;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != lastChar) {
                frequencyIndex++;
                lastChar = string.charAt(i);
                frequencies.add(new CompressedValue(1, string.charAt(i)));
            } else {
                frequencies.get(frequencyIndex).frequency++;
            }
        }

        final StringBuilder compressedString = new StringBuilder();
        for(CompressedValue cv : frequencies) {
            compressedString.append(cv.character);
            compressedString.append(cv.frequency);
        }

        if (compressedString.length() >= string.length()) {
            return string;
        }

        return compressedString.toString();
    }

    public static class CompressedValue {
        int frequency;
        char character;

        public CompressedValue(int x, char y) {
            frequency = x;
            character = y;
        }
    }

    public static void question7() {
        int [ ] [ ] scores = {   { 20, 18, 22, 20 },
                                 { 18, 20, 18, 21 },
                                 { 16, 18, 16, 20 },
                                 { 25, 24, 22, 24 }
                             };

        question7_execution(scores, 4);
    }

    public static void question7_execution(final int [][] matrix, final int n) {

        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - first;

            for (int offset = 0; offset < n - 1; offset++) {
                int temp = matrix[first][first + offset];

                matrix[first][first + offset] = matrix[last - offset][first];
                matrix[last - offset][offset] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[first + offset][last];
                matrix[first + offset][last] = temp;
            }
       }
    }

    public static void question8() {

    }

    public static void question8_execution(final int [][] matrix, final int m, final int n) {
        boolean [][] checkedPoints = new boolean[2][];
        checkedPoints[0] = new boolean[m];
        checkedPoints[1] = new boolean[n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    checkedPoints[0][i] = true;
                    checkedPoints[1][j] = true;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            if (checkedPoints[0][i] == true) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; ++j) {
            if (checkedPoints[1][j] == true) {
                for (int i = 0; i < n; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void question9() {

    }

    public static boolean question9_execution(final String a, final String b) {
        if (a.length() != b.length()) {
            return false;
        }

        final StringBuilder builder = new StringBuilder(a);
        builder.append(a);

        if (/*b.isSubstring(a)*/ true) {
            return true;
        } else {
            return false;
        }
    }
}

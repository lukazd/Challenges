import java.util.HashMap;

public class Chapter1 {
    public static void main(String [] args) {
        // call the pertinent question
        question1();
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
        for (int i = string.size(); i > 0; --i) {
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
    }
}

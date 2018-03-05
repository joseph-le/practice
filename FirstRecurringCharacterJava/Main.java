import java.util.HashMap;

public class Main {

	public static String check(String stringToCheck) {
		if (stringToCheck == null || stringToCheck.length() < 2) {
			return null;
		}
		HashMap<String, Integer> charactersSeen = new HashMap<String, Integer>();
		for (int i = 0; i < stringToCheck.length(); i++) {
			String currentChar = "" + stringToCheck.charAt(i);
			if (charactersSeen.containsKey(currentChar)) {
				return currentChar;
			} else {
				charactersSeen.put(currentChar, 1);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		test(null, null);
		test(null, "");
		test(null, "a");
		test("b", "abcb");
		test("a", "abcab");
		test("*", "abc*pls*");
		test("a", "aa");
	}

	public static void test(String expected, String stringToCheck) {
		boolean result = verify(expected, check(stringToCheck));
		if (result) {
			System.out.println("passed!");
		} else {
			System.out.printf("expected \"%s\" from \"%s\"\n", expected, stringToCheck);
		}
	}

	public static boolean verify(String expected, String actual) {
		if (expected == null && actual == null) {
			return true;
		} else if (expected == null || actual == null) {
			return false;
		}
		return expected.equals(actual);
	}
}
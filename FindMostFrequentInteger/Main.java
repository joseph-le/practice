import java.util.HashMap;
import java.util.HashSet;

public class Main {

	public static HashSet<Integer> findMostFrequentInteger(int[] integerList) {
		HashSet<Integer> resultSet = new HashSet<Integer>();
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		int maxCount = 0;
		for (int i = 0; i < integerList.length; i++) {
			if (!counts.containsKey(integerList[i])) {
				counts.put(integerList[i], 0);
			}
			counts.put(integerList[i], counts.get(integerList[i]) + 1);
			if (counts.get(integerList[i]) == maxCount) {
				resultSet.add(integerList[i]);
			} else if (counts.get(integerList[i]) > maxCount) {
				maxCount = counts.get(integerList[i]);
				resultSet.clear();
				resultSet.add(integerList[i]);
			}
		}
		return resultSet;
	}

	public static void main(String[] args) {
		int[] expected;
		int[] testCase;

		expected = new int[0];
		testCase = new int[0];
		test(expected, testCase);

		expected = new int[]{1};
		testCase = new int[]{1};
		test(expected, testCase);

		expected = new int[]{1};
		testCase = new int[]{1, 1, 2, 3};
		test(expected, testCase);

		expected = new int[]{2};
		testCase = new int[]{1, 1, 2, 3, 2, 2};
		test(expected, testCase);

		expected = new int[]{1, 2};
		testCase = new int[]{1, 1, 2, 2, 3};
		test(expected, testCase);
	}

	public static void test(int[] expected, int[] testCase) {
		boolean pass = verify(expected, findMostFrequentInteger(testCase));
		if (pass) {
			System.out.println("Passed!");
		} else {
			System.out.println("expected " + printIntArray(expected) + " from " + printIntArray(testCase));
		}
	}

	private static String printIntArray(int[] thingToPrint) {
		String blah = "[";
		for (int i = 0; i < thingToPrint.length; i++) {
			blah += i;
			if (i != thingToPrint.length - 1) {
				blah += ", ";
			}
		}
		blah += "]";
		return blah;
	}

	public static boolean verify(int[] expected, HashSet<Integer> actual) {
		HashSet<Integer> expectedHS = new HashSet<Integer>(expected.length);
		for (int i = 0; i < expected.length; i++) {
			expectedHS.add(expected[i]);
		}
		return expectedHS.containsAll(actual) && actual.containsAll(expectedHS);
	}
}
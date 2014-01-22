package com.tactfactory.testpremier;

/**
 * Java engine (very slow) Implementation
 */
public class EngineJava {

	public String calculate(int qt) {
		//return calBuilder(qt);
		return calOptim(qt);
	}
	
	// For best memory usage
	private String calBuilder(int qt) {
		StringBuilder builder = new StringBuilder(10000);
		int i = 3, count, c;
		int value = qt;

		if (value >= 1) {
			builder.append("2, ");
		}

		for (count = 2; count <= value;) {
			for (c = 2; c <= i - 1; c++) {
				if (i % c == 0)
					break;
			}

			if (c == i) {
				builder.append( String.format("%d, ", i ) );
				count++;
			}
			i++;
		}
		return builder.toString();
	}
	
	// For best memory usage
	private String calOptim(int qt) {
		String result = "";
		int i = 3, count, c;
		int value = qt;

		if (value >= 1) {
			result = "2, ";
		}

		for (count = 2; count <= value;) {
			for (c = 2; c <= i - 1; c++) {
				if (i % c == 0)
					break;
			}

			if (c == i) {
				result = result + String.valueOf(i) + ", ";
				count++;
			}
			i++;
		}
		return result;
	}

}

package org.eclipse.vjet.vsf.dapunit;

/**
 * Assert utility functions 
 */
public class AssertUtils {
	
	/**
	 * Asserts that two int values are equal. If they are not, an
     * {@link AssertionError} is thrown.
	 * 
	 * @param expected
	 * @param actual
	 */
	static void assertEquals (int expected, int actual) {
		assertEquals(null, expected, actual);
	}

	/**
	 * Asserts that two int values are equal. If they are not, an
     * {@link AssertionError} is thrown.
	 * 
	 * @param message
	 * @param expected
	 * @param actual
	 */
	static void assertEquals (String message, int expected, int actual) {
		if (expected != actual) {
	        String formatted = "";
	        if (message != null && !message.equals("")) {
	            formatted = message + " ";
	        }
	        formatted = formatted + "expected:<" + expected + "> but was:<" + actual + ">";
	        throw new AssertionError(message);
		}
	}
	
	 /**
     * Asserts that an object isn't null. If it is an {@link AssertionError} is
     * thrown with the given message.
     *
     * @param message
     * @param object
     */
    static public void assertNotNull(String message, Object object) {
        if (object == null) {
            if (message == null) {
                throw new AssertionError();
            }
            throw new AssertionError(message);
        }
    }
}

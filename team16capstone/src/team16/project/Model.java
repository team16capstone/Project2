package team16.project;

import java.math.BigInteger;

public class Model {

	private static final String INITIAL_VALUE = "0";
	private BigInteger m_total; // The total current value state.

	Model() {
		reset();
	}

	public String getValue() {
		return m_total.toString();
	}

	public void reset() {
		m_total = new BigInteger(INITIAL_VALUE);

	}

	public void doSomething(String userInput) {
		// TODO Auto-generated method stub
		
	}
}

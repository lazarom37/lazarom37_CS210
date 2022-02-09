// CS210 Assignment #8 "Rational Number"
// Marcus Lazaro
// This project is meant to be practice for using classes as well as constructors and accessors
// through creating a class dedicated in handling rational numbers, this program was made to handle
// the four basic operations of math with rational numbers utilizing constructors and accessors.

public class RationalNumber {

	private int mainNumerator;
	private int mainDenominator;

	//***TWO CONSTRUCTORS***/
	public RationalNumber(int numerator, int denominator) {	//Constructs new rational number, assuming that denominator will never be zero
		mainNumerator = numerator;
		mainDenominator = denominator;
	}

	public RationalNumber() { 		//Constructs new rational number to represent 0/1
		mainNumerator = 0;
		mainDenominator = 1;
	}
	//***TWO ACCESSORS***/
	 public int getDenominator() {		//Returns denominator
		return mainDenominator;
	 }

	public int getNumerator() {		//Returns numerator
		return mainNumerator;
	}

	public String toString() {		//Returns rational number, corrects itself in case num/denom do not create actual rational numbers
		String rationalNumber;
		if (mainDenominator == 1){
			rationalNumber = "" + mainNumerator;
		} else if (mainDenominator == 0){
			rationalNumber = "INVALID. Cannot divide by zero";
		} else if (mainNumerator == 0){
			rationalNumber = "0";
		} else {
			rationalNumber = mainNumerator + "/" + mainDenominator;
		}
		return rationalNumber;
	}
	
	public RationalNumber add(RationalNumber other) {		//Basic addition for two rational numbers
		int newNumerator = 0;
		int newDenominator = 0;

		if (mainDenominator != other.getDenominator()){
			newNumerator = mainNumerator + other.getNumerator();
			newDenominator = mainDenominator * other.getDenominator();
		} else {
			newNumerator = mainNumerator + other.getNumerator();
			newDenominator = mainDenominator;
		}
		RationalNumber result = new RationalNumber(newNumerator, newDenominator);
		return result;
	}

	public RationalNumber subtract(RationalNumber other) {		//Basic subtraction for two rational numbers
		int newNumerator = 0;
		int newDenominator = 0;

		if (mainDenominator != other.getDenominator()){
			newNumerator = ((other.getDenominator() * mainNumerator) - mainDenominator * other.getNumerator());
			newDenominator = mainDenominator * other.getDenominator();
		} else {
			newNumerator = mainNumerator - other.getNumerator();
			newDenominator = mainDenominator;
		}
		RationalNumber result = new RationalNumber(newNumerator, newDenominator);
		return result;
	}

	public RationalNumber multiply(RationalNumber other) {		//Basic multiplication for two rational numbers
		int newNumerator = mainNumerator * other.getNumerator();
		int newDenominator = mainDenominator * other.getDenominator();
		RationalNumber result = new RationalNumber(newNumerator, newDenominator);
		return result;
	}

	public RationalNumber divide(RationalNumber other) {		//Basic division for two rational numbers
		int newNumerator = mainNumerator * other.getDenominator();
		int newDenominator = mainDenominator * other.getNumerator();
		RationalNumber result = new RationalNumber(newNumerator, newDenominator);
		return result;
	}	
}

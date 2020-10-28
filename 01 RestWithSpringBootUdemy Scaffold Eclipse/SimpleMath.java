package br.com.erudio.model;

public class SimpleMath {

	public Double sum(Double numberOne, Double numberTwo) {
		Double sum = numberOne + numberTwo;
		return sum;
	}
	
	public Double minus(Double numberOne, Double numberTwo) {
		Double minus = numberOne - numberTwo;
		return minus;
	}
	
	public Double multiply(Double numberOne, Double numberTwo) {
		Double multiply = numberOne * numberTwo;
		return multiply;
	}
	
	public Double divide(Double numberOne, Double numberTwo) {
		Double divide = numberOne / numberTwo;
		return divide;
	}
	
	public Double media(Double numberOne, Double numberTwo) {
		Double media = (numberOne + numberTwo) / 2;
		return media;
	}
	
	public Double sqrt(Double number) {
		Double sqrt = Math.sqrt(number);
		return sqrt;
	}
	
}

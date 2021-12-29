package com.geektrust.tame_of_thrones;

public class AlphabetNode {
	private char alphabet;
	private AlphabetNode nextAlphabet;
	public AlphabetNode(char alphabet, AlphabetNode nextAlphabet) {
		super();
		this.alphabet = alphabet;
		this.nextAlphabet = nextAlphabet;
	}
	public char getAlphabet() {
		return alphabet;
	}
	public void setAlphabet(char alphabet) {
		this.alphabet = alphabet;
	}
	public AlphabetNode getNextAlphabet() {
		return nextAlphabet;
	}
	public void setNextAlphabet(AlphabetNode nextAlphabet) {
		this.nextAlphabet = nextAlphabet;
	}
}

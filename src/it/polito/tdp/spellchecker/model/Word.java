package it.polito.tdp.spellchecker.model;

public class Word {

	private String word;
	private boolean correct;
	public Word(String nextToken) {
		this.word = nextToken;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	@Override
	public String toString() {
		return word+"\n";
	}
		
}

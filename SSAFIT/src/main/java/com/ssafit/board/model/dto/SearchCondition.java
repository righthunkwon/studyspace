package com.ssafit.board.model.dto;

public class SearchCondition {
	private String key;
	private String word;

	public SearchCondition() {
		this.key = "none";
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
package com.petmarkets2020.model;

public class CoinsPackages {
	private int coinId;
	private int value;

	public CoinsPackages() {
	}

	public CoinsPackages(int coinId, int value) {
		this.coinId = coinId;
		this.value = value;
	}

	public int getCoinId() {
		return coinId;
	}

	public void setCoinId(int coinId) {
		this.coinId = coinId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CoinsPackages [coinId=" + coinId + ", value=" + value + "]";
	}

}

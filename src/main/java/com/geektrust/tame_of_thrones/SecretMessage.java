package com.geektrust.tame_of_thrones;

public class SecretMessage {
	private String kingdom;
	private String message;
	
	public SecretMessage(String kingdom, String secretMessage) {
		super();
		this.kingdom = kingdom;
		this.message = secretMessage;
	}

	public String getKingdom() {
		return kingdom;
	}

	public void setKingdom(String kingdom) {
		this.kingdom = kingdom;
	}

	public String getSecretMessage() {
		return message;
	}

	public void setSecretMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SecretMessage [kingdom=" + kingdom + ", message=" + message + "]";
	}
	
}

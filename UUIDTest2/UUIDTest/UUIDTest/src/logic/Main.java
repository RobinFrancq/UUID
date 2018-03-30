package logic;

import db.UUIDDAO;

public class Main {
	public static void main(String[] args) {
		
		UUIDDAO dao = new UUIDDAO();
		
		System.out.println(myUUID.createUUID("01"));
		
		dao.insert(myUUID.createUUID("01"));
		
	}
}

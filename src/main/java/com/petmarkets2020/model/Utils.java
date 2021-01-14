package com.petmarkets2020.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Utils {
	static FirebaseDatabase firebaseDatabase;
	static DatabaseReference databaseReference;

	public static String getCurrentDate() {
		return new SimpleDateFormat("dd/MM/yyyy", Locale.KOREA).format(new Date());
	}

	public static DatabaseReference connectFireBase(String name) {
		firebaseDatabase = FirebaseDatabase.getInstance();
		databaseReference = firebaseDatabase.getReference(name);
		return databaseReference;

	}
}

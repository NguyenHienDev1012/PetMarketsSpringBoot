package com.petmarkets2020.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.UsersModel;

@Service
public class LoginService {
	FirebaseDatabase firebaseDatabase;
	DatabaseReference databaseReference;
	UsersModel usersModel;

	public UsersModel checkLogin(String uid, String password) {
		firebaseDatabase = FirebaseDatabase.getInstance();
		databaseReference = firebaseDatabase.getReference("Users");

		if (databaseReference.child(uid) != null) {
			databaseReference.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {

				@Override
				public void onDataChange(DataSnapshot snapshot) {

					usersModel = snapshot.getValue(UsersModel.class);
					if (!(BCrypt.checkpw(usersModel.getPwd(), password))) {
						usersModel = null;
					}

				}

				@Override
				public void onCancelled(DatabaseError error) {

				}

			});

		}
		return usersModel;
	}
}

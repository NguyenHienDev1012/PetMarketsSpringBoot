package com.petmarkets2020.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.UsersModel;
import com.petmarkets2020.model.Utils;

@Service
public class LoginService {
	public static final String COL_NAME = "Users";
	private UsersModel usersModel;

	public interface ILogin {
		public void responseData(UsersModel usersModel);
	}

	public UsersModel checkLogin(String uid, String password, ILogin iLogin) {

		if (Utils.connectFireBase(COL_NAME).child(uid) != null) {
			Utils.connectFireBase(COL_NAME).child(uid).addListenerForSingleValueEvent(new ValueEventListener() {

				@Override
				public void onDataChange(DataSnapshot snapshot) {

					usersModel = snapshot.getValue(UsersModel.class);
					iLogin.responseData(usersModel);
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

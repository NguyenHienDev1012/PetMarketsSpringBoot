package com.petmarkets2020.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.UsersModel;
import com.petmarkets2020.model.Utils;

@Service
public class UsersModelServices {
	public static final String COL_NAME = "Users";
	private List<UsersModel> listUsers;

	public interface IUsers {
		public void responseData(List<UsersModel> list);
	}

	public List<UsersModel> getListUser(IUsers iUsers) {
		listUsers = new ArrayList<UsersModel>();
		Utils.connectFireBase(COL_NAME).addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot data : snapshot.getChildren()) {
					UsersModel user = data.getValue(UsersModel.class);
					listUsers.add(user);
					iUsers.responseData(listUsers);

				}
			}
			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
		return listUsers;
	}
}

package com.petmarkets2020.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.UsersModel;

@Service
public class UsersModelServices {
	public static final String COL_NAME = "Users";
	List<UsersModel> list;
	final CountDownLatch latch = new CountDownLatch(1);

	public List<UsersModel> getListUser() throws InterruptedException {
		list = new ArrayList<UsersModel>();
		FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
		DatabaseReference databaseReference = firebaseDatabase.getReference(COL_NAME);
		databaseReference.addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot data : snapshot.getChildren()) {
					System.out.println(data.getKey());
					UsersModel user = data.getValue(UsersModel.class);
					list.add(user);
				}
			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
		latch.await(700, TimeUnit.MILLISECONDS);
		return list;
	}
}

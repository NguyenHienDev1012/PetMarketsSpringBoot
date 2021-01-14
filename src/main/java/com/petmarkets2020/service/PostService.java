package com.petmarkets2020.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.PostModel;
import com.petmarkets2020.model.Utils;

@Service
public class PostService {
	public static final String COL_NAME = "Post";
	List<PostModel> list;

	public List<PostModel> getAllPost() {
		list = new ArrayList<PostModel>();
		list.clear();
		Utils.connectFireBase(COL_NAME).addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot posts : snapshot.getChildren()) {
					PostModel p = posts.getValue(PostModel.class);
					System.out.println(p.toString());
					list.add(p);
				}

			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
		return list;
	}

	public void refusePost(String idPost) {
		DatabaseReference databaseReference = Utils.connectFireBase(COL_NAME);
		databaseReference.child(idPost).child("hidden").setValueAsync(false);
	}

	public void approvedPost(String idPost) {
		DatabaseReference databaseReference = Utils.connectFireBase(COL_NAME);
		databaseReference.child(idPost).child("hidden").setValueAsync(true);

	}
}

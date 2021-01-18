package com.petmarkets2020.service;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.Comments;
import com.petmarkets2020.model.Utils;

@Service
public class CommentServices {
	FirebaseDatabase firebaseDatabase;
	DatabaseReference databaseReference;
	Comments comment = null;
	final CountDownLatch latch = new CountDownLatch(1);

	public CommentServices() {
	}

	public Comments getComments(String cmtId) throws InterruptedException, ExecutionException {
		Utils.connectFireBase("Comments").child(cmtId).addListenerForSingleValueEvent(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {

				comment = snapshot.getValue(Comments.class);
				System.out.println(comment);
			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});

		return comment;
	}

	public ArrayList<Comments> getlistComments() throws InterruptedException {

		ArrayList<Comments> listComments = new ArrayList<Comments>();
		Utils.connectFireBase("Comments").addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot dss : snapshot.getChildren()) {
					comment = dss.getValue(Comments.class);
					listComments.add(comment);
					System.out.println(dss.getValue());
				}

				System.out.println(comment.toString());
			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
		latch.await(700, TimeUnit.MILLISECONDS);
		return listComments;
	}

}

package com.petmarkets2020.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.PostModel;
import com.petmarkets2020.model.Utils;

@Service
public class PostService {
	public static final String COL_NAME = "Post";
	public static final String COL_NAME_NOTI = "Notifications";
	private String col_status = "status";
	private List<PostModel> listPosts;
	private String col_timeStart = "timeStart";
	final CountDownLatch latch = new CountDownLatch(1);

	public List<PostModel> getAllPost() throws InterruptedException {

		listPosts = new ArrayList<PostModel>();
		Utils.connectFireBase(COL_NAME).addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot posts : snapshot.getChildren()) {
					PostModel p = posts.getValue(PostModel.class);
					listPosts.add(p);
				}

			}

			@Override
			public void onCancelled(DatabaseError error) {
			}
		});
		latch.await(700, TimeUnit.MILLISECONDS);
		return listPosts;
	}

	public static String getCurrentDate(boolean isTimeMil) {
		if (isTimeMil)
			return new SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.KOREA).format(new Date());
		return new SimpleDateFormat("dd/MM/yyyy", Locale.KOREA).format(new Date());
	}

	public void setNotification(String col_poster, String content, String postId, String time) {
		String keyNotiification = String.valueOf(System.currentTimeMillis());
		Utils.connectFireBase(COL_NAME_NOTI).child(col_poster).child(keyNotiification).child("content")
				.setValueAsync(content);
		Utils.connectFireBase(COL_NAME_NOTI).child(col_poster).child(keyNotiification).child("isChecked")
				.setValueAsync(false);
		Utils.connectFireBase(COL_NAME_NOTI).child(col_poster).child(keyNotiification).child("postId")
				.setValueAsync(postId);
		Utils.connectFireBase(COL_NAME_NOTI).child(col_poster).child(keyNotiification).child("time")
				.setValueAsync(time);
		Utils.connectFireBase(COL_NAME_NOTI).child(col_poster).child(keyNotiification).child("notiId")
				.setValueAsync(System.currentTimeMillis());
	}

	String postTitle;
	String poster;
	String notiId;

	public void refusePost(String idPost) {
		DatabaseReference databaseReference = Utils.connectFireBase(COL_NAME);
		databaseReference.child(idPost).child(col_status).setValueAsync(2);
		String currentdate = getCurrentDate(true);
		databaseReference.child(idPost).addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				postTitle = snapshot.child("title").getValue().toString();
				poster = snapshot.child("poster").getValue().toString();
				String statusApprove = "bài viết " + postTitle + " đã bị từ chối";
				setNotification(poster, statusApprove, idPost, currentdate);
			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});

	}

	public void approvedPost(String idPost) {
		DatabaseReference databaseReference = Utils.connectFireBase(COL_NAME);
		databaseReference.child(idPost).child(col_status).setValueAsync(1);

		String currentdate = getCurrentDate(true);
		databaseReference.child(idPost).child(col_timeStart).setValueAsync(currentdate);
		databaseReference.child(idPost).addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				postTitle = snapshot.child("title").getValue().toString();
				poster = snapshot.child("poster").getValue().toString();
				String statusApprove = "bài viết " + postTitle + " đã được duyệt";
				setNotification(poster, statusApprove, idPost, currentdate);
			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});

	}

}

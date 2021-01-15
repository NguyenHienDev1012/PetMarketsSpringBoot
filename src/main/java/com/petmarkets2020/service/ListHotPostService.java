package com.petmarkets2020.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.HotPost;
import com.petmarkets2020.model.Utils;

@Service
public class ListHotPostService {
	private HotPost hotPost = new HotPost();

	public interface IHostPost {
		void responseData(ArrayList<HotPost> lisHotPosts);
	}

	public ArrayList<HotPost> getListHotPost(IHostPost iHotPost) {
		ArrayList<HotPost> lisHotPosts = new ArrayList<HotPost>();
		Utils.connectFireBase("HotPost").addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot dss : snapshot.getChildren()) {
					hotPost = dss.getValue(HotPost.class);
					lisHotPosts.add(hotPost);
					iHotPost.responseData(lisHotPosts);

				}

			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
		return lisHotPosts;

	}
}

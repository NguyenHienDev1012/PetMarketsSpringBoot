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

	public ArrayList<HotPost> getListHotPost() {
		ArrayList<HotPost> lisHotPosts = new ArrayList<HotPost>();
		Utils.connectFireBase("HotPost").addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot dss : snapshot.getChildren()) {
					hotPost = dss.getValue(HotPost.class);
					lisHotPosts.add(hotPost);
					System.out.println(dss.getValue());
				}

				System.out.println(hotPost.toString());
			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
		return lisHotPosts;

	}
}

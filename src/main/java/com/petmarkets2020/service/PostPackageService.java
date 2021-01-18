package com.petmarkets2020.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.PostPackage;
import com.petmarkets2020.model.Utils;

@Service
public class PostPackageService {
	public static final String COL_NAME = "PostPackage";
	private List<PostPackage> list;
	final CountDownLatch latch = new CountDownLatch(1);

	public List<PostPackage> getAllPostPackage() throws InterruptedException{
		list = new ArrayList<PostPackage>();
		Utils.connectFireBase(COL_NAME).addValueEventListener(new ValueEventListener() {
			
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot posts : snapshot.getChildren()) {
					PostPackage p = posts.getValue(PostPackage.class);
					list.add(p);
				}
				
			}
			
			@Override
			public void onCancelled(DatabaseError error) {
				// TODO Auto-generated method stub
				
			}
		});
		latch.await(700, TimeUnit.MILLISECONDS);
		return list;
	}

}

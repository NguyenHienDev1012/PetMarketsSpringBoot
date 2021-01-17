package com.petmarkets2020.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.PetType;
import com.petmarkets2020.model.Utils;

@Service
public class PetTypeServices {
	public static final String COL_NAME = "PetType";
	HashMap<String, PetType> hm = new HashMap<String, PetType>();
	private HashMap<String, PetType> childMap;

	public HashMap<String, HashMap<String, PetType>> getAll() {
		HashMap<String, HashMap<String, PetType>> thm = new HashMap<String, HashMap<String, PetType>>();
		Utils.connectFireBase(COL_NAME).addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {

				for (DataSnapshot data : snapshot.getChildren()) {
					childMap = new HashMap<>();
					data.getChildren().forEach(dataSnap -> {
						childMap.put(dataSnap.getKey(), dataSnap.getValue(PetType.class));
					});
					thm.put(data.getKey(), childMap);
				}
			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
		return thm;
	}

}

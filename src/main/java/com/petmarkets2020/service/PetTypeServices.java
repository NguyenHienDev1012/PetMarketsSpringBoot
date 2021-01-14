package com.petmarkets2020.service;

import java.util.ArrayList;
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

	public HashMap<String, HashMap<String, PetType>> getAll() {

		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, PetType> hm = new HashMap<String, PetType>();
		
		HashMap<String, HashMap<String, PetType>>  thm = new HashMap<String, HashMap<String, PetType>>();
	
		Utils.connectFireBase(COL_NAME).addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot data : snapshot.getChildren()) {
					System.out.println(data.getKey());
					list.add(data.getKey());
				}
				for (int i = 0; i < list.size(); i++) {
					
					for(DataSnapshot s : snapshot.child(list.get(i)).getChildren()) {
						if(!hm.isEmpty()) {
							hm.clear();
						}
						PetType pet = s.getValue(PetType.class);
						hm.put(s.getKey(), pet);
						//System.out.println(pet.getName()+"LLL");
					}
					thm.put(list.get(i), hm);
					System.out.println(thm);
				}
			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
		//System.out.println(list.size() + "k");
		return thm;
	}

//	public HashMap<String, PetType> getPetTypeDetails(String type) {
//
//		Utils.connectFireBase(COL_NAME).child("cat").addValueEventListener(new ValueEventListener() {
//
//			@Override
//			public void onDataChange(DataSnapshot snapshot) {
//
//				PetType pet = snapshot.getValue(PetType.class);
//			//	hm.put(snapshot.getKey(), pet);
//				System.out.println("HHH");
//				System.out.println(pet.getName()+"LLL");
//			}
//
//			@Override
//			public void onCancelled(DatabaseError error) {
//
//			}
//		});
//
//		return hm;

}

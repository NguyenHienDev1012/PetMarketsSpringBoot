package com.petmarkets2020.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.CoinsPackages;
import com.petmarkets2020.model.Utils;

@Service
public class CoinPackagesServices {

	private CoinsPackages coinsPackages = new CoinsPackages();
	private boolean isdeleted = false;

	public ArrayList<CoinsPackages> getListCoinPackages() {
		ArrayList<CoinsPackages> listCoinsPackages = new ArrayList<CoinsPackages>();
		Utils.connectFireBase("CoinsPackage").addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot dss : snapshot.getChildren()) {
					coinsPackages = dss.getValue(CoinsPackages.class);
					listCoinsPackages.add(coinsPackages);
					System.out.println(dss.getValue());
				}

			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
		return listCoinsPackages;

	}

	public boolean deleteCoinPackage(String id) {
		DatabaseReference databaseReference = Utils.connectFireBase("CoinsPackage");
		databaseReference.child(id).addListenerForSingleValueEvent(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				CoinsPackages coinsPackages = snapshot.getValue(CoinsPackages.class);
				if (coinsPackages.getCoinId() == Integer.parseInt(id)) {
					databaseReference.child(id).removeValueAsync();
					isdeleted = false;
					System.out.println("Vao day 1");
				}

				else {
					isdeleted = true;
					System.out.println("Vao day o");
				}

			}

			@Override
			public void onCancelled(DatabaseError error) {

			}
		});

		return isdeleted;

	}

	public void addCoinPackages(CoinsPackages coinsPackages) {
		DatabaseReference databaseReference = Utils.connectFireBase("CoinsPackage");
		databaseReference.child(String.valueOf(coinsPackages.getCoinId())).child("coinId")
				.setValueAsync(coinsPackages.getCoinId());
		databaseReference.child(String.valueOf(coinsPackages.getCoinId())).child("value")
				.setValueAsync(coinsPackages.getValue());
	}
	


}

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

	private CoinsPackages coinsPackages;
	private boolean isdeleted = false;
	public static final String COL_NAME = "CoinsPackage";


	public ArrayList<CoinsPackages> getListCoinPackages() {
		ArrayList<CoinsPackages> listCoinsPackages = new ArrayList<CoinsPackages>();
		Utils.connectFireBase(COL_NAME).addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot coins : snapshot.getChildren()) {
					if ((CoinsPackages) coins.getValue(CoinsPackages.class) != null) {
						coinsPackages = coins.getValue(CoinsPackages.class);
						listCoinsPackages.add(coinsPackages);
					}
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

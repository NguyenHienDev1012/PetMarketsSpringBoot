package com.petmarkets2020.service;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.petmarkets2020.model.TransactionHistory;
import com.petmarkets2020.model.Utils;

@Service
public class TransactionHistoryService {
	public static final String COL_NAME = "TransactionHistory";
	public HashMap<String, TransactionHistory> hmTransaction;
	public HashMap<String, HashMap<String, TransactionHistory>> transactions = new HashMap<String, HashMap<String, TransactionHistory>>();
	final CountDownLatch latch = new CountDownLatch(1);
	public HashMap<String, HashMap<String, TransactionHistory>> getAllTransactionHistory() throws InterruptedException {
		Utils.connectFireBase(COL_NAME).addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for (DataSnapshot data : snapshot.getChildren()) {
					hmTransaction = new HashMap<String, TransactionHistory>();
					data.getChildren().forEach(dataSnap -> {
						hmTransaction.put(dataSnap.getKey(), dataSnap.getValue(TransactionHistory.class));
						System.out.println(hmTransaction.toString());
					});
					transactions.put(data.getKey(), hmTransaction);

				}
			}

			@Override
			public void onCancelled(DatabaseError error) {
				// TODO Auto-generated method stub

			}
		});
		latch.await(700, TimeUnit.MILLISECONDS);
		return transactions;

	}
}

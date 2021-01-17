package com.petmarkets2020.service;

import java.util.HashMap;

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

	public interface ITransactionHistory {
		public void responseData(HashMap<String, HashMap<String, TransactionHistory>> transactions);

	}
	
	public void transactionHistory(ITransactionHistory itransaction) {
		Utils.connectFireBase(COL_NAME).addValueEventListener(new ValueEventListener() {
			
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				for(DataSnapshot data: snapshot.getChildren()) {
					hmTransaction = new HashMap<String, TransactionHistory>();
					data.getChildren().forEach(dataSnap -> {
						hmTransaction.put(dataSnap.getKey(), dataSnap.getValue(TransactionHistory.class));
						System.out.println(hmTransaction.toString());
					});
					transactions.put(data.getKey(), hmTransaction);
				}
				itransaction.responseData(transactions);
			}
			
			@Override
			public void onCancelled(DatabaseError error) {
				
			}
		});
	}
}

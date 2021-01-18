package com.petmarkets2020.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class LogoutServices {
	final CountDownLatch latch = new CountDownLatch(1);
	public void logout(HttpSession session) throws InterruptedException {
		latch.await(700, TimeUnit.MILLISECONDS);
		session.removeAttribute("fullname");

	}

}

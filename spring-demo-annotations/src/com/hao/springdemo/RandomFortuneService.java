package com.hao.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {
			"Random lucky 1",
			"Random lucky 2",
			"Random lucky 3"
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String fortune = data[index];
		return fortune;
	}

}

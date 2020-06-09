package com.hao.springdemo;

public class TrackCoach implements Coach{
	
	private FortuneService fortuneService;
	
	
	
	public TrackCoach(FortuneService fortuneService) {
//		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout(){
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it!" + fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartUp() {
		System.out.println("Do My Start Up");
	}
	
	// add an destroy method
	public void doMyCleanUp() {
		System.out.println("Do My Clean Up");
	}
}

package com.hao.springdemo;

public class KendoCoach implements Coach{
	
	private FortuneService fortuneService;
	private String emailAddress;
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("I am here! email address Setter method!");
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("I am here! team Setter method!");
	}

	private String team;
	
	public KendoCoach() {
		System.out.println("I am here! No-arg constructor!");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("I am here! fortune Setter method!");
	}

	@Override
	public String getDailyWorkout() {
		return "Do 500 Suburi!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
}

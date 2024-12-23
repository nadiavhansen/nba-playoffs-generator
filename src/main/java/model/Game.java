package model;

import java.util.Random;

public class Game {
	
	private final Team team1;
	private final Team team2;
	private Team winner;
	private int team1Points;
	private int team2Points;
	
	public Game (Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
		
	}
	
	public void generateResult() {
		Random random = new Random();
		
		this.team1Points = random.nextInt(50)+80;
		this.team2Points = random.nextInt(50)+80;
		
		if(team1Points > team2Points) {
			winner = team1;
		} else if (team2Points > team1Points) {
			winner = team2;
		} else {
			generateResult();
		}
		
	}
	
	public Team getWinner() {
		return winner;
		
	}
	
	@Override
	public String toString() {
		return team1.getName()+" ("+ team1Points +") x ("+ 
									team2Points + ") "+ team2.getName(); 
	}

}

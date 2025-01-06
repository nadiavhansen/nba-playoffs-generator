package model;

public class Game {
	
	private final Team team1;
	private final Team team2;
	private int team1Score;
	private int team2Score;
	
	public Game (Team team1, Team team2, int team1Score, int team2Score) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
		
	}
	
	public Team getWinner() {
        return team1Score > team2Score ? team1 : team2;
    }
	
	@Override
	public String toString() {
		return team1.getName()+" ("+ team1Score +") x ("+ 
									team2Score + ") "+ team2.getName(); 
	}

}

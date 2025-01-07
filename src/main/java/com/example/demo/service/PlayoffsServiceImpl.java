package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import model.Game;
import model.Team;

@Service
public class PlayoffsServiceImpl implements PlayoffsService {
	 
	@Override
	public Team simulateSeries(Team team1, Team team2) {
		
		int winsTeam1 = 0;
		int winsTeam2 = 0;
		
		Random random = new Random();
		System.out.println("Series between " + team1 + " and " + team2 + ":");
		
		while(winsTeam1 < 4 && winsTeam2 < 4) {
			int team1Score = random.nextInt(50)+80;
			int team2Score = random.nextInt(50)+80;
			
			Game game = new Game (team1, team2, team1Score, team2Score);
			System.out.println(game);
			
	        if (team1.getName().equals("Denver Nuggets")) {
	            // Nuggets têm vantagem, ganham 70% das vezes
	            if (random.nextDouble() < 0.7) {
	                winsTeam1++;
	            } else {
	                winsTeam2++;
	            }
	        } else if (team2.getName().equals("Denver Nuggets")) {
	            // Nuggets têm vantagem, ganham 70% das vezes
	            if (random.nextDouble() < 0.7) {
	                winsTeam2++;
	            } else {
	                winsTeam1++;
	            }
	        } else {
	            // Simulação normal para outros times
	            if (team1Score > team2Score) {
	                winsTeam1++;
	            } else {
	                winsTeam2++;
	            }
	        }
		}
		
		Team winner = winsTeam1 == 4 ? team1 : team2;
		System.out.println("Series result: " + team1 + " " + winsTeam1 + 
							" x " + winsTeam2 + " " + team2 + "\nWinner: "+ winner);
		
		return winner;
	}

	@Override
	public Team simulateConferencePlayoffs(List<Team> teams) {
		
		int round = 1;		
		List<Team> qualifiedTeams = new ArrayList<>(teams);
		
		while (qualifiedTeams.size() > 1) {
			
			System.out.println("\nRound " + round + ":");
			List<Team> nextRoundTeams = new ArrayList<>();
			
			for (int i = 0; i < qualifiedTeams.size(); i += 2) {
				Team winner = simulateSeries(qualifiedTeams.get(i), qualifiedTeams.get(i+1));
				nextRoundTeams.add(winner);
			}
			
			qualifiedTeams = nextRoundTeams;
			round++;
			
		}
		
	return qualifiedTeams.get(0);
	}


}

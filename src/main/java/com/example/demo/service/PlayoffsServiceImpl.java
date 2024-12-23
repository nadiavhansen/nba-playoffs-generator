package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Game;
import model.Team;

@Service
public class PlayoffsServiceImpl implements PlayoffsService {
	
	//@Override
	public List<Team> playGame(List<Team> teams){
		List<Team> winners = new ArrayList<>();
		
		for (int i = 0; i < teams.size() ; i += 2 ) {
			Game game = new Game(teams.get(i), teams.get(i+1));
			game.generateResult();
			System.out.println(game);
			winners.add(game.getWinner());
			
		}
		//System.out.println("teams = "+teams);
		return teams.size()>2 ? playGame(winners) : winners;
	}
	
	public Team playFinal(Team westTeam, Team eastTeam) {
		
		Game finalGame = new Game (westTeam, eastTeam);
		finalGame.generateResult();
		System.out.println(finalGame);
		
		return finalGame.getWinner();
	}

}

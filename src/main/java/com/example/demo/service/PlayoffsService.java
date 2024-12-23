package com.example.demo.service;
import java.util.List;

import model.Team;

public interface PlayoffsService {
	
	List<Team> playGame(List<Team> teams);
	Team playFinal(Team westTeam, Team eastTeam);

}

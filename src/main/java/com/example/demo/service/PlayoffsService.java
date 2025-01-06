package com.example.demo.service;
import java.util.List;

import model.Team;

public interface PlayoffsService {
	
	Team simulateSeries(Team team1, Team team2);
	Team simulateConferencePlayoffs(List<Team> teams);

}

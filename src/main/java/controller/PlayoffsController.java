package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.demo.service.PlayoffsService;

import model.Team;

@Controller
public class PlayoffsController {
	
	private final PlayoffsService service;
	
	public PlayoffsController (PlayoffsService service) {
		this.service = service;
		inicializeTeams();
	}

	private List<Team> west = new ArrayList<>();
	private List<Team> east = new ArrayList<>();
	
	private void inicializeTeams() {
		
		west.add(new Team("Denver Nuggets"));
		west.add(new Team("Memphis Grizzlies"));
		west.add(new Team("Sacramento Kings"));
        west.add(new Team("Phoenix Suns"));
        west.add(new Team("Los Angeles Clippers"));
        west.add(new Team("Golden State Warriors"));
        west.add(new Team("Los Angeles Lakers"));
        west.add(new Team("Minnesota Timberwolves"));
        
        east.add(new Team("Milwaukee Bucks"));
        east.add(new Team("Boston Celtics"));
        east.add(new Team("Philadelphia 76ers"));
        east.add(new Team("Cleveland Cavaliers"));
        east.add(new Team("New York Knicks"));
        east.add(new Team("Brooklyn Nets"));
        east.add(new Team("Miami Heat"));
        east.add(new Team("Atlanta Hawks"));
		
	}
	
	public void inicializePlayoffs() {
		System.out.println("==== Playoffs West ====");
		List<Team> westChampion = service.playGame(west);
		
		System.out.println("\n==== Playoffs East ====");
		List<Team> eastChampion = service.playGame(west);
		
		System.out.println("\n==== Final ====");
		Team nbaChampion = service.playFinal(westChampion.get(0), eastChampion.get(0));
		System.out.println("NBA Champion: "+ nbaChampion.getName());
	}
	
	

}

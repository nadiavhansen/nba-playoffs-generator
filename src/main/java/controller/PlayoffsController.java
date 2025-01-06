package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.demo.service.PlayoffsService;

import model.Team;

@Controller
public class PlayoffsController {
	
	private final PlayoffsService playoffsService;
	
	public PlayoffsController (PlayoffsService playoffsService) {
		this.playoffsService = playoffsService;
	}
	
	public void startPlayoffs() {
		List<Team> westConference = Arrays.asList(new Team("Denver Nuggets"),
												  new Team("Memphis Grizzlies"),
												  new Team("Sacramento Kings"),
												  new Team("Phoenix Suns"),
												  new Team("Los Angeles Clippers"),
												  new Team("Golden State Warriors"),
												  new Team("Los Angeles Lakers"),
												  new Team("Minnesota Timberwolves"));
		List<Team> eastConference = Arrays.asList(new Team("Milwaukee Buckss"),
				  								  new Team("Boston Celtics"),
												  new Team("Philadelphia 76ers"),
												  new Team("Cleveland Cavaliers"),
												  new Team("New York Knicks"),
												  new Team("Brooklyn Nets"),
												  new Team("Miami Heat"),
												  new Team("Atlanta Hawks"));
		System.out.println("West Conference Playoffs:");
		Team westChampion = playoffsService.simulateConferencePlayoffs(westConference);
		
		System.out.println("\nEast Conference Playoffs:");
		Team eastChampion = playoffsService.simulateConferencePlayoffs(eastConference);
		
		System.out.println("\nNBA Finals: " + westChampion + " x " + eastChampion);
		Team nbaChampion = playoffsService.simulateSeries(westChampion, eastChampion);
		System.out.println("\nNBA Champion: " + nbaChampion);
	}

}

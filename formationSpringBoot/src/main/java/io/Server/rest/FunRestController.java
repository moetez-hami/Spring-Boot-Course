package io.Server.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	//inject properties for: coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	
	//expose new endpoint for "teaminfo"
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: "+coachName+", Team name: "+teamName;
	}

	//expose "/" that return "hello world"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/train")
	public String train() {
		return "You have train 5k";
	}
}

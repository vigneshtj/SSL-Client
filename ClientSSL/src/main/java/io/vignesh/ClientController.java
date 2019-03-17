package io.vignesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@RequestMapping("/demos")
	public String display() {
		return clientService.getValues();
	}
	
	
}

package org.wecancodeit.food.rescue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodRescueController {

	@RequestMapping("/home")
	public String home() {
		return "index";
	}

}

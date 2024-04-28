package net.codejava.controller;

import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.codejava.model.User;
import net.codejava.repository.UserRepository;
import net.codejava.service.GradeService;
import net.codejava.service.UserDetailsServiceImpl;
import net.codejava.model.Grade;
import net.codejava.model.MyUserDetails;

@Controller
public class WebController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailsServiceImpl udi;
	@Autowired
	private GradeService gs;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(Model page) {
		User user = new User();
		user.setEnabled(true);
		page.addAttribute("User", user);
		return "signup";
	}
	@PostMapping("/signup")
	public String register(Model page, @ModelAttribute("User") User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);
		user.setRole("ROLE_STUDENT");
		udi.save(user);
		Grade grade = new Grade();
		grade.setId(user.getId());
		gs.save(grade);
		return "redirect:/signup";
	}
	
	@RequestMapping("/profile")
	public String profile(Model page) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Long id = ((MyUserDetails) userDetails).getId();
		int practice_score = gs.get(id).getPractice_score();
		int puzzle_score = gs.get(id).getPuzzle_score();
		
		List<User> listUser = userRepository.getAllUser();
		User user = userRepository.getUserByUsername(username);
		page.addAttribute("listUser", listUser);
		page.addAttribute("User", user);
		page.addAttribute("updateStatus", "");
		page.addAttribute("practice_score", practice_score);
		page.addAttribute("puzzle_score", puzzle_score);
		return "profile";
	}
	
	@PostMapping("/update")
	public String update(Model page, @ModelAttribute("User") User user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Long id = ((MyUserDetails) userDetails).getId();
		user.setId(id);
		user.setEnabled(true);
		user.setRole("ROLE_STUDENT");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		udi.save(user);
		return "redirect:/profile";
	}
	
	@RequestMapping("/edit/{username}")
	public ModelAndView showEdit(@PathVariable(name = "username") String username) {
		ModelAndView mav = new ModelAndView("edit");
		User user = userRepository.getUserByUsername(username);
		mav.addObject("User", user);
		return mav;
		
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("User") User user) {
		User user1 = userRepository.getUserByUsername(user.getUsername());
		user.setPassword(user1.getPassword());
		udi.save(user);
		user.setPassword(user.getPassword());
		return "redirect:/profile";
	}
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") Long id) {
		userRepository.deleteById(id);
		return "redirect:/profile";
	}
	
}

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * 球団関連機能の処理の制御を行うコントローラ.
 * 
 * @author yukiando
 *
 */
@Repository
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	/**
	 * 球団の一覧表示をする.
	 * 
	 * @param model リクエストスコープ
	 * @return　球団一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Team> teamList = teamService.showList();
		model.addAttribute("teamList", teamList); 
		return "team-list";
	}
	
	/**
	 * 球団の詳細を表示する.
	 * 
	 * @param id ID
	 * @param model リクエストスコープ
	 * @return 球団詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		Team team = teamService.showDetail(id);
		model.addAttribute("team", team);
		return "team-detail";
	}
	
	/**
	 * 球団一覧画面に戻る.
	 * 
	 * @return 球団一覧画面
	 */
	@RequestMapping("/backPage")
	public String backPage() {
		return "redirect:/team/showList";
	}
}

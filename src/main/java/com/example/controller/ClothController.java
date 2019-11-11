package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.service.ClothService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * 衣類検索機能の処理の制御を行うコントローラ.
 * 
 * @author yukiando
 *
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {

	@Autowired
	private ClothService clothService;
	
	/**
	 * 衣類検索画面を表示する.
	 * 
	 * @return　衣類検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "cloth-search";
	}
	
	/**
	 * 衣類検索結果を表示する.
	 * 
	 * @param gender　性別
	 * @param color　カラー
	 * @param model　リクエストスコープ
	 * @return　衣類検索画面
	 */
	@RequestMapping("/condittionalSearch")
	public String condittionalSearch(Integer gender, String color, Model model) {
		List<Cloth>  clothList= clothService.search(gender, color);
		model.addAttribute("clothList", clothList);
		return "cloth-search";
	}
}

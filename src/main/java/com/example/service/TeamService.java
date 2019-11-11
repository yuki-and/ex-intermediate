package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * 球団関連機能の業務処理を行うサービス.
 * 
 * @author yukiando
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * 球団情報を全件取得する.
	 * 
	 * @return 球団リスト
	 */
	public List<Team> showList(){
		return teamRepository.findAll();
	}
	
	/**
	 * IDから球団情報を取得する.
	 * 
	 * @param id　ID
	 * @return　球団情報
	 */
	public Team showDetail(Integer id) {
		return teamRepository.load(id);
	}
}

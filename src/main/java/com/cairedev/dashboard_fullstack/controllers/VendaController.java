package com.cairedev.dashboard_fullstack.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairedev.dashboard_fullstack.models.Venda;
import com.cairedev.dashboard_fullstack.repositorys.VendaRepository;

@RestController
@RequestMapping("/api/vendas")
// PERMITE que o frontend em outra porta acesse esta api
@CrossOrigin(origins = "http://localhost:5173")
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public Map<String, Object> getDashBoardData(){
		// 1- Busca os KPIS
		Map<String, Object> kpis = vendaRepository.findKpis();
		
		// 2- busca as vendas recentes
		List<Venda> vendasRecentes = vendaRepository.findTop5ByOrderByDataVendaDesc();
		
		// 3- monta o json
		Map<String, Object> response = new HashMap<>();
		response.put("kpis", kpis);
		response.put("vendasRecentes", vendasRecentes);
		
		return response;
	}

}

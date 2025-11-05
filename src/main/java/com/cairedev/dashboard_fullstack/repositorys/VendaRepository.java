package com.cairedev.dashboard_fullstack.repositorys;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cairedev.dashboard_fullstack.models.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

		//Consultado customizada para os KPIS Key performance indicators
	@Query(value = "SELECT " + 
				   "COUNT(*) as totalVendas, " +
				   "SUM(valor_total) as receitaTotal, " +
				   "AVG(valor_total) as ticketMedio " +
				   "FROM vendas", nativeQuery = true)
	Map<String, Object> findKpis(); //Retorna um map com as colunas agregadas
	
	//Metodo p buscar as ultimas 5 vendas (para a tabela)
	List<Venda> findTop5ByOrderByDataVendaDesc();
	
}

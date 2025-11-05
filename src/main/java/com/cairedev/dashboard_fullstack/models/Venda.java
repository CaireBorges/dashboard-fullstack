package com.cairedev.dashboard_fullstack.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="vendas")
@Data // anotacao do lombok p criar getters, setters,tostring,etc
public class Venda {
	
	@Id
	private Integer idVenda;
	
	private LocalDate dataVenda;
	private Integer idCliente;
	private Integer idProduto;
	private Integer quantidade;
	private BigDecimal valorUnitario;
	

}

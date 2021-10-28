package com.hairplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hairplace.model.Estabelecimento;
import com.hairplace.model.Servico;
import com.hairplace.repository.EstabelecimentoRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Endpoints de User", value = "")
public class EstabelecimentoHorariosController {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @GetMapping("/estabelecimento/{id}")
    public Optional<Estabelecimento> getAllEstabelecimentos(@PathVariable(value = "id") Long id) {
    	return estabelecimentoRepository.findById(id);
    }

    @GetMapping("/estabelecimento/{id}/servicos")
    public List<Servico> getServicosByEstabelecimento(@PathVariable(value = "id") Long id) {
    	List<Servico> servicos = estabelecimentoRepository
    			.findById(id)
    			.get()
    			.getServicos();
    	
    	return servicos;
    }

}

package com.hairplace.controller;

import com.hairplace.model.*;
import com.hairplace.repository.EstabelecimentoRepository;
import com.hairplace.repository.ServicoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Endpoints de Serviços", value = "")
public class ServicoController {

    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    EstabelecimentoRepository estabelecimentoRepository ;

    @GetMapping("/servicos")
    public List<ServicoModel> getAllservicos(){
        return servicoRepository.findAll();
    }

    @GetMapping("/servico/{id}")
    public Optional<ServicoModel> getServicoById(@PathVariable(value="id") long id){
        return servicoRepository.findById(id);
    }

    @GetMapping("/servico/find/{nome}")
    public List<ServicoModel> getservicoByNomeIgnoreCase(@PathVariable(value = "nome") String nome) {
        return servicoRepository.findByNameIgnoreCase(nome.toUpperCase());
    }

    @PostMapping("/servico")
    public ServicoModel saveServico(@RequestBody @Valid ServicoModel servico) {
        try {
            final EstabelecimentoModel business = estabelecimentoRepository.getById(servico.getBusinessService().getId());

            servico.setBusinessService(business);

            return servicoRepository.save(servico);

        }catch (Exception e){
            throw e;
        }

    }

    @DeleteMapping("/servico/{id}")
    public void deleteServico(@PathVariable(value="id") long id) {
        Optional<ServicoModel> servico = servicoRepository.findById(id);
        servicoRepository.deleteById(servico.get().getId());
    }

    @PutMapping("/servico/{id}")
    public ServicoModel updateServico(@PathVariable(value="id") long id, @RequestBody @Valid ServicoModel servicoUpdate) {
        Optional<ServicoModel> servico = servicoRepository.findById(id);
        servicoUpdate.setId(servico.get().getId());
        return servicoRepository.save(servicoUpdate);
    }

    @PutMapping("/servico/inactive/{id}")
    public ServicoModel updateServicoInactive(@PathVariable(value="id") long id) {
        Optional<ServicoModel> servico = servicoRepository.findById(id);
        servico.get().setInativo(true);

        return servicoRepository.save(servico.get());
    }

    @PutMapping("/servico/active/{id}")
    public ServicoModel updateServicoActive(@PathVariable(value="id") long id) {
        Optional<ServicoModel> servico = servicoRepository.findById(id);
        servico.get().setInativo(false);

        return servicoRepository.save(servico.get());
    }
}

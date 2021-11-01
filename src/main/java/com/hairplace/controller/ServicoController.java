package com.hairplace.controller;

import com.hairplace.model.ServicoModel;
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

    @GetMapping("/servicos")
    public List<ServicoModel> getAllServicos(){
        return servicoRepository.findAll();
    }

    @GetMapping("/servico/{id}")
    public Optional<ServicoModel> getServicoById(@PathVariable(value="id") long id){
        return servicoRepository.findById(id);
    }

    @PostMapping("/servico")
    public ServicoModel saveServico(@RequestBody @Valid ServicoModel servico) {
        return servicoRepository.save(servico);
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
}

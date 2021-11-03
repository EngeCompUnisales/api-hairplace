package com.hairplace.controller;

import com.hairplace.model.AtendimentoModel;
import com.hairplace.repository.AtendimentoRepository;
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
@Api(tags = "Endpoints de Agendamento", value = "")
public class AtendimentoController {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    @GetMapping("/agendamento")
    public List<AtendimentoModel> getAllAgendamento(){
        return atendimentoRepository.findAll();
    }

    @GetMapping("/agendamento/{id}")
    public Optional<AtendimentoModel> getAgendamentoById(@PathVariable(value="id") long id){
        return atendimentoRepository.findById(id);
    }

    @PostMapping("/agendamento")
    public AtendimentoModel saveAgendamento(@RequestBody @Valid AtendimentoModel atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    @DeleteMapping("/agendamento/{id}")
    public void deleteAgendamento(@PathVariable(value="id") long id) {
        Optional<AtendimentoModel> agendamento = atendimentoRepository.findById(id);
        atendimentoRepository.deleteById(agendamento.get().getId());
    }

    @PutMapping("/agendamento/{id}")
    public AtendimentoModel updateAgendamento(@PathVariable(value="id") long id, @RequestBody @Valid AtendimentoModel atendimentoUpdate) {
        Optional<AtendimentoModel> atendimento = atendimentoRepository.findById(id);
        atendimentoUpdate.setId(atendimento.get().getId());
        return atendimentoRepository.save(atendimentoUpdate);
    }
}
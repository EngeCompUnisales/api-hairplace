package com.hairplace.controller;

import com.hairplace.model.*;
import com.hairplace.repository.*;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Endpoints de Agendamento", value = "")
public class AgendamentoController {


    @Autowired
    UserRepository userRepository ;

    @Autowired
    ServicoRepository servicoRepository ;

    @Autowired
    EstabelecimentoRepository estabelecimentoRepository ;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Autowired
    AtendimentoRepository atendimentoRepository;

    @GetMapping("/agendamento")
    public List<AgendamentoModel> getAllAgendamento(){
        return agendamentoRepository.findAll();
    }

    @GetMapping("/agendamento/{id}")
    public Optional<AgendamentoModel> getAgendamentoById(@PathVariable(value="id") long id){
        return agendamentoRepository.findById(id);
    }

    @PostMapping("/agendamento")
    public AgendamentoModel saveAgendamento(@RequestBody @Valid AgendamentoModel agendamento) {
        try {
            final Optional<UserModel> user = userRepository.findById(agendamento.getClient().getId());
            final ServicoModel service = servicoRepository.getById(agendamento.getService().getId());
            final EstabelecimentoModel business = estabelecimentoRepository.getById(agendamento.getBusinessService().getId());

            agendamento.setClient(user.get());
            agendamento.setService(service);
            agendamento.setBusinessService(business);

            return agendamentoRepository.save(agendamento);

        }catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/agendamento/{id}")
    public void deleteAgendamento(@PathVariable(value="id") long id) {
        Optional<AgendamentoModel> agendamento = agendamentoRepository.findById(id);
        agendamentoRepository.deleteById(agendamento.get().getId());
    }

    @PutMapping("/agendamento/{id}")
    public AgendamentoModel updateAgendamento(@PathVariable(value="id") long id, @RequestBody @Valid AgendamentoModel agendamentoUpdate) {
        Optional<AgendamentoModel> agendamento = agendamentoRepository.findById(id);
        agendamentoUpdate.setId(agendamento.get().getId());
        return agendamentoRepository.save(agendamentoUpdate);
    }


    @PutMapping("/agendamento/completed/{id}")
    public AgendamentoModel updateAgendamentoCompleted(@PathVariable(value="id") long id, @RequestBody @Valid Date dateCompleted) {
        Optional<AgendamentoModel> agendamento = agendamentoRepository.findById(id);
        agendamento.get().setServiceCompleted(dateCompleted);

        AtendimentoModel atendimento = new AtendimentoModel();
        atendimento.setAgendamento(agendamento.get());

        atendimentoRepository.save(atendimento);

        return agendamentoRepository.save(agendamento.get());
    }
}
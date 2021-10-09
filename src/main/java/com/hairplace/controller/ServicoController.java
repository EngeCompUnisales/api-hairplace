package com.hairplace.controller;

import com.hairplace.model.ServicoModel;
import com.hairplace.repository.ServicoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Nome da api", value = "info da api")
public class ServicoController {

    @Autowired
    ServicoRepository servicoRepository;

    @GetMapping("/servicos")
    public ResponseEntity<List<ServicoModel>> getAllServicos(){
        List<ServicoModel> servicosList = servicoRepository.findAll();
        if(servicosList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            for(ServicoModel servico : servicosList) {
                long id = servico.getId();
                servico.add(linkTo(methodOn(ServicoController.class).getServicoById(id)).withSelfRel());
            }
            return new ResponseEntity<List<ServicoModel>>(servicosList, HttpStatus.OK);
        }
    }

    @GetMapping("/servico/{id}")
    public ResponseEntity<ServicoModel> getServicoById(@PathVariable(value="id") long id){
        Optional<ServicoModel> servico = servicoRepository.findById(id);
        if(!servico.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            servico.get().add(linkTo(methodOn(ServicoController.class).getAllServicos()).withRel("Lista de Serviços"));
            return new ResponseEntity<ServicoModel>(servico.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/servico")
    public ResponseEntity<ServicoModel> saveServico(@RequestBody @Valid ServicoModel servico) {
        return new ResponseEntity<ServicoModel>(servicoRepository.save(servico), HttpStatus.CREATED);
    }

    @DeleteMapping("/servico/{id}")
    public ResponseEntity<?> deleteServico(@PathVariable(value="id") long id) {
        Optional<ServicoModel> servico = servicoRepository.findById(id);
        if(!servico.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            servicoRepository.delete(servico.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/servico/{id}")
    public ResponseEntity<ServicoModel> updateServico(@PathVariable(value="id") long id,
        @RequestBody @Valid ServicoModel servicoUpdate) {
        Optional<ServicoModel> servico = servicoRepository.findById(id);
        if(!servico.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            servicoUpdate.setId(servico.get().getId());
            return new ResponseEntity<ServicoModel>(servicoRepository.save(servicoUpdate), HttpStatus.OK);
        }
    }
}

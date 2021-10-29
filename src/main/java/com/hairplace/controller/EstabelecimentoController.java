package com.hairplace.controller;

import com.hairplace.model.EstabelecimentoModel;
import com.hairplace.repository.EstabelecimentoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;  //nao sei se vai ser usado aqui

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Endpoints de Estabelecimento", value = "")

public class EstabelecimentoController {

    @Autowired
    EstabelecimentoRepository estabelecimentoRepository ;

    @GetMapping("/estabelecimento")
    public List<EstabelecimentoModel> getAllEstabelecimento(){
        return estabelecimentoRepository.findAll();
    }

    @GetMapping("/estabelecimento/{id}")
    public Optional<EstabelecimentoModel> getEstabelecimentoById(@PathVariable(value="id") long id){
        return estabelecimentoRepository.findById(id);
    }

    @PostMapping("/estabelecimento")
    public EstabelecimentoModel saveEstabelecimento(@RequestBody @Valid EstabelecimentoModel estabelecimento) {
        return estabelecimentoRepository.save(estabelecimento);
    }

    @DeleteMapping("/estabelecimento/{id}")
    public void deleteEstabelecimento(@PathVariable(value="id") long id) {
        Optional<EstabelecimentoModel> estabelecimento = estabelecimentoRepository.findById(id);
        estabelecimentoRepository.deleteById(estabelecimento.get().getId());
    }

    @PutMapping("/estabelecimento/{id}")
    public EstabelecimentoModel updateEstabelecimento(@PathVariable(value="id") long id, @RequestBody @Valid EstabelecimentoModel estabelecimentoUpdate) {
        Optional<EstabelecimentoModel> estabelecimento = estabelecimentoRepository.findById(id);
        estabelecimentoUpdate.setId(estabelecimento.get().getId());
        return estabelecimentoRepository.save(estabelecimentoUpdate);
    }
}
package com.hairplace.controller;

import com.hairplace.model.EstabelecimentoModel;
import com.hairplace.model.UserModel;
import com.hairplace.repository.EstabelecimentoRepository;
import com.hairplace.repository.UserRepository;
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
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Endpoints de Estabelecimento", value = "")
public class EstabelecimentoController {

    @Autowired
    UserRepository userRepository ;

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

    @GetMapping("/estabelecimento/find/{name}")
    public List<EstabelecimentoModel> getEstabelecimentoByName(@PathVariable(value = "name") String name) {
        return estabelecimentoRepository.findByNameContaing(name.toUpperCase());
    }
    
    @GetMapping("/estabelecimento/responsible/{id_responsible}")
    public List<EstabelecimentoModel> getEstabelecimentoByResponsible(@PathVariable(value = "id_responsible") long idUser) {
    	Optional<UserModel> user = userRepository.findById(idUser);
    	return estabelecimentoRepository.findByResponsible(user);
    }

    @PostMapping("/estabelecimento")
    public EstabelecimentoModel saveEstabelecimento(@RequestBody @Valid EstabelecimentoModel estabelecimento) {
        try{
            final UserModel user = userRepository.getById(estabelecimento.getResponsible().getId());
            estabelecimento.setResponsible(user);
            return estabelecimentoRepository.save(estabelecimento);
        }catch (Exception e){
            throw e;
        }

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
        estabelecimentoUpdate.setResponsible(estabelecimento.get().getResponsible());
        return estabelecimentoRepository.save(estabelecimentoUpdate);
    }
}
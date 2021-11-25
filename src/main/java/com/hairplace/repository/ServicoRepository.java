package com.hairplace.repository;

import com.hairplace.model.EstabelecimentoModel;
import com.hairplace.model.ServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoModel, Long>{

    @Query("Select e from ServicoModel e where inativo=false and UPPER(e.nome) like %:nomePart%")
    List<ServicoModel> findByNameIgnoreCase(@Param("nomePart") String nomePart);
}
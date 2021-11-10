package com.hairplace.repository;

import com.hairplace.model.EstabelecimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoModel, Long>{

	Optional<EstabelecimentoModel> findEstabelecimentoByResponsibleById(long idUser);
	
}
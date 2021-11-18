package com.hairplace.repository;

import com.hairplace.model.EstabelecimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoModel, Long>{

	@Query("select e from EstabelecimentoModel e join UserModel u on e.responsible = u.id where u.id = ?1")
	Optional<EstabelecimentoModel> findByResponsible(long idUser);
	
}
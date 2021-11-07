package com.hairplace.repository;

import com.hairplace.model.EstabelecimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoModel, Long>{

	@Query("select e from estabelecimento e join usuario u on e.id_responsavel = u.id where u.id = %?1")
	EstabelecimentoModel findEstabelecimentoByIdUser(long idUser);
	
}
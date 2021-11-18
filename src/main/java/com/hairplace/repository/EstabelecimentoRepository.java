package com.hairplace.repository;

import com.hairplace.model.EstabelecimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoModel, Long>{

	Optional<EstabelecimentoModel> findByResponsible(long idUser);

	@Query("Select e from EstabelecimentoModel e where e.name like %:namePart%")
	List<EstabelecimentoModel> findByNameContaing(@Param("namePart") String namePart);

}
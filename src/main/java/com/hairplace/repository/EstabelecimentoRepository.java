package com.hairplace.repository;

import com.hairplace.model.EstabelecimentoModel;
import com.hairplace.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoModel, Long>{

	List<EstabelecimentoModel> findByResponsible(Optional<UserModel> user);

	@Query("Select e from EstabelecimentoModel e where e.name like %:namePart%")
	List<EstabelecimentoModel> findByNameContaing(@Param("namePart") String namePart);

}
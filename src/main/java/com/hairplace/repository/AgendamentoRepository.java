package com.hairplace.repository;

import com.hairplace.model.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long>{

}
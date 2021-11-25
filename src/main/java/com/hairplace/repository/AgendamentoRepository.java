package com.hairplace.repository;

import com.hairplace.model.AgendamentoModel;
import com.hairplace.model.EstabelecimentoModel;
import com.hairplace.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long>{

    List<AgendamentoModel> findByClient(Optional<UserModel> user);

}
/*
import com.hairplace.model.PayingModel;
import com.hairplace.repository.PayingRepository;
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
import org.springframework.web.bind.annotation.RequestParam; //nao sei se vai ser usado aqui 

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Endpoints de Estabelecimento", value = "")

public class PayingController {

    @Autowired
    PayingRepository PayingRepository ;

    @GetMapping("/estabelecimento")
    public List<PayingModel> getAllestabelecimento(){
        return PayingRepository.findAll();
    }

    @GetMapping("/estabelecimento/{id}")
    public Optional<PayingModel> getestabelecimentoById(@PathVariable(value="id") long id){
        return PayingRepository.findById(id);
    }

    @PostMapping("/estabelecimento")
    public PayingModel saveestabelecimento(@RequestBody @Valid PayingModel estabelecimento) {
        return PayingRepository.save(estabelecimento);
    }

    @DeleteMapping("/estabelecimento/{id}")
    public void deleteestabelecimento(@PathVariable(value="id") long id) {
        Optional<PayingModel> estabelecimento = PayingRepository.findById(id);
        PayingRepository.deleteById(estabelecimento.get().getId());
    }
    
    @HeadMapping("/estabelecimento")
    public List<PayingModel> headAllestabelecimento(){
        return PayingRepository.findAll();
    }

    @HeadMapping("/estabelecimento/{id}")
    public Optional<PayingModel> headestabelecimentoById(@PathVariable(value="id") long id){
        return PayingRepository.findById(id);
    }

   @PutMapping("/estabelecimento/{id}")
    public PayingModel updateestabelecimento(@PathVariable(value="id") long id, @RequestBody @Valid PayingModel estabelecimentoUpdate) {
        Optional<PayingModel> estabelecimento = PayingRepository.findById(id);
        estabelecimentoUpdate.setId(estabelecimento.get().getId());
        return PayingRepository.save(estabelecimentoUpdate);
    }
}
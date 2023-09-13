package one.digitalInovation.gof.service;


import one.digitalInovation.gof.model.Endereco;
import one.digitalInovation.gof.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {


    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}

package one.digitalInovation.gof.service.impl;

import one.digitalInovation.gof.dto.ClienteDTO;

import one.digitalInovation.gof.model.Cliente;
import one.digitalInovation.gof.model.Endereco;
import one.digitalInovation.gof.repository.ClienteRepository;
import one.digitalInovation.gof.repository.EnderecoRepository;
import one.digitalInovation.gof.service.ClienteService;
import one.digitalInovation.gof.service.ViaCepService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<ClienteDTO> buscarTodos() {
        return clienteRepository.findAll().stream().map(ClienteDTO::toDTO).toList();
    }

    @Override
    public ClienteDTO buscarPorId(long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return ClienteDTO.toDTO(cliente.get());
    }

    @Override
    public Cliente inserir(ClienteDTO clienteDTO) {
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO,cliente);
      return salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }



    @Override
    public void deletar(long id) {
        clienteRepository.deleteById(id);
    }

    private Cliente salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        var endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            var novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }


}

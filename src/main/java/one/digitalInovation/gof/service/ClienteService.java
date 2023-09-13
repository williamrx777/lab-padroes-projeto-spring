package one.digitalInovation.gof.service;

import one.digitalInovation.gof.dto.ClienteDTO;
import one.digitalInovation.gof.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> buscarTodos();

    ClienteDTO buscarPorId(long id);

    Cliente inserir(ClienteDTO clienteDTO);

    Cliente atualizar(long id, ClienteDTO clienteDTO);

    void deletar(long id);
}

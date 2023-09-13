package one.digitalInovation.gof.dto;

import jakarta.persistence.ManyToOne;
import one.digitalInovation.gof.model.Cliente;
import one.digitalInovation.gof.model.Endereco;

public class ClienteDTO {

    private String nome;

    private Endereco endereco;

    public ClienteDTO() {
    }

    public ClienteDTO( String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public static ClienteDTO toDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEndereco(cliente.getEndereco());
        return clienteDTO;
    }

    public static Cliente toEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEndereco(clienteDTO.getEndereco());
        return cliente;
    }



}

package br.com.petz.cliente_pet.cliente.application.api;

import br.com.petz.cliente_pet.cliente.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
@JsonPropertyOrder({"idCliente", "nomeCompleto", "cpf","email" ,"celular"})
public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String celular;


    public ClienteListResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
    }

    public static List<ClienteListResponse> converte(List<Cliente> clientes) {

        return clientes.stream()
                .map(ClienteListResponse::new)
                .collect(Collectors.toList());
    }
}

package br.com.fiap.sprint1.JavaSprint1WhitelabelAPI.dto.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCustomerDTO(

        @NotBlank(message = "Nome não pode ser vazio")
        @Size(max = 50, message = "Email pode ter no máximo caracteres")
        String name,

        @NotBlank(message = "Email não pode ser vazio")
        @Size(max = 70, message = "Email pode ter no máximo caracteres")
        String email
) {
}

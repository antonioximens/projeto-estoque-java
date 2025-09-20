package poo2.estoque.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ItemCreateDTO(
        @NotBlank(message = "O nome do item não pode estar vazio!") String name,

        @Min(value = 1, message = "A quantidade deve ser no mínimo 1!") int quantity,

        @Min(value = 0, message = "O preço deve ser no minimo 1!") double price) {
}

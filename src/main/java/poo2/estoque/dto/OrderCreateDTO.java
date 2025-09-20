package poo2.estoque.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public record OrderCreateDTO(
        @NotEmpty(message = "A Lista de itens não pode estar vazia") @Valid List<ItemCreateDTO> items) {
}

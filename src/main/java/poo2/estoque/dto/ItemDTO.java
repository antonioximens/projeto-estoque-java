package poo2.estoque.dto;

public record ItemDTO(
                Long id,
                String name,
                int quantity,
                double price) {
}

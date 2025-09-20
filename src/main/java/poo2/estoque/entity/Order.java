package poo2.estoque.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*
 * CRIANDO UM ENTIDADE DENTRO DA CLASSE JAVA QUE SERVE DE REFERENCIA PARA O JPA
 * OS @ SÃO NOTAÇÕES QUE AJUDAM A IDENTIFICAR E VALIDAR
 * COMO ESTOU CRIANDO UMA TABELA, O NOME QUE FICOU EM @Table E DECLAREI O NOME
 */
@Entity
@Table(name = "orders")

public class Order {
    // gerando id no autoincremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // gerando data de criação atual
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    // constructor
    public Order() {
    }

    // gerando os getters e setters id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // criando getters e setters creatdAt
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // criando getters e setters List<Item>
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // Metodo para calcular o total do pedido
    public double getTotal() {
        //
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    // Metodo auxiliar para adicionar itens
    public void addItem(Item item) {
        items.add(item);
        item.setOrder(this);
    }

    // Metodo auxiliar para remover itens
    public void removeItem(Item item) {
        items.remove(item);
        item.setOrder(null);
    }
}

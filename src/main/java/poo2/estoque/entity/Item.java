package poo2.estoque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
 * CRIANDO UM ENTIDADE DENTRO DA CLASSE JAVA QUE SERVE DE REFERENCIA PARA O JPA
 * OS @ SÃO NOTAÇÕES QUE AJUDAM A IDENTIFICAR E VALIDAR
 * COMO ESTOU CRIANDO UMA TABELA, O NOME QUE FICOU EM @Table E DECLAREI O NOME
 */

@Entity
@Table(name = "items")
public class Item {
    // criando o auto incremento do id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // declarando as variaveis
    private Long id;
    private String name;
    private int quantity;
    private double price;

    // n para n -> banco de dados ( cardinalidade )
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    // criando o constructor sem parametros
    public Item() {
    }

    // criando cosntructor com parametros
    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // criando getters e setters id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // criando getters e setters name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // criando getters e setters quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // criando getters e setters price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // criando getters e setters Order
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

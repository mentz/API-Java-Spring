package dev.mentz.myorder.entities;

import javax.persistence.*;

//@Entity informa Swagger e Spring que isso é uma entidade
@Entity
//@Table permite mudar o nome da tabela no banco de dados
@Table(name = "RESTAURANTE")
public class Restaurant {
//    @Id define qual atributo é a chave primária
    @Id
//    @GeneratedValue define a estratégia do valor para o campo Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column permite definir detalhes da coluna
    @Column(name = "NOME", nullable = false)
    private String name;

    @Column(name = "FONE", nullable = false)
    private String phone;

    @Column(name = "EMAIL", nullable = false)
    private String email;

//    Os métodos getId(), setId, getName, ... foram gerados
//    pelo IntelliJ usando Builder Pattern. O Builder Pattern
//    permite instanciar a classe com a seguinte sintaxe:
//    return new Restaurant().setName().setEmail()[...];

    public Integer getId() {
        return id;
    }

    public Restaurant setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Restaurant setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Restaurant setEmail(String email) {
        this.email = email;
        return this;
    }
}

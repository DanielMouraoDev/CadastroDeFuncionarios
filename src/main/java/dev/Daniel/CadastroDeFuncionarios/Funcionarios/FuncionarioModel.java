package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import dev.Daniel.CadastroDeFuncionarios.Cargos.CargosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "senioridade")
    private String senioridade;

    @ManyToOne(fetch = FetchType.EAGER) // traz os dados de cargos
    @JoinColumn(name = "cargos_Id")
    private CargosModel cargosModel;
}
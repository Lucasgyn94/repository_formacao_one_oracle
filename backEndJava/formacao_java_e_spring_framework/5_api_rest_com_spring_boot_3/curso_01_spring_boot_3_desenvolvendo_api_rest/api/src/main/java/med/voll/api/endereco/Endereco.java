package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;


    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }


    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        } else if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        } else if (dados.cep() != null) {
            this.cep = dados.cep();
        } else if (dados.uf() != null) {
            this.uf = dados.uf();
        } else if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        } else if (dados.numero() != null) {
            this.numero = dados.numero();
        } else if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
    }
}

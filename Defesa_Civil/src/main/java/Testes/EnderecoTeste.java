package Testes;
import com.controller.EnderecoDAO;
import com.model.Endereco;
import java.util.Scanner;
import java.util.List;


public class EnderecoTeste {
    public static void main(String[] args){
        Endereco endereco = new Endereco();
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        Scanner input = new Scanner(System.in);

        System.out.println("Digite seu CEP");
        endereco.setCEP(input.nextLine());


        System.out.println("Digite o complemento");
        endereco.setComplemento(input.nextLine());


        System.out.println("Digite o numero da rua");
        endereco.setNumero(input.nextInt());
        input.nextLine();

        System.out.println("Digite o logradouro");
        endereco.setLogradouro(input.nextLine());

        System.out.println("Digite sua cidade");
        endereco.setCidade(input.nextLine());


        input.close();

        Endereco enderecoSalvo = enderecoDAO.Salvar(endereco);

        if (enderecoSalvo != null) {
            System.out.println("Endereço salvo com sucesso!");
            System.out.println("Endereço salvo: " + enderecoSalvo.getLogradouro());
        } else {
            System.err.println("Erro ao salvar Endereço");
        }



        List<Endereco> enderecos = enderecoDAO.ListarEndereco();

        if (enderecos != null && !enderecos.isEmpty()) {
            System.out.println("Endereços encontrados ");
            for (Endereco enderecoParaListagem : enderecos) {
                System.out.println("ID: " + enderecoParaListagem.getIdEndereco() +
                        ", Logradouro: " + enderecoParaListagem.getLogradouro() +
                        ", Cidade: " + enderecoParaListagem.getCidade() +
                        ", Complemento: " + enderecoParaListagem.getComplemento() +
                        ", CEP: " + enderecoParaListagem.getCEP() +
                        ", Numero: " + enderecoParaListagem.getNumero());
            }
        } else {
            System.out.println("Nenhum endereço encontrado em ");
        }
    }
}


package segundoteste;

import java.util.ArrayList;
import java.util.List;

public class Segundo {

    int idAtual = 0;
    List<Candidato> listaCandidatos = new ArrayList<>();
    Boolean candidatoCadastrado = false;
    int posicaoId = -1;

    public boolean checkName(String nomeCandidato) {
        for (int i = 0; i < listaCandidatos.size(); i++) {
            if (listaCandidatos.get(i).getNome().equals(nomeCandidato)) {
                candidatoCadastrado = true;
                break;
            } else {
                candidatoCadastrado = false;
            }
        }
        return candidatoCadastrado;
    }

    public int checkId(int codCandidato) {
        for (int i = 0; i < listaCandidatos.size(); i++) {
            if (listaCandidatos.get(i).id == codCandidato) {
                posicaoId = i;
                break;
            } else {
                posicaoId = -1;
            }
        }
        return posicaoId;
    }

    public int iniciarProcesso(String nome) throws Exception {
        if (nome.length() < 2) {
            throw new Exception("Nome inválido");
        }
        if (checkName(nome) == true) {
            throw new Exception("Candidato já participa do processo");
        } else {
            idAtual = idAtual + 1;
            Candidato novoCandidato = new Candidato(idAtual, nome, "Recebido");
            listaCandidatos.add(novoCandidato);
        }
        return idAtual;
    }

    public void marcarEntrevista(int codCandidato) throws Exception {
        if (checkId(codCandidato) == -1) {
            throw new Exception("Candidato não encontrado");
        } else {
            if (listaCandidatos.get(checkId(codCandidato)).status == "Qualificado") {
                System.out.println("Entrevista já marcada para o candidato");
            } else {
                listaCandidatos.get(checkId(codCandidato)).setStatus("Qualificado");
            }
        }
    }

    public void desqualificarCandidato(int codCandidato) throws Exception {
        if (checkId(codCandidato) == -1) {
            throw new Exception("Candidato não encontrado");
        } else {
            if (listaCandidatos.get(checkId(codCandidato)).status == "Desqualificado") {
                System.out.println("Candidato já desqualificado");
            } else {
                listaCandidatos.get(checkId(codCandidato)).setStatus("Desqualificado");
            }
        }
    }

    public String verificarStatusCandidato(int codCandidato) throws Exception {
        if (checkId(codCandidato) == -1) {
            throw new Exception("Candidato não encontrado");
        } else {
            String statusCandidato = listaCandidatos.get(checkId(codCandidato)).getStatus();
            System.out.println(statusCandidato);
            return statusCandidato;
        }
    }

    public void aprovarCandidato(int codCandidato) throws Exception {
        if (checkId(codCandidato) == -1) {
            throw new Exception("Candidato não encontrado");
        } else {
            listaCandidatos.get(checkId(codCandidato)).setStatus("Aprovado");
        }
    }

    public List<String> obterAprovados() {
        List<String> listaAprovados = new ArrayList<>();

        for (int i = 0; i < listaCandidatos.size(); i++) {
            if (listaCandidatos.get(i).getStatus().equals("Aprovado")) {
                listaAprovados.add(listaCandidatos.get(i).getNome());
            }
        }
        return listaAprovados;
    }
}

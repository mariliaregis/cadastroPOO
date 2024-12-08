# cadastroPOO
package model;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList; 
import java.io.IOException;



public class CadastroPOOMariliaregis {

 

public class Pessoa implements Serializable {
    private int id;
    private String nome;

    public Pessoa() {
    }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void exibir() {
        System.out.println("ID: " + id + ", Nome: " + nome);
    }
}

    public static void main(String[] args) {
        // TODO code application logic here
    }
   public class PessoaFisica extends Pessoa {
    private String cpf;
    private int idade;

    public PessoaFisica() {
    }

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    /*@Override*/

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + cpf + ", Idade: " + idade);
    }
} 
   public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }
}

public class PessoaFisicaRepo {
    private final ArrayList<PessoaFisica> lista = new ArrayList<>();

    public void inserir(PessoaFisica pf) {
        lista.add(pf);
    }

    public void alterar(PessoaFisica pf) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == pf.getId()) {
                lista.set(i, pf);
                return;
            }
        }
    }

    public void excluir(int id) {
        lista.removeIf(p -> p.getId() == id);
    }

    public PessoaFisica obter(int id) {
        return lista.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return new ArrayList<>(lista);
    }

    public void persistir(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        }
    }

    @SuppressWarnings("unchecked")
    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            lista.clear();
            lista.addAll((ArrayList<PessoaFisica>) ois.readObject());
        }
    }
}

} 

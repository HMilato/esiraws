/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author HMilato Studio
 */
public class Estudante {
    
    private String nr_estudante;
    private String nome_completo;
    private int nivel_frequencia;
    private String email;

    public String getNr_estudante() {
        return nr_estudante;
    }

    public void setNr_estudante(String nr_estudante) {
        this.nr_estudante = nr_estudante;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public int getNivel_frequencia() {
        return nivel_frequencia;
    }

    public void setNivel_frequencia(int nivel_frequencia) {
        this.nivel_frequencia = nivel_frequencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}

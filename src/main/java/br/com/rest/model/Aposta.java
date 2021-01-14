package br.com.rest.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nr_sorteado")
	private String numeroSorteado;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	@JsonIgnore
	private Usuario usuario;
	
	private static final ArrayList<String> numerosDisponiveis = new ArrayList<String>(
            Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
                    "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47",
                    "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"));
	
	public void geraAposta() {
		HashSet<String> gera = new HashSet<String>();
        Random random = new Random();

        while (gera.size() < 6) {
            Integer i = random.nextInt(numerosDisponiveis.size());
            gera.add(numerosDisponiveis.get(i));
        }
        
        ArrayList<String> ordena = new ArrayList<String>(gera);
        ordena.sort(null);
        
        this.numeroSorteado = ordena.toString();
        
    }

	public int getId() {
		return id;
	}

	public String getNumeroSorteado() {
		return numeroSorteado;
	}

	public void setNumeroSorteado(String numeroSorteado) {
		this.numeroSorteado = numeroSorteado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static ArrayList<String> getNumerosdisponiveis() {
		return numerosDisponiveis;
	}
	
	

}

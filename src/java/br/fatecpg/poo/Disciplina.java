/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fatecpg.poo;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Disciplina {
    String nome, ementa;
    int ciclo, nota;

    public Disciplina(String nome, String ementa, int ciclo) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
    }

    private static ArrayList<Disciplina> disciplinas;
    
    public static ArrayList<Disciplina> getList(){
        if(disciplinas == null){
            disciplinas = new ArrayList<>();
            disciplinas.add(new Disciplina("Gestão de Projetos", "Definição de projeto segundo concepção difundida pelas melho"
                    + "res práticas de gestão de projetos. Histórico do desenvolvimento do conjunto de conhecimentos de gest"
                    + "ão de projetos. Comparação ente o gerenciamento por projetos com o gerenciamento tradicional. O cicl"
                    + "o de vida de um projeto. Os fatores de sucesso e insucesso de projetos e sua mensuração. As nove de c"
                    + "onhecimento para a gestão de projetos e seus processos : Integração, Escopo, Tempo, Custo, Qualidade, R"
                    + "ecursos Humanos, Comunicações, Riscos e Aquisições.", 5));
            disciplinas.add(new Disciplina("Laboratório de Banco de Dados", "Tecnologias emergentes de mercado que serão apl"
                    + "icadas em laboratório", 5));
            disciplinas.add(new Disciplina("Laboratório de Engenharia de Software", "Desenvolvimento de um software utilizan"
                    + "do os conhecimentos adquiridos ao longo do curso. A elaboração deve abordar as disciplinas de requ"
                    + "isitos, análise e projeto, implementação, implantação e gerência de projetos. O processo de desenvol"
                    + "vimento, assim como a técnica fica a critério de acordo entre professor e aluno.", 5));
            disciplinas.add(new Disciplina("Programação para Dispositivos Móveis", "Ambientes de programação para dispositivos "
                    + "móveis. Emuladores. Interface gráfica, serviços baseados em localização, armazenamento de dados persist"
                    + "entes, serviços de telefonia e comunicação entre processos. Desenvolvimento de aplicações com J2ME.", 5));
            disciplinas.add(new Disciplina("Redes de Computadores", "Comunicação de Dados. Topologia e Características Físic"
                    + "as de Redes. Redes Locais de Longa Distância. Redes de Alta Velocidade. Protocolos e Serviços de Comunic"
                    + "ação. Camadas de Sistemas Abertos. Sistemas Operacionais de Redes. Interconexão de redes. Avaliação de "
                    + "Desempenho. Estrutura e Funcionamento da Internet.", 5));
            disciplinas.add(new Disciplina("Segurança da Informação", "Requisitos de segurança de aplicações, de base de dad"
                    + "os e de comunicações. Segurança de dispositivos móveis. Políticas de segurança. Criptografia. Firewa"
                    + "lls. Vulnerabilidades e principais tecnologias de segurança.", 5));
            disciplinas.add(new Disciplina("Inglês V", "Aprofundamento da compreensão e produção oral e escrita por meio funç"
                    + "ões sociais e estruturas mais complexas da língua. Ênfase na oralidade, atendendo às especificidades "
                    + "acadêmico-profissionais da área e abordando aspectos sócio-culturais da língua inglesa.", 5));
            disciplinas.add(new Disciplina("Trabalho de Graduação I", "O estudante elaborará, sob a orientação de docente, u"
                    + "m Trabalho de Graduação, e o apresentará perante uma banca examinadora. As disciplinas de Projetos d"
                    + "everão subsidiar o trabalho de graduação, com temas e propostas de projetos, casos, etc.", 5));
            disciplinas.add(new Disciplina("Programação Orientada a Objetos", "Conceitos e evolução da tecnologia de orientaç"
                    + "ão a objetos. Limitações e diferenças entre o paradigma da programação estruturada em relação à orien"
                    + "tação a objetos. Conceito de objeto, classe, métodos, atributos, herança, polimorfismo, agregação, ass"
                    + "ociação, dependência, encapsulamento, mensagem e suas respectivas notações na linguagem padrão de repr"
                    + "esentação da orientação a objetos. Implementação de algoritmos orientado a objetos utilizando linguage"
                    + "ns de programação. Aplicação e uso das estruturas fundamentais da orientação a objetos.", 4));
        }
        return disciplinas;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import br.fatecpg.poo.Disciplina;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author bruno
 */
public class DbListener implements ServletContextListener {
    private static final String CLASS_NAME = "org.sqlite.JDBC";
        private static final String DATABASE_URL = "jdbc:sqlite:disciplinasp2.db";
        
        public static String exceptionMessage = null;
        
        public static Connection getConnection() throws Exception {
            return DriverManager.getConnection(DATABASE_URL);
        }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       String step = "Inicializando conexão";
       Connection con = null;
       Statement stmt = null;
       
       try{
           step = "Classe do driver sendo registrada";
           Class.forName(CLASS_NAME);
           con = getConnection();
           step = "Preparando o stmt";
           stmt = con.createStatement();
           step = "Adicionando disciplinas à tabela";
           stmt.execute(Disciplina.getCreateStatement());
           if(Disciplina.getList().isEmpty()){
               step = "Criando registros iniciais para a tabela";
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Gestão de Projetos',"
                       + "'Definição de projeto segundo concepção difundida pelas melhores práticas de gestão de "
                       + "projetos. Histórico do desenvolvimento do conjunto de conhecimentos de gestão de projetos. "
                       + "Comparação ente o gerenciamento por projetos com o gerenciamento tradicional. O ciclo de vida "
                       + "de um projeto. Os fatores de sucesso e insucesso de projetos e sua mensuração. As nove de conhecimento "
                       + "para a gestão de projetos e seus processos : Integração, Escopo, Tempo, Custo, Qualidade, Recursos "
                       + "Humanos, Comunicações, Riscos e Aquisições.',"
                       + "5,"
                       + "null"
                       + ")");
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Laboratório de Banco de Dados',"
                       + "'Tecnologias emergentes de mercado que serão aplicadas em laboratório',"
                       + "5,"
                       + "null"
                       + ")");
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Laboratório de Engenharia de Software',"
                       + "'Desenvolvimento de um software utilizando os conhecimentos adquiridos ao longo do curso. A elaboração deve "
                       + "abordar as disciplinas de requisitos, análise e projeto, implementação, implantação e gerência de projetos. "
                       + "O processo de desenvolvimento, assim como a técnica fica a critério de acordo entre professor e aluno.',"
                       + "5,"
                       + "null"
                       + ")");
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Programação para Dispositivos Móveis',"
                       + "'Ambientes de programação para dispositivos móveis. Emuladores. Interface gráfica, serviços baseados em localização"
                       + ", armazenamento de dados persistentes, serviços de telefonia e comunicação entre processos. Desenvolvimento d"
                       + "e aplicações com J2ME.',"
                       + "5,"
                       + "null"
                       + ")");
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Redes de Computadores',"
                       + "'Comunicação de Dados. Topologia e Características Físicas de Redes. Redes Locais de Longa Distância. Redes de "
                       + "Alta Velocidade. Protocolos e Serviços de Comunicação. Camadas de Sistemas Abertos. Sistemas Operacionais de R"
                       + "edes. Interconexão de redes. Avaliação de Desempenho. Estrutura e Funcionamento da Internet.',"
                       + "5,"
                       + "null"
                       + ")");
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Segurança da Informação',"
                       + "'Requisitos de segurança de aplicações, de base de dados e de comunicações. Segurança de dispositivos móveis. "
                       + "Políticas de segurança. Criptografia. Firewalls. Vulnerabilidades e principais tecnologias de segurança.',"
                       + "5,"
                       + "null"
                       + ")");
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Inglês V',"
                       + "'Aprofundamento da compreensão e produção oral e escrita por meio funções sociais e estruturas mais complexas"
                       + " da língua. Ênfase na oralidade, atendendo às especificidades acadêmico-profissionais da área e abordando as"
                       + "pectos sócio-culturais da língua inglesa.',"
                       + "5,"
                       + "null"
                       + ")");
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Trabalho de Graduação I',"
                       + "'O estudante elaborará, sob a orientação de docente, um Trabalho de Graduação, e o apresentará perante uma "
                       + "banca examinadora. As disciplinas de Projetos deverão subsidiar o trabalho de graduação, com temas e propostas "
                       + "de projetos, casos, etc.',"
                       + "5,"
                       + "null"
                       + ")");
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Programação Orientada a Objetos',"
                       + "'Conceitos e evolução da tecnologia de orientação a objetos. Limitações e diferenças entre o paradigma da programação"
                       + " estruturada em relação à orientação a objetos. Conceito de objeto, classe, métodos, atributos, herança, polimorfismo,"
                       + " agregação, associação, dependência, encapsulamento, mensagem e suas respectivas notações na linguagem padrão de rep"
                       + "resentação da orientação a objetos. Implementação de algoritmos orientado a objetos utilizando linguagens de programa"
                       + "ção. Aplicação e uso das estruturas fundamentais da orientação a objetos.',"
                       + "4,"
                       + "null"
                       + ")");
           }
           step = "Criacao feita, desconectando do BD";
       }catch(Exception ex){
           exceptionMessage = step + ": " + ex.getLocalizedMessage();
       }finally{
           try{
               stmt.close();
           }catch(Exception ex1){};
           try{
               con.close();
           }catch(Exception ex1){};
       }
       
       
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}

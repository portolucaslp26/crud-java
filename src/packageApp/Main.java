package packageApp;

import java.util.Date;

import package1.Contato;
import packageDao.ContatoDAO;

public class Main {
    public static void main(String[] args) {

        ContatoDAO dao = new ContatoDAO();
        Contato contato = new Contato();

        contato.setNome("Lucas");
        contato.setTelefone("(11) 98765-4321");
        contato.setRegister_date(new Date());
        dao.create(contato);

        //visualizar o contato
        Contato contato2 = dao.read(1);
        System.out.println(contato2.getNome());
        System.out.println(contato2.getTelefone());
        System.out.println(contato2.getRegister_date());
        
    }
}

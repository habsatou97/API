package com.example.RelationClientBanque;

import com.example.RelationClientBanque.models.Banque;
import com.example.RelationClientBanque.models.Client;
import com.example.RelationClientBanque.models.CompteBancaire;
import com.example.RelationClientBanque.repository.BanqueRepository;
import com.example.RelationClientBanque.repository.ClientRepository;
import com.example.RelationClientBanque.repository.CompteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class RelationClientBanqueApplication implements CommandLineRunner {
	@Autowired

	private final CompteBancaireRepository compteBancaireRepository;
	@Autowired
    private final ClientRepository clientRepository;
	@Autowired
    private final BanqueRepository banqueRepository;

	public RelationClientBanqueApplication(CompteBancaireRepository compteBancaireRepository, ClientRepository clientRepository, BanqueRepository banqueRepository) {
		this.compteBancaireRepository = compteBancaireRepository;
		this.clientRepository = clientRepository;
		this.banqueRepository = banqueRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RelationClientBanqueApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Client client1=clientRepository.save(new Client(1L,"Habsatou","Thiam",26));
		Client client2=clientRepository.save(new Client(2L,"absatou","Thiam",26));
		Client client3=clientRepository.save(new Client(3L,"satou","Thiam",26));
		Client client4=clientRepository.save(new Client(4L,"Habsa","Thiam",26));

		Banque banque1=banqueRepository.save(new Banque(1L,"BHS","Saint-Louis"));
		Banque banque2=banqueRepository.save(new Banque(2L,"CBAO","Thies"));
		Banque banque3=banqueRepository.save(new Banque(3L,"Reve","Saint-Louis"));

		CompteBancaire compte1=compteBancaireRepository.save(new CompteBancaire(1L, LocalDateTime.now(),1234900.09));
		CompteBancaire compte2=compteBancaireRepository.save(new CompteBancaire(2L, LocalDateTime.now(),2378900.9));
		CompteBancaire compte3=compteBancaireRepository.save(new CompteBancaire(3L, LocalDateTime.now(),1234900.8));
		compte1.setClient(client1);
		compte1.setBanque(banque1);

		//client1.addCompte(compte1);
		//banque1.addClient(client1);
		//banque1.addCompte(compte1);
		//client1.addBanque(banque1);
		//client1.addCompte(compte1);





	}
}

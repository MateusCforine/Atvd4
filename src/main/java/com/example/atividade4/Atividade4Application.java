package com.example.atividade4;

import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Consulta;
import com.example.atividade4.models.Prontuario;
import com.example.atividade4.models.Tutor;
import com.example.atividade4.models.Vacina;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.ConsultaRepository;
import com.example.atividade4.repositories.ProntuarioRepository;
import com.example.atividade4.repositories.TutorRepository;
import com.example.atividade4.repositories.VacinaRepository;
import com.example.atividade4.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class Atividade4Application implements CommandLineRunner {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private VacinaRepository vacinaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Atividade4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("========================================");
        System.out.println(" SISTEMA PETCARE INICIADO COM SUCESSO ");
        System.out.println("========================================");

        Tutor tutor = Tutor.builder()
                .nome("João Silva")
                .cpf("12345678900")
                .telefone("15999999999")
                .endereco("Rua das Flores, 100")
                .build();

        tutor = tutorRepository.save(tutor);

        Animal animal = Animal.builder()
                .nome("Rex")
                .especie("caninos")
                .raca("Golden Retriever")
                .dataNascimento(LocalDate.of(2020, 5, 10))
                .tutor(tutor)
                .build();

        animal = animalRepository.save(animal);

        Veterinario veterinario = Veterinario.builder()
                .nome("Dra. Ana")
                .crmv("CRMV-SP 12345")
                .telefone("15988887777")
                .especializacao("caninos")
                .build();

        veterinario = veterinarioRepository.save(veterinario);

        Consulta consulta = Consulta.builder()
                .dataHora(LocalDateTime.of(2026, 5, 22, 14, 0))
                .local("Sala 01")
                .status("Agendada")
                .animal(animal)
                .veterinario(veterinario)
                .build();

        consulta = consultaRepository.save(consulta);

        Prontuario prontuario = Prontuario.builder()
                .dataAtendimento(LocalDateTime.of(2026, 5, 22, 14, 30))
                .observacoes("Animal apresentou febre e falta de apetite.")
                .animal(animal)
                .veterinario(veterinario)
                .build();

        prontuario = prontuarioRepository.save(prontuario);

        Vacina vacina = Vacina.builder()
                .nomeVacina("Antirrábica")
                .dataAplicacao(LocalDate.of(2026, 5, 22))
                .proximaDose(LocalDate.of(2027, 5, 22))
                .animal(animal)
                .build();

        vacina = vacinaRepository.save(vacina);

        System.out.println();
        System.out.println("========== TUTOR CADASTRADO ==========");
        System.out.println("ID: " + tutor.getId());
        System.out.println("Nome: " + tutor.getNome());
        System.out.println("CPF: " + tutor.getCpf());
        System.out.println("Telefone: " + tutor.getTelefone());
        System.out.println("Endereço: " + tutor.getEndereco());

        System.out.println();
        System.out.println("========== ANIMAL CADASTRADO ==========");
        System.out.println("ID: " + animal.getId());
        System.out.println("Nome: " + animal.getNome());
        System.out.println("Espécie: " + animal.getEspecie());
        System.out.println("Raça: " + animal.getRaca());
        System.out.println("Data de nascimento: " + animal.getDataNascimento());
        System.out.println("Tutor: " + animal.getTutor().getNome());

        System.out.println();
        System.out.println("========== VETERINÁRIO CADASTRADO ==========");
        System.out.println("ID: " + veterinario.getId());
        System.out.println("Nome: " + veterinario.getNome());
        System.out.println("CRMV: " + veterinario.getCrmv());
        System.out.println("Telefone: " + veterinario.getTelefone());
        System.out.println("Especialização: " + veterinario.getEspecializacao());

        System.out.println();
        System.out.println("========== CONSULTA AGENDADA ==========");
        System.out.println("ID: " + consulta.getId());
        System.out.println("Data e hora: " + consulta.getDataHora());
        System.out.println("Local: " + consulta.getLocal());
        System.out.println("Status: " + consulta.getStatus());
        System.out.println("Animal: " + consulta.getAnimal().getNome());
        System.out.println("Veterinário: " + consulta.getVeterinario().getNome());

        System.out.println();
        System.out.println("========== PRONTUÁRIO REGISTRADO ==========");
        System.out.println("ID: " + prontuario.getId());
        System.out.println("Data do atendimento: " + prontuario.getDataAtendimento());
        System.out.println("Observações: " + prontuario.getObservacoes());
        System.out.println("Animal: " + prontuario.getAnimal().getNome());
        System.out.println("Veterinário: " + prontuario.getVeterinario().getNome());

        System.out.println();
        System.out.println("========== VACINA REGISTRADA ==========");
        System.out.println("ID: " + vacina.getId());
        System.out.println("Vacina: " + vacina.getNomeVacina());
        System.out.println("Data de aplicação: " + vacina.getDataAplicacao());
        System.out.println("Próxima dose: " + vacina.getProximaDose());
        System.out.println("Animal: " + vacina.getAnimal().getNome());

        System.out.println();
        System.out.println("========================================");
        System.out.println(" DADOS INICIAIS INSERIDOS COM SUCESSO ");
        System.out.println("========================================");
    }
}
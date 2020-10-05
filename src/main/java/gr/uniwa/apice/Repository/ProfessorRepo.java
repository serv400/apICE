package gr.uniwa.apice.Repository;

import gr.uniwa.apice.Domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepo extends JpaRepository<Professor,Integer> {
        Professor findProfessorByProfId(int id);
}

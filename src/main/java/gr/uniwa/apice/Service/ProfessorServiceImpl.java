package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Professor;
import gr.uniwa.apice.Repository.ProfessorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService{
    @Autowired
    private ProfessorRepo professorRepo;

    @Override
    public Professor findById(int profId) {
        return professorRepo.findProfessorByProfId(profId);
    }

    @Override
    public void deleteProfessor(Professor professor) {
        professorRepo.delete(professor);
    }
}

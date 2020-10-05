package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Professor;

public interface ProfessorService {
    Professor findById(int profId);
    void deleteProfessor(Professor professor);
}

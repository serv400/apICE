package gr.uniwa.apice.Service;

import gr.uniwa.apice.Repository.ProfessorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService{
    @Autowired
    private ProfessorRepo professorRepo;
}

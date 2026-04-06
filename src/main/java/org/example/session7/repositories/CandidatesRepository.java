package org.example.session7.repositories;

import org.example.session7.entities.candidate.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatesRepository extends JpaRepository<Candidate, Long> {
}

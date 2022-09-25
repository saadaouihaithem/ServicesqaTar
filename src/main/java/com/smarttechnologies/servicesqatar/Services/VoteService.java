package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteService extends JpaRepository<Vote,Long>{


}

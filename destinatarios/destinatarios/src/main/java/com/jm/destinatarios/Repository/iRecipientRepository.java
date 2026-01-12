package com.jm.destinatarios.Repository;

import com.jm.destinatarios.Entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRecipientRepository extends JpaRepository<Recipient,Long> {
}

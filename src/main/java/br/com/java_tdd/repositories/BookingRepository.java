package br.com.java_tdd.repositories;

import br.com.java_tdd.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, String> {

    Optional<BookingModel> findByReserveName(String name);

}

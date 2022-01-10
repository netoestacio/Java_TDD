package br.com.java_tdd.services;

import br.com.java_tdd.model.BookingModel;
import br.com.java_tdd.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public Integer daysCalculatorWithDataBase(String name) {
        Optional<BookingModel> bookingModelOptional = repository.findByReserveName(name);

        if(bookingModelOptional.isPresent()){
            return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut()).getDays();
        }else{
            return 0;
        }

    }
}

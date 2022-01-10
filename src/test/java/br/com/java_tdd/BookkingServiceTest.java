package br.com.java_tdd;

import br.com.java_tdd.model.BookingModel;
import br.com.java_tdd.repositories.BookingRepository;
import br.com.java_tdd.services.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class BookkingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration {
        @Bean
        public BookingService bookingService(){
            return new BookingService();
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDaysCalculator(){
        String name = "Pedro";
        Integer days = bookingService.daysCalculatorWithDataBase(name);

        Assertions.assertEquals(days, 10);
    }

    @Before
    public void setup(){
        LocalDate checkIn = LocalDate.parse("2022-01-01");
        LocalDate checkOut = LocalDate.parse("2022-01-11");
        BookingModel model = new BookingModel("1", "Pedro", checkIn, checkOut, 2);

        Mockito.when(bookingRepository
                        .findByReserveName(model.getReserveName()))
                        .thenReturn(Optional.of(model));
    }

}

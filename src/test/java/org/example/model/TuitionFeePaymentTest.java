package org.example.model;

import org.example.service.TuitionFeePayment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
     void setup(){
        tuitionFeePayment = new TuitionFeePayment();
    }
    @Test
    @DisplayName("Calculation of Tuition Fee")
    void shouldReturnCorrectCalculationOfTuitionFee(){
        //Act
        tuitionFeePayment.calculateTuitionFee(3, 0);

        //Assert
        assertEquals(3000, tuitionFeePayment.calculateTuitionFee(3,0));
    }
    @Test
    void shouldReturnCurrentCalculationOfTuitionFeeWithTenPercentDiscount(){
        //Act
        tuitionFeePayment.calculateTuitionFee(3, 0.10);

        //Assert
        assertEquals(2700, tuitionFeePayment.calculateTuitionFee(3,.10));

    }
    @Test
    void shouldMakeAPayment(){
        tuitionFeePayment.calculateTuitionFee(3,.10);

        //Act
        tuitionFeePayment.makePayment(1000);

        //Assert
        assertEquals(1700, tuitionFeePayment.getRemainingBalance());
    }
    @Test
    void shouldCheckIfTuitionFeeIsNotFullyPaid(){
        //Act
        tuitionFeePayment.makePayment(1000);

        //Assert
        assertFalse(tuitionFeePayment.isFullyPaid());
    }
    @Test
    void shouldCheckIFTuitionFeeIsFullyPaid(){
        //Act
        tuitionFeePayment.calculateTuitionFee(3, .10);

        //Assert
        assertTrue(tuitionFeePayment.isFullyPaid());
    }
}
package com.iesam.firsttime.features.vote.domain;

import com.iesam.firsttime.features.vote.data.Stub1AppConfigDataRepository;
import com.iesam.firsttime.features.vote.data.Stub2AppConfigDataRepository;
import com.iesam.firsttime.features.vote.data.StubAppConfigDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VoteAppUseCaseTest {
    private VoteAppUseCase voteAppUseCase;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        voteAppUseCase = null;
    }

    @Test
    public void cuandoObtengoUnNuloEntoncesNoMuestroElMensaje() {
        //Given: se declaran variables.
        voteAppUseCase= new VoteAppUseCase(
                new StubAppConfigDataRepository()
        );

        //When
        boolean vote = voteAppUseCase.execute();

        //Then
        Assertions.assertFalse(vote);
    }

    @Test
    public void cuandoObtengoUnCincoEntoncesMuestroElMensaje() {
        //Given: se declaran variables.
        voteAppUseCase = new VoteAppUseCase(
                new Stub1AppConfigDataRepository()
        );
        //When
        boolean vote = voteAppUseCase.execute();

        //Then
        Assertions.assertTrue(vote);
    }

    @Test
    public void cuandoObtengoUnNumeroDistintoDeCincoEntoncesNoMuestroElMensaje() {
        //Given: se declaran variables.
        voteAppUseCase = new VoteAppUseCase(
                new Stub2AppConfigDataRepository()
        );
        //When
        boolean vote = voteAppUseCase.execute();

        //Then
        Assertions.assertFalse(vote);
    }
}

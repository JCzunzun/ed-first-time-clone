package com.iesam.firsttime.features.appconfig.domain;


import com.iesam.firsttime.features.appconfig.data.Stub1AppConfigDataRepository;
import com.iesam.firsttime.features.appconfig.data.StubAppConfigDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IncrementAppOpenedUseCaseTest {
    private IncrementAppOpenedUseCase appOpenedUseCase;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        appOpenedUseCase = null;
    }

    @Test
    public void cuandoObtengoUnFicheroComprueboQueNoSeaNulo() {
        //Given: se declaran variables.
        appOpenedUseCase= new IncrementAppOpenedUseCase(
                new StubAppConfigDataRepository()
        );
        StubAppConfigDataRepository appConfigDataRepository= new StubAppConfigDataRepository();
        //When
        appOpenedUseCase.execute();

        //Then
        AppConfig savedConfig=  appConfigDataRepository.getAppConfig();
        Assertions.assertNotNull(savedConfig); //verificamos que el archivo no sea nulo
        Assertions.assertEquals(0,savedConfig.countTimeOpened); //verificamos que el contador se haya iniciado
    }

    @Test
    public void cuandoNoObtengoUnCeroAumentoElContador() {
        //Given: se declaran variables.
        appOpenedUseCase = new IncrementAppOpenedUseCase(
                new Stub1AppConfigDataRepository()
        );
        StubAppConfigDataRepository configDataRepository= new StubAppConfigDataRepository();
        AppConfig configAntes = configDataRepository.getAppConfig();
        Assertions.assertNotNull(configAntes,"el archivo es nulo");
        int contadorAntes =configAntes.countTimeOpened;

        //When
        appOpenedUseCase.execute();

        //Then
        AppConfig saveConfig = configDataRepository.getAppConfig();
        Assertions.assertNotNull(saveConfig);
        int contadorDespues=saveConfig.countTimeOpened;
        Assertions.assertEquals(contadorAntes+1,contadorDespues,"no se incremento en 1");//comparamos el contador que creamos antes de ejecutar +1 y el de despues
    }


}

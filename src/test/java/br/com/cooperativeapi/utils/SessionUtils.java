package br.com.cooperativeapi.utils;

import br.com.cooperativeapi.entity.session.Session;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SessionUtils {

    public static Session create() {
        return Session.builder()
                .id(1)
                .openDate(LocalDateTime.now())
                .closeDate(LocalDateTime.now().plus(100, ChronoUnit.MINUTES))
                .build();
    }
}

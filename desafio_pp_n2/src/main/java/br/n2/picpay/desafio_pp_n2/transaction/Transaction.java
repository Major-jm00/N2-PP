package br.n2.picpay.desafio_pp_n2.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A classe Transaction é um registro que representa uma transação.
 * Ela contém detalhes sobre a transação, como id, pagador, beneficiário, valor e data de criação.
 *
 * @param id O ID da transação.
 * @param payer O ID do pagador da transação.
 * @param payee O ID do beneficiário da transação.
 * @param value O valor da transação.
 * @param createdAt A data e hora de criação da transação.
 */

@Table("TRANSACTIONS")
public record Transaction(
        @Id Long id,
        Long payer,
        Long payee,
        BigDecimal value,
        @CreatedDate LocalDateTime createdAt) {
    public Transaction {
        value = value.setScale(2);
    }
}
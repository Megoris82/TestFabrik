	CREATE DATABASE contocorrente;

    create table transaction (
       transactionId bigint not null,
        accountingDate datetime,
        amount double precision,
        currency varchar(255),
        description varchar(255),
        operationId varchar(255),
        type varchar(200),
        valueDate datetime,
        primary key (transactionId)
    ) engine=InnoDB;

CREATE DATABASE java_test;

-- CREATE SCHEMA
CREATE SCHEMA IF NOT EXISTS clients;

-- TABLE PERSON
CREATE TABLE IF NOT EXISTS clients.persons
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    identification VARCHAR(15) UNIQUE NOT NULL,
    name           VARCHAR(100)       NOT NULL,
    gender         CHAR(1)            NOT NULL NOT NULL CHECK (gender IN ('M', 'F', 'O')),
    birthdate      DATE               NOT NULL,
    address        VARCHAR(255),
    phone          VARCHAR(15)
);

-- INDEXES FOR PERSON
CREATE INDEX person_name_idx ON clients.persons (name);
CREATE INDEX person_identification_idx ON clients.persons (identification);

-- TABLE CLIENT
CREATE TABLE IF NOT EXISTS clients.clients
(
    id       BIGINT PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    status   BOOLEAN      NOT NULL DEFAULT TRUE,
    CONSTRAINT client_person_fk FOREIGN KEY (id) REFERENCES clients.persons (id) ON DELETE CASCADE
);

CREATE SCHEMA IF NOT EXISTS accounts;

-- TABLE ACCOUNT
CREATE TABLE IF NOT EXISTS accounts.accounts
(
    account_number  VARCHAR(20)    PRIMARY KEY,
    account_type    VARCHAR(50)    NOT NULL NOT NULL CHECK (account_type IN ('SAVINGS', 'CURRENT')),
    initial_balance DECIMAL(15, 2) NOT NULL CHECK (initial_balance >= 0),
	balance			DECIMAL(15,2)  NOT NULL CHECK (initial_balance >= 0),
    status          BOOLEAN        NOT NULL DEFAULT TRUE,
    client_id       int4,
    CONSTRAINT account_client_fk FOREIGN KEY (client_id) REFERENCES clients.clients ON DELETE CASCADE
);

CREATE INDEX account_client_id_idx ON accounts.accounts (client_id);

-- TABLE TRANSACTION
CREATE TABLE IF NOT EXISTS accounts.transactions
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    account_number   VARCHAR(20),
    date             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    transaction_type VARCHAR(50)    NOT NULL CHECK (transaction_type IN ('DEPOSIT', 'WITHDRAWAL')),
    amount           DECIMAL(15, 2) NOT NULL CHECK (amount != 0),
    balance          DECIMAL(15, 2) NOT NULL CHECK (balance >= 0),
	observation      VARCHAR(50),
    CONSTRAINT transaction_account_number_fk FOREIGN KEY (account_number) REFERENCES accounts.accounts ON DELETE CASCADE
);

-- INDEX FOR TRANSACTION
CREATE INDEX transaction_account_number_Idx ON accounts.transactions (account_number);
CREATE INDEX transaction_date_idx ON accounts.transactions (date);

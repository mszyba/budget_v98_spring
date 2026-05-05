CREATE TABLE if not exists category (
                            id   BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE if not exists subcategory (
                               id          BIGINT AUTO_INCREMENT PRIMARY KEY,
                               name        VARCHAR(100) NOT NULL,
                               category_id BIGINT NOT NULL
);

CREATE TABLE if not exists transaction (
                              id              BIGINT AUTO_INCREMENT PRIMARY KEY,
                              date            DATE           NOT NULL,
                              amount          DECIMAL(15,2)  NOT NULL,
                              type            VARCHAR(20)    NOT NULL,
                              category_id     BIGINT,
                              subcategory_id  BIGINT,
                              description     VARCHAR(500),
                              amount_foreign  DECIMAL(15,2),
                              exchange_rate   DECIMAL(10,6)
);
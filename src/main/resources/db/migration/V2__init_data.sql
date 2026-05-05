INSERT INTO category (name) VALUES
                                ('Jedzenie'),
                                ('Transport'),
                                ('Mieszkanie'),
                                ('Rozrywka'),
                                ('Zdrowie'),
                                ('Edukacja'),
                                ('Zakupy'),
                                ('Podróże'),
                                ('Oszczędności'),
                                ('Inne');


INSERT INTO subcategory (name, category_id) VALUES
                                                ('Restauracje', 1),
                                                ('Spożywcze', 1),
                                                ('Paliwo', 2),
                                                ('Komunikacja publiczna', 2),
                                                ('Czynsz', 3),
                                                ('Media', 3),
                                                ('Kino', 4),
                                                ('Siłownia', 5),
                                                ('Kursy online', 6),
                                                ('Ubrania', 7);


INSERT INTO transaction
(date, amount, type, category_id, subcategory_id, description, amount_foreign, exchange_rate)
VALUES
    ('2026-04-01', 45.50, 'EXPENSE', 1, 1, 'Obiad w restauracji', NULL, NULL),
    ('2026-04-02', 120.30, 'EXPENSE', 1, 2, 'Zakupy spożywcze', NULL, NULL),
    ('2026-04-03', 200.00, 'EXPENSE', 2, 3, 'Tankowanie samochodu', NULL, NULL),
    ('2026-04-04', 90.00, 'EXPENSE', 2, 4, 'Bilet miesięczny', NULL, NULL),
    ('2026-04-05', 1800.00, 'EXPENSE', 3, 5, 'Czynsz za mieszkanie', NULL, NULL),
    ('2026-04-06', 350.00, 'EXPENSE', 3, 6, 'Prąd i gaz', NULL, NULL),
    ('2026-04-07', 30.00, 'EXPENSE', 4, 7, 'Bilet do kina', NULL, NULL),
    ('2026-04-08', 150.00, 'EXPENSE', 5, 8, 'Karnet na siłownię', NULL, NULL),
    ('2026-04-09', 500.00, 'EXPENSE', 6, 9, 'Kurs programowania', NULL, NULL),
    ('2026-04-10', 250.00, 'EXPENSE', 7, 10, 'Zakup bluzy', NULL, NULL);

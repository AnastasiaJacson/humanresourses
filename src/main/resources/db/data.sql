INSERT INTO employees (id, firstName, lastName, middleName, dateOfBirth, dateOfHire , salary,
department, position, sex, ismarried)
VALUES (1, 'Оксана', 'Грушевська', 'Аркадіївна', '1992-03-26', '2020-01-26', 15000,
        'Технічний відділ', 'інженерка', TRUE, TRUE),
       (2, 'Максим', 'Блаженко', 'Орестович', '1975-12-19', '2020-02-10', 20000,
        'Технічний відділ', 'інженер', FALSE, FALSE),
       (3, 'Оля', 'Янішевська', 'Юріївна', '1981-01-12', '2020-02-23', 25000,
        'Технічний відділ', 'тестувальник', TRUE, FALSE),
       (4, 'Анна', 'Дуліба', 'Мирославівна', '1990-01-26', '2020-02-28', 19000,
        'Технічна підтримка', 'оператор', TRUE, TRUE),
       (5, 'Андрій', 'Татарин', 'Олексійович', '1976-10-10', '2020-03-18', 22000,
        'Технічна підтримка', 'оператор', FALSE, FALSE),
       (6, 'Денис', 'Холопенко', 'Олександрович', '1972-03-15', '2020-03-25', 24000,
        'Технічна підтрика', 'адміністратор', FALSE, FALSE),
       (7, 'Юля', 'Ясінська', 'Юріївна', '1986-01-10', '2020-03-31', 23000,
        'Технічний відділ', 'інженерка', TRUE, FALSE),
       (8, 'Тетяна', 'Стахова', 'Володимирівна', '1992-05-19', '2020-04-05', 24000,
        'Бугалтерія', 'головний бугалтер', TRUE, TRUE),
       (9, 'Орест', 'Соколинський', 'Ігорович', '1984-04-12', '2020-04-10', 20000,
        'Технічний відділ', 'інженер', FALSE, FALSE),
       (10, 'Владислав', 'Романов', 'Вікторович', '1986-05-19', '2020-04-20', 26000,
        'Технічна підтримка', 'оператор', FALSE, FALSE),
       (11, 'Тарас', 'Чуба', 'Антонович', '2000-12-23', '2020-05-13', 15000,
        'Технічний відділ', 'інженер', FALSE, TRUE),
       (12, 'Марк', 'Горбаченко', 'Денисович', '1999-12-19', '2020-06-10', 21000,
        'Бугалтерія', 'бугалтер', FALSE, FALSE);
SELECT setval('employees_id_seq', 12);
       
      
insert into roles(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id, description)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Admin'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Manager'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Employee');


insert into users(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id, enabled,
                  first_name, gender, last_name, user_name, role_id)
values ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, true, 'admin', 'MALE', 'admin', 'admin@admin.com',
        1);

insert into users(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id, enabled,
                  first_name, gender, last_name, user_name, role_id)
values ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, true, 'John', 'MALE', 'cudeo', 'john@cydeo.com',
        2);

insert into users(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id, enabled,
                  first_name, gender, last_name, user_name, role_id)
values ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, true, 'Abc', 'MALE', 'Def', 'abc@cydeo.com',
        3);

insert into projects(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id, end_date,
                     project_code, project_detail, project_name, project_status, start_date, manager_id)
values ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '2022-01-15', 'PR001', 'project...', 'Spring DI',
        'OPEN', '2022-01-05', 2);

insert into tasks(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                  assigned_date, task_detail, task_status, task_subject, project_id, employee_id)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '2022-01-05', 'jsıfjsd', 'OPEN', 'DI', 1, 3);
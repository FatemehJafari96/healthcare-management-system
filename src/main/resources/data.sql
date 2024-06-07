delete from user_ where email='fatemeh@gmail.com';
INSERT INTO user_ (first_name, last_name, email, password, role) VALUES
            ('fatemeh', 'jafari', 'fatemeh@gmail.com',
             '$2a$04$RZsL0kD/VHs0UU2maqA86OK1H08A18/78aooPcZ1zuLVH0TuWszkG', 'USER');

-- Delete existing user
DELETE FROM user_ WHERE email='john.doe@gmail.com';

-- Insert new user
INSERT INTO user_ (first_name, last_name, email, password, role) VALUES
    ('John', 'Doe', 'john.doe@gmail.com',
     '$2a$04$RZsL0kD/VHs0UU2maqA86OK1H08A18/78aooPcZ1zuLVH0TuWszkG', 'PATIENT');

-- Delete existing user
DELETE FROM user_ WHERE email='jane.smith@gmail.com';

-- Insert new user
INSERT INTO user_ (first_name, last_name, email, password, role) VALUES
    ('Jane', 'Smith', 'jane.smith@gmail.com',
     '$2a$04$RZsL0kD/VHs0UU2maqA86OK1H08A18/78aooPcZ1zuLVH0TuWszkG', 'HEALTHCARE');

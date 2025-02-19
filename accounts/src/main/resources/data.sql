INSERT INTO CUSTOMER (name, email, mobile_number, create_dt)
VALUES ('John Doe', 'john.doe@example.com', '1234567890', CURRENT_DATE);

INSERT INTO ACCOUNT (customer_id, account_number, account_type, branch_address, create_dt)
VALUES (1, 1000000001, 'SAVINGS', '123 Main Street, NY', CURRENT_DATE);

INSERT INTO ACCOUNT (customer_id, account_number, account_type, branch_address, create_dt)
VALUES (1, 1000000002, 'CHECKING', '123 Main Street, NY', CURRENT_DATE);
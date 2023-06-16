CREATE TABLE users (
  id BINARY(16) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  created TIMESTAMP,
  modified TIMESTAMP,
  isActive BOOLEAN
);

CREATE TABLE phones (
  id BINARY(16) PRIMARY KEY,
  cel_number VARCHAR(255) NOT NULL,
  code_city VARCHAR(255),
  code_country VARCHAR(255),
  user_id BINARY(16) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

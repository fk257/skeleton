CREATE TABLE receipts (
  id INT UNSIGNED AUTO_INCREMENT,
  created TIME DEFAULT CURRENT_DATE (),
  merchant VARCHAR(255),
  amount DECIMAL(12,2),

  PRIMARY KEY (id)
);

CREATE TABLE receipt_tags (
  id INT UNSIGNED AUTO_INCREMENT,
  tag VARCHAR(32),
  receipt_id INT
);
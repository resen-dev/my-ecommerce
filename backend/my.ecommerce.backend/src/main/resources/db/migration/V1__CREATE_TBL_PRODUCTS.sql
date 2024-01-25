CREATE TABLE IF NOT EXISTS TBL_PRODUCTS (
    ID SERIAL PRIMARY KEY,
    NAME TEXT NOT NULL CHECK (LENGTH(NAME) <= 30)
);

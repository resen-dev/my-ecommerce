ALTER TABLE TBL_USER
ADD COLUMN IF NOT EXISTS USERNAME TEXT CHECK (LENGTH(USERNAME) <= 20) UNIQUE;

DO $$ BEGIN
    CREATE TYPE bean_type AS ENUM('roasted', 'not_roasted');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

CREATE TABLE IF NOT EXISTS coffee (
    id          UUID NOT NULL DEFAULT gen_random_uuid(),
    bean_type   bean_type NOT NULL,
    title       TEXT NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY(id)
);

CREATE INDEX IF NOT EXISTS "coffee_title_idx" ON coffee("title");
CREATE INDEX IF NOT EXISTS "coffee_created_at_idx" ON coffee("created_at");


---------------------- TESTDATA ----------------------
insert into coffee(bean_type, title) values ('roasted', 'KraugeBeans');
insert into coffee(bean_type, title) values ('not_roasted', 'NetBeans');
insert into coffee(bean_type, title) values ('not_roasted', 'ConfigurationBeans');
insert into coffee(bean_type, title) values ('roasted', 'Beans');
insert into coffee(bean_type, title) values ('not_roasted', 'Bønner fra KB');
insert into coffee(bean_type, title) values ('not_roasted', 'Ukjente bønner fra shady kilde');
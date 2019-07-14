# --- Ups!
CREATE TABLE "todo" (
    "id"        INT auto_increment PRIMARY KEY,
    "title"     VARCHAR(30) NOT NULL,
    "content"   VARCHAR(200) NOT NULL,
    "create_at" DATE NOT NULL,
    "update_at" DATE NOT NULL
);
INSERT INTO "todo" ("id", "title", "content", "create_at")
    VALUES (default, '今日の買い物', 'じゃがいも/にんじん/牛肉/玉ねぎ', '2019-07-14');
INSERT INTO "todo" ("id", "title", "content", "create_at")
    VALUES (default, '明日の持ち物', 'メモ/筆記用具/印鑑/PC', '2019-07-14');

# ---Downs!
DROP DATABASE "todo"

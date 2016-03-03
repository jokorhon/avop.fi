-- study_right_id -> 'avain' @ VIRTA
-- arvo_answer_hash -> hashed answer credentials key @ Arvo
CREATE TABLE visitors
(id SERIAL PRIMARY KEY,
 study_right_id VARCHAR(100),
 arvo_answer_hash VARCHAR(255),
 login_time TIMESTAMP);

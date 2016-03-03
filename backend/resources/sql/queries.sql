-- :name create-visitor! :! :n
-- :doc creates a new visitor record
INSERT INTO visitors
(study_right_id, arvo_answer_hash, login_time)
VALUES (:study_right_id, :arvo_answer_hash, now())

-- :name get-visitors-by-srid :? :*
-- :doc retrieve visitors for certan study right id
SELECT * FROM visitors
WHERE study_right_id = :study_right_id

-- :name get-mapping-by-domain :? :1
-- :doc get Haka to VIRTA organization mapping by domain
SELECT * FROM organization_mappings
WHERE domain = :domain
-- :name create-visitor! :! :n
-- :doc creates a new visitor record
INSERT INTO visitors
(opiskeluoikeus_id, oppilaitos_id, arvo_answer_hash, login_time)
VALUES (:opiskeluoikeus_id, :oppilaitos_id, :arvo_answer_hash, now())

-- :name get-visitor-by-srid :? :1
-- :doc retrieve visitor for certan study right id
SELECT * FROM visitors
WHERE opiskeluoikeus_id = :opiskeluoikeus_id

-- :name get-mapping-by-domain :? :1
-- :doc get Haka to VIRTA organization mapping by domain
SELECT * FROM organization_mappings
WHERE domain = :domain

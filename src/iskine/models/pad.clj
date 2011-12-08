(ns iskine.models.pad
  (:require korma.db
            korma.core))

(defdb db (sqlite3 {:db "iskine"}))

(defentity pads)

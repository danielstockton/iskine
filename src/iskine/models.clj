(ns iskine.models
  (:use somnium.congomongo))

(def conn (make-connection "iskine"
                                :host "127.0.0.1"
                                :port 27017))

(defn init []
  (set-connection! conn))

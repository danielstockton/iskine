(ns iskine.server
  (:require [noir.server :as server]
            [iskine.models :as models]))

(server/load-views "src/iskine/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (models/init)
    (server/start port {:mode mode
                        :ns 'iskine})))


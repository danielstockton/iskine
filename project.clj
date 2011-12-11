(defproject iskine "0.1.0-SNAPSHOT"
            :description "Simple Notebook App"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.0"]
                           [congomongo "0.1.7"]]
            :dev-dependencies [[org.clojars.scott/lein-nailgun "1.1.0"]]
            :main iskine.server)


(ns iskine.views.home
  (:require [iskine.views.common :as common]
            [noir.response :as resp])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defn randchar
  "returns a random alphanumeric character"
  []
  (let [alphanum (concat (range 48 58) (range 65 91) (range 97 123))]
    (char (nth alphanum (rand (count alphanum))))))

(defn randstring 
  "returns a randomised string of length 10"
  []
  (apply str (take 10 (repeatedly randchar))))


(defpage "/" []
          (resp/redirect (str "/" (randstring))))

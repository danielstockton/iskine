(ns iskine.views.home
  (:require [iskine.views.common :as common]
            [noir.response :as resp])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defn randchar
  "returns a random alphanumeric character"
  []
  (char (nth (range 48 122) (rand (count (range 48 122))))))

(defn randstring 
  "returns a randomised string"
  []
  (apply str (take 10 (repeatedly randchar))))


(defpage "/" []
          (resp/redirect (str "/" (randstring))))

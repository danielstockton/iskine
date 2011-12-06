(ns iskine.views.home
  (:require [iskine.views.common :as common])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defpage "/" []
         (common/layout
           [:p "Welcome to iskine"]))

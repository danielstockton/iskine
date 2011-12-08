(ns iskine.views.notepad
  (:require [iskine.views.common :as common])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers
        hiccup.form-helpers))

(defpartial notepad [{:keys [notepad]}]
            [:section.notepad {:contenteditable "true"}])

(defpage "/:id" {:keys [id]}
         (common/layout
           (notepad id)))

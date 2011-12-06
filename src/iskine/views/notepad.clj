(ns iskine.views.notepad
  (:require [iskine.views.common :as common])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers
        hiccup.form-helpers))

(defpartial notefield [{:keys [note]}]
  (text-field "note" note))

(defpage "/:id" {:keys [id]}
         (common/layout
           [:h1 "Notepad: " id]
           (form-to [:post (str "/" id "/submit")]
            (notefield id)
            (submit-button "Submit"))))

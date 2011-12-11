(ns iskine.views.notepad
  (:require [iskine.views.common :as common])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers
        hiccup.form-helpers
        somnium.congomongo))

(defpartial notepad [{:keys [notepad]}]
            [:section.notepad {:contenteditable "true"}])

(defpage "/:id" {:keys [id]}
         (when-not (fetch-one
                     :pads
                     :where {:name id})
           (insert! :pads {:name id}))
         (common/layout
           (notepad id)))

(defpage [:post "/:id"] {:keys [id content]}
         (def pad (fetch-one 
                    :pads
                    :where {:name id})) 
         (update! :pads pad (merge pad {:content content})))

(defpage [:post "/:id/protect"] {:keys [password]}
         (insert! :pads {:password password}))

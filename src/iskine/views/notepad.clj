(ns iskine.views.notepad
  (:require [iskine.views.common :as common]
            [noir.cookies :as cookies]
            [noir.response :as resp])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers
        hiccup.form-helpers
        somnium.congomongo))

(defn protected? [id]
  (:password (fetch-one :pads :where {:name id})))

(defn has-access? [id]
  (= (cookies/get (keyword id)) (:password (fetch-one :pads :where {:name id}))))

(defpartial lock [id]
            (form-to {:id "passform"} [:post (str "/" id "/protect")]
                     (text-field "password")
                     (submit-button "Lock")))

(defpartial login [id]
            (form-to [:post (str "/" id "/authorise")]
                     (text-field "password")
                     (submit-button "Unlock")))

(defpartial notepad [id]
            [:section#notepad {:contenteditable "true"} (:content (fetch-one :pads :where {:name id}))])

(defpage [:post "/:id/authorise"] {:keys [id password]}
         (if (= password (:password (fetch-one :pads :where {:name id})))
           (do (cookies/put! (keyword id) password)
             (resp/redirect (str "/" id)))
           (resp/redirect (str "/" id "/login"))))

(defpage [:any "/:id"] {:keys [id]}
         (if (protected? id)
           (if (has-access? id)
             (common/layout 
               id 
               (notepad id)
               (lock id))
             (resp/redirect (str "/" id "/login")))
           (do
             (insert! :pads {:name id})
             (common/layout id 
                            (notepad id)
                            (lock id)))))

(defpage "/:id/login" {:keys [id]}
         (common/layout
           id
           (login id)))

(defpage [:post "/:id/update"] {:keys [id content]}
         (def pad (fetch-one 
                    :pads
                    :where {:name id})) 
         (update! :pads pad (merge pad {:content content})))

(defpage [:post "/:id/protect"] {:keys [id password]}
         (def pad (fetch-one 
                    :pads
                    :where {:name id})) 
         (if (and (protected? id) (has-access? id))
           (update! :pads pad (merge pad {:password password}))
           (update! :pads pad (merge pad {:password password}))))

(defpage [:post "/:id/rename"] {:keys [id rename]}
         (def pad (fetch-one
                    :pads
                    :where {:name id}))
         (update! :pads pad (merge pad {:name rename})))

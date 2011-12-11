(ns iskine.views.common
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defpartial layout [& content]
            (html5
              [:head
               [:title "iskine"]
               (include-js "/js/notepad.js")
               (include-css "/css/reset.css")
               (include-css "http://fonts.googleapis.com/css?family=Bitter")
               (include-css "/css/style.css")]
              [:body
               [:div#toolbar
                [:div#logo (link-to "/" "iskine")]
                [:div#nav
                 [:ul
                  [:li (link-to "/protect" "protect")]
                  [:li (link-to "/rename" "rename")]]]]
               [:div#wrapper
                content]]))

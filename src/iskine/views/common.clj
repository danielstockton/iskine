(ns iskine.views.common
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defpartial layout [id & content]
            (html5
              [:head
               [:title "iskine"]
               (include-js "http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js")
               (include-js "https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js")
               (include-js "/js/notepad.js")
               (include-css "/css/reset.css")
               (include-css "http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/themes/base/jquery-ui.css")
               (include-css "http://fonts.googleapis.com/css?family=Bitter")
               (include-css "/css/style.css")]
              [:body
               [:div#toolbar
                [:div#logo (link-to "/" "iskine")]
                [:div#nav
                 [:ul
                  [:li (link-to {:id "protect"} (str "/" id "/protect") "protect")]
                  [:li (link-to {:id "rename"} (str "/" id "/rename") "rename")]]]]
               [:div#wrapper
                content]]))

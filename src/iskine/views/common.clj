(ns iskine.views.common
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defpartial layout [& content]
            (html5
              [:head
               [:title "iskine"]
               (include-css "/css/reset.css")
               (include-css "/css/style.css")]
              [:body
               [:div#toolbar
                "iskine"]
               [:div#wrapper
                content]]))

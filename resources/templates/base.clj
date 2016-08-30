(ns templates.base
  (require [hiccup.core :as h]
           [hiccup.page :as hp]))

(defn base-head []
  [:head
   [:meta {:content "text/html; charset=UTF-8", :http-equiv "Content-Type"}]
   [:meta {:content "width=device-width, initial-scale=1", :name "viewport"}]
   [:title "Welcome to guestbook"]
   [:h2 "Welcome to Guestbook!"]
   (hp/include-css "/css/screen.css"
                   "/assets/bootstrap/css/bootstrap.min.css"
                   "/assets/font-awesome/css/font-awesome.min.css")
   ])

(defn base-navbar []
  [:nav {:class="navbar navbar-light bg-faded" :role="navigation"}
   [:button {:class="navbar-toggler hidden-sm-up"
             :type="button"
             :data-toggle="collapse"
             :data-target="#collapsing-navbar"}]
   [:div {:class="collapse navbar-toggleable-xs" :id="collapsing-navbar"}
    [:a {:class="navbar-brand" :href="{{servlet-context}}/"}]
    [:ul {:class="nav navbar-nav"}
     [:li {:class= "nav-item"}
      [:a {:href="{{servlet-context}}/"
           :class="nav-link{% ifequal page ome.html %} active{%endifequal%}"}]]
     [:li {:class= "nav-item"}
      [:a {:href="{{servlet-context}}/about"
           :class="nav-link{% ifequal page"}]]]]])





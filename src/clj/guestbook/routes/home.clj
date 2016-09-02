(ns guestbook.routes.home
  (:require [guestbook.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [guestbook.db.core :as d]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [hiccup.core :as h]
            [hiccup.page :as hp]
            [templates.home :as home]))

#_(defn home-page [] (layout/render
                     "home.html"
                     {:messages (d/get-messages)}))

(defn home-page []
  (h/html (home/home-render (d/get-messages))))

(defn about-page []
  (layout/render "about.html"))

(defn save-message! [{:keys [params]}]
  (d/save-message!
    (assoc params :timestamp (java.util.Date.)))
  (response/found "/"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/message" request (save-message! request)))


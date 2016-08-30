(ns templates.home
  (require [hiccup.core :as h]
           [hiccup.page :as hp]
           [templates.base :as b]))

(defn home-render [m]
  [:html
   (b/base-head)
   [:body
    [:div {:xmlns "http://www.w3.org/1999/html", :class "row"}
     [:div {:class "span12"}
      [:ul {:class "content"}
       (for [item m]
         [:li
          [:p (:message item)]
          [:p "- " (:name item)]])]]]
    [:div {:class "row"}
     [:div {:class "span12"}
      [:form {:method "POST" :action "/message"}
       [:div {:class "form-group"}
        (anti-forgery-field)
        [:p
         "Name:"
         [:input {:class "form-control" :type "text" :name "name"
                  :value ""}]]
        [:p
         "Message:"
         [:textarea {:class "form-control" :rows "4" :cols "50"
                     :name "message"}]]
        [:input {:type "submit" :class "btn btn-primary" :value "comment"}]]]]]
    ]])

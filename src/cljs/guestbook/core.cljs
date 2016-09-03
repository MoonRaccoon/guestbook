(ns guestbook.core
    (:require [reagent.core :as reagent :refer [atom]]))

(-> (.getElementById js/document "content")
    (.-innerHTML)
    (set! "Hello, Bitchboiiiii"))
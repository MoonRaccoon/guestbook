(ns user
  (:require [mount.core :as mount]
            guestbook.core))

(defn start []
  (mount/start-without #'guestbook.core/repl-server))

(defn stop []
  (mount/stop-except #'guestbook.core/repl-server))

(defn restart []
  (stop)
  (start))


;;Delete below

;;(require '[guestbook.db.core :refer :all])

#_(mount/start #'guestbook.db.core/*db*
             )


#_(save-message! {:name      "Shamwow",
                :message   "Shamcow",
                :timestamp (java.util.Date.)})

#_(get-messages)

#_(save-message! {:name "Shamwow",
                :message "Shampow, Shampoo, Shambow, Shamrow, ShamNOW!",
                :timestamp (java.util.Date.)})

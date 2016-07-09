(ns chjoori-app.state
  (:require [chjoori-app.react-native :refer [get-initial-url app-state-changes]]))



(defonce app-state (atom {:greeting "Hello Clojure in iOS and Android!"}))

(defonce initial-url (atom nil))
(.. (get-initial-url)
    (then #(reset! initial-url %)))
(app-state-changes
 (fn [& _]
   (.. (get-initial-url)
       (then #(reset! initial-url %)))))

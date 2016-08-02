(ns chjoori-app.state
  (:require [react-native.utils :refer [get-initial-url app-state-changes]]
            [rum.core :as rum]))



(defonce app-state (atom {:greeting "Hello Clojure in iOS and Android!"}))

(defonce initial-url (atom nil))
(.. (get-initial-url)
    (then #(reset! initial-url %)))
(app-state-changes
 (fn [& _]
   (.. (get-initial-url)
       (then #(reset! initial-url %)))))

(defonce route (atom nil))
(def current-route (rum/derived-atom [route] ::key first))

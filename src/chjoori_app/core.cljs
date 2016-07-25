(ns chjoori-app.core
  (:require [re-natal.support :as support]
            [chjoori-app.root-component :refer [AppRoot]]
            [chjoori-app.state :refer [current-route]]
            [react-native.utils :refer [register-component]]))



(defonce root-component-factory (support/make-root-component-factory))
(defn mount-app [] (support/mount (AppRoot)))
(defn init []
  (reset! current-route [:register])
  (mount-app)
  (register-component "chjooriApp" (fn [] root-component-factory)))

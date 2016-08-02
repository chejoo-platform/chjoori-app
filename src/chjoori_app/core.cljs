(ns chjoori-app.core
  (:require [re-natal.support :as support]
            [chjoori-app.root-component :refer [AppRoot]]
            [chjoori-app.routing :as routing]
            [react-native.utils :refer [register-component]]))



(defonce root-component-factory (support/make-root-component-factory))
(defn mount-app [] (support/mount (AppRoot)))
(defn init []
  (routing/reset [:register])
  (mount-app)
  (register-component "chjooriApp" (fn [] root-component-factory)))

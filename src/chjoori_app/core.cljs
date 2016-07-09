(ns chjoori-app.core
  (:require [re-natal.support :as support]
            [chjoori-app.pages.register.layout :refer [AppRoot]]
            [react-native.utils :refer [register-component]]
            [chjoori-app.state :refer [app-state]]))



(defonce root-component-factory (support/make-root-component-factory))
(defn mount-app [] (support/mount (AppRoot app-state)))
(defn init []
  (mount-app)
  (register-component "chjooriApp" (fn [] root-component-factory)))

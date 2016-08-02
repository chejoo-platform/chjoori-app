(ns chjoori-app.routing
  (:refer-clojure :exclude [pop replace])
  (:require [chjoori-app.state :refer [route]]
            [react-native.utils :refer [on-hardware-back-pressed]]))


(defn push [to]
  (swap! route conj to))

(defn pop []
  (swap! route next))

(defn replace [with]
  (pop)
  (push with))

(defn reset [with]
  (reset! route (list with)))

(on-hardware-back-pressed
 (fn []
   (when (< 1 (count @route))
     (pop))))

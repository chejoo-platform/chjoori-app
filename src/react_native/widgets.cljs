(ns react-native.widgets
  (:require [react-native.core :refer [react react-native]]))



(defn create-element [rn-comp opts & children]
  (apply js/React.createElement rn-comp (clj->js opts) children))

(def view (partial create-element (.-View react-native)))
(def text (partial create-element (.-Text react-native)))
(def image (partial create-element (.-Image react-native)))
(def touchable-highlight (partial create-element (.-TouchableHighlight react-native)))
(def touchable-opacity (partial create-element (.-TouchableOpacity react-native)))

(ns react-native.widgets
  (:require [react-native.core :refer [react react-native]]))



(defn create-element [rn-comp opts & children]
  (apply js/React.createElement rn-comp (clj->js opts) children))

(def view (partial create-element (.-View react-native)))
(def scroll-view (partial create-element (.-ScrollView react-native)))
(def list-view (partial create-element (.-ListView react-native)))
(def text (partial create-element (.-Text react-native)))
(def text-input (partial create-element (.-TextInput react-native)))
(def image (partial create-element (.-Image react-native)))
(def touchable-highlight (partial create-element (.-TouchableHighlight react-native)))
(def touchable-opacity (partial create-element (.-TouchableOpacity react-native)))
(def touchable-native-feedback (partial create-element (.-TouchableNativeFeedback react-native)))
(def ripple (.. react-native -TouchableNativeFeedback -Ripple))
(def navigator (partial create-element (.-Navigator react-native)))

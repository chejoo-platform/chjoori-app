(ns widgets.browser-link
  (:require [react-native.widgets :refer [touchable-native-feedback ripple]]
            [react-native.utils :refer [open-url]]))



(defn browser-link
  "Creates an element that opens a given link upon being touched."
  [props link & children]
  (apply touchable-native-feedback
         (assoc props
                :onPress #(open-url link)
                :background (ripple "#333" true))
         children))

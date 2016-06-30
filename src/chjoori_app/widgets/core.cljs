(ns chjoori-app.widgets.core)

(def ReactNative (js/require "react-native"))



(defn create-element [rn-comp opts & children]
  (apply js/React.createElement rn-comp (clj->js opts) children))

(def view (partial create-element (.-View ReactNative)))
(def text (partial create-element (.-Text ReactNative)))
(def image (partial create-element (.-Image ReactNative)))
(def touchable-highlight (partial create-element (.-TouchableHighlight ReactNative)))
(def touchable-opacity (partial create-element (.-TouchableOpacity ReactNative)))

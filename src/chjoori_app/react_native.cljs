(ns chjoori-app.react-native)



(def React (.-React js/window))
(def ReactNative (.-ReactNative js/window))
(def app-registry (.-AppRegistry ReactNative))
(def linking (.-Linking ReactNative))

(defn register-component [name f] (.registerComponent app-registry name f))

(defn alert [title] (.alert (.-Alert ReactNative) title))

(defn open-url [url] (.openURL linking url))

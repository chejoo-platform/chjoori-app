(ns chjoori-app.react-native)



(def React (.-React js/window))
(def ReactNative (.-ReactNative js/window))
(def app-registry (.-AppRegistry ReactNative))
(def app-state (.-AppState ReactNative))
(def linking (.-Linking ReactNative))

(defn register-component [name f] (.registerComponent app-registry name f))

(defn alert [title] (.alert (.-Alert ReactNative) title))

(defn open-url [url] (.openURL linking url))

(defn get-initial-url [] (.getInitialURL linking))

(defn current-app-state [] (.-currentState app-state))

(defn app-state-changes [cfn] (.addEventListener app-state "change" cfn))

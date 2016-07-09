(ns react-native.core)



(def react (.-React js/window))
(def react-native (.-ReactNative js/window))
(def app-registry (.-AppRegistry react-native))
(def app-state (.-AppState react-native))
(def linking (.-Linking react-native))
(def alert (.-Alert react-native))

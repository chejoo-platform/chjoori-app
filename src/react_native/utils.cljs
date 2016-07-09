(ns react-native.utils
  (:require [react-native.core :refer [app-registry alert linking app-state]]))



(defn register-component [name f] (.registerComponent app-registry name f))

(defn alert [title] (.alert alert title))

(defn open-url [url] (.openURL linking url))

(defn get-initial-url [] (.getInitialURL linking))

(defn current-app-state [] (.-currentState app-state))

(defn app-state-changes [cfn] (.addEventListener app-state "change" cfn))

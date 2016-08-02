(ns react-native.utils
  (:require [react-native.core :as rn
             :refer [app-registry linking app-state back-android]]))



(defn register-component [name f] (.registerComponent app-registry name f))

(defn alert [title] (.alert rn/alert title))

(defn open-url [url] (.openURL linking url))

(defn get-initial-url [] (.getInitialURL linking))

(defn current-app-state [] (.-currentState app-state))

(defn app-state-changes [cfn] (.addEventListener app-state "change" cfn))

(defn on-hardware-back-pressed [cfn]
  (.addEventListener back-android "hardwareBackPress" cfn))

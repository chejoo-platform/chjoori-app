(ns chjoori-app.core
  (:require-macros [rum.core :refer [defc]])
  (:require [re-natal.support :as support]
            [rum.core :as rum]
            [chjoori-app.widgets.core :refer [view text image touchable-highlight]]))


(set! js/window.React (js/require "react"))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))

(def logo-img (js/require "./images/cljs.png"))

(defn alert [title]
  (.alert (.-Alert ReactNative) title))

(defonce app-state (atom {:greeting "Hello Clojure in iOS and Android!"}))


(def styles
  {:container {:flexDirection "column"
               :margin 40
               :alignItems "center"}
   :header {:fontSize 30
            :fontWeight "100"
            :marginBottom 20
            :textAlign "center"}
   :logo {:width 80
          :height 80
          :marginBottom 30}
   :button {:backgroundColor "#999"
            :padding 10
            :borderRadius 5}
   :button-text {:color "white"
                 :textAlign "center"
                 :fontWeight "bold"}})

(defc AppRoot < rum/cursored-watch [state]
  (view {:style (:container styles)}
        (text {:style (:header styles)} (:greeting @state))
        (image {:source logo-img
                :style  (:logo styles)})
        (touchable-highlight {:style (:button styles)
                              :onPress #(alert "HELLO!")}
                             (text {:style (:button-text styles)} "press me"))))


(defonce root-component-factory (support/make-root-component-factory))

(defn mount-app [] (support/mount (AppRoot app-state)))

(defn init []
  (mount-app)
  (.registerComponent app-registry "chjooriApp" (fn [] root-component-factory)))

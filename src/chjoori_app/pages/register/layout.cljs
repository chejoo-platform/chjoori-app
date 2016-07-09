(ns chjoori-app.pages.register.layout
  (:require [rum.core :as rum]
            [react-native.widgets :refer [view text image touchable-opacity]]
            [react-native.utils :refer [open-url]]
            [chjoori-app.state :refer [initial-url]])
  (:require-macros [rum.core :refer [defc]]))



(def telegram-logo (js/require "./images/telegram.png"))
(def telegram-bot-url "https://telegram.me/ChjooriBot?start=register")

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
   :button {:backgroundColor "#3B5998"
            :padding 10
            :borderRadius 5}
   :button-text {:color "white"
                 :textAlign "center"
                 :fontWeight "bold"}})

(defc AppRoot < rum/cursored-watch rum/reactive [state]
  (view {:style (:container styles)}
        (text {:style (:header styles)} (:greeting @state))
        (text {} (rum/react initial-url))
        (touchable-opacity {:activeOpacity 0.01
                            :onPress #(open-url telegram-bot-url)}
                           (view {:style (:button styles)}
                                 (image {:source telegram-logo
                                         :style  (:logo styles)})))))
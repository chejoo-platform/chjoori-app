(ns chjoori-app.pages.register.layout
  (:require [rum.core :as rum]
            [react-native.widgets :refer [view text image touchable-opacity]]
            [react-native.utils :refer [open-url]]
            [chjoori-app.routing :as routing]
            [widgets.browser-link :refer [browser-link]])
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

(defc register-page < rum/reactive []
  (view {:style (:container styles)}
        (text {:style (:header styles)} "با تلگرام ثبت نام کنید.")
        (browser-link {} telegram-bot-url
                      (view {:style (:button styles)}
                            (image {:source telegram-logo
                                    :style  (:logo styles)})))
        (touchable-opacity {:onPress #(routing/push [:list-questions])}
                           (text {} "Next"))))

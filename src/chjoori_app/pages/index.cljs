(ns chjoori-app.pages.index
  (:require-macros [rum.core :refer [defc]])
  (:require [rum.core :as rum]
            [chjoori-app.widgets.core :refer [view text image touchable-highlight]]
            [chjoori-app.react-native :refer [alert]]))



(def telegram-logo (js/require "./images/telegram.png"))

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
        (image {:source telegram-logo
                :style  (:logo styles)})
        (touchable-highlight {:style (:button styles)
                              :onPress #(alert "HELLO!")}
                             (text {:style (:button-text styles)} "press me"))))

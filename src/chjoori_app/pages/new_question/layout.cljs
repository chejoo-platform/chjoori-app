(ns chjoori-app.pages.new-question.layout
  (:require [rum.core :as rum]
            [react-native.widgets :refer [view text image touchable-opacity text-input]]
            [react-native.utils :refer [open-url]]
            [chjoori-app.state :refer [app-state]]
            [chjoori-app.routing :as routing]
            [widgets.browser-link :refer [browser-link]])
  (:require-macros [rum.core :refer [defcs]]))



(def styles
  {:container {:flexDirection "column"
               :margin 40
               :alignItems "center"}
   :input {:height 40
           :alignSelf "stretch"
           :borderColor "gray"
           :borderWidth 1}})


(defn new-question [text]
  (swap! app-state
         update :questions
         (fnil conj []) {:question text
                         :id (random-uuid)})
  (routing/push [:list-questions]))


(defcs new-question-page < rum/reactive (rum/local "سوال" ::text) [state]
  (let [txt (::text state)]
    (view {:style (:container styles)}
          (text-input {:style (:input styles)
                       :onChangeText #(reset! txt %)
                       :value @txt})
          (touchable-opacity {:onPress #(new-question @txt)}
                             (text {} "ایجاد")))))

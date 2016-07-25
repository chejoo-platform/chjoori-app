(ns chjoori-app.pages.list-questions.layout
  (:require [rum.core :as rum]
            [react-native.widgets :refer [view text touchable-highlight]]
            [chjoori-app.state :refer [app-state current-route]])
  (:require-macros [rum.core :refer [defc]]))



(def styles
  {:container {:flexDirection "column"
               :margin 40}
   :new-button {:backgroundColor "#999"}})


(def questions (rum/cursor app-state [:questions]))


(defn new-question []
  (reset! current-route [:new-question]))


(defc list-questions-page < rum/reactive []
  (apply view {:style (:container styles)}
         (touchable-highlight {:onPress #(new-question)}
                              (text {:style (:new-button styles)}
                                    "ایجاد سوال"))
         (for [q (rum/react questions)]
           (touchable-highlight {}
                                (text {} (:question q))))))

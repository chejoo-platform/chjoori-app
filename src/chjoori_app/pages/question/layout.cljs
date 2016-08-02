(ns chjoori-app.pages.question.layout
  (:require [rum.core :as rum]
            [chjoori-app.state :refer [app-state]]
            [react-native.widgets :refer [view text text-input touchable-highlight scroll-view]])
  (:require-macros [rum.core :refer [defcs]]))



(def styles
  {:container {:flexDirection "column"
               :alignItems "stretch"
               :padding 40
               :flex 1}
   :answers-container {}
   :question {:marginBottom 10}
   :answer {:flexDirection "row"
            :alignItems "flex-end"}
   :answer-input {:flex 1}
   :answer-button {:flex 0}})


(defn create-answer [qid ans]
  (let [update-for-question (fn [qseq id func & rst]
                              (map #(if (= id (:id %)) (apply func % rst) %) qseq))]
    (swap! app-state
           update :questions
           update-for-question qid
           update :answers
           conj {:text ans})))


(defcs question-page < rum/reactive (rum/local "" ::answer) [state id]
  (let [questions (:questions (rum/react app-state))
        q (first (filter #(= id (:id %)) questions))
        answer-text (::answer state)]
    (view {:style (:container styles)}
          (text {:style (:question styles)} (:question q))
          (view {:style (:answer styles)}
                (text-input {:style (:answer-input styles)
                             :multiline true
                             :onChangeText #(reset! answer-text %)
                             :value @answer-text})
                (touchable-highlight {:style (:answer-button styles)
                                      :onPress #(do (create-answer id @answer-text)
                                                    (reset! answer-text ""))}
                                     (text {} "ارسال")))
          (apply scroll-view {:style (:answers-container styles)}
                 (for [answer (:answers q)]
                   (text {} (:text answer))))
          )))

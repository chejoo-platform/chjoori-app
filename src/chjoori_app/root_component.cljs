(ns chjoori-app.root-component
  (:require [rum.core :as rum]
            [chjoori-app.pages.register.layout :refer [register-page]]
            [chjoori-app.pages.question.layout :refer [question-page]]
            [chjoori-app.pages.new-question.layout :refer [new-question-page]]
            [chjoori-app.pages.list-questions.layout :refer [list-questions-page]]
            [chjoori-app.state :refer [current-route]])
  (:require-macros [rum.core :refer [defc]]))



(def routes
  {:register register-page
   :new-question new-question-page
   :list-questions list-questions-page
   :question question-page})


(def route-for
  (memoize
   (fn [[route & params]]
     (apply (get routes route) params))))


(defc AppRoot < rum/reactive []
  (let [r (rum/react current-route)]
    (route-for r)))

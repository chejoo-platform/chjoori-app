(ns user
  (:require [figwheel-sidecar.repl-api :as ra]
            [figwheel-sidecar.config :as fc]))
;; This namespace is loaded automatically by nREPL

;; read project.clj to get build configs
(def profiles (->> "project.clj"
                   slurp
                   read-string
                   (drop-while #(not= % :profiles))
                   (apply hash-map)
                   :profiles))

(def cljs-builds (get-in profiles [:dev :cljsbuild :builds]))

(defn start-figwheel
  "Start figwheel for one or more builds"
  [& build-ids]
  (apply ra/start-figwheel! (fc/fetch-config) build-ids)
  (ra/cljs-repl))

(defn stop-figwheel
  "Stops figwheel"
  []
  (ra/stop-figwheel!))

(ns hello-figwheel.core
  (:require [sablono.core :as sab])
  )

(def app-state (atom { :likes 0 }))

(defn like-figwheel [data]
  (sab/html [:div
             [:h1 "Seymore's quantified popularity: " (:likes @data)]
             [:div [:a {:href "#"
                        :onClick #(swap! data update-in [:likes] inc)}
                    "Thumbs up"]]
             ]
  )

(defn render! []
  (.render js/React
           (like-figwheel app-state)

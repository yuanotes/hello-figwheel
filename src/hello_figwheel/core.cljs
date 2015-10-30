(ns hello-figwheel.core
  (:require [sablono.core :as sab])
  )

(defonce app-state (atom { :likes 0 }))


(defn like-figwheel [data]
  (sab/html [:div
             [:h1 "Seymore's quantified popularity: " (:likes @data)]
             [:div [:a {:href "#"
                        :onClick #(swap! data update-in [:likes] inc)}
                    "Thumbs up"]]
             ]
  )
  )

(defn render! []
  (.render js/React
           (like-figwheel app-state)
           (.getElementById js/document "app")))
(add-watch app-state :on-change (fn [_ _ _ _] (render!)))
(render!)

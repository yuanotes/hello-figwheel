(ns hello-figwheel.core
  (:require [sablono.core :as sab]
            [hello-figwheel.components :refer [like-figwheel]]
            )
  )

(defonce app-state (atom { :likes 0 }))


(defn render! []
  (.render js/React
           (like-figwheel app-state)
           (.getElementById js/document "app")))
(add-watch app-state :on-change (fn [_ _ _ _] (render!)))
(render!)

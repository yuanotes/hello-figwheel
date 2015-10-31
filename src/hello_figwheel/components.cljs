(ns hello-figwheel.components
  (:require [sablono.core :as sab])
  )

(defn like-figwheel [data]
  (sab/html [:div
             [:h1 "Seymore's quantified popularity: " (:likes @data)]
             [:div [:a {:href "#"
                        :onClick #(swap! data update-in [:likes] inc)}
                    "Thumbs up"]]
             ]
            )
  )

(ns http-kit-288.core
  (:require [org.httpkit.server :refer :all]
            [compojure.core :refer [defroutes POST]]))

(defroutes app
           (POST "/process" [] {:status 200 :body "OK!"}))

(defonce server (atom nil))

(defn start []
  (reset! server (run-server #'app {:port 8091 :max-body 10})))

(defn stop []
  (@server))
